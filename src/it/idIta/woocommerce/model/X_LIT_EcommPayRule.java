/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package it.idIta.woocommerce.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for LIT_EcommPayRule
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_LIT_EcommPayRule extends PO implements I_LIT_EcommPayRule, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200615L;

    /** Standard Constructor */
    public X_LIT_EcommPayRule (Properties ctx, int LIT_EcommPayRule_ID, String trxName)
    {
      super (ctx, LIT_EcommPayRule_ID, trxName);
      /** if (LIT_EcommPayRule_ID == 0)
        {
			setC_DocType_ID (0);
			setLIT_Ecommerce (null);
			setLIT_EcommPayRule_ID (0);
			setName (null);
			setPaymentRule (null);
// B
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_LIT_EcommPayRule (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_LIT_EcommPayRule[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** WooCommerce = WOO */
	public static final String LIT_ECOMMERCE_WooCommerce = "WOO";
	/** Amazon = AMZ */
	public static final String LIT_ECOMMERCE_Amazon = "AMZ";
	/** Ebay = EBY */
	public static final String LIT_ECOMMERCE_Ebay = "EBY";
	/** Set Type Ecommerce.
		@param LIT_Ecommerce Type Ecommerce	  */
	public void setLIT_Ecommerce (String LIT_Ecommerce)
	{

		set_Value (COLUMNNAME_LIT_Ecommerce, LIT_Ecommerce);
	}

	/** Get Type Ecommerce.
		@return Type Ecommerce	  */
	public String getLIT_Ecommerce () 
	{
		return (String)get_Value(COLUMNNAME_LIT_Ecommerce);
	}

	/** Set Ecommerce Payment Rule.
		@param LIT_EcommPayRule_ID Ecommerce Payment Rule	  */
	public void setLIT_EcommPayRule_ID (int LIT_EcommPayRule_ID)
	{
		if (LIT_EcommPayRule_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LIT_EcommPayRule_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LIT_EcommPayRule_ID, Integer.valueOf(LIT_EcommPayRule_ID));
	}

	/** Get Ecommerce Payment Rule.
		@return Ecommerce Payment Rule	  */
	public int getLIT_EcommPayRule_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_EcommPayRule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LIT_EcommPayRule_UU.
		@param LIT_EcommPayRule_UU LIT_EcommPayRule_UU	  */
	public void setLIT_EcommPayRule_UU (String LIT_EcommPayRule_UU)
	{
		set_Value (COLUMNNAME_LIT_EcommPayRule_UU, LIT_EcommPayRule_UU);
	}

	/** Get LIT_EcommPayRule_UU.
		@return LIT_EcommPayRule_UU	  */
	public String getLIT_EcommPayRule_UU () 
	{
		return (String)get_Value(COLUMNNAME_LIT_EcommPayRule_UU);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** PaymentRule AD_Reference_ID=195 */
	public static final int PAYMENTRULE_AD_Reference_ID=195;
	/** Cash = B */
	public static final String PAYMENTRULE_Cash = "B";
	/** Credit Card = K */
	public static final String PAYMENTRULE_CreditCard = "K";
	/** Direct Deposit = T */
	public static final String PAYMENTRULE_DirectDeposit = "T";
	/** Check = S */
	public static final String PAYMENTRULE_Check = "S";
	/** On Credit = P */
	public static final String PAYMENTRULE_OnCredit = "P";
	/** Direct Debit = D */
	public static final String PAYMENTRULE_DirectDebit = "D";
	/** Mixed POS Payment = M */
	public static final String PAYMENTRULE_MixedPOSPayment = "M";
	/** RID = F */
	public static final String PAYMENTRULE_RID = "F";
	/** Cash on delivery  = C */
	public static final String PAYMENTRULE_CashOnDelivery = "C";
	/** Set Payment Rule.
		@param PaymentRule 
		How you pay the invoice
	  */
	public void setPaymentRule (String PaymentRule)
	{

		set_Value (COLUMNNAME_PaymentRule, PaymentRule);
	}

	/** Get Payment Rule.
		@return How you pay the invoice
	  */
	public String getPaymentRule () 
	{
		return (String)get_Value(COLUMNNAME_PaymentRule);
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}