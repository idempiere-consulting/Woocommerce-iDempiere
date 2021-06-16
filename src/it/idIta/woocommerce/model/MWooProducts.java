package it.idIta.woocommerce.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MWooProducts extends X_LIT_WooProducts {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6129730797046637914L;

	public MWooProducts(Properties ctx, int LIT_WooProducts_ID, String trxName) {
		super(ctx, LIT_WooProducts_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MWooProducts(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public List<MWooProducts> selectAllWooProd(){
		List<MWooProducts> list = null;
		
		list = new Query(getCtx(), MWooProducts.Table_Name, "", null).setClient_ID().list();
		
		return list;
	}
	
	public static void deleteWooProduct(int idWooProd){
		
		String SQL_DELETE_WOOPROD = "DELETE FROM "+ MWooProducts.Table_Name + " WHERE "+MWooProducts.COLUMNNAME_LIT_IdProdWoo+"=? AND AD_CLIENT_ID=?";

		DB.executeUpdateEx(SQL_DELETE_WOOPROD, new Object[] {idWooProd, Env.getAD_Client_ID(Env.getCtx())}, null);
			
	}
	
	public static void deleteAllWooProduct(){
		String SQL_DELETE_WOOPROD = "DELETE FROM "+ MWooProducts.Table_Name + " WHERE AD_CLIENT_ID=?";

		DB.executeUpdateEx(SQL_DELETE_WOOPROD, new Object[] {Env.getAD_Client_ID(Env.getCtx())}, null);
	}

}
