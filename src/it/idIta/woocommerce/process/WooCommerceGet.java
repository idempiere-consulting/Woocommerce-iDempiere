package it.idIta.woocommerce.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MLocator;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.Woocommerce;
import com.icoderman.woocommerce.oauth.OAuthConfig;

import it.idIta.woocommerce.model.MWooProducts;
import it.idIta.woocommerce.pojo.Category;
import it.idIta.woocommerce.pojo.Image;
import it.idIta.woocommerce.pojo.Product;
import za.co.ntier.model.X_zz_woocommerce;

public class WooCommerceGet extends SvrProcess {

	private PO wcDefaults;
	private List<Product> listWoo = null;
	
	@Override
	protected void prepare() {

	}

	@Override
	protected String doIt() throws Exception {
//		Thread thread = new Thread(new Runnable_Woo_Product());
//		thread.start();
/////////////////////////////////////////////////////////////////////////////////		
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
		manageWoocommerce.initSyncForProd();
		syncWoo_iDempiere();
		synciDempiere_Woo(manageWoocommerce);
	
		return "";
	}
	
	private void syncWoo_iDempiere(){
		MWooProducts wooProd = new MWooProducts(getCtx(), 0, null);
		
		List<MWooProducts> listWooProd = wooProd.selectAllWooProd();
		
		//price 
//		int M_PriceList_ID = MSysConfig.getIntValue("LIT_Woocommerce_PriceList_ID", 0, Env.getAD_Client_ID(Env.getCtx()));
//		if(M_PriceList_ID == 0)
//			throw new AdempiereException(Msg.getMsg(Env.getAD_Language(getCtx()), "LIT_WooSystemConfig", new String[] {"'LIT_Woocommerce_PriceList_ID'"}));
		int M_PriceList_ID = wcDefaults.get_ValueAsInt("Local_Incl_PriceList_ID");
		MPriceList priceList = new MPriceList(Env.getCtx(), M_PriceList_ID, null);
		MPriceListVersion priceListVer = priceList.getPriceListVersion(null);
		int p_M_PriceList_Version_ID = priceListVer.getM_PriceList_Version_ID();
		
		//locator
		//MWarehouse warehouse = MWarehouse.get(Env.getCtx(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"));
		MWarehouse warehouse = new MWarehouse(getCtx(), wcDefaults.get_ValueAsInt("M_Warehouse_ID"), null);
		MLocator locator = warehouse.getDefaultLocator();
		
		boolean updProd = false;
		for (MWooProducts mWooProduct : listWooProd) {
			MProduct mProduct = null;
			
			mProduct = new Query(getCtx(), MProduct.Table_Name, MProduct.COLUMNNAME_SKU+"=?", null)
			.setClient_ID()
			.setParameters(mWooProduct.getLIT_Sku())
			.first();
			
			if(mProduct == null)
				mProduct = new MProduct(getCtx(), 0, null);
			else{
				if(mProduct.getUpdated().before(mWooProduct.getLIT_UpdatedAt()))
					updProd = true;
			}

			if(mProduct.getM_Product_ID()==0 || updProd){
				
				mProduct.setValue(mWooProduct.getLIT_Sku());
				mProduct.setSKU(mWooProduct.getLIT_Sku());
				mProduct.setName(mWooProduct.getName());
				if(mWooProduct.getLIT_ShortDescription()!=null)
					mProduct.setDescription(mWooProduct.getLIT_ShortDescription().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", ""));
				else
					mProduct.setDescription("");
				if(mWooProduct.getLIT_DescriptionWoo()!=null)
					mProduct.setDocumentNote(mWooProduct.getLIT_DescriptionWoo().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", ""));
				else
					mProduct.setDocumentNote("");
				//Product category
				int M_Product_Category_ID = DB.getSQLValue(null, "SELECT M_Product_Category_ID FROM M_Product_Category WHERE Name=? AND AD_Client_ID=?",mWooProduct.getLIT_CategoryWoo(), Env.getAD_Client_ID(Env.getCtx()));
				if(M_Product_Category_ID>0)
					mProduct.setM_Product_Category_ID(M_Product_Category_ID);
				else
					throw new AdempiereException("Impossibile caricare il prodotto - "+mWooProduct.getName()+"["+mWooProduct.getLIT_Sku()+"] - : categoria prodotto '"+mWooProduct.getLIT_CategoryWoo()+"' non presente a sistema");
				//
				if(!updProd){
//					MTaxCategory taxCateg = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_Name+" LIKE ?", null)
//							.setClient_ID()
//							.setParameters("%IVA%22%")
//							.first();
					MTax tax = new MTax(getCtx(), wcDefaults.get_ValueAsInt("Standard_Tax_ID"), null);
					MTaxCategory taxCateg = (MTaxCategory)tax.getC_TaxCategory();
					if(taxCateg!=null)
						mProduct.setC_TaxCategory_ID(taxCateg.getC_TaxCategory_ID()); //TODO   22%....
					else
						mProduct.setC_TaxCategory_ID(Env.getContextAsInt(getCtx(), "#C_TaxCategory_ID")); //TODO   standard....
					
					if(mWooProduct.isLIT_IsManagingStock())
						mProduct.setProductType(MProduct.PRODUCTTYPE_Item);//TODO   "Item"....
					else
						mProduct.setProductType(MProduct.PRODUCTTYPE_Service);//TODO   "Service"....
					
					mProduct.setC_UOM_ID(Env.getContextAsInt(getCtx(), "#C_UOM_ID"));
					
					boolean isStock = mWooProduct.isLIT_IsInStock();
					mProduct.setIsStocked(isStock);
					
					//locator/warehouse
					if(isStock){
						if(locator != null){
							mProduct.saveEx();
							
							MStorageOnHand s1 = MStorageOnHand.getCreate(getCtx(), locator.getM_Locator_ID(), mProduct.getM_Product_ID(), 0,null, null);
							s1.setQtyOnHand(new BigDecimal(mWooProduct.getLIT_StockQuantity()));
							s1.saveEx();
							
							mProduct.setM_Locator_ID(locator.getM_Locator_ID());
						}
					}
					mProduct.saveEx();
				}
			
				if (p_M_PriceList_Version_ID != 0)
				{
					BigDecimal PriceList = mWooProduct.getLIT_RegularPrice();
					BigDecimal PriceStd = mWooProduct.getPrice();
					BigDecimal PriceLimit = mWooProduct.getPrice();
					if (PriceStd.signum() != 0 || PriceLimit.signum() != 0 || PriceList.signum() != 0)
					{
						MProductPrice pp = MProductPrice.get(getCtx(), 
							p_M_PriceList_Version_ID, mProduct.getM_Product_ID(), null);
						if (pp == null)
							pp = new MProductPrice (getCtx(), 
								p_M_PriceList_Version_ID, mProduct.getM_Product_ID(), null);
						pp.setPrices(PriceList, PriceStd, PriceLimit);
						
						pp.saveEx();
					}
				}
				mProduct.setImageURL(mWooProduct.getLIT_ImageUrl());
				
				mProduct.saveEx();
/*				
				String message = "Product Processed: "+order.getDocumentNo();
				addLog(order.getC_Order_ID(), order.getDateOrdered(), null, message, order.get_Table_ID(), order.getC_Order_ID());
*/				
				
				final String sqlupd = "UPDATE " + MProduct.Table_Name
						+" SET " + MProduct.COLUMNNAME_Created+"=?,"+ MProduct.COLUMNNAME_Updated+"=? "
						+" WHERE " + MProduct.COLUMNNAME_M_Product_ID+"=?";
					DB.executeUpdateEx(sqlupd, new Object[]{mWooProduct.getLIT_CreatedAt(), mWooProduct.getLIT_UpdatedAt(), mProduct.getM_Product_ID()}, null);

					updProd = false;
					
					addLog(mProduct.getM_Product_ID(), new Timestamp(System.currentTimeMillis()), null, 
							"INSERT/UPDATE_TO_iDEMPIERE___Value: "+mProduct.getValue()+" --- SKU: "+mProduct.getSKU()+" --- Nome: "+mProduct.getName());
			}
		}
	}
	
	private void synciDempiere_Woo(ManageWoocommerce manageWoocommerce){
		
		//price 
//		int M_PriceList_ID = MSysConfig.getIntValue("LIT_Woocommerce_PriceList_ID", 0, Env.getAD_Client_ID(Env.getCtx()));
//		if(M_PriceList_ID == 0)
//			throw new AdempiereException("Set 'LIT_Woocommerce_PriceList_ID' from SystemConfigurator....");
		int M_PriceList_ID = wcDefaults.get_ValueAsInt("Local_Incl_PriceList_ID");
		MPriceList priceList = new MPriceList(Env.getCtx(), M_PriceList_ID, null);
		MPriceListVersion priceListVer = priceList.getPriceListVersion(null);
		int p_M_PriceList_Version_ID = priceListVer.getM_PriceList_Version_ID();
		
		//locator
//		MWarehouse warehouse = MWarehouse.get(Env.getCtx(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"));
		MWarehouse warehouse = new MWarehouse(getCtx(), wcDefaults.get_ValueAsInt("M_Warehouse_ID"), null);
		MLocator locator = warehouse.getDefaultLocator();
		
		String whereClause = MProduct.COLUMNNAME_IsSelfService+"=? "
				+ "AND "+MProduct.COLUMNNAME_SKU+" IS NOT NULL "
				+ "AND NOT EXISTS (SELECT * FROM "+MWooProducts.Table_Name+ " od "
					+ "WHERE "+ MProduct.Table_Name+"."+MProduct.COLUMNNAME_SKU+" =  od."+MWooProducts.COLUMNNAME_LIT_Sku
					+ " AND od."+MWooProducts.COLUMNNAME_AD_Client_ID+"=?)";
		
		List<MProduct> listProducts = new Query(getCtx(), MProduct.Table_Name, whereClause , null)
				.setClient_ID()
				.setParameters("Y", Env.getAD_Client_ID(getCtx()))
				.list();
//(line 555)		if(listProducts.size()>0){
			
//			int idWoo = DB.getSQLValue(null, "SELECT MAX("+MWooProducts.COLUMNNAME_LIT_IdProdWoo+") FROM "+MWooProducts.Table_Name)+1;
			
		Product productRest = null;
		if(listWoo == null)
			listWoo = new ArrayList<Product>();
		
		List<Category> listCategories = null;
		
		//createNew ____ 01/06/2018
		for (MProduct mProduct : listProducts) {
			productRest = new Product();
			
//			productRest.setId(idWoo);
			productRest.setName(mProduct.getName());
			productRest.setDateCreated(mProduct.getCreated().toString());
			productRest.setDateModified(mProduct.getUpdated().toString());
			productRest.setSku(mProduct.getSKU());
			
			productRest.setDescription("<p> "+mProduct.getDocumentNote()+" </p>");
			productRest.setShortDescription(mProduct.getDescription());
			if(mProduct.getM_Product_Category()!=null){
				listCategories = new ArrayList<Category>();
				Category prodCateg = manageWoocommerce.getProductCategory(mProduct.getM_Product_Category().getName());
				listCategories.add(prodCateg);
				productRest.setCategories(listCategories);
			}

			//TODO....tax
//			if(mProduct.getC_TaxCategory()!=null){
//				productRest.setTaxClass(mProduct.getC_TaxCategory().getName());
//			}
			if(mProduct.getProductType().equals(MProduct.PRODUCTTYPE_Item)){
				BigDecimal qtyStock = MStorageOnHand.getQtyOnHand(mProduct.getM_Product_ID(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"), 0, null);
				
				if(qtyStock.intValue()>0){
					productRest.setStockStatus("instock");
					productRest.setManageStock(true);
					productRest.setStockQuantity(qtyStock.intValue());
				}
				else{
					productRest.setStockStatus("outofstock");
					productRest.setManageStock(true);
					productRest.setStockQuantity(0);
				}

			}
			else{
				productRest.setStockStatus("outofstock");
				productRest.setManageStock(false);
				//productRest.setStockQuantity(1);
				productRest.setVirtual(true);
			}
			
			if(p_M_PriceList_Version_ID>0){
				MProductPrice prodPrice = MProductPrice.get(getCtx(), p_M_PriceList_Version_ID, mProduct.getM_Product_ID(), null);
				
				if(prodPrice != null){
					productRest.setRegularPrice(prodPrice.getPriceList().toString());					
					productRest.setSalePrice(prodPrice.getPriceStd().toString());
				}
			}
			
			if(mProduct.getImageURL()!=null && !mProduct.getImageURL().isEmpty()){
				List<Image> listImages = new ArrayList<Image>();
				Image image = new Image();
				//image.setId(1);
				image.setSrc(mProduct.getImageURL());
				listImages.add(image);
				productRest.setImages(listImages);
			}    // TODO Image.....
			
			listWoo.add(productRest);
			addLog(mProduct.getM_Product_ID(), new Timestamp(System.currentTimeMillis()), null, 
					"INSERT_TO_WOOCOMMERCE___Value: "+mProduct.getValue()+" --- SKU: "+mProduct.getSKU()+" --- Nome: "+mProduct.getName());
//				idWoo++;
		}
		if(listWoo.size()>0){
			int limit = 10;
			List<Product> tmpLst = new ArrayList<Product>();
			while(listWoo.size()>0) {
				if(listWoo.size()<=limit) {
					manageWoocommerce.updateProductsTOpost(listWoo,true);
					listWoo.clear();
				}
				else {
					for (int i = 0; i < limit; i++) {
						tmpLst.add(listWoo.get(0));
						listWoo.remove(0);
					}
					manageWoocommerce.updateProductsTOpost(tmpLst,true);
					tmpLst.clear();
				}
			}
			//manageWoocommerce.updateProductsTOpost(listWoo,true);
			
		}
		//createNew ____ 01/06/2018 END
		
		listWoo.clear();
				
		//Update ____ 01/06/2018
		whereClause = MProduct.COLUMNNAME_IsSelfService+"=? "
				+ "AND "+MProduct.COLUMNNAME_SKU+" IS NOT NULL "
				+ "AND "+MProduct.COLUMNNAME_Updated +"> (SELECT "+MWooProducts.COLUMNNAME_LIT_UpdatedAt+ " FROM "+MWooProducts.Table_Name+
				" mw WHERE "+MProduct.Table_Name+"."+MProduct.COLUMNNAME_SKU+" =  mw."+MWooProducts.COLUMNNAME_LIT_Sku
				 	+" AND mw."+MWooProducts.COLUMNNAME_AD_Client_ID+"=?)";
		listProducts = null;
		listProducts = new Query(getCtx(), MProduct.Table_Name, whereClause , null)
				.setClient_ID()
				.setParameters("Y", Env.getAD_Client_ID(getCtx()))
				.list();
		
		int idWoo = 0;
		for (MProduct prodUpd : listProducts) {
			
			productRest = new Product();
			
			idWoo = DB.getSQLValue(null, 
					"SELECT "+MWooProducts.COLUMNNAME_LIT_IdProdWoo+ " FROM "+MWooProducts.Table_Name 
					+" WHERE "+MWooProducts.COLUMNNAME_LIT_Sku+"=? "
					+ "AND "+MWooProducts.COLUMNNAME_AD_Client_ID+"="+Env.getAD_Client_ID(getCtx()),
					prodUpd.getSKU());
			
			productRest.setId(idWoo);
			productRest.setName(prodUpd.getName());
			productRest.setDateCreated(prodUpd.getCreated().toString());
			productRest.setDateModified(prodUpd.getUpdated().toString());
			productRest.setSku(prodUpd.getSKU());
			
			productRest.setDescription("<p> "+prodUpd.getDocumentNote()+" </p>");
			productRest.setShortDescription(prodUpd.getDescription());
			if(prodUpd.getM_Product_Category()!=null){

				listCategories = new ArrayList<Category>();
				Category prodCateg = manageWoocommerce.getProductCategory(prodUpd.getM_Product_Category().getName());
				listCategories.add(prodCateg);
				productRest.setCategories(listCategories);

			}

			//TODO....tax
//			if(mProduct.getC_TaxCategory()!=null){
//				productRest.setTaxClass(mProduct.getC_TaxCategory().getName());
//			}
			if(prodUpd.getProductType().equals(MProduct.PRODUCTTYPE_Item)){
				BigDecimal qtyStock = MStorageOnHand.getQtyOnHand(prodUpd.getM_Product_ID(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"), 0, null);
				if(qtyStock.intValue()>0){
					productRest.setStockStatus("instock");
					productRest.setManageStock(true);
					productRest.setStockQuantity(qtyStock.intValue());
				}
				else{
					productRest.setStockStatus("outofstock");
					productRest.setManageStock(true);
					productRest.setStockQuantity(0);
				}
			}
			
			else{
				productRest.setStockStatus("outofstock");
				productRest.setManageStock(true);
				productRest.setStockQuantity(1);
			}
			
			if(p_M_PriceList_Version_ID>0){
				MProductPrice prodPrice = MProductPrice.get(getCtx(), p_M_PriceList_Version_ID, prodUpd.getM_Product_ID(), null);
				
				if(prodPrice != null){
					productRest.setRegularPrice(prodPrice.getPriceList().toString());					
					productRest.setSalePrice(prodPrice.getPriceStd().toString());
				}
			}
			
			if(prodUpd.getImageURL()!=null && !prodUpd.getImageURL().isEmpty()){
				List<Image> listImages = new ArrayList<Image>();
				Image image = new Image();
				//image.setId(1);
				image.setSrc(prodUpd.getImageURL());
				listImages.add(image);
				productRest.setImages(listImages);
			}     //TODO Image.....
			
			listWoo.add(productRest);
			addLog(prodUpd.getM_Product_ID(), new Timestamp(System.currentTimeMillis()), null, 
					"UPDATE_TO_WOOCOMMERCE___Value: "+prodUpd.getValue()+" --- SKU: "+prodUpd.getSKU()+" --- Nome: "+prodUpd.getName());
		}
		
		if(listWoo.size()>0){
			int limit = 10;
			List<Product> tmpLst = new ArrayList<Product>();
			while(listWoo.size()>0) {
				if(listWoo.size()<=limit) {
					manageWoocommerce.updateProductsTOpost(listWoo,false);
					listWoo.clear();
				}
				else {
					for (int i = 0; i < limit; i++) {
						tmpLst.add(listWoo.get(0));
						listWoo.remove(0);
					}
					manageWoocommerce.updateProductsTOpost(tmpLst,false);
					tmpLst.clear();
				}
			}
			//manageWoocommerce.updateProductsTOpost(listWoo,false);
		}
		//Update ____ 01/06/2018 END
	}
	
	

//	public class Runnable_Woo_Product implements Runnable {
//		
//		
//		@Override
//		public void run() {
//			final PO wcDefaults;
//			String whereClause = " isactive = 'Y' AND AD_Client_ID = ?";
//			wcDefaults = new Query(getCtx(), X_zz_woocommerce.Table_Name, whereClause, null)
//					.setParameters(new Object[] { Env.getAD_Client_ID(getCtx()) }).firstOnly();
//			if (wcDefaults == null) {
//				throw new IllegalStateException("/nWooCommerce Defaults need to be set on iDempiere /n");
//			}
//
//			// Setup client
//			OAuthConfig config = new OAuthConfig((String) wcDefaults.get_Value("url"),
//					(String) wcDefaults.get_Value("consumerkey"), (String) wcDefaults.get_Value("consumersecret"));
//			Woocommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);
//			
//			ManageWoocommerce manageWoocommerce = new ManageWoocommerce(wooCommerce);
//			syncWoo_iDempiere();
//			synciDempiere_Woo(manageWoocommerce);
//		}
//		
//		
//		private void syncWoo_iDempiere(){
//			MWooProducts wooProd = new MWooProducts(getCtx(), 0, null);
//			
//			List<MWooProducts> listWooProd = wooProd.selectAllWooProd();
//			
//			//price 
//			int M_PriceList_ID = MSysConfig.getIntValue("LIT_Woocommerce_PriceList_ID", 0, Env.getAD_Client_ID(Env.getCtx()));
//			if(M_PriceList_ID == 0)
//				throw new AdempiereException(Msg.getMsg(Env.getAD_Language(getCtx()), "LIT_WooSystemConfig", new String[] {"'LIT_Woocommerce_PriceList_ID'"}));
//			MPriceList priceList = new MPriceList(Env.getCtx(), M_PriceList_ID, null);
//			MPriceListVersion priceListVer = priceList.getPriceListVersion(null);
//			int p_M_PriceList_Version_ID = priceListVer.getM_PriceList_Version_ID();
//			
//			//locator
//			MWarehouse warehouse = MWarehouse.get(Env.getCtx(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"));
//			MLocator locator = warehouse.getDefaultLocator();
//			
//			boolean updProd = false;
//			for (MWooProducts mWooProduct : listWooProd) {
//				MProduct mProduct = null;
//				
//				mProduct = new Query(getCtx(), MProduct.Table_Name, MProduct.COLUMNNAME_SKU+"=?", null)
//				.setClient_ID()
//				.setParameters(mWooProduct.getLIT_Sku())
//				.first();
//				
//				if(mProduct == null)
//					mProduct = new MProduct(getCtx(), 0, null);
//				else{
//					if(mProduct.getUpdated().before(mWooProduct.getLIT_UpdatedAt()))
//						updProd = true;
//				}
//
//				if(mProduct.getM_Product_ID()==0 || updProd){
//					
//					mProduct.setValue(mWooProduct.getLIT_Sku());
//					mProduct.setSKU(mWooProduct.getLIT_Sku());
//					mProduct.setName(mWooProduct.getName());
//					if(mWooProduct.getLIT_ShortDescription()!=null)
//						mProduct.setDescription(mWooProduct.getLIT_ShortDescription().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", ""));
//					else
//						mProduct.setDescription("");
//					if(mWooProduct.getLIT_DescriptionWoo()!=null)
//						mProduct.setDocumentNote(mWooProduct.getLIT_DescriptionWoo().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", ""));
//					else
//						mProduct.setDocumentNote("");
//					//Product category
//					int M_Product_Category_ID = DB.getSQLValue(null, "SELECT M_Product_Category_ID FROM M_Product_Category WHERE Name=? AND AD_Client_ID=?",mWooProduct.getLIT_CategoryWoo(), Env.getAD_Client_ID(Env.getCtx()));
//					if(M_Product_Category_ID>0)
//						mProduct.setM_Product_Category_ID(M_Product_Category_ID);
//					else
//						throw new AdempiereException("Impossibile caricare il prodotto - "+mWooProduct.getName()+"["+mWooProduct.getLIT_Sku()+"] - : categoria prodotto '"+mWooProduct.getLIT_CategoryWoo()+"' non presente a sistema");
//					//
//					if(!updProd){
//						MTaxCategory taxCateg = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_Name+" LIKE ?", null)
//								.setClient_ID()
//								.setParameters("%IVA%22%")
//								.first();
//						if(taxCateg!=null)
//							mProduct.setC_TaxCategory_ID(taxCateg.getC_TaxCategory_ID()); //TODO   22%....
//						else
//							mProduct.setC_TaxCategory_ID(Env.getContextAsInt(getCtx(), "#C_TaxCategory_ID")); //TODO   standard....
//						
//						if(mWooProduct.isLIT_IsManagingStock())
//							mProduct.setProductType(MProduct.PRODUCTTYPE_Item);//TODO   "Item"....
//						else
//							mProduct.setProductType(MProduct.PRODUCTTYPE_Service);//TODO   "Service"....
//						
//						mProduct.setC_UOM_ID(Env.getContextAsInt(getCtx(), "#C_UOM_ID"));
//						
//						boolean isStock = mWooProduct.isLIT_IsInStock();
//						mProduct.setIsStocked(isStock);
//						
//						//locator/warehouse
//						if(isStock){
//							if(locator != null){
//								mProduct.saveEx();
//								
//								MStorageOnHand s1 = MStorageOnHand.getCreate(getCtx(), locator.getM_Locator_ID(), mProduct.getM_Product_ID(), 0,null, null);
//								s1.setQtyOnHand(new BigDecimal(mWooProduct.getLIT_StockQuantity()));
//								s1.saveEx();
//								
//								mProduct.setM_Locator_ID(locator.getM_Locator_ID());
//							}
//						}
//						mProduct.saveEx();
//					}
//				
//					if (p_M_PriceList_Version_ID != 0)
//					{
//						BigDecimal PriceList = mWooProduct.getLIT_RegularPrice();
//						BigDecimal PriceStd = mWooProduct.getPrice();
//						BigDecimal PriceLimit = mWooProduct.getPrice();
//						if (PriceStd.signum() != 0 || PriceLimit.signum() != 0 || PriceList.signum() != 0)
//						{
//							MProductPrice pp = MProductPrice.get(getCtx(), 
//								p_M_PriceList_Version_ID, mProduct.getM_Product_ID(), null);
//							if (pp == null)
//								pp = new MProductPrice (getCtx(), 
//									p_M_PriceList_Version_ID, mProduct.getM_Product_ID(), null);
//							pp.setPrices(PriceList, PriceStd, PriceLimit);
//							
//							pp.saveEx();
//						}
//					}
//					mProduct.setImageURL(mWooProduct.getLIT_ImageUrl());
//					
//					mProduct.saveEx();
//	/*				
//					String message = "Product Processed: "+order.getDocumentNo();
//					addLog(order.getC_Order_ID(), order.getDateOrdered(), null, message, order.get_Table_ID(), order.getC_Order_ID());
//	*/				
//					
//					final String sqlupd = "UPDATE " + MProduct.Table_Name
//							+" SET " + MProduct.COLUMNNAME_Created+"=?,"+ MProduct.COLUMNNAME_Updated+"=? "
//							+" WHERE " + MProduct.COLUMNNAME_M_Product_ID+"=?";
//						DB.executeUpdateEx(sqlupd, new Object[]{mWooProduct.getLIT_CreatedAt(), mWooProduct.getLIT_UpdatedAt(), mProduct.getM_Product_ID()}, null);
//
//						updProd = false;
//						
//						addLog(mProduct.getM_Product_ID(), new Timestamp(System.currentTimeMillis()), null, 
//								"INSERT/UPDATE_TO_iDEMPIERE___Value: "+mProduct.getValue()+" --- SKU: "+mProduct.getSKU()+" --- Nome: "+mProduct.getName());
//				}
//			}
//		}
//		
//		private void synciDempiere_Woo(ManageWoocommerce manageWoocommerce){
//			
//			//price 
//			int M_PriceList_ID = MSysConfig.getIntValue("LIT_Woocommerce_PriceList_ID", 0, Env.getAD_Client_ID(Env.getCtx()));
//			if(M_PriceList_ID == 0)
//				throw new AdempiereException("Set 'LIT_Woocommerce_PriceList_ID' from SystemConfigurator....");
//			MPriceList priceList = new MPriceList(Env.getCtx(), M_PriceList_ID, null);
//			MPriceListVersion priceListVer = priceList.getPriceListVersion(null);
//			int p_M_PriceList_Version_ID = priceListVer.getM_PriceList_Version_ID();
//			
//			//locator
//			MWarehouse warehouse = MWarehouse.get(Env.getCtx(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"));
//			MLocator locator = warehouse.getDefaultLocator();
//			
//			String whereClause = MProduct.COLUMNNAME_IsSelfService+"=? "
//					+ "AND "+MProduct.COLUMNNAME_SKU+" IS NOT NULL "
//					+ "AND NOT EXISTS (SELECT * FROM "+MWooProducts.Table_Name+ " od "
//						+ "WHERE "+ MProduct.Table_Name+"."+MProduct.COLUMNNAME_SKU+" =  od."+MWooProducts.COLUMNNAME_LIT_Sku
//						+ " AND od."+MWooProducts.COLUMNNAME_AD_Client_ID+"=?)";
//			
//			List<MProduct> listProducts = new Query(getCtx(), MProduct.Table_Name, whereClause , null)
//					.setClient_ID()
//					.setParameters("Y", Env.getAD_Client_ID(getCtx()))
//					.list();
//	//(line 555)		if(listProducts.size()>0){
//				
////				int idWoo = DB.getSQLValue(null, "SELECT MAX("+MWooProducts.COLUMNNAME_LIT_IdProdWoo+") FROM "+MWooProducts.Table_Name)+1;
//				
//			Product productRest = null;
//			if(listWoo == null)
//				listWoo = new ArrayList<Product>();
//			
//			List<Category> listCategories = null;
//			
//			//createNew ____ 01/06/2018
//			for (MProduct mProduct : listProducts) {
//				productRest = new Product();
//				
////				productRest.setId(idWoo);
//				productRest.setName(mProduct.getName());
//				productRest.setDateCreated(mProduct.getCreated().toString());
//				productRest.setDateModified(mProduct.getUpdated().toString());
//				productRest.setSku(mProduct.getSKU());
//				
//				productRest.setDescription("<p> "+mProduct.getDocumentNote()+" </p>");
//				productRest.setShortDescription(mProduct.getDescription());
//				if(mProduct.getM_Product_Category()!=null){
//					listCategories = new ArrayList<Category>();
//					Category prodCateg = manageWoocommerce.getProductCategory(mProduct.getM_Product_Category().getName());
//					listCategories.add(prodCateg);
//					productRest.setCategories(listCategories);
//				}
//
//				//TODO....tax
////				if(mProduct.getC_TaxCategory()!=null){
////					productRest.setTaxClass(mProduct.getC_TaxCategory().getName());
////				}
//				if(mProduct.getProductType().equals(MProduct.PRODUCTTYPE_Item)){
//					BigDecimal qtyStock = MStorageOnHand.getQtyOnHand(mProduct.getM_Product_ID(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"), 0, null);
//					
//					if(qtyStock.intValue()>0){
//						productRest.setStockStatus("instock");
//						productRest.setManageStock(true);
//						productRest.setStockQuantity(qtyStock.intValue());
//					}
//					else{
//						productRest.setStockStatus("outofstock");
//						productRest.setManageStock(true);
//						productRest.setStockQuantity(0);
//					}
//
//				}
//				else{
//					productRest.setStockStatus("outofstock");
//					productRest.setManageStock(false);
//					//productRest.setStockQuantity(1);
//					productRest.setVirtual(true);
//				}
//				
//				if(p_M_PriceList_Version_ID>0){
//					MProductPrice prodPrice = MProductPrice.get(getCtx(), p_M_PriceList_Version_ID, mProduct.getM_Product_ID(), null);
//					
//					if(prodPrice != null){
//						productRest.setRegularPrice(prodPrice.getPriceList().toString());					
//						productRest.setSalePrice(prodPrice.getPriceStd().toString());
//					}
//				}
//				
//				if(mProduct.getImageURL()!=null && !mProduct.getImageURL().isEmpty()){
//					List<Image> listImages = new ArrayList<Image>();
//					Image image = new Image();
//					//image.setId(1);
//					image.setSrc(mProduct.getImageURL());
//					listImages.add(image);
//					productRest.setImages(listImages);
//				}    // TODO Image.....
//				
//				listWoo.add(productRest);
//				addLog(mProduct.getM_Product_ID(), new Timestamp(System.currentTimeMillis()), null, 
//						"INSERT_TO_WOOCOMMERCE___Value: "+mProduct.getValue()+" --- SKU: "+mProduct.getSKU()+" --- Nome: "+mProduct.getName());
////					idWoo++;
//			}
//			if(listWoo.size()>0){
//				int limit = 10;
//				List<Product> tmpLst = new ArrayList<Product>();
//				while(listWoo.size()>0) {
//					if(listWoo.size()<=limit) {
//						manageWoocommerce.updateProductsTOpost(listWoo,true);
//						listWoo.clear();
//					}
//					else {
//						for (int i = 0; i < limit; i++) {
//							tmpLst.add(listWoo.get(0));
//							listWoo.remove(0);
//						}
//						manageWoocommerce.updateProductsTOpost(tmpLst,true);
//						tmpLst.clear();
//					}
//				}
//				//manageWoocommerce.updateProductsTOpost(listWoo,true);
//				
//			}
//			//createNew ____ 01/06/2018 END
//			
//			listWoo.clear();
//					
//			//Update ____ 01/06/2018
//			whereClause = MProduct.COLUMNNAME_IsSelfService+"=? "
//					+ "AND "+MProduct.COLUMNNAME_SKU+" IS NOT NULL "
//					+ "AND "+MProduct.COLUMNNAME_Updated +"> (SELECT "+MWooProducts.COLUMNNAME_LIT_UpdatedAt+ " FROM "+MWooProducts.Table_Name+
//					" mw WHERE "+MProduct.Table_Name+"."+MProduct.COLUMNNAME_SKU+" =  mw."+MWooProducts.COLUMNNAME_LIT_Sku
//					 	+" AND mw."+MWooProducts.COLUMNNAME_AD_Client_ID+"=?)";
//			listProducts = null;
//			listProducts = new Query(getCtx(), MProduct.Table_Name, whereClause , null)
//					.setClient_ID()
//					.setParameters("Y", Env.getAD_Client_ID(getCtx()))
//					.list();
//			
//			int idWoo = 0;
//			for (MProduct prodUpd : listProducts) {
//				
//				productRest = new Product();
//				
//				idWoo = DB.getSQLValue(null, 
//						"SELECT "+MWooProducts.COLUMNNAME_LIT_IdProdWoo+ " FROM "+MWooProducts.Table_Name 
//						+" WHERE "+MWooProducts.COLUMNNAME_LIT_Sku+"=? "
//						+ "AND "+MWooProducts.COLUMNNAME_AD_Client_ID+"="+Env.getAD_Client_ID(getCtx()),
//						prodUpd.getSKU());
//				
//				productRest.setId(idWoo);
//				productRest.setName(prodUpd.getName());
//				productRest.setDateCreated(prodUpd.getCreated().toString());
//				productRest.setDateModified(prodUpd.getUpdated().toString());
//				productRest.setSku(prodUpd.getSKU());
//				
//				productRest.setDescription("<p> "+prodUpd.getDocumentNote()+" </p>");
//				productRest.setShortDescription(prodUpd.getDescription());
//				if(prodUpd.getM_Product_Category()!=null){
//
//					listCategories = new ArrayList<Category>();
//					Category prodCateg = manageWoocommerce.getProductCategory(prodUpd.getM_Product_Category().getName());
//					listCategories.add(prodCateg);
//					productRest.setCategories(listCategories);
//
//				}
//
//				//TODO....tax
////				if(mProduct.getC_TaxCategory()!=null){
////					productRest.setTaxClass(mProduct.getC_TaxCategory().getName());
////				}
//				if(prodUpd.getProductType().equals(MProduct.PRODUCTTYPE_Item)){
//					BigDecimal qtyStock = MStorageOnHand.getQtyOnHand(prodUpd.getM_Product_ID(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"), 0, null);
//					if(qtyStock.intValue()>0){
//						productRest.setStockStatus("instock");
//						productRest.setManageStock(true);
//						productRest.setStockQuantity(qtyStock.intValue());
//					}
//					else{
//						productRest.setStockStatus("outofstock");
//						productRest.setManageStock(true);
//						productRest.setStockQuantity(0);
//					}
//				}
//				
//				else{
//					productRest.setStockStatus("outofstock");
//					productRest.setManageStock(true);
//					productRest.setStockQuantity(1);
//				}
//				
//				if(p_M_PriceList_Version_ID>0){
//					MProductPrice prodPrice = MProductPrice.get(getCtx(), p_M_PriceList_Version_ID, prodUpd.getM_Product_ID(), null);
//					
//					if(prodPrice != null){
//						productRest.setRegularPrice(prodPrice.getPriceList().toString());					
//						productRest.setSalePrice(prodPrice.getPriceStd().toString());
//					}
//				}
//				
//				if(prodUpd.getImageURL()!=null && !prodUpd.getImageURL().isEmpty()){
//					List<Image> listImages = new ArrayList<Image>();
//					Image image = new Image();
//					//image.setId(1);
//					image.setSrc(prodUpd.getImageURL());
//					listImages.add(image);
//					productRest.setImages(listImages);
//				}     //TODO Image.....
//				
//				listWoo.add(productRest);
//				addLog(prodUpd.getM_Product_ID(), new Timestamp(System.currentTimeMillis()), null, 
//						"UPDATE_TO_WOOCOMMERCE___Value: "+prodUpd.getValue()+" --- SKU: "+prodUpd.getSKU()+" --- Nome: "+prodUpd.getName());
//			}
//			
//			if(listWoo.size()>0){
//				int limit = 10;
//				List<Product> tmpLst = new ArrayList<Product>();
//				while(listWoo.size()>0) {
//					if(listWoo.size()<=limit) {
//						manageWoocommerce.updateProductsTOpost(listWoo,false);
//						listWoo.clear();
//					}
//					else {
//						for (int i = 0; i < limit; i++) {
//							tmpLst.add(listWoo.get(0));
//							listWoo.remove(0);
//						}
//						manageWoocommerce.updateProductsTOpost(tmpLst,false);
//						tmpLst.clear();
//					}
//				}
//				//manageWoocommerce.updateProductsTOpost(listWoo,false);
//			}
//			//Update ____ 01/06/2018 END
//		}
//		
//		
//	}
}
