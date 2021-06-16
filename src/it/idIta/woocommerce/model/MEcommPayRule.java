package it.idIta.woocommerce.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MEcommPayRule extends X_LIT_EcommPayRule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -552430611406185439L;

	public MEcommPayRule(Properties ctx, int LIT_EcommPayRule_ID, String trxName) {
		super(ctx, LIT_EcommPayRule_ID, trxName);
	}

	public MEcommPayRule(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public static MEcommPayRule findByType(String typeEcommerce, String methodPay) {
		MEcommPayRule ecPayRule = null;
		
		ecPayRule = new Query(Env.getCtx(), Table_Name, "LIT_Ecommerce=? AND Value=?", null)
				.setOnlyActiveRecords(true)
				.setClient_ID()
				.setParameters(typeEcommerce, methodPay)
				.first();
		return ecPayRule;
	}
}
