package it.idIta.woocommerce.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.DBException;
import org.compiere.model.MLocator;
import org.compiere.model.MProduct;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.Woocommerce;
import com.icoderman.woocommerce.oauth.OAuthConfig;

import it.idIta.woocommerce.model.MWooProducts;
import it.idIta.woocommerce.pojo.Product;
import za.co.ntier.model.X_zz_woocommerce;

public class WooSyncStock extends SvrProcess {

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
		synchronizeStock(manageWoocommerce);
		
	
		return "Sync_Stock OK";
	}
	
	private void synchronizeStock(ManageWoocommerce manageWoocommerce){
		
		//locator
		//MWarehouse warehouse = MWarehouse.get(Env.getCtx(), Env.getContextAsInt(getCtx(), "#M_Warehouse_ID"));
		MWarehouse warehouse = new MWarehouse(getCtx(), wcDefaults.get_ValueAsInt("M_Warehouse_ID"), null);
		MLocator locator = warehouse.getDefaultLocator();

		Product productRest = null;
		
		List<MProduct> prodStock = getProductsStock();
		if(prodStock.size()>0)
			listWoo = new ArrayList<Product>();
		
		int tmpProductID = 0;
		MStorageOnHand storage = null;
		for (MProduct mProduct : prodStock) {
			if(mProduct.getM_Product_ID()!= tmpProductID){
				tmpProductID = mProduct.getM_Product_ID();
				storage = MStorageOnHand.get(getCtx(), locator.getM_Locator_ID(), mProduct.getM_Product_ID(), 0, null, null);
				if(storage != null){
					productRest = new Product();
					
					int idWoo = DB.getSQLValue(null, 
							"SELECT "+MWooProducts.COLUMNNAME_LIT_IdProdWoo+ " FROM "+MWooProducts.Table_Name 
							+" WHERE "+MWooProducts.COLUMNNAME_LIT_Sku+"=? "
							+ "AND "+MWooProducts.COLUMNNAME_AD_Client_ID+"="+Env.getAD_Client_ID(getCtx()),
							mProduct.getSKU());
					
					productRest.setId(idWoo);
					productRest.setDateCreated(storage.getCreated().toString());
					productRest.setDateModified(storage.getUpdated().toString());
					productRest.setStockStatus("instock");
					productRest.setManageStock(true);
					//TODO   productRest.setStockQuantity(storage.getQtyOnHand().intValue()); (??)
					productRest.setStockQuantity(MStorageOnHand.getQtyOnHand(mProduct.getM_Product_ID(), warehouse.getM_Warehouse_ID(), 0, null).intValue()); /// (???)
					
					listWoo.add(productRest);				
				}
			}
		}
		
		if(listWoo!=null && listWoo.size()>0){
			int limit = 90;
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
	}
	
	private List<MProduct> getProductsStock(){
		List<MProduct> list = new ArrayList<MProduct>();
		int AD_Client_ID = Env.getAD_Client_ID(getCtx());
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try
		{
			sql="SELECT * FROM M_PRODUCT "
					+ "INNER JOIN LIT_WOOPRODUCTS ON M_PRODUCT.SKU = LIT_WOOPRODUCTS.LIT_SKU "
					+ "INNER JOIN M_STORAGEONHAND ON M_PRODUCT.M_PRODUCT_ID = M_STORAGEONHAND.M_PRODUCT_ID "
					+ "WHERE M_PRODUCT.AD_CLIENT_ID=? AND M_PRODUCT.AD_CLIENT_ID = LIT_WOOPRODUCTS.AD_CLIENT_ID "
					+ "AND LIT_WOOPRODUCTS.LIT_ISINSTOCK = 'Y' "
					+ "AND LIT_WOOPRODUCTS.LIT_STOCKQUANTITY <> M_STORAGEONHAND.QTYONHAND";
			
			pstmt = DB.prepareStatement(sql, get_TrxName());
			pstmt.setInt(1, AD_Client_ID);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				MProduct product = new MProduct(getCtx(), rs, null);
				list.add(product);
			}
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql, e);
			throw new DBException(e, sql);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		
		return list;
	}
}
