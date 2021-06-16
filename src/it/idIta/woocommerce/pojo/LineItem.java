
package it.idIta.woocommerce.pojo;

import java.util.ArrayList;
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
    "product_id",
    "variation_id",
    "quantity",
    "tax_class",
    "subtotal",
    "subtotal_tax",
    "total",
    "total_tax",
    "taxes",
    "meta_data",
    "sku",
    "price"
})
public class LineItem {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("product_id")
    private long productId;
    @JsonProperty("variation_id")
    private long variationId;
    @JsonProperty("quantity")
    private long quantity;
    @JsonProperty("tax_class")
    private String taxClass;
    @JsonProperty("subtotal")
    private String subtotal;
    @JsonProperty("subtotal_tax")
    private String subtotalTax;
    @JsonProperty("total")
    private String total;
    @JsonProperty("total_tax")
    private String totalTax;
    @JsonProperty("taxes")
    private List<Tax> taxes = new ArrayList<Tax>();
    @JsonProperty("meta_data")
    private List<MetaData> metaData = new ArrayList<MetaData>();
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("price")
    private long price;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    public LineItem withId(long id) {
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

    public LineItem withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("product_id")
    public long getProductId() {
        return productId;
    }

    @JsonProperty("product_id")
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public LineItem withProductId(long productId) {
        this.productId = productId;
        return this;
    }

    @JsonProperty("variation_id")
    public long getVariationId() {
        return variationId;
    }

    @JsonProperty("variation_id")
    public void setVariationId(long variationId) {
        this.variationId = variationId;
    }

    public LineItem withVariationId(long variationId) {
        this.variationId = variationId;
        return this;
    }

    @JsonProperty("quantity")
    public long getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public LineItem withQuantity(long quantity) {
        this.quantity = quantity;
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

    public LineItem withTaxClass(String taxClass) {
        this.taxClass = taxClass;
        return this;
    }

    @JsonProperty("subtotal")
    public String getSubtotal() {
        return subtotal;
    }

    @JsonProperty("subtotal")
    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public LineItem withSubtotal(String subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    @JsonProperty("subtotal_tax")
    public String getSubtotalTax() {
        return subtotalTax;
    }

    @JsonProperty("subtotal_tax")
    public void setSubtotalTax(String subtotalTax) {
        this.subtotalTax = subtotalTax;
    }

    public LineItem withSubtotalTax(String subtotalTax) {
        this.subtotalTax = subtotalTax;
        return this;
    }

    @JsonProperty("total")
    public String getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(String total) {
        this.total = total;
    }

    public LineItem withTotal(String total) {
        this.total = total;
        return this;
    }

    @JsonProperty("total_tax")
    public String getTotalTax() {
        return totalTax;
    }

    @JsonProperty("total_tax")
    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public LineItem withTotalTax(String totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    @JsonProperty("taxes")
    public List<Tax> getTaxes() {
        return taxes;
    }

    @JsonProperty("taxes")
    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public LineItem withTaxes(List<Tax> taxes) {
        this.taxes = taxes;
        return this;
    }

    @JsonProperty("meta_data")
    public List<MetaData> getMetaData() {
        return metaData;
    }

    @JsonProperty("meta_data")
    public void setMetaData(List<MetaData> metaData) {
        this.metaData = metaData;
    }

    public LineItem withMetaData(List<MetaData> metaData) {
        this.metaData = metaData;
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

    public LineItem withSku(String sku) {
        this.sku = sku;
        return this;
    }

    @JsonProperty("price")
    public long getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(long price) {
        this.price = price;
    }

    public LineItem withPrice(long price) {
        this.price = price;
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

    public LineItem withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
