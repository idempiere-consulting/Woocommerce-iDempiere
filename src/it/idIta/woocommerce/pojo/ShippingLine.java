
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
    "method_title",
    "method_id",
    "total",
    "total_tax",
    "taxes",
    "meta_data"
})
public class ShippingLine {

    @JsonProperty("id")
    private long id;
    @JsonProperty("method_title")
    private String methodTitle;
    @JsonProperty("method_id")
    private String methodId;
    @JsonProperty("total")
    private String total;
    @JsonProperty("total_tax")
    private String totalTax;
    @JsonProperty("taxes")
    private List<Object> taxes = new ArrayList<Object>();
    @JsonProperty("meta_data")
    private List<Object> metaData = new ArrayList<Object>();
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

    public ShippingLine withId(long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("method_title")
    public String getMethodTitle() {
        return methodTitle;
    }

    @JsonProperty("method_title")
    public void setMethodTitle(String methodTitle) {
        this.methodTitle = methodTitle;
    }

    public ShippingLine withMethodTitle(String methodTitle) {
        this.methodTitle = methodTitle;
        return this;
    }

    @JsonProperty("method_id")
    public String getMethodId() {
        return methodId;
    }

    @JsonProperty("method_id")
    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public ShippingLine withMethodId(String methodId) {
        this.methodId = methodId;
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

    public ShippingLine withTotal(String total) {
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

    public ShippingLine withTotalTax(String totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    @JsonProperty("taxes")
    public List<Object> getTaxes() {
        return taxes;
    }

    @JsonProperty("taxes")
    public void setTaxes(List<Object> taxes) {
        this.taxes = taxes;
    }

    public ShippingLine withTaxes(List<Object> taxes) {
        this.taxes = taxes;
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

    public ShippingLine withMetaData(List<Object> metaData) {
        this.metaData = metaData;
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

    public ShippingLine withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
