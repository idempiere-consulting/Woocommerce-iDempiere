package it.idIta.woocommerce.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.DBException;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
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

public class WooSyncPrice extends SvrProcess {

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
		synchronizePrice(manageWoocommerce);
		
	
		return "Sync_Price OK";
	}
	
	private void synchronizePrice(ManageWoocommerce manageWoocommerce){
		//price
//		int M_PriceList_ID = MSysConfig.getIntValue("LIT_Woocommerce_PriceList_ID", 0, Env.getAD_Client_ID(Env.getCtx()));
//		if(M_PriceList_ID == 0)
//			throw new AdempiereException(Msg.getMsg(Env.getAD_Language(getCtx()), "LIT_WooSystemConfig", new String[] {"'LIT_Woocommerce_PriceList_ID'"}));
		int M_PriceList_ID = wcDefaults.get_ValueAsInt("Local_Incl_PriceList_ID");
		MPriceList priceList = new MPriceList(Env.getCtx(), M_PriceList_ID, null);
		MPriceListVersion priceListVer = priceList.getPriceListVersion(null);
		int p_M_PriceList_Version_ID = priceListVer.getM_PriceList_Version_ID();
		
		List<MProduct> prodPrice = getProductsPrice(p_M_PriceList_Version_ID);
		if(prodPrice.size()>0)
			listWoo = new ArrayList<Product>();
		
		Product productRest = null;
		
		for (MProduct mProduct : prodPrice) {
			MProductPrice productPrice = MProductPrice.get(getCtx(), p_M_PriceList_Version_ID, mProduct.getM_Product_ID(), null);
			/*
			BigDecimal PriceList = mWooProduct.getLIT_RegularPrice();
				BigDecimal PriceStd = mWooProduct.getPrice();
				BigDecimal PriceLimit = mWooProduct.getPrice();
			*/
			if(productPrice != null){
				
				productRest = new Product();
				
				int idWoo = DB.getSQLValue(null, 
						"SELECT "+MWooProducts.COLUMNNAME_LIT_IdProdWoo+ " FROM "+MWooProducts.Table_Name 
						+" WHERE "+MWooProducts.COLUMNNAME_LIT_Sku+"=? "
						+ "AND "+MWooProducts.COLUMNNAME_AD_Client_ID+"="+Env.getAD_Client_ID(getCtx()),
						mProduct.getSKU());
				
				productRest.setId(idWoo);
				productRest.setDateCreated(productPrice.getCreated().toString());
				productRest.setDateModified(productPrice.getUpdated().toString());
				productRest.setRegularPrice(productPrice.getPriceList().toString());					
				productRest.setSalePrice(productPrice.getPriceStd().toString());
				
				listWoo.add(productRest);
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
	
	private List<MProduct> getProductsPrice(int priceListVersion){
		List<MProduct> list = new ArrayList<MProduct>();
		int AD_Client_ID = Env.getAD_Client_ID(getCtx());
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try
		{
			sql="SELECT * FROM M_PRODUCT "
				+ "INNER JOIN LIT_WOOPRODUCTS ON M_PRODUCT.SKU = LIT_WOOPRODUCTS.LIT_SKU "
				+ "INNER JOIN M_PRODUCTPRICE ON M_PRODUCT.M_PRODUCT_ID = M_PRODUCTPRICE.M_PRODUCT_ID "
				+ "WHERE M_PRODUCT.AD_CLIENT_ID=? AND M_PRODUCT.AD_CLIENT_ID = LIT_WOOPRODUCTS.AD_CLIENT_ID "
				+ "AND M_PRODUCTPRICE.M_PRICELIST_VERSION_ID = ? "
				+ "AND (LIT_WOOPRODUCTS.LIT_REGULARPRICE <> M_PRODUCTPRICE.PRICELIST OR LIT_WOOPRODUCTS.PRICE <> M_PRODUCTPRICE.PRICESTD OR LIT_WOOPRODUCTS.LIT_SALEPRICE <> M_PRODUCTPRICE.PRICELIST)";
					
			
			pstmt = DB.prepareStatement(sql, get_TrxName());
			pstmt.setInt(1, AD_Client_ID);
			pstmt.setInt(2, priceListVersion);
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
