package it.idIta.woocommerce.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.Woocommerce;
import com.icoderman.woocommerce.oauth.OAuthConfig;

import it.idIta.woocommerce.pojo.AttributeIntoProduct;
import it.idIta.woocommerce.pojo.Product;
import it.idIta.woocommerce.pojo.ProductAttribute;
import it.idIta.woocommerce.pojo.ProductAttributeTerm;
import za.co.ntier.model.X_zz_woocommerce;

public class WooSyncAttribute extends SvrProcess {

	private PO wcDefaults;
	private List<ProductAttribute> listPAttributeWoo = null;
	
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
		synchronizeAttributes(manageWoocommerce);
		synchronizeAttributeToProduct(manageWoocommerce);
		
	
		return "Sync_Attribute OK";
	}
	
	private void synchronizeAttributes(ManageWoocommerce manageWoocommerce){
		/// -----ProductAttribute
		List<List<Object>> records_Attributes = DB.getSQLArrayObjectsEx(null, "SELECT attribute_name FROM lit_wooprodattribute_v WHERE AD_Client_ID=? group by attribute_name", Env.getAD_Client_ID(getCtx()));
		if(records_Attributes.size()>0) {
			listPAttributeWoo = new ArrayList<ProductAttribute>();
			
			ProductAttribute patt = null;
			for (List<Object> object : records_Attributes) {
				patt = new ProductAttribute();
				patt.setName((String)object.get(0));
				listPAttributeWoo.add(patt);
			}
			records_Attributes = null;
			
			int limit = 90;
			List<ProductAttribute> tmpLst = new ArrayList<ProductAttribute>();
			List<ProductAttribute> result = new ArrayList<ProductAttribute>();
			while(listPAttributeWoo.size()>0) {
				if(listPAttributeWoo.size()<=limit) {
					result = manageWoocommerce.updateProdAttributeTOpost(listPAttributeWoo, true);
					listPAttributeWoo.clear();
				}
				else {
					for (int i = 0; i < limit; i++) {
						tmpLst.add(listPAttributeWoo.get(0));
						listPAttributeWoo.remove(0);
					}
					result.addAll(manageWoocommerce.updateProdAttributeTOpost(tmpLst, true));
					tmpLst.clear();
				}
			}
			
			/// -----ProductAttributeTerm
			List<List<Object>> records_AttributesTerms =  DB.getSQLArrayObjectsEx(null, 
					"SELECT attribute_name1, attribute_name FROM lit_wooprodattribute_v WHERE AD_Client_ID=? order by attribute_name", Env.getAD_Client_ID(getCtx()));
			if(records_AttributesTerms.size()>0) {
				ProductAttributeTerm pattTerm = null;
				
				TreeMap<Integer, List<ProductAttributeTerm>> update_UPD = new TreeMap<Integer, List<ProductAttributeTerm>>();
				for (List<Object> list : records_AttributesTerms) {
					String nameParentAttr = (String)list.get(1);
					pattTerm = new ProductAttributeTerm();
					pattTerm.setName((String)list.get(0));
					//listPAttributeTermWoo.add(pattTerm);
					int id =-1;
					Optional<Integer>  optResult = result.stream()
							.filter(x -> x.getName().equals(nameParentAttr))
							.map(ProductAttribute:: getId)
							.findAny();
					if(optResult!=null && optResult.isPresent())
						id = optResult.get();
					if(id > 0) {
						if(!update_UPD.containsKey(id))
							update_UPD.put(id, new ArrayList<ProductAttributeTerm>());
						update_UPD.get(id).add(pattTerm);
					}
				}
				records_AttributesTerms = null;
				
				List<ProductAttributeTerm> listPAttributeTermWoo = null;
				int idProdAttribute = 0;
				for (Map.Entry<Integer, List<ProductAttributeTerm>> entry: update_UPD.entrySet()) {
					idProdAttribute = entry.getKey();
					listPAttributeTermWoo = entry.getValue();
					List<ProductAttributeTerm> tmpLst2 = new ArrayList<ProductAttributeTerm>();
					while(listPAttributeTermWoo.size()>0) {
						if(listPAttributeTermWoo.size()<=limit) {
							manageWoocommerce.updateProdAttributeTermTOpost(listPAttributeTermWoo, true, idProdAttribute);
							listPAttributeTermWoo.clear();
						}
						else {
							for (int i = 0; i < limit; i++) {
								tmpLst2.add(listPAttributeTermWoo.get(0));
								listPAttributeTermWoo.remove(0);
							}
							manageWoocommerce.updateProdAttributeTermTOpost(tmpLst2, true, idProdAttribute);
							tmpLst.clear();
						}
					}
					listPAttributeTermWoo = null;
					tmpLst2 = null;
				}
			}
		}
		//manageWoocommerce.getTestProdAttribute();
		
	}
	
	private void synchronizeAttributeToProduct(ManageWoocommerce manageWoocommerce) {
		// "SELECT ad_client_id, ad_org_id, product_value, attribute_name1, attribute_name FROM lit_wooprodattribute_v WHERE AD_Client_ID=? order by product_value, attribute_name"
		List<List<Object>> records_ForProductAttributes =  DB.getSQLArrayObjectsEx(null, "SELECT product_sku FROM lit_wooprodattribute_v WHERE AD_Client_ID=? group by product_sku", Env.getAD_Client_ID(getCtx()));
		
		if(records_ForProductAttributes.size()>0) {
			List<Product> listProdutUpdated = new ArrayList<Product>();
			
			String product_valueSKU = "";
			Product prd_UPD = null;
			for (List<Object> object : records_ForProductAttributes) {
				product_valueSKU = (String)object.get(0);
				if(product_valueSKU==null || product_valueSKU.trim().length()<=0)
					continue;
					
				Product product_REST = manageWoocommerce.getProductBySKU(product_valueSKU);
				if(product_REST!=null) {
					prd_UPD = new Product();
					prd_UPD.setId(product_REST.getId());
					
					List<AttributeIntoProduct> attributes = new ArrayList<AttributeIntoProduct>();
					List<List<Object>> records_1 = DB.getSQLArrayObjectsEx(null, 
							"SELECT attribute_name1, attribute_name FROM lit_wooprodattribute_v WHERE AD_Client_ID =? and product_sku =? order by attribute_name", 
							Env.getAD_Client_ID(getCtx()), product_valueSKU);
					String atName_tmp = "";
					String attributeName  = "";
					List<String> option = new ArrayList<String>();
					int count = 1;
					for(List<Object> obj_1 : records_1) {
						attributeName = (String)obj_1.get(1);
						if(!attributeName.equals(atName_tmp)) {
							if(attributes.size()>0 && attributes.get(0)!=null) {
								attributes.get(0).setOptions(option);
								option = new ArrayList<String>();
							}
							attributes.add(0,new AttributeIntoProduct()); //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
							attributes.get(0).setName(attributeName);
							attributes.get(0).setPosition(0);
							attributes.get(0).setVariation(true);
							attributes.get(0).setVisible(true);
							atName_tmp = attributeName;
						}
						option.add((String)obj_1.get(0));
						if(count==records_1.size()) {
							attributes.get(0).setOptions(option);
							option = new ArrayList<String>();
						}
						count++;
					}
					prd_UPD.setAttributes(attributes);
					listProdutUpdated.add(prd_UPD);
				}
			}
			
			if(listProdutUpdated.size()>0) {
				int limit = 90;
				List<Product> tmpLst = new ArrayList<Product>();
				while(listProdutUpdated.size()>0) {
					if(listProdutUpdated.size()<=limit) {
						manageWoocommerce.updateProductsTOpost(listProdutUpdated,false);
						listProdutUpdated.clear();
					}
					else {
						for (int i = 0; i < limit; i++) {
							tmpLst.add(listProdutUpdated.get(0));
							listProdutUpdated.remove(0);
						}
						manageWoocommerce.updateProductsTOpost(tmpLst,false);
						tmpLst.clear();
					}
				}
			}
		}
	}
	
}
