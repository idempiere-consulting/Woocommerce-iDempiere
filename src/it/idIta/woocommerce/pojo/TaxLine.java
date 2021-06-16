
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
    "rate_code",
    "rate_id",
    "label",
    "compound",
    "tax_total",
    "shipping_tax_total",
    "meta_data"
})
public class TaxLine {

    @JsonProperty("id")
    private long id;
    @JsonProperty("rate_code")
    private String rateCode;
    @JsonProperty("rate_id")
    private long rateId;
    @JsonProperty("label")
    private String label;
    @JsonProperty("compound")
    private boolean compound;
    @JsonProperty("tax_total")
    private String taxTotal;
    @JsonProperty("shipping_tax_total")
    private String shippingTaxTotal;
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

    public TaxLine withId(long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("rate_code")
    public String getRateCode() {
        return rateCode;
    }

    @JsonProperty("rate_code")
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public TaxLine withRateCode(String rateCode) {
        this.rateCode = rateCode;
        return this;
    }

    @JsonProperty("rate_id")
    public long getRateId() {
        return rateId;
    }

    @JsonProperty("rate_id")
    public void setRateId(long rateId) {
        this.rateId = rateId;
    }

    public TaxLine withRateId(long rateId) {
        this.rateId = rateId;
        return this;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    public TaxLine withLabel(String label) {
        this.label = label;
        return this;
    }

    @JsonProperty("compound")
    public boolean isCompound() {
        return compound;
    }

    @JsonProperty("compound")
    public void setCompound(boolean compound) {
        this.compound = compound;
    }

    public TaxLine withCompound(boolean compound) {
        this.compound = compound;
        return this;
    }

    @JsonProperty("tax_total")
    public String getTaxTotal() {
        return taxTotal;
    }

    @JsonProperty("tax_total")
    public void setTaxTotal(String taxTotal) {
        this.taxTotal = taxTotal;
    }

    public TaxLine withTaxTotal(String taxTotal) {
        this.taxTotal = taxTotal;
        return this;
    }

    @JsonProperty("shipping_tax_total")
    public String getShippingTaxTotal() {
        return shippingTaxTotal;
    }

    @JsonProperty("shipping_tax_total")
    public void setShippingTaxTotal(String shippingTaxTotal) {
        this.shippingTaxTotal = shippingTaxTotal;
    }

    public TaxLine withShippingTaxTotal(String shippingTaxTotal) {
        this.shippingTaxTotal = shippingTaxTotal;
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

    public TaxLine withMetaData(List<Object> metaData) {
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

    public TaxLine withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
