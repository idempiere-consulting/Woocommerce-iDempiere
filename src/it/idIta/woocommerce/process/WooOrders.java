package it.idIta.woocommerce.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBPGroup;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCountry;
import org.compiere.model.MLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUser;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.Woocommerce;
import com.icoderman.woocommerce.oauth.OAuthConfig;

import it.idIta.woocommerce.model.MEcommPayRule;
import it.idIta.woocommerce.pojo.Customer;
import it.idIta.woocommerce.pojo.LineItem;
import it.idIta.woocommerce.pojo.Order;
import za.co.ntier.model.X_zz_woocommerce;

public class WooOrders extends SvrProcess {

	private PO wcDefaults;
	private List<Order> listWooOrder = null;
	private List<Order> listWooOrderComplete = null;

	@Override
	protected void prepare() {

	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = " isactive = 'Y' AND AD_Client_ID = ?";
		wcDefaults = new Query(getCtx(), X_zz_woocommerce.Table_Name, whereClause, null)
				.setParameters(new Object[] { Env.getAD_Client_ID(getCtx()) }).firstOnly();
		if (wcDefaults == null) {
			throw new IllegalStateException("/nWooCommerce Defaults need to be set on iDempiere /n");
		}

		// Setup client
		OAuthConfig config = new OAuthConfig((String) wcDefaults.get_Value("url"),
				(String) wcDefaults.get_Value("consumerkey"), (String) wcDefaults.get_Value("consumersecret"));
		Woocommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);
		ManageWoocommerce manageWoocommerce = new ManageWoocommerce(wooCommerce);

		listWooOrder = manageWoocommerce.getwoo_Orders();
		createCompleteOrder(manageWoocommerce);
		return "Order OK";
	}

	private void createCompleteOrder(ManageWoocommerce manageWoocommerce){


		if(listWooOrder !=null && listWooOrder.size()>0){

//			int M_PriceList_ID = MSysConfig.getIntValue("LIT_Woocommerce_PriceList_ID", 0, Env.getAD_Client_ID(Env.getCtx()));
//			if(M_PriceList_ID == 0)
//				throw new AdempiereException(Msg.getMsg(Env.getAD_Language(getCtx()), "LIT_WooSystemConfig", new String[] {"'LIT_Woocommerce_PriceList_ID'"}));
			int M_PriceList_ID = wcDefaults.get_ValueAsInt("Local_Incl_PriceList_ID");
			MOrder mOrder = null;
			Customer customer = null;
			MBPartner partner = null;
			MCountry country = null;
			MLocation location = null;
			MBPartnerLocation bpLocation = null;
			MBPartnerLocation bpLocationShip = null;

			String   nameCustomer = "";
			String   mailCustomer = "";
			String[] nameSplit = null;
			LocalDateTime lDT = null;
			DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			listWooOrderComplete = new ArrayList<Order>();
			for (Order order : listWooOrder) {
				location = null;
				bpLocation = null;
				bpLocationShip = null;
				nameCustomer = "";
				mailCustomer = "";
				nameSplit = null; 
				lDT = null;

				if(order.getBilling()!= null) {
					nameCustomer = order.getBilling().getLastName()+"_"+order.getBilling().getFirstName();
					mailCustomer = order.getBilling().getEmail();
				}
				else {
					nameCustomer = customer.getLastName()+"_"+customer.getFirstName();
					mailCustomer = customer.getEmail();
				}
				nameSplit = nameCustomer.split("_"); //0- LastName/Surname   1- FirstName

				partner = new Query(getCtx(), "C_BPartner", "C_BPartner_ID IN(SELECT C_BPartner_ID FROM AD_User WHERE Email LIKE ?)", null)
						.setParameters(mailCustomer)
						.setClient_ID()
						.first();
				if(partner == null){
					partner = new MBPartner(getCtx(), 0, null);

					partner.setValue(nameCustomer);
					partner.setName(nameSplit[0] +" "+ nameSplit[1]);
					partner.setIsCustomer(true);
					int bpGroup = DB.getSQLValue(null, "SELECT C_BP_Group_ID FROM C_BP_Group WHERE IsActive='Y' AND AD_Client_ID=? AND Name=?", Env.getAD_Client_ID(getCtx()),"Standard");
					if(bpGroup<=0) {
						bpGroup = MBPGroup.getDefault(getCtx()).getC_BP_Group_ID();
					}
					partner.setC_BP_Group_ID(bpGroup);
					//partner.setIsCustomer(false);
					partner.setM_PriceList_ID(M_PriceList_ID);
					partner.setInvoiceRule("I");
					partner.saveEx();

					if(order.getBilling()!= null){
						location = new MLocation(getCtx(), 0, null); 
						location.setAddress1(order.getBilling().getAddress1());
						location.setAddress2(order.getBilling().getAddress2());
						location.setCity(order.getBilling().getCity());
						location.setPostal(order.getBilling().getPostcode());
						location.setRegionName(order.getBilling().getState());
						country = new Query(getCtx(), MCountry.Table_Name, MCountry.COLUMNNAME_CountryCode+"=?", null)
								.setParameters(order.getBilling().getCountry())
								.first();
						location.setCountry(country);
						location.saveEx();

						bpLocation = new MBPartnerLocation(partner);
						bpLocation.setC_Location_ID(location.getC_Location_ID());
						/// Impostazione per poter creare 2 differenti indirizzi, dato che di default sono valorizzati tutti e due a TRUE
						bpLocation.setIsBillTo(true);   
						bpLocation.setIsShipTo(false);  
						///////
						bpLocation.setPhone(order.getBilling().getPhone());
						bpLocation.saveEx();
					}

					String shipAddress_1 = "";
					if(order.getShipping()!=null && order.getShipping().getAddress1()!=null && !order.getShipping().getAddress1().trim().isEmpty()) {
						shipAddress_1 = order.getShipping().getAddress1().trim();
						if(location!=null && location.getAddress1()!=null && !location.getAddress1().trim().isEmpty() && location.getAddress1().trim().equalsIgnoreCase(shipAddress_1)) {
							bpLocation.setIsShipTo(true);
							bpLocation.saveEx();
						}
						else {

							location = new MLocation(getCtx(), 0, null); 
							location.setAddress1(shipAddress_1);
							location.setAddress2(order.getShipping().getAddress2());
							location.setCity(order.getShipping().getCity());
							location.setPostal(order.getShipping().getPostcode());
							location.setRegionName(order.getBilling().getState());
							country = new Query(getCtx(), MCountry.Table_Name, MCountry.COLUMNNAME_CountryCode+"=?", null)
									.setParameters(order.getShipping().getCountry())
									.first();
							location.setCountry(country);
							location.saveEx();

							bpLocationShip = new MBPartnerLocation(partner);
							bpLocationShip.setC_Location_ID(location.getC_Location_ID());
							/// Impostazione per poter creare 2 differenti indirizzi, dato che di default sono valorizzati tutti e due a TRUE
							bpLocationShip.setIsShipTo(true);
							bpLocationShip.setIsBillTo(false);
							///////
							bpLocationShip.saveEx();

							if(bpLocation==null)// Forzatura SOLO in caso eccezionali....
								bpLocation = bpLocationShip;
						}
					}

					MUser userPartner = new MUser(partner);
					userPartner.set_ValueOfColumn("SurName", nameSplit[0]);
					userPartner.setEMail(mailCustomer);
					userPartner.setC_BPartner_Location_ID(bpLocation.getC_BPartner_Location_ID());
					userPartner.saveEx();	
				}

				mOrder = new MOrder(getCtx(), 0, null);

				mOrder.setAD_Org_ID(Env.getAD_Org_ID(getCtx()));
				mOrder.setBPartner(partner);
				mOrder.setM_Warehouse_ID(MWarehouse.getForOrg(getCtx(), mOrder.getAD_Org_ID())[0].getM_Warehouse_ID());

				//MEcommPayRule ecommPay = MEcommPayRule.findByType(MEcommPayRule.LIT_ECOMMERCE_WooCommerce, order.getPaymentMethod());
				//int docType = ecommPay.getC_DocType_ID();
				int docType = DB.getSQLValue(null, "SELECT C_DocType_ID FROM C_DocType WHERE C_DocType_UU='32baf4f6-771e-4c01-ab94-0b2c1945a84c'"); //Standard_Order //TODO
				mOrder.setC_DocTypeTarget_ID(docType);
				int currencyID = Env.getContextAsInt(getCtx(), "$C_Currency_ID");
				if(currencyID <=0){
					MAcctSchema[] accSchemas = MAcctSchema.getClientAcctSchema(getCtx(), Env.getAD_Client_ID(getCtx()), null);
					for (MAcctSchema mAcctSchema : accSchemas) {
						if(mAcctSchema.getGAAP().equals("UN")){
							mOrder.setC_Currency_ID(mAcctSchema.getC_Currency_ID());
							break;
						}
					}
				}
				//mOrder.setM_PriceList_ID(M_PriceList_ID);
				if(partner.getC_PaymentTerm_ID()>0)
					mOrder.setC_PaymentTerm_ID(partner.getC_PaymentTerm_ID());
				else
					mOrder.setC_PaymentTerm_ID(Env.getContextAsInt(getCtx(), "#C_PaymentTerm_ID"));

				lDT = LocalDateTime.from(formatDateTime.parse(order.getDateCreated()));
				mOrder.setDateOrdered(Timestamp.valueOf(lDT));
				mOrder.setDatePromised(Timestamp.valueOf(lDT));
				//mOrder.setPaymentRule(ecommPay.getPaymentRule());
				mOrder.setPaymentRule(MOrder.PAYMENTRULE_DirectDebit);//TODO  
				mOrder.saveEx();

				MOrderLine ordLine = null;
				for (LineItem line : order.getLineItems()) {

					MProduct prod = new Query(getCtx(), MProduct.Table_Name, MProduct.COLUMNNAME_SKU+"=?", null)
							.setClient_ID()
							.setParameters(line.getSku())
							.first();

					if(prod!=null){
						ordLine = new MOrderLine(mOrder);

						ordLine.setProduct(prod);
						ordLine.setQty(new BigDecimal(line.getQuantity()));
						ordLine.setPrice(BigDecimal.valueOf(line.getPrice()));
						ordLine.setPriceList(BigDecimal.valueOf(line.getPrice()));
						ordLine.setPriceLimit(BigDecimal.valueOf(line.getPrice()));

						MTax tax = new MTaxCategory(getCtx(), prod.getC_TaxCategory_ID(), null).getDefaultTax();
						ordLine.setC_Tax_ID(tax.getC_Tax_ID());
						ordLine.saveEx();	
					}				
				} 				
				mOrder.setDocAction(DocAction.ACTION_Complete);
				if(mOrder.processIt(DocAction.ACTION_Complete)){
					mOrder.saveEx();

					Order orderREST = new Order();
					orderREST.setId(order.getId());
					orderREST.setStatus("completed");

					listWooOrderComplete.add(orderREST);

					addLog(mOrder.getC_Order_ID(), mOrder.getDateOrdered(), null, "Order Completed n.: "+mOrder.getDocumentNo(), mOrder.get_Table_ID(), mOrder.getC_Order_ID());
				}
			}

			if(listWooOrderComplete.size()>0){
				int limit = 10;
				List<Order> tmpLst = new ArrayList<Order>();
				while(listWooOrderComplete.size()>0) {
					if(listWooOrderComplete.size()<=limit) {
						manageWoocommerce.updateOrdersTOpost(listWooOrderComplete,false);
						listWooOrderComplete.clear();
					}
					else {
						for (int i = 0; i < limit; i++) {
							tmpLst.add(listWooOrderComplete.get(0));
							listWooOrderComplete.remove(0);
						}
						manageWoocommerce.updateOrdersTOpost(tmpLst,false);
						tmpLst.clear();
					}
				}
				//manageWoocommerce.updateOrdersTOpost(listWooOrderComplete,false);
			}
		}
	}
}
