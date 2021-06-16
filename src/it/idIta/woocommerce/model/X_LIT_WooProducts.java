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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for LIT_WooProducts
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_LIT_WooProducts extends PO implements I_LIT_WooProducts, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180529L;

    /** Standard Constructor */
    public X_LIT_WooProducts (Properties ctx, int LIT_WooProducts_ID, String trxName)
    {
      super (ctx, LIT_WooProducts_ID, trxName);
      /** if (LIT_WooProducts_ID == 0)
        {
			setLIT_WooProducts_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_LIT_WooProducts (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LIT_WooProducts[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Average Rating.
		@param LIT_AverageRating Average Rating	  */
	public void setLIT_AverageRating (String LIT_AverageRating)
	{
		set_Value (COLUMNNAME_LIT_AverageRating, LIT_AverageRating);
	}

	/** Get Average Rating.
		@return Average Rating	  */
	public String getLIT_AverageRating () 
	{
		return (String)get_Value(COLUMNNAME_LIT_AverageRating);
	}

	/** Set Button Text.
		@param LIT_ButtonText Button Text	  */
	public void setLIT_ButtonText (String LIT_ButtonText)
	{
		set_Value (COLUMNNAME_LIT_ButtonText, LIT_ButtonText);
	}

	/** Get Button Text.
		@return Button Text	  */
	public String getLIT_ButtonText () 
	{
		return (String)get_Value(COLUMNNAME_LIT_ButtonText);
	}

	/** Set Catalog Visibility.
		@param LIT_CatalogVisibility Catalog Visibility	  */
	public void setLIT_CatalogVisibility (String LIT_CatalogVisibility)
	{
		set_Value (COLUMNNAME_LIT_CatalogVisibility, LIT_CatalogVisibility);
	}

	/** Get Catalog Visibility.
		@return Catalog Visibility	  */
	public String getLIT_CatalogVisibility () 
	{
		return (String)get_Value(COLUMNNAME_LIT_CatalogVisibility);
	}

	/** Set Product Category Woocommerce.
		@param LIT_CategoryWoo Product Category Woocommerce	  */
	public void setLIT_CategoryWoo (String LIT_CategoryWoo)
	{
		set_Value (COLUMNNAME_LIT_CategoryWoo, LIT_CategoryWoo);
	}

	/** Get Product Category Woocommerce.
		@return Product Category Woocommerce	  */
	public String getLIT_CategoryWoo () 
	{
		return (String)get_Value(COLUMNNAME_LIT_CategoryWoo);
	}

	/** Set Created At.
		@param LIT_CreatedAt Created At	  */
	public void setLIT_CreatedAt (Timestamp LIT_CreatedAt)
	{
		set_Value (COLUMNNAME_LIT_CreatedAt, LIT_CreatedAt);
	}

	/** Get Created At.
		@return Created At	  */
	public Timestamp getLIT_CreatedAt () 
	{
		return (Timestamp)get_Value(COLUMNNAME_LIT_CreatedAt);
	}

	/** Set Description Woo.
		@param LIT_DescriptionWoo Description Woo	  */
	public void setLIT_DescriptionWoo (String LIT_DescriptionWoo)
	{
		set_Value (COLUMNNAME_LIT_DescriptionWoo, LIT_DescriptionWoo);
	}

	/** Get Description Woo.
		@return Description Woo	  */
	public String getLIT_DescriptionWoo () 
	{
		return (String)get_Value(COLUMNNAME_LIT_DescriptionWoo);
	}

	/** Set Dim_Height.
		@param LIT_DimHeight Dim_Height	  */
	public void setLIT_DimHeight (BigDecimal LIT_DimHeight)
	{
		set_Value (COLUMNNAME_LIT_DimHeight, LIT_DimHeight);
	}

	/** Get Dim_Height.
		@return Dim_Height	  */
	public BigDecimal getLIT_DimHeight () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_DimHeight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Dim_Length.
		@param LIT_DimLength Dim_Length	  */
	public void setLIT_DimLength (BigDecimal LIT_DimLength)
	{
		set_Value (COLUMNNAME_LIT_DimLength, LIT_DimLength);
	}

	/** Get Dim_Length.
		@return Dim_Length	  */
	public BigDecimal getLIT_DimLength () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_DimLength);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Dim_Unit.
		@param LIT_DimUnit Dim_Unit	  */
	public void setLIT_DimUnit (String LIT_DimUnit)
	{
		set_Value (COLUMNNAME_LIT_DimUnit, LIT_DimUnit);
	}

	/** Get Dim_Unit.
		@return Dim_Unit	  */
	public String getLIT_DimUnit () 
	{
		return (String)get_Value(COLUMNNAME_LIT_DimUnit);
	}

	/** Set Dim_Width.
		@param LIT_DimWidth Dim_Width	  */
	public void setLIT_DimWidth (BigDecimal LIT_DimWidth)
	{
		set_Value (COLUMNNAME_LIT_DimWidth, LIT_DimWidth);
	}

	/** Get Dim_Width.
		@return Dim_Width	  */
	public BigDecimal getLIT_DimWidth () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_DimWidth);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Download Expiry.
		@param LIT_DownloadExpiry Download Expiry	  */
	public void setLIT_DownloadExpiry (int LIT_DownloadExpiry)
	{
		set_Value (COLUMNNAME_LIT_DownloadExpiry, Integer.valueOf(LIT_DownloadExpiry));
	}

	/** Get Download Expiry.
		@return Download Expiry	  */
	public int getLIT_DownloadExpiry () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_DownloadExpiry);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Download Limit.
		@param LIT_DownloadLimit Download Limit	  */
	public void setLIT_DownloadLimit (int LIT_DownloadLimit)
	{
		set_Value (COLUMNNAME_LIT_DownloadLimit, Integer.valueOf(LIT_DownloadLimit));
	}

	/** Get Download Limit.
		@return Download Limit	  */
	public int getLIT_DownloadLimit () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_DownloadLimit);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Download Type.
		@param LIT_DownloadType Download Type	  */
	public void setLIT_DownloadType (String LIT_DownloadType)
	{
		set_Value (COLUMNNAME_LIT_DownloadType, LIT_DownloadType);
	}

	/** Get Download Type.
		@return Download Type	  */
	public String getLIT_DownloadType () 
	{
		return (String)get_Value(COLUMNNAME_LIT_DownloadType);
	}

	/** Set Enabled Html Short Descr.
		@param LIT_EnabledHtmlShortDescr Enabled Html Short Descr	  */
	public void setLIT_EnabledHtmlShortDescr (String LIT_EnabledHtmlShortDescr)
	{
		set_Value (COLUMNNAME_LIT_EnabledHtmlShortDescr, LIT_EnabledHtmlShortDescr);
	}

	/** Get Enabled Html Short Descr.
		@return Enabled Html Short Descr	  */
	public String getLIT_EnabledHtmlShortDescr () 
	{
		return (String)get_Value(COLUMNNAME_LIT_EnabledHtmlShortDescr);
	}

	/** Set Id Product Woocommerce.
		@param LIT_IdProdWoo Id Product Woocommerce	  */
	public void setLIT_IdProdWoo (int LIT_IdProdWoo)
	{
		set_Value (COLUMNNAME_LIT_IdProdWoo, Integer.valueOf(LIT_IdProdWoo));
	}

	/** Get Id Product Woocommerce.
		@return Id Product Woocommerce	  */
	public int getLIT_IdProdWoo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_IdProdWoo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Image Url.
		@param LIT_ImageUrl Image Url	  */
	public void setLIT_ImageUrl (String LIT_ImageUrl)
	{
		set_Value (COLUMNNAME_LIT_ImageUrl, LIT_ImageUrl);
	}

	/** Get Image Url.
		@return Image Url	  */
	public String getLIT_ImageUrl () 
	{
		return (String)get_Value(COLUMNNAME_LIT_ImageUrl);
	}

	/** Set Backordered.
		@param LIT_IsBackordered Backordered	  */
	public void setLIT_IsBackordered (boolean LIT_IsBackordered)
	{
		set_Value (COLUMNNAME_LIT_IsBackordered, Boolean.valueOf(LIT_IsBackordered));
	}

	/** Get Backordered.
		@return Backordered	  */
	public boolean isLIT_IsBackordered () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsBackordered);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Backorders Allowed.
		@param LIT_IsBackordersAllowed Backorders Allowed	  */
	public void setLIT_IsBackordersAllowed (boolean LIT_IsBackordersAllowed)
	{
		set_Value (COLUMNNAME_LIT_IsBackordersAllowed, Boolean.valueOf(LIT_IsBackordersAllowed));
	}

	/** Get Backorders Allowed.
		@return Backorders Allowed	  */
	public boolean isLIT_IsBackordersAllowed () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsBackordersAllowed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Downloadable.
		@param LIT_IsDownloadable Downloadable	  */
	public void setLIT_IsDownloadable (boolean LIT_IsDownloadable)
	{
		set_Value (COLUMNNAME_LIT_IsDownloadable, Boolean.valueOf(LIT_IsDownloadable));
	}

	/** Get Downloadable.
		@return Downloadable	  */
	public boolean isLIT_IsDownloadable () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsDownloadable);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Enable Html Description.
		@param LIT_IsEnableHtmlDescription Enable Html Description	  */
	public void setLIT_IsEnableHtmlDescription (boolean LIT_IsEnableHtmlDescription)
	{
		set_Value (COLUMNNAME_LIT_IsEnableHtmlDescription, Boolean.valueOf(LIT_IsEnableHtmlDescription));
	}

	/** Get Enable Html Description.
		@return Enable Html Description	  */
	public boolean isLIT_IsEnableHtmlDescription () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsEnableHtmlDescription);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Featured.
		@param LIT_IsFeatured Featured	  */
	public void setLIT_IsFeatured (boolean LIT_IsFeatured)
	{
		set_Value (COLUMNNAME_LIT_IsFeatured, Boolean.valueOf(LIT_IsFeatured));
	}

	/** Get Featured.
		@return Featured	  */
	public boolean isLIT_IsFeatured () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsFeatured);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set In Stock.
		@param LIT_IsInStock In Stock	  */
	public void setLIT_IsInStock (boolean LIT_IsInStock)
	{
		set_Value (COLUMNNAME_LIT_IsInStock, Boolean.valueOf(LIT_IsInStock));
	}

	/** Get In Stock.
		@return In Stock	  */
	public boolean isLIT_IsInStock () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsInStock);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Managing Stock.
		@param LIT_IsManagingStock Managing Stock	  */
	public void setLIT_IsManagingStock (boolean LIT_IsManagingStock)
	{
		set_Value (COLUMNNAME_LIT_IsManagingStock, Boolean.valueOf(LIT_IsManagingStock));
	}

	/** Get Managing Stock.
		@return Managing Stock	  */
	public boolean isLIT_IsManagingStock () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsManagingStock);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set On Sale.
		@param LIT_IsOnSale On Sale	  */
	public void setLIT_IsOnSale (boolean LIT_IsOnSale)
	{
		set_Value (COLUMNNAME_LIT_IsOnSale, Boolean.valueOf(LIT_IsOnSale));
	}

	/** Get On Sale.
		@return On Sale	  */
	public boolean isLIT_IsOnSale () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsOnSale);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Purchaseable.
		@param LIT_IsPurchaseable Purchaseable	  */
	public void setLIT_IsPurchaseable (boolean LIT_IsPurchaseable)
	{
		set_Value (COLUMNNAME_LIT_IsPurchaseable, Boolean.valueOf(LIT_IsPurchaseable));
	}

	/** Get Purchaseable.
		@return Purchaseable	  */
	public boolean isLIT_IsPurchaseable () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsPurchaseable);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Reviews Allowed.
		@param LIT_IsReviewsAllowed Reviews Allowed	  */
	public void setLIT_IsReviewsAllowed (boolean LIT_IsReviewsAllowed)
	{
		set_Value (COLUMNNAME_LIT_IsReviewsAllowed, Boolean.valueOf(LIT_IsReviewsAllowed));
	}

	/** Get Reviews Allowed.
		@return Reviews Allowed	  */
	public boolean isLIT_IsReviewsAllowed () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsReviewsAllowed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Shipping Class.
		@param LIT_IsShippingClass Shipping Class	  */
	public void setLIT_IsShippingClass (boolean LIT_IsShippingClass)
	{
		set_Value (COLUMNNAME_LIT_IsShippingClass, Boolean.valueOf(LIT_IsShippingClass));
	}

	/** Get Shipping Class.
		@return Shipping Class	  */
	public boolean isLIT_IsShippingClass () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsShippingClass);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Shipping Required.
		@param LIT_IsShippingRequired Shipping Required	  */
	public void setLIT_IsShippingRequired (boolean LIT_IsShippingRequired)
	{
		set_Value (COLUMNNAME_LIT_IsShippingRequired, Boolean.valueOf(LIT_IsShippingRequired));
	}

	/** Get Shipping Required.
		@return Shipping Required	  */
	public boolean isLIT_IsShippingRequired () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsShippingRequired);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set ShippingTaxable.
		@param LIT_IsShippingTaxable ShippingTaxable	  */
	public void setLIT_IsShippingTaxable (boolean LIT_IsShippingTaxable)
	{
		set_Value (COLUMNNAME_LIT_IsShippingTaxable, Boolean.valueOf(LIT_IsShippingTaxable));
	}

	/** Get ShippingTaxable.
		@return ShippingTaxable	  */
	public boolean isLIT_IsShippingTaxable () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsShippingTaxable);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sold Individually.
		@param LIT_IsSoldIndividually Sold Individually	  */
	public void setLIT_IsSoldIndividually (boolean LIT_IsSoldIndividually)
	{
		set_Value (COLUMNNAME_LIT_IsSoldIndividually, Boolean.valueOf(LIT_IsSoldIndividually));
	}

	/** Get Sold Individually.
		@return Sold Individually	  */
	public boolean isLIT_IsSoldIndividually () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsSoldIndividually);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Taxable.
		@param LIT_IsTaxable Taxable	  */
	public void setLIT_IsTaxable (boolean LIT_IsTaxable)
	{
		set_Value (COLUMNNAME_LIT_IsTaxable, Boolean.valueOf(LIT_IsTaxable));
	}

	/** Get Taxable.
		@return Taxable	  */
	public boolean isLIT_IsTaxable () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsTaxable);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Virtual.
		@param LIT_IsVirtual Virtual	  */
	public void setLIT_IsVirtual (boolean LIT_IsVirtual)
	{
		set_Value (COLUMNNAME_LIT_IsVirtual, Boolean.valueOf(LIT_IsVirtual));
	}

	/** Get Virtual.
		@return Virtual	  */
	public boolean isLIT_IsVirtual () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsVirtual);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Visible.
		@param LIT_IsVisible Visible	  */
	public void setLIT_IsVisible (boolean LIT_IsVisible)
	{
		set_Value (COLUMNNAME_LIT_IsVisible, Boolean.valueOf(LIT_IsVisible));
	}

	/** Get Visible.
		@return Visible	  */
	public boolean isLIT_IsVisible () 
	{
		Object oo = get_Value(COLUMNNAME_LIT_IsVisible);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Menu Order.
		@param LIT_MenuOrder Menu Order	  */
	public void setLIT_MenuOrder (int LIT_MenuOrder)
	{
		set_Value (COLUMNNAME_LIT_MenuOrder, Integer.valueOf(LIT_MenuOrder));
	}

	/** Get Menu Order.
		@return Menu Order	  */
	public int getLIT_MenuOrder () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_MenuOrder);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name Product Woocommerce.
		@param LIT_NameProdWoo Name Product Woocommerce	  */
	public void setLIT_NameProdWoo (String LIT_NameProdWoo)
	{
		set_Value (COLUMNNAME_LIT_NameProdWoo, LIT_NameProdWoo);
	}

	/** Get Name Product Woocommerce.
		@return Name Product Woocommerce	  */
	public String getLIT_NameProdWoo () 
	{
		return (String)get_Value(COLUMNNAME_LIT_NameProdWoo);
	}

	/** Set Parent Id Woo.
		@param LIT_ParentId_Woo Parent Id Woo	  */
	public void setLIT_ParentId_Woo (int LIT_ParentId_Woo)
	{
		set_Value (COLUMNNAME_LIT_ParentId_Woo, Integer.valueOf(LIT_ParentId_Woo));
	}

	/** Get Parent Id Woo.
		@return Parent Id Woo	  */
	public int getLIT_ParentId_Woo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_ParentId_Woo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Permalink.
		@param LIT_Permalink Permalink	  */
	public void setLIT_Permalink (String LIT_Permalink)
	{
		set_Value (COLUMNNAME_LIT_Permalink, LIT_Permalink);
	}

	/** Get Permalink.
		@return Permalink	  */
	public String getLIT_Permalink () 
	{
		return (String)get_Value(COLUMNNAME_LIT_Permalink);
	}

	/** Set Price Html.
		@param LIT_PriceHtml Price Html	  */
	public void setLIT_PriceHtml (String LIT_PriceHtml)
	{
		set_Value (COLUMNNAME_LIT_PriceHtml, LIT_PriceHtml);
	}

	/** Get Price Html.
		@return Price Html	  */
	public String getLIT_PriceHtml () 
	{
		return (String)get_Value(COLUMNNAME_LIT_PriceHtml);
	}

	/** Set Product Url.
		@param LIT_ProductUrl Product Url	  */
	public void setLIT_ProductUrl (String LIT_ProductUrl)
	{
		set_Value (COLUMNNAME_LIT_ProductUrl, LIT_ProductUrl);
	}

	/** Get Product Url.
		@return Product Url	  */
	public String getLIT_ProductUrl () 
	{
		return (String)get_Value(COLUMNNAME_LIT_ProductUrl);
	}

	/** Set Purchase Note.
		@param LIT_PurchaseNote Purchase Note	  */
	public void setLIT_PurchaseNote (String LIT_PurchaseNote)
	{
		set_Value (COLUMNNAME_LIT_PurchaseNote, LIT_PurchaseNote);
	}

	/** Get Purchase Note.
		@return Purchase Note	  */
	public String getLIT_PurchaseNote () 
	{
		return (String)get_Value(COLUMNNAME_LIT_PurchaseNote);
	}

	/** Set Rating Count.
		@param LIT_RatingCount Rating Count	  */
	public void setLIT_RatingCount (int LIT_RatingCount)
	{
		set_Value (COLUMNNAME_LIT_RatingCount, Integer.valueOf(LIT_RatingCount));
	}

	/** Get Rating Count.
		@return Rating Count	  */
	public int getLIT_RatingCount () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_RatingCount);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Regular Price.
		@param LIT_RegularPrice Regular Price	  */
	public void setLIT_RegularPrice (BigDecimal LIT_RegularPrice)
	{
		set_Value (COLUMNNAME_LIT_RegularPrice, LIT_RegularPrice);
	}

	/** Get Regular Price.
		@return Regular Price	  */
	public BigDecimal getLIT_RegularPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_RegularPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sale Price.
		@param LIT_SalePrice Sale Price	  */
	public void setLIT_SalePrice (BigDecimal LIT_SalePrice)
	{
		set_Value (COLUMNNAME_LIT_SalePrice, LIT_SalePrice);
	}

	/** Get Sale Price.
		@return Sale Price	  */
	public BigDecimal getLIT_SalePrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_SalePrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sale Price Dates From.
		@param LIT_SalePriceDatesFrom Sale Price Dates From	  */
	public void setLIT_SalePriceDatesFrom (Timestamp LIT_SalePriceDatesFrom)
	{
		set_Value (COLUMNNAME_LIT_SalePriceDatesFrom, LIT_SalePriceDatesFrom);
	}

	/** Get Sale Price Dates From.
		@return Sale Price Dates From	  */
	public Timestamp getLIT_SalePriceDatesFrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_LIT_SalePriceDatesFrom);
	}

	/** Set Sale Price Dates To.
		@param LIT_SalePriceDatesTo Sale Price Dates To	  */
	public void setLIT_SalePriceDatesTo (Timestamp LIT_SalePriceDatesTo)
	{
		set_Value (COLUMNNAME_LIT_SalePriceDatesTo, LIT_SalePriceDatesTo);
	}

	/** Get Sale Price Dates To.
		@return Sale Price Dates To	  */
	public Timestamp getLIT_SalePriceDatesTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_LIT_SalePriceDatesTo);
	}

	/** Set Shipping Class Id.
		@param LIT_ShippingClassId Shipping Class Id	  */
	public void setLIT_ShippingClassId (int LIT_ShippingClassId)
	{
		set_Value (COLUMNNAME_LIT_ShippingClassId, Integer.valueOf(LIT_ShippingClassId));
	}

	/** Get Shipping Class Id.
		@return Shipping Class Id	  */
	public int getLIT_ShippingClassId () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_ShippingClassId);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Short Description.
		@param LIT_ShortDescription Short Description	  */
	public void setLIT_ShortDescription (String LIT_ShortDescription)
	{
		set_Value (COLUMNNAME_LIT_ShortDescription, LIT_ShortDescription);
	}

	/** Get Short Description.
		@return Short Description	  */
	public String getLIT_ShortDescription () 
	{
		return (String)get_Value(COLUMNNAME_LIT_ShortDescription);
	}

	/** Set Sku.
		@param LIT_Sku Sku	  */
	public void setLIT_Sku (String LIT_Sku)
	{
		set_Value (COLUMNNAME_LIT_Sku, LIT_Sku);
	}

	/** Get Sku.
		@return Sku	  */
	public String getLIT_Sku () 
	{
		return (String)get_Value(COLUMNNAME_LIT_Sku);
	}

	/** Set Status Woo.
		@param LIT_StatusWoo Status Woo	  */
	public void setLIT_StatusWoo (String LIT_StatusWoo)
	{
		set_Value (COLUMNNAME_LIT_StatusWoo, LIT_StatusWoo);
	}

	/** Get Status Woo.
		@return Status Woo	  */
	public String getLIT_StatusWoo () 
	{
		return (String)get_Value(COLUMNNAME_LIT_StatusWoo);
	}

	/** Set Stock Quantity.
		@param LIT_StockQuantity Stock Quantity	  */
	public void setLIT_StockQuantity (int LIT_StockQuantity)
	{
		set_Value (COLUMNNAME_LIT_StockQuantity, Integer.valueOf(LIT_StockQuantity));
	}

	/** Get Stock Quantity.
		@return Stock Quantity	  */
	public int getLIT_StockQuantity () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_StockQuantity);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax Class.
		@param LIT_TaxClass Tax Class	  */
	public void setLIT_TaxClass (String LIT_TaxClass)
	{
		set_Value (COLUMNNAME_LIT_TaxClass, LIT_TaxClass);
	}

	/** Get Tax Class.
		@return Tax Class	  */
	public String getLIT_TaxClass () 
	{
		return (String)get_Value(COLUMNNAME_LIT_TaxClass);
	}

	/** Set Tax Status.
		@param LIT_TaxStatus Tax Status	  */
	public void setLIT_TaxStatus (String LIT_TaxStatus)
	{
		set_Value (COLUMNNAME_LIT_TaxStatus, LIT_TaxStatus);
	}

	/** Get Tax Status.
		@return Tax Status	  */
	public String getLIT_TaxStatus () 
	{
		return (String)get_Value(COLUMNNAME_LIT_TaxStatus);
	}

	/** Set Total Sales.
		@param LIT_TotalSales Total Sales	  */
	public void setLIT_TotalSales (int LIT_TotalSales)
	{
		set_Value (COLUMNNAME_LIT_TotalSales, Integer.valueOf(LIT_TotalSales));
	}

	/** Get Total Sales.
		@return Total Sales	  */
	public int getLIT_TotalSales () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_TotalSales);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Type Product.
		@param LIT_TypeProdWoo Type Product	  */
	public void setLIT_TypeProdWoo (String LIT_TypeProdWoo)
	{
		set_Value (COLUMNNAME_LIT_TypeProdWoo, LIT_TypeProdWoo);
	}

	/** Get Type Product.
		@return Type Product	  */
	public String getLIT_TypeProdWoo () 
	{
		return (String)get_Value(COLUMNNAME_LIT_TypeProdWoo);
	}

	/** Set Updated At.
		@param LIT_UpdatedAt Updated At	  */
	public void setLIT_UpdatedAt (Timestamp LIT_UpdatedAt)
	{
		set_Value (COLUMNNAME_LIT_UpdatedAt, LIT_UpdatedAt);
	}

	/** Get Updated At.
		@return Updated At	  */
	public Timestamp getLIT_UpdatedAt () 
	{
		return (Timestamp)get_Value(COLUMNNAME_LIT_UpdatedAt);
	}

	/** Set Woocommerce Products.
		@param LIT_WooProducts_ID Woocommerce Products	  */
	public void setLIT_WooProducts_ID (int LIT_WooProducts_ID)
	{
		if (LIT_WooProducts_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LIT_WooProducts_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LIT_WooProducts_ID, Integer.valueOf(LIT_WooProducts_ID));
	}

	/** Get Woocommerce Products.
		@return Woocommerce Products	  */
	public int getLIT_WooProducts_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_WooProducts_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LIT_WooProducts_UU.
		@param LIT_WooProducts_UU LIT_WooProducts_UU	  */
	public void setLIT_WooProducts_UU (String LIT_WooProducts_UU)
	{
		set_Value (COLUMNNAME_LIT_WooProducts_UU, LIT_WooProducts_UU);
	}

	/** Get LIT_WooProducts_UU.
		@return LIT_WooProducts_UU	  */
	public String getLIT_WooProducts_UU () 
	{
		return (String)get_Value(COLUMNNAME_LIT_WooProducts_UU);
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

	/** Set Price.
		@param Price 
		Price
	  */
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Title.
		@param Title 
		Name this entity is referred to as
	  */
	public void setTitle (String Title)
	{
		set_ValueNoCheck (COLUMNNAME_Title, Title);
	}

	/** Get Title.
		@return Name this entity is referred to as
	  */
	public String getTitle () 
	{
		return (String)get_Value(COLUMNNAME_Title);
	}

	/** Set Weight.
		@param Weight 
		Weight of a product
	  */
	public void setWeight (BigDecimal Weight)
	{
		set_ValueNoCheck (COLUMNNAME_Weight, Weight);
	}

	/** Get Weight.
		@return Weight of a product
	  */
	public BigDecimal getWeight () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Weight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}