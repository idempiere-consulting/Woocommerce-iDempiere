
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
    "parent_id",
    "number",
    "order_key",
    "created_via",
    "version",
    "status",
    "currency",
    "date_created",
    "date_created_gmt",
    "date_modified",
    "date_modified_gmt",
    "discount_total",
    "discount_tax",
    "shipping_total",
    "shipping_tax",
    "cart_tax",
    "total",
    "total_tax",
    "prices_include_tax",
    "customer_id",
    "customer_ip_address",
    "customer_user_agent",
    "customer_note",
    "billing",
    "shipping",
    "payment_method",
    "payment_method_title",
    "transaction_id",
    "date_paid",
    "date_paid_gmt",
    "date_completed",
    "date_completed_gmt",
    "cart_hash",
    "meta_data",
    "line_items",
    "tax_lines",
    "shipping_lines",
    "fee_lines",
    "coupon_lines",
    "refunds",
    "_links"
})
public class Order {

    @JsonProperty("id")
    private long id;
    @JsonProperty("parent_id")
    private long parentId;
    @JsonProperty("number")
    private String number;
    @JsonProperty("order_key")
    private String orderKey;
    @JsonProperty("created_via")
    private String createdVia;
    @JsonProperty("version")
    private String version;
    @JsonProperty("status")
    private String status;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;
    @JsonProperty("date_modified")
    private String dateModified;
    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;
    @JsonProperty("discount_total")
    private String discountTotal;
    @JsonProperty("discount_tax")
    private String discountTax;
    @JsonProperty("shipping_total")
    private String shippingTotal;
    @JsonProperty("shipping_tax")
    private String shippingTax;
    @JsonProperty("cart_tax")
    private String cartTax;
    @JsonProperty("total")
    private String total;
    @JsonProperty("total_tax")
    private String totalTax;
    @JsonProperty("prices_include_tax")
    private boolean pricesIncludeTax;
    @JsonProperty("customer_id")
    private long customerId;
    @JsonProperty("customer_ip_address")
    private String customerIpAddress;
    @JsonProperty("customer_user_agent")
    private String customerUserAgent;
    @JsonProperty("customer_note")
    private String customerNote;
    @JsonProperty("billing")
    private Billing billing;
    @JsonProperty("shipping")
    private Shipping shipping;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("payment_method_title")
    private String paymentMethodTitle;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("date_paid")
    private String datePaid;
    @JsonProperty("date_paid_gmt")
    private String datePaidGmt;
    @JsonProperty("date_completed")
    private Object dateCompleted;
    @JsonProperty("date_completed_gmt")
    private Object dateCompletedGmt;
    @JsonProperty("cart_hash")
    private String cartHash;
    @JsonProperty("meta_data")
    private List<MetaData> metaData = new ArrayList<MetaData>();
    @JsonProperty("line_items")
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    @JsonProperty("tax_lines")
    private List<TaxLine> taxLines = new ArrayList<TaxLine>();
    @JsonProperty("shipping_lines")
    private List<ShippingLine> shippingLines = new ArrayList<ShippingLine>();
    @JsonProperty("fee_lines")
    private List<Object> feeLines = new ArrayList<Object>();
    @JsonProperty("coupon_lines")
    private List<Object> couponLines = new ArrayList<Object>();
    @JsonProperty("refunds")
    private List<Object> refunds = new ArrayList<Object>();
    @JsonProperty("_links")
    private Links links;
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

    public Order withId(long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("parent_id")
    public long getParentId() {
        return parentId;
    }

    @JsonProperty("parent_id")
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Order withParentId(long parentId) {
        this.parentId = parentId;
        return this;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    public Order withNumber(String number) {
        this.number = number;
        return this;
    }

    @JsonProperty("order_key")
    public String getOrderKey() {
        return orderKey;
    }

    @JsonProperty("order_key")
    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public Order withOrderKey(String orderKey) {
        this.orderKey = orderKey;
        return this;
    }

    @JsonProperty("created_via")
    public String getCreatedVia() {
        return createdVia;
    }

    @JsonProperty("created_via")
    public void setCreatedVia(String createdVia) {
        this.createdVia = createdVia;
    }

    public Order withCreatedVia(String createdVia) {
        this.createdVia = createdVia;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Order withVersion(String version) {
        this.version = version;
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

    public Order withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Order withCurrency(String currency) {
        this.currency = currency;
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

    public Order withDateCreated(String dateCreated) {
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

    public Order withDateCreatedGmt(String dateCreatedGmt) {
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

    public Order withDateModified(String dateModified) {
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

    public Order withDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
        return this;
    }

    @JsonProperty("discount_total")
    public String getDiscountTotal() {
        return discountTotal;
    }

    @JsonProperty("discount_total")
    public void setDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
    }

    public Order withDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
        return this;
    }

    @JsonProperty("discount_tax")
    public String getDiscountTax() {
        return discountTax;
    }

    @JsonProperty("discount_tax")
    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }

    public Order withDiscountTax(String discountTax) {
        this.discountTax = discountTax;
        return this;
    }

    @JsonProperty("shipping_total")
    public String getShippingTotal() {
        return shippingTotal;
    }

    @JsonProperty("shipping_total")
    public void setShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public Order withShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
        return this;
    }

    @JsonProperty("shipping_tax")
    public String getShippingTax() {
        return shippingTax;
    }

    @JsonProperty("shipping_tax")
    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public Order withShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
        return this;
    }

    @JsonProperty("cart_tax")
    public String getCartTax() {
        return cartTax;
    }

    @JsonProperty("cart_tax")
    public void setCartTax(String cartTax) {
        this.cartTax = cartTax;
    }

    public Order withCartTax(String cartTax) {
        this.cartTax = cartTax;
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

    public Order withTotal(String total) {
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

    public Order withTotalTax(String totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    @JsonProperty("prices_include_tax")
    public boolean isPricesIncludeTax() {
        return pricesIncludeTax;
    }

    @JsonProperty("prices_include_tax")
    public void setPricesIncludeTax(boolean pricesIncludeTax) {
        this.pricesIncludeTax = pricesIncludeTax;
    }

    public Order withPricesIncludeTax(boolean pricesIncludeTax) {
        this.pricesIncludeTax = pricesIncludeTax;
        return this;
    }

    @JsonProperty("customer_id")
    public long getCustomerId() {
        return customerId;
    }

    @JsonProperty("customer_id")
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Order withCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    @JsonProperty("customer_ip_address")
    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    @JsonProperty("customer_ip_address")
    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public Order withCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
        return this;
    }

    @JsonProperty("customer_user_agent")
    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    @JsonProperty("customer_user_agent")
    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public Order withCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
        return this;
    }

    @JsonProperty("customer_note")
    public String getCustomerNote() {
        return customerNote;
    }

    @JsonProperty("customer_note")
    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public Order withCustomerNote(String customerNote) {
        this.customerNote = customerNote;
        return this;
    }

    @JsonProperty("billing")
    public Billing getBilling() {
        return billing;
    }

    @JsonProperty("billing")
    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Order withBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    @JsonProperty("shipping")
    public Shipping getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Order withShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    @JsonProperty("payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("payment_method")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Order withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    @JsonProperty("payment_method_title")
    public String getPaymentMethodTitle() {
        return paymentMethodTitle;
    }

    @JsonProperty("payment_method_title")
    public void setPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
    }

    public Order withPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
        return this;
    }

    @JsonProperty("transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Order withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @JsonProperty("date_paid")
    public String getDatePaid() {
        return datePaid;
    }

    @JsonProperty("date_paid")
    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public Order withDatePaid(String datePaid) {
        this.datePaid = datePaid;
        return this;
    }

    @JsonProperty("date_paid_gmt")
    public String getDatePaidGmt() {
        return datePaidGmt;
    }

    @JsonProperty("date_paid_gmt")
    public void setDatePaidGmt(String datePaidGmt) {
        this.datePaidGmt = datePaidGmt;
    }

    public Order withDatePaidGmt(String datePaidGmt) {
        this.datePaidGmt = datePaidGmt;
        return this;
    }

    @JsonProperty("date_completed")
    public Object getDateCompleted() {
        return dateCompleted;
    }

    @JsonProperty("date_completed")
    public void setDateCompleted(Object dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Order withDateCompleted(Object dateCompleted) {
        this.dateCompleted = dateCompleted;
        return this;
    }

    @JsonProperty("date_completed_gmt")
    public Object getDateCompletedGmt() {
        return dateCompletedGmt;
    }

    @JsonProperty("date_completed_gmt")
    public void setDateCompletedGmt(Object dateCompletedGmt) {
        this.dateCompletedGmt = dateCompletedGmt;
    }

    public Order withDateCompletedGmt(Object dateCompletedGmt) {
        this.dateCompletedGmt = dateCompletedGmt;
        return this;
    }

    @JsonProperty("cart_hash")
    public String getCartHash() {
        return cartHash;
    }

    @JsonProperty("cart_hash")
    public void setCartHash(String cartHash) {
        this.cartHash = cartHash;
    }

    public Order withCartHash(String cartHash) {
        this.cartHash = cartHash;
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

    public Order withMetaData(List<MetaData> metaData) {
        this.metaData = metaData;
        return this;
    }

    @JsonProperty("line_items")
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    @JsonProperty("line_items")
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Order withLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    @JsonProperty("tax_lines")
    public List<TaxLine> getTaxLines() {
        return taxLines;
    }

    @JsonProperty("tax_lines")
    public void setTaxLines(List<TaxLine> taxLines) {
        this.taxLines = taxLines;
    }

    public Order withTaxLines(List<TaxLine> taxLines) {
        this.taxLines = taxLines;
        return this;
    }

    @JsonProperty("shipping_lines")
    public List<ShippingLine> getShippingLines() {
        return shippingLines;
    }

    @JsonProperty("shipping_lines")
    public void setShippingLines(List<ShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public Order withShippingLines(List<ShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
        return this;
    }

    @JsonProperty("fee_lines")
    public List<Object> getFeeLines() {
        return feeLines;
    }

    @JsonProperty("fee_lines")
    public void setFeeLines(List<Object> feeLines) {
        this.feeLines = feeLines;
    }

    public Order withFeeLines(List<Object> feeLines) {
        this.feeLines = feeLines;
        return this;
    }

    @JsonProperty("coupon_lines")
    public List<Object> getCouponLines() {
        return couponLines;
    }

    @JsonProperty("coupon_lines")
    public void setCouponLines(List<Object> couponLines) {
        this.couponLines = couponLines;
    }

    public Order withCouponLines(List<Object> couponLines) {
        this.couponLines = couponLines;
        return this;
    }

    @JsonProperty("refunds")
    public List<Object> getRefunds() {
        return refunds;
    }

    @JsonProperty("refunds")
    public void setRefunds(List<Object> refunds) {
        this.refunds = refunds;
    }

    public Order withRefunds(List<Object> refunds) {
        this.refunds = refunds;
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

    public Order withLinks(Links links) {
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

    public Order withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
