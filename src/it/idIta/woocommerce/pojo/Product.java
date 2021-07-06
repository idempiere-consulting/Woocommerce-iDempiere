
package it.idIta.woocommerce.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "slug",
    "permalink",
    "date_created",
    "date_created_gmt",
    "date_modified",
    "date_modified_gmt",
    "type",
    "status",
    "featured",
    "catalog_visibility",
    "description",
    "short_description",
    "sku",
    "price",
    "regular_price",
    "sale_price",
    "date_on_sale_from",
    "date_on_sale_from_gmt",
    "date_on_sale_to",
    "date_on_sale_to_gmt",
    "price_html",
    "on_sale",
    "purchasable",
    "total_sales",
    "virtual",
    "downloadable",
    "downloads",
    "download_limit",
    "download_expiry",
    "external_url",
    "button_text",
    "tax_status",
    "tax_class",
    "manage_stock",
    "stock_quantity",
    "stock_status",
    "backorders",
    "backorders_allowed",
    "backordered",
    "sold_individually",
    "weight",
    "dimensions",
    "shipping_required",
    "shipping_taxable",
    "shipping_class",
    "shipping_class_id",
    "reviews_allowed",
    "average_rating",
    "rating_count",
    "related_ids",
    "upsell_ids",
    "cross_sell_ids",
    "parent_id",
    "purchase_note",
    "categories",
    "tags",
    "images",
    "attributes",
    "default_attributes",
    "variations",
    "grouped_products",
    "menu_order",
    "meta_data",
    "_links"
})
public class Product {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;
    @JsonProperty("date_modified")
    private String dateModified;
    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("featured")
    private boolean featured;
    @JsonProperty("catalog_visibility")
    private String catalogVisibility;
    @JsonProperty("description")
    private String description;
    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("price")
    private String price;
    @JsonProperty("regular_price")
    private String regularPrice;
    @JsonProperty("sale_price")
    private String salePrice;
    @JsonProperty("date_on_sale_from")
    private Object dateOnSaleFrom;
    @JsonProperty("date_on_sale_from_gmt")
    private Object dateOnSaleFromGmt;
    @JsonProperty("date_on_sale_to")
    private Object dateOnSaleTo;
    @JsonProperty("date_on_sale_to_gmt")
    private Object dateOnSaleToGmt;
    @JsonProperty("price_html")
    private String priceHtml;
    @JsonProperty("on_sale")
    private boolean onSale;
    @JsonProperty("purchasable")
    private boolean purchasable;
    @JsonProperty("total_sales")
    private int totalSales;
    @JsonProperty("virtual")
    private boolean virtual;
    @JsonProperty("downloadable")
    private boolean downloadable;
    @JsonProperty("downloads")
    private List<Object> downloads = null;
    @JsonProperty("download_limit")
    private int downloadLimit;
    @JsonProperty("download_expiry")
    private int downloadExpiry;
    @JsonProperty("external_url")
    private String externalUrl;
    @JsonProperty("button_text")
    private String buttonText;
    @JsonProperty("tax_status")
    private String taxStatus;
    @JsonProperty("tax_class")
    private String taxClass;
    @JsonProperty("manage_stock")
    private boolean manageStock;
    @JsonProperty("stock_quantity")
    private Object stockQuantity;
    @JsonProperty("stock_status")
    private String stockStatus;
    @JsonProperty("backorders")
    private String backorders;
    @JsonProperty("backorders_allowed")
    private boolean backordersAllowed;
    @JsonProperty("backordered")
    private boolean backordered;
    @JsonProperty("sold_individually")
    private boolean soldIndividually;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("dimensions")
    private Dimensions dimensions;
    @JsonProperty("shipping_required")
    private boolean shippingRequired;
    @JsonProperty("shipping_taxable")
    private boolean shippingTaxable;
    @JsonProperty("shipping_class")
    private String shippingClass;
    @JsonProperty("shipping_class_id")
    private int shippingClassId;
    @JsonProperty("reviews_allowed")
    private boolean reviewsAllowed;
    @JsonProperty("average_rating")
    private String averageRating;
    @JsonProperty("rating_count")
    private int ratingCount;
    @JsonProperty("related_ids")
    private List<Integer> relatedIds = null;
    @JsonProperty("upsell_ids")
    private List<Object> upsellIds = null;
    @JsonProperty("cross_sell_ids")
    private List<Object> crossSellIds = null;
    @JsonProperty("parent_id")
    private int parentId;
    @JsonProperty("purchase_note")
    private String purchaseNote;
    @JsonProperty("categories")
    private List<Category> categories = null;
    @JsonProperty("tags")

    private List<Object> tags = null;
    @JsonProperty("images")

    private List<Image> images = null;
    @JsonProperty("attributes")

    private List<AttributeIntoProduct> attributes = null;
    @JsonProperty("default_attributes")

    private List<Object> defaultAttributes = null;
    @JsonProperty("variations")

    private List<Object> variations = null;
    @JsonProperty("grouped_products")

    private List<Object> groupedProducts = null;
    @JsonProperty("menu_order")
    private int menuOrder;
    @JsonProperty("meta_data")

    private List<Object> metaData = null;
    @JsonProperty("_links")

    private Links links;
    @JsonIgnore

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public Product withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Product withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    @JsonProperty("permalink")
    public String getPermalink() {
        return permalink;
    }

    @JsonProperty("permalink")
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Product withPermalink(String permalink) {
        this.permalink = permalink;
        return this;
    }

    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Product withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    @JsonProperty("date_created_gmt")
    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    @JsonProperty("date_created_gmt")
    public void setDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public Product withDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
        return this;
    }

    @JsonProperty("date_modified")
    public String getDateModified() {
        return dateModified;
    }

    @JsonProperty("date_modified")
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public Product withDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    @JsonProperty("date_modified_gmt")
    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }

    @JsonProperty("date_modified_gmt")
    public void setDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public Product withDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Product withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Product withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("featured")
    public boolean isFeatured() {
        return featured;
    }

    @JsonProperty("featured")
    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Product withFeatured(boolean featured) {
        this.featured = featured;
        return this;
    }

    @JsonProperty("catalog_visibility")
    public String getCatalogVisibility() {
        return catalogVisibility;
    }

    @JsonProperty("catalog_visibility")
    public void setCatalogVisibility(String catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
    }

    public Product withCatalogVisibility(String catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Product withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("short_description")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("short_description")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Product withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product withSku(String sku) {
        this.sku = sku;
        return this;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    public Product withPrice(String price) {
        this.price = price;
        return this;
    }

    @JsonProperty("regular_price")
    public String getRegularPrice() {
        return regularPrice;
    }

    @JsonProperty("regular_price")
    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Product withRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
        return this;
    }

    @JsonProperty("sale_price")
    public String getSalePrice() {
        return salePrice;
    }

    @JsonProperty("sale_price")
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public Product withSalePrice(String salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    @JsonProperty("date_on_sale_from")
    public Object getDateOnSaleFrom() {
        return dateOnSaleFrom;
    }

    @JsonProperty("date_on_sale_from")
    public void setDateOnSaleFrom(Object dateOnSaleFrom) {
        this.dateOnSaleFrom = dateOnSaleFrom;
    }

    public Product withDateOnSaleFrom(Object dateOnSaleFrom) {
        this.dateOnSaleFrom = dateOnSaleFrom;
        return this;
    }

    @JsonProperty("date_on_sale_from_gmt")
    public Object getDateOnSaleFromGmt() {
        return dateOnSaleFromGmt;
    }

    @JsonProperty("date_on_sale_from_gmt")
    public void setDateOnSaleFromGmt(Object dateOnSaleFromGmt) {
        this.dateOnSaleFromGmt = dateOnSaleFromGmt;
    }

    public Product withDateOnSaleFromGmt(Object dateOnSaleFromGmt) {
        this.dateOnSaleFromGmt = dateOnSaleFromGmt;
        return this;
    }

    @JsonProperty("date_on_sale_to")
    public Object getDateOnSaleTo() {
        return dateOnSaleTo;
    }

    @JsonProperty("date_on_sale_to")
    public void setDateOnSaleTo(Object dateOnSaleTo) {
        this.dateOnSaleTo = dateOnSaleTo;
    }

    public Product withDateOnSaleTo(Object dateOnSaleTo) {
        this.dateOnSaleTo = dateOnSaleTo;
        return this;
    }

    @JsonProperty("date_on_sale_to_gmt")
    public Object getDateOnSaleToGmt() {
        return dateOnSaleToGmt;
    }

    @JsonProperty("date_on_sale_to_gmt")
    public void setDateOnSaleToGmt(Object dateOnSaleToGmt) {
        this.dateOnSaleToGmt = dateOnSaleToGmt;
    }

    public Product withDateOnSaleToGmt(Object dateOnSaleToGmt) {
        this.dateOnSaleToGmt = dateOnSaleToGmt;
        return this;
    }

    @JsonProperty("price_html")
    public String getPriceHtml() {
        return priceHtml;
    }

    @JsonProperty("price_html")
    public void setPriceHtml(String priceHtml) {
        this.priceHtml = priceHtml;
    }

    public Product withPriceHtml(String priceHtml) {
        this.priceHtml = priceHtml;
        return this;
    }

    @JsonProperty("on_sale")
    public boolean isOnSale() {
        return onSale;
    }

    @JsonProperty("on_sale")
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public Product withOnSale(boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    @JsonProperty("purchasable")
    public boolean isPurchasable() {
        return purchasable;
    }

    @JsonProperty("purchasable")
    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public Product withPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
        return this;
    }

    @JsonProperty("total_sales")
    public int getTotalSales() {
        return totalSales;
    }

    @JsonProperty("total_sales")
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public Product withTotalSales(int totalSales) {
        this.totalSales = totalSales;
        return this;
    }

    @JsonProperty("virtual")
    public boolean isVirtual() {
        return virtual;
    }

    @JsonProperty("virtual")
    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public Product withVirtual(boolean virtual) {
        this.virtual = virtual;
        return this;
    }

    @JsonProperty("downloadable")
    public boolean isDownloadable() {
        return downloadable;
    }

    @JsonProperty("downloadable")
    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public Product withDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
        return this;
    }

    @JsonProperty("downloads")
    public List<Object> getDownloads() {
        return downloads;
    }

    @JsonProperty("downloads")
    public void setDownloads(List<Object> downloads) {
        this.downloads = downloads;
    }

    public Product withDownloads(List<Object> downloads) {
        this.downloads = downloads;
        return this;
    }

    @JsonProperty("download_limit")
    public int getDownloadLimit() {
        return downloadLimit;
    }

    @JsonProperty("download_limit")
    public void setDownloadLimit(int downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public Product withDownloadLimit(int downloadLimit) {
        this.downloadLimit = downloadLimit;
        return this;
    }

    @JsonProperty("download_expiry")
    public int getDownloadExpiry() {
        return downloadExpiry;
    }

    @JsonProperty("download_expiry")
    public void setDownloadExpiry(int downloadExpiry) {
        this.downloadExpiry = downloadExpiry;
    }

    public Product withDownloadExpiry(int downloadExpiry) {
        this.downloadExpiry = downloadExpiry;
        return this;
    }

    @JsonProperty("external_url")
    public String getExternalUrl() {
        return externalUrl;
    }

    @JsonProperty("external_url")
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Product withExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
        return this;
    }

    @JsonProperty("button_text")
    public String getButtonText() {
        return buttonText;
    }

    @JsonProperty("button_text")
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public Product withButtonText(String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    @JsonProperty("tax_status")
    public String getTaxStatus() {
        return taxStatus;
    }

    @JsonProperty("tax_status")
    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public Product withTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
        return this;
    }

    @JsonProperty("tax_class")
    public String getTaxClass() {
        return taxClass;
    }

    @JsonProperty("tax_class")
    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public Product withTaxClass(String taxClass) {
        this.taxClass = taxClass;
        return this;
    }

    @JsonProperty("manage_stock")
    public boolean isManageStock() {
        return manageStock;
    }

    @JsonProperty("manage_stock")
    public void setManageStock(boolean manageStock) {
        this.manageStock = manageStock;
    }

    public Product withManageStock(boolean manageStock) {
        this.manageStock = manageStock;
        return this;
    }

    @JsonProperty("stock_quantity")
    public Object getStockQuantity() {
        return stockQuantity;
    }

    @JsonProperty("stock_quantity")
    public void setStockQuantity(Object stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Product withStockQuantity(Object stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    @JsonProperty("stock_status")
    public String getStockStatus() {
        return stockStatus;
    }

    @JsonProperty("stock_status")
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Product withStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
        return this;
    }

    @JsonProperty("backorders")
    public String getBackorders() {
        return backorders;
    }

    @JsonProperty("backorders")
    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    public Product withBackorders(String backorders) {
        this.backorders = backorders;
        return this;
    }

    @JsonProperty("backorders_allowed")
    public boolean isBackordersAllowed() {
        return backordersAllowed;
    }

    @JsonProperty("backorders_allowed")
    public void setBackordersAllowed(boolean backordersAllowed) {
        this.backordersAllowed = backordersAllowed;
    }

    public Product withBackordersAllowed(boolean backordersAllowed) {
        this.backordersAllowed = backordersAllowed;
        return this;
    }

    @JsonProperty("backordered")
    public boolean isBackordered() {
        return backordered;
    }

    @JsonProperty("backordered")
    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    public Product withBackordered(boolean backordered) {
        this.backordered = backordered;
        return this;
    }

    @JsonProperty("sold_individually")
    public boolean isSoldIndividually() {
        return soldIndividually;
    }

    @JsonProperty("sold_individually")
    public void setSoldIndividually(boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
    }

    public Product withSoldIndividually(boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
        return this;
    }

    @JsonProperty("weight")
    public String getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Product withWeight(String weight) {
        this.weight = weight;
        return this;
    }

    @JsonProperty("dimensions")
    public Dimensions getDimensions() {
        return dimensions;
    }

    @JsonProperty("dimensions")
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Product withDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    @JsonProperty("shipping_required")
    public boolean isShippingRequired() {
        return shippingRequired;
    }

    @JsonProperty("shipping_required")
    public void setShippingRequired(boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
    }

    public Product withShippingRequired(boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
        return this;
    }

    @JsonProperty("shipping_taxable")
    public boolean isShippingTaxable() {
        return shippingTaxable;
    }

    @JsonProperty("shipping_taxable")
    public void setShippingTaxable(boolean shippingTaxable) {
        this.shippingTaxable = shippingTaxable;
    }

    public Product withShippingTaxable(boolean shippingTaxable) {
        this.shippingTaxable = shippingTaxable;
        return this;
    }

    @JsonProperty("shipping_class")
    public String getShippingClass() {
        return shippingClass;
    }

    @JsonProperty("shipping_class")
    public void setShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
    }

    public Product withShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
        return this;
    }

    @JsonProperty("shipping_class_id")
    public int getShippingClassId() {
        return shippingClassId;
    }

    @JsonProperty("shipping_class_id")
    public void setShippingClassId(int shippingClassId) {
        this.shippingClassId = shippingClassId;
    }

    public Product withShippingClassId(int shippingClassId) {
        this.shippingClassId = shippingClassId;
        return this;
    }

    @JsonProperty("reviews_allowed")
    public boolean isReviewsAllowed() {
        return reviewsAllowed;
    }

    @JsonProperty("reviews_allowed")
    public void setReviewsAllowed(boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
    }

    public Product withReviewsAllowed(boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
        return this;
    }

    @JsonProperty("average_rating")
    public String getAverageRating() {
        return averageRating;
    }

    @JsonProperty("average_rating")
    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public Product withAverageRating(String averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    @JsonProperty("rating_count")
    public int getRatingCount() {
        return ratingCount;
    }

    @JsonProperty("rating_count")
    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Product withRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
        return this;
    }

    @JsonProperty("related_ids")
    public List<Integer> getRelatedIds() {
        return relatedIds;
    }

    @JsonProperty("related_ids")
    public void setRelatedIds(List<Integer> relatedIds) {
        this.relatedIds = relatedIds;
    }

    public Product withRelatedIds(List<Integer> relatedIds) {
        this.relatedIds = relatedIds;
        return this;
    }

    @JsonProperty("upsell_ids")
    public List<Object> getUpsellIds() {
        return upsellIds;
    }

    @JsonProperty("upsell_ids")
    public void setUpsellIds(List<Object> upsellIds) {
        this.upsellIds = upsellIds;
    }

    public Product withUpsellIds(List<Object> upsellIds) {
        this.upsellIds = upsellIds;
        return this;
    }

    @JsonProperty("cross_sell_ids")
    public List<Object> getCrossSellIds() {
        return crossSellIds;
    }

    @JsonProperty("cross_sell_ids")
    public void setCrossSellIds(List<Object> crossSellIds) {
        this.crossSellIds = crossSellIds;
    }

    public Product withCrossSellIds(List<Object> crossSellIds) {
        this.crossSellIds = crossSellIds;
        return this;
    }

    @JsonProperty("parent_id")
    public int getParentId() {
        return parentId;
    }

    @JsonProperty("parent_id")
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Product withParentId(int parentId) {
        this.parentId = parentId;
        return this;
    }

    @JsonProperty("purchase_note")
    public String getPurchaseNote() {
        return purchaseNote;
    }

    @JsonProperty("purchase_note")
    public void setPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
    }

    public Product withPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
        return this;
    }

    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Product withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Product withTags(List<Object> tags) {
        this.tags = tags;
        return this;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Product withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    @JsonProperty("attributes")
    public List<AttributeIntoProduct> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(List<AttributeIntoProduct> attributes) {
        this.attributes = attributes;
    }

    public Product withAttributes(List<AttributeIntoProduct> attributes) {
        this.attributes = attributes;
        return this;
    }

    @JsonProperty("default_attributes")
    public List<Object> getDefaultAttributes() {
        return defaultAttributes;
    }

    @JsonProperty("default_attributes")
    public void setDefaultAttributes(List<Object> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
    }

    public Product withDefaultAttributes(List<Object> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
        return this;
    }

    @JsonProperty("variations")
    public List<Object> getVariations() {
        return variations;
    }

    @JsonProperty("variations")
    public void setVariations(List<Object> variations) {
        this.variations = variations;
    }

    public Product withVariations(List<Object> variations) {
        this.variations = variations;
        return this;
    }

    @JsonProperty("grouped_products")
    public List<Object> getGroupedProducts() {
        return groupedProducts;
    }

    @JsonProperty("grouped_products")
    public void setGroupedProducts(List<Object> groupedProducts) {
        this.groupedProducts = groupedProducts;
    }

    public Product withGroupedProducts(List<Object> groupedProducts) {
        this.groupedProducts = groupedProducts;
        return this;
    }

    @JsonProperty("menu_order")
    public int getMenuOrder() {
        return menuOrder;
    }

    @JsonProperty("menu_order")
    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Product withMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
        return this;
    }

    @JsonProperty("meta_data")
    public List<Object> getMetaData() {
        return metaData;
    }

    @JsonProperty("meta_data")
    public void setMetaData(List<Object> metaData) {
        this.metaData = metaData;
    }

    public Product withMetaData(List<Object> metaData) {
        this.metaData = metaData;
        return this;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    public Product withLinks(Links links) {
        this.links = links;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Product withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
