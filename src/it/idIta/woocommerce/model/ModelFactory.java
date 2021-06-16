package it.idIta.woocommerce.model;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;


public class ModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		
		if (X_LIT_WooProducts.Table_Name.equals(tableName))
			return MWooProducts.class;
		else if (X_LIT_EcommPayRule.Table_Name.equals(tableName))
			return MEcommPayRule.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		
		if (X_LIT_WooProducts.Table_Name.equals(tableName))
			return new MWooProducts(Env.getCtx(), Record_ID, trxName);
		else if (X_LIT_EcommPayRule.Table_Name.equals(tableName))
			return new MEcommPayRule(Env.getCtx(), Record_ID, trxName);
		
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		
		if (X_LIT_WooProducts.Table_Name.equals(tableName))
			return new MWooProducts(Env.getCtx(), rs, trxName);
		else if (X_LIT_EcommPayRule.Table_Name.equals(tableName))
			return new MEcommPayRule(Env.getCtx(), rs, trxName);
		
		return null;
	}

}
