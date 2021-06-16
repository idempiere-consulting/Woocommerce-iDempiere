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
package it.idIta.woocommerce.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for LIT_WooProducts
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_LIT_WooProducts 
{

    /** TableName=LIT_WooProducts */
    public static final String Table_Name = "LIT_WooProducts";

    /** AD_Table_ID=1000084 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name LIT_AverageRating */
    public static final String COLUMNNAME_LIT_AverageRating = "LIT_AverageRating";

	/** Set Average Rating	  */
	public void setLIT_AverageRating (String LIT_AverageRating);

	/** Get Average Rating	  */
	public String getLIT_AverageRating();

    /** Column name LIT_ButtonText */
    public static final String COLUMNNAME_LIT_ButtonText = "LIT_ButtonText";

	/** Set Button Text	  */
	public void setLIT_ButtonText (String LIT_ButtonText);

	/** Get Button Text	  */
	public String getLIT_ButtonText();

    /** Column name LIT_CatalogVisibility */
    public static final String COLUMNNAME_LIT_CatalogVisibility = "LIT_CatalogVisibility";

	/** Set Catalog Visibility	  */
	public void setLIT_CatalogVisibility (String LIT_CatalogVisibility);

	/** Get Catalog Visibility	  */
	public String getLIT_CatalogVisibility();

    /** Column name LIT_CategoryWoo */
    public static final String COLUMNNAME_LIT_CategoryWoo = "LIT_CategoryWoo";

	/** Set Product Category Woocommerce	  */
	public void setLIT_CategoryWoo (String LIT_CategoryWoo);

	/** Get Product Category Woocommerce	  */
	public String getLIT_CategoryWoo();

    /** Column name LIT_CreatedAt */
    public static final String COLUMNNAME_LIT_CreatedAt = "LIT_CreatedAt";

	/** Set Created At	  */
	public void setLIT_CreatedAt (Timestamp LIT_CreatedAt);

	/** Get Created At	  */
	public Timestamp getLIT_CreatedAt();

    /** Column name LIT_DescriptionWoo */
    public static final String COLUMNNAME_LIT_DescriptionWoo = "LIT_DescriptionWoo";

	/** Set Description Woo	  */
	public void setLIT_DescriptionWoo (String LIT_DescriptionWoo);

	/** Get Description Woo	  */
	public String getLIT_DescriptionWoo();

    /** Column name LIT_DimHeight */
    public static final String COLUMNNAME_LIT_DimHeight = "LIT_DimHeight";

	/** Set Dim_Height	  */
	public void setLIT_DimHeight (BigDecimal LIT_DimHeight);

	/** Get Dim_Height	  */
	public BigDecimal getLIT_DimHeight();

    /** Column name LIT_DimLength */
    public static final String COLUMNNAME_LIT_DimLength = "LIT_DimLength";

	/** Set Dim_Length	  */
	public void setLIT_DimLength (BigDecimal LIT_DimLength);

	/** Get Dim_Length	  */
	public BigDecimal getLIT_DimLength();

    /** Column name LIT_DimUnit */
    public static final String COLUMNNAME_LIT_DimUnit = "LIT_DimUnit";

	/** Set Dim_Unit	  */
	public void setLIT_DimUnit (String LIT_DimUnit);

	/** Get Dim_Unit	  */
	public String getLIT_DimUnit();

    /** Column name LIT_DimWidth */
    public static final String COLUMNNAME_LIT_DimWidth = "LIT_DimWidth";

	/** Set Dim_Width	  */
	public void setLIT_DimWidth (BigDecimal LIT_DimWidth);

	/** Get Dim_Width	  */
	public BigDecimal getLIT_DimWidth();

    /** Column name LIT_DownloadExpiry */
    public static final String COLUMNNAME_LIT_DownloadExpiry = "LIT_DownloadExpiry";

	/** Set Download Expiry	  */
	public void setLIT_DownloadExpiry (int LIT_DownloadExpiry);

	/** Get Download Expiry	  */
	public int getLIT_DownloadExpiry();

    /** Column name LIT_DownloadLimit */
    public static final String COLUMNNAME_LIT_DownloadLimit = "LIT_DownloadLimit";

	/** Set Download Limit	  */
	public void setLIT_DownloadLimit (int LIT_DownloadLimit);

	/** Get Download Limit	  */
	public int getLIT_DownloadLimit();

    /** Column name LIT_DownloadType */
    public static final String COLUMNNAME_LIT_DownloadType = "LIT_DownloadType";

	/** Set Download Type	  */
	public void setLIT_DownloadType (String LIT_DownloadType);

	/** Get Download Type	  */
	public String getLIT_DownloadType();

    /** Column name LIT_EnabledHtmlShortDescr */
    public static final String COLUMNNAME_LIT_EnabledHtmlShortDescr = "LIT_EnabledHtmlShortDescr";

	/** Set Enabled Html Short Descr	  */
	public void setLIT_EnabledHtmlShortDescr (String LIT_EnabledHtmlShortDescr);

	/** Get Enabled Html Short Descr	  */
	public String getLIT_EnabledHtmlShortDescr();

    /** Column name LIT_IdProdWoo */
    public static final String COLUMNNAME_LIT_IdProdWoo = "LIT_IdProdWoo";

	/** Set Id Product Woocommerce	  */
	public void setLIT_IdProdWoo (int LIT_IdProdWoo);

	/** Get Id Product Woocommerce	  */
	public int getLIT_IdProdWoo();

    /** Column name LIT_ImageUrl */
    public static final String COLUMNNAME_LIT_ImageUrl = "LIT_ImageUrl";

	/** Set Image Url	  */
	public void setLIT_ImageUrl (String LIT_ImageUrl);

	/** Get Image Url	  */
	public String getLIT_ImageUrl();

    /** Column name LIT_IsBackordered */
    public static final String COLUMNNAME_LIT_IsBackordered = "LIT_IsBackordered";

	/** Set Backordered	  */
	public void setLIT_IsBackordered (boolean LIT_IsBackordered);

	/** Get Backordered	  */
	public boolean isLIT_IsBackordered();

    /** Column name LIT_IsBackordersAllowed */
    public static final String COLUMNNAME_LIT_IsBackordersAllowed = "LIT_IsBackordersAllowed";

	/** Set Backorders Allowed	  */
	public void setLIT_IsBackordersAllowed (boolean LIT_IsBackordersAllowed);

	/** Get Backorders Allowed	  */
	public boolean isLIT_IsBackordersAllowed();

    /** Column name LIT_IsDownloadable */
    public static final String COLUMNNAME_LIT_IsDownloadable = "LIT_IsDownloadable";

	/** Set Downloadable	  */
	public void setLIT_IsDownloadable (boolean LIT_IsDownloadable);

	/** Get Downloadable	  */
	public boolean isLIT_IsDownloadable();

    /** Column name LIT_IsEnableHtmlDescription */
    public static final String COLUMNNAME_LIT_IsEnableHtmlDescription = "LIT_IsEnableHtmlDescription";

	/** Set Enable Html Description	  */
	public void setLIT_IsEnableHtmlDescription (boolean LIT_IsEnableHtmlDescription);

	/** Get Enable Html Description	  */
	public boolean isLIT_IsEnableHtmlDescription();

    /** Column name LIT_IsFeatured */
    public static final String COLUMNNAME_LIT_IsFeatured = "LIT_IsFeatured";

	/** Set Featured	  */
	public void setLIT_IsFeatured (boolean LIT_IsFeatured);

	/** Get Featured	  */
	public boolean isLIT_IsFeatured();

    /** Column name LIT_IsInStock */
    public static final String COLUMNNAME_LIT_IsInStock = "LIT_IsInStock";

	/** Set In Stock	  */
	public void setLIT_IsInStock (boolean LIT_IsInStock);

	/** Get In Stock	  */
	public boolean isLIT_IsInStock();

    /** Column name LIT_IsManagingStock */
    public static final String COLUMNNAME_LIT_IsManagingStock = "LIT_IsManagingStock";

	/** Set Managing Stock	  */
	public void setLIT_IsManagingStock (boolean LIT_IsManagingStock);

	/** Get Managing Stock	  */
	public boolean isLIT_IsManagingStock();

    /** Column name LIT_IsOnSale */
    public static final String COLUMNNAME_LIT_IsOnSale = "LIT_IsOnSale";

	/** Set On Sale	  */
	public void setLIT_IsOnSale (boolean LIT_IsOnSale);

	/** Get On Sale	  */
	public boolean isLIT_IsOnSale();

    /** Column name LIT_IsPurchaseable */
    public static final String COLUMNNAME_LIT_IsPurchaseable = "LIT_IsPurchaseable";

	/** Set Purchaseable	  */
	public void setLIT_IsPurchaseable (boolean LIT_IsPurchaseable);

	/** Get Purchaseable	  */
	public boolean isLIT_IsPurchaseable();

    /** Column name LIT_IsReviewsAllowed */
    public static final String COLUMNNAME_LIT_IsReviewsAllowed = "LIT_IsReviewsAllowed";

	/** Set Reviews Allowed	  */
	public void setLIT_IsReviewsAllowed (boolean LIT_IsReviewsAllowed);

	/** Get Reviews Allowed	  */
	public boolean isLIT_IsReviewsAllowed();

    /** Column name LIT_IsShippingClass */
    public static final String COLUMNNAME_LIT_IsShippingClass = "LIT_IsShippingClass";

	/** Set Shipping Class	  */
	public void setLIT_IsShippingClass (boolean LIT_IsShippingClass);

	/** Get Shipping Class	  */
	public boolean isLIT_IsShippingClass();

    /** Column name LIT_IsShippingRequired */
    public static final String COLUMNNAME_LIT_IsShippingRequired = "LIT_IsShippingRequired";

	/** Set Shipping Required	  */
	public void setLIT_IsShippingRequired (boolean LIT_IsShippingRequired);

	/** Get Shipping Required	  */
	public boolean isLIT_IsShippingRequired();

    /** Column name LIT_IsShippingTaxable */
    public static final String COLUMNNAME_LIT_IsShippingTaxable = "LIT_IsShippingTaxable";

	/** Set ShippingTaxable	  */
	public void setLIT_IsShippingTaxable (boolean LIT_IsShippingTaxable);

	/** Get ShippingTaxable	  */
	public boolean isLIT_IsShippingTaxable();

    /** Column name LIT_IsSoldIndividually */
    public static final String COLUMNNAME_LIT_IsSoldIndividually = "LIT_IsSoldIndividually";

	/** Set Sold Individually	  */
	public void setLIT_IsSoldIndividually (boolean LIT_IsSoldIndividually);

	/** Get Sold Individually	  */
	public boolean isLIT_IsSoldIndividually();

    /** Column name LIT_IsTaxable */
    public static final String COLUMNNAME_LIT_IsTaxable = "LIT_IsTaxable";

	/** Set Taxable	  */
	public void setLIT_IsTaxable (boolean LIT_IsTaxable);

	/** Get Taxable	  */
	public boolean isLIT_IsTaxable();

    /** Column name LIT_IsVirtual */
    public static final String COLUMNNAME_LIT_IsVirtual = "LIT_IsVirtual";

	/** Set Virtual	  */
	public void setLIT_IsVirtual (boolean LIT_IsVirtual);

	/** Get Virtual	  */
	public boolean isLIT_IsVirtual();

    /** Column name LIT_IsVisible */
    public static final String COLUMNNAME_LIT_IsVisible = "LIT_IsVisible";

	/** Set Visible	  */
	public void setLIT_IsVisible (boolean LIT_IsVisible);

	/** Get Visible	  */
	public boolean isLIT_IsVisible();

    /** Column name LIT_MenuOrder */
    public static final String COLUMNNAME_LIT_MenuOrder = "LIT_MenuOrder";

	/** Set Menu Order	  */
	public void setLIT_MenuOrder (int LIT_MenuOrder);

	/** Get Menu Order	  */
	public int getLIT_MenuOrder();

    /** Column name LIT_NameProdWoo */
    public static final String COLUMNNAME_LIT_NameProdWoo = "LIT_NameProdWoo";

	/** Set Name Product Woocommerce	  */
	public void setLIT_NameProdWoo (String LIT_NameProdWoo);

	/** Get Name Product Woocommerce	  */
	public String getLIT_NameProdWoo();

    /** Column name LIT_ParentId_Woo */
    public static final String COLUMNNAME_LIT_ParentId_Woo = "LIT_ParentId_Woo";

	/** Set Parent Id Woo	  */
	public void setLIT_ParentId_Woo (int LIT_ParentId_Woo);

	/** Get Parent Id Woo	  */
	public int getLIT_ParentId_Woo();

    /** Column name LIT_Permalink */
    public static final String COLUMNNAME_LIT_Permalink = "LIT_Permalink";

	/** Set Permalink	  */
	public void setLIT_Permalink (String LIT_Permalink);

	/** Get Permalink	  */
	public String getLIT_Permalink();

    /** Column name LIT_PriceHtml */
    public static final String COLUMNNAME_LIT_PriceHtml = "LIT_PriceHtml";

	/** Set Price Html	  */
	public void setLIT_PriceHtml (String LIT_PriceHtml);

	/** Get Price Html	  */
	public String getLIT_PriceHtml();

    /** Column name LIT_ProductUrl */
    public static final String COLUMNNAME_LIT_ProductUrl = "LIT_ProductUrl";

	/** Set Product Url	  */
	public void setLIT_ProductUrl (String LIT_ProductUrl);

	/** Get Product Url	  */
	public String getLIT_ProductUrl();

    /** Column name LIT_PurchaseNote */
    public static final String COLUMNNAME_LIT_PurchaseNote = "LIT_PurchaseNote";

	/** Set Purchase Note	  */
	public void setLIT_PurchaseNote (String LIT_PurchaseNote);

	/** Get Purchase Note	  */
	public String getLIT_PurchaseNote();

    /** Column name LIT_RatingCount */
    public static final String COLUMNNAME_LIT_RatingCount = "LIT_RatingCount";

	/** Set Rating Count	  */
	public void setLIT_RatingCount (int LIT_RatingCount);

	/** Get Rating Count	  */
	public int getLIT_RatingCount();

    /** Column name LIT_RegularPrice */
    public static final String COLUMNNAME_LIT_RegularPrice = "LIT_RegularPrice";

	/** Set Regular Price	  */
	public void setLIT_RegularPrice (BigDecimal LIT_RegularPrice);

	/** Get Regular Price	  */
	public BigDecimal getLIT_RegularPrice();

    /** Column name LIT_SalePrice */
    public static final String COLUMNNAME_LIT_SalePrice = "LIT_SalePrice";

	/** Set Sale Price	  */
	public void setLIT_SalePrice (BigDecimal LIT_SalePrice);

	/** Get Sale Price	  */
	public BigDecimal getLIT_SalePrice();

    /** Column name LIT_SalePriceDatesFrom */
    public static final String COLUMNNAME_LIT_SalePriceDatesFrom = "LIT_SalePriceDatesFrom";

	/** Set Sale Price Dates From	  */
	public void setLIT_SalePriceDatesFrom (Timestamp LIT_SalePriceDatesFrom);

	/** Get Sale Price Dates From	  */
	public Timestamp getLIT_SalePriceDatesFrom();

    /** Column name LIT_SalePriceDatesTo */
    public static final String COLUMNNAME_LIT_SalePriceDatesTo = "LIT_SalePriceDatesTo";

	/** Set Sale Price Dates To	  */
	public void setLIT_SalePriceDatesTo (Timestamp LIT_SalePriceDatesTo);

	/** Get Sale Price Dates To	  */
	public Timestamp getLIT_SalePriceDatesTo();

    /** Column name LIT_ShippingClassId */
    public static final String COLUMNNAME_LIT_ShippingClassId = "LIT_ShippingClassId";

	/** Set Shipping Class Id	  */
	public void setLIT_ShippingClassId (int LIT_ShippingClassId);

	/** Get Shipping Class Id	  */
	public int getLIT_ShippingClassId();

    /** Column name LIT_ShortDescription */
    public static final String COLUMNNAME_LIT_ShortDescription = "LIT_ShortDescription";

	/** Set Short Description	  */
	public void setLIT_ShortDescription (String LIT_ShortDescription);

	/** Get Short Description	  */
	public String getLIT_ShortDescription();

    /** Column name LIT_Sku */
    public static final String COLUMNNAME_LIT_Sku = "LIT_Sku";

	/** Set Sku	  */
	public void setLIT_Sku (String LIT_Sku);

	/** Get Sku	  */
	public String getLIT_Sku();

    /** Column name LIT_StatusWoo */
    public static final String COLUMNNAME_LIT_StatusWoo = "LIT_StatusWoo";

	/** Set Status Woo	  */
	public void setLIT_StatusWoo (String LIT_StatusWoo);

	/** Get Status Woo	  */
	public String getLIT_StatusWoo();

    /** Column name LIT_StockQuantity */
    public static final String COLUMNNAME_LIT_StockQuantity = "LIT_StockQuantity";

	/** Set Stock Quantity	  */
	public void setLIT_StockQuantity (int LIT_StockQuantity);

	/** Get Stock Quantity	  */
	public int getLIT_StockQuantity();

    /** Column name LIT_TaxClass */
    public static final String COLUMNNAME_LIT_TaxClass = "LIT_TaxClass";

	/** Set Tax Class	  */
	public void setLIT_TaxClass (String LIT_TaxClass);

	/** Get Tax Class	  */
	public String getLIT_TaxClass();

    /** Column name LIT_TaxStatus */
    public static final String COLUMNNAME_LIT_TaxStatus = "LIT_TaxStatus";

	/** Set Tax Status	  */
	public void setLIT_TaxStatus (String LIT_TaxStatus);

	/** Get Tax Status	  */
	public String getLIT_TaxStatus();

    /** Column name LIT_TotalSales */
    public static final String COLUMNNAME_LIT_TotalSales = "LIT_TotalSales";

	/** Set Total Sales	  */
	public void setLIT_TotalSales (int LIT_TotalSales);

	/** Get Total Sales	  */
	public int getLIT_TotalSales();

    /** Column name LIT_TypeProdWoo */
    public static final String COLUMNNAME_LIT_TypeProdWoo = "LIT_TypeProdWoo";

	/** Set Type Product	  */
	public void setLIT_TypeProdWoo (String LIT_TypeProdWoo);

	/** Get Type Product	  */
	public String getLIT_TypeProdWoo();

    /** Column name LIT_UpdatedAt */
    public static final String COLUMNNAME_LIT_UpdatedAt = "LIT_UpdatedAt";

	/** Set Updated At	  */
	public void setLIT_UpdatedAt (Timestamp LIT_UpdatedAt);

	/** Get Updated At	  */
	public Timestamp getLIT_UpdatedAt();

    /** Column name LIT_WooProducts_ID */
    public static final String COLUMNNAME_LIT_WooProducts_ID = "LIT_WooProducts_ID";

	/** Set Woocommerce Products	  */
	public void setLIT_WooProducts_ID (int LIT_WooProducts_ID);

	/** Get Woocommerce Products	  */
	public int getLIT_WooProducts_ID();

    /** Column name LIT_WooProducts_UU */
    public static final String COLUMNNAME_LIT_WooProducts_UU = "LIT_WooProducts_UU";

	/** Set LIT_WooProducts_UU	  */
	public void setLIT_WooProducts_UU (String LIT_WooProducts_UU);

	/** Get LIT_WooProducts_UU	  */
	public String getLIT_WooProducts_UU();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Price */
    public static final String COLUMNNAME_Price = "Price";

	/** Set Price.
	  * Price
	  */
	public void setPrice (BigDecimal Price);

	/** Get Price.
	  * Price
	  */
	public BigDecimal getPrice();

    /** Column name Title */
    public static final String COLUMNNAME_Title = "Title";

	/** Set Title.
	  * Name this entity is referred to as
	  */
	public void setTitle (String Title);

	/** Get Title.
	  * Name this entity is referred to as
	  */
	public String getTitle();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Weight */
    public static final String COLUMNNAME_Weight = "Weight";

	/** Set Weight.
	  * Weight of a product
	  */
	public void setWeight (BigDecimal Weight);

	/** Get Weight.
	  * Weight of a product
	  */
	public BigDecimal getWeight();
}
