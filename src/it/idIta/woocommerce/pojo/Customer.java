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
	"date_created",
	"date_created_gmt",
	"date_modified",
	"date_modified_gmt",
	"email",
	"first_name",
	"last_name",
	"role",
	"username",
	"billing",
	"shipping",
	"is_paying_customer",
	"avatar_url",
	"meta_data",
	"_links"
})
public class Customer {

	@JsonProperty("id")
	private long id;
	@JsonProperty("date_created")
	private String dateCreated;
	@JsonProperty("date_created_gmt")
	private String dateCreatedGmt;
	@JsonProperty("date_modified")
	private String dateModified;
	@JsonProperty("date_modified_gmt")
	private String dateModifiedGmt;
	@JsonProperty("email")
	private String email;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("role")
	private String role;
	@JsonProperty("username")
	private String username;
	@JsonProperty("billing")
	private Billing billing;
	@JsonProperty("shipping")
	private Shipping shipping;
	@JsonProperty("is_paying_customer")
	private boolean isPayingCustomer;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	@JsonProperty("meta_data")
	private List<Object> metaData = new ArrayList<Object>();
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

	public Customer withId(long id) {
		this.id = id;
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

	public Customer withDateCreated(String dateCreated) {
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

	public Customer withDateCreatedGmt(String dateCreatedGmt) {
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

	public Customer withDateModified(String dateModified) {
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

	public Customer withDateModifiedGmt(String dateModifiedGmt) {
		this.dateModifiedGmt = dateModifiedGmt;
		return this;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	public Customer withEmail(String email) {
		this.email = email;
		return this;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Customer withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Customer withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@JsonProperty("role")
	public String getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(String role) {
		this.role = role;
	}

	public Customer withRole(String role) {
		this.role = role;
		return this;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public Customer withUsername(String username) {
		this.username = username;
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

	public Customer withBilling(Billing billing) {
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

	public Customer withShipping(Shipping shipping) {
		this.shipping = shipping;
		return this;
	}

	@JsonProperty("is_paying_customer")
	public boolean isIsPayingCustomer() {
		return isPayingCustomer;
	}

	@JsonProperty("is_paying_customer")
	public void setIsPayingCustomer(boolean isPayingCustomer) {
		this.isPayingCustomer = isPayingCustomer;
	}

	public Customer withIsPayingCustomer(boolean isPayingCustomer) {
		this.isPayingCustomer = isPayingCustomer;
		return this;
	}

	@JsonProperty("avatar_url")
	public String getAvatarUrl() {
		return avatarUrl;
	}

	@JsonProperty("avatar_url")
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Customer withAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
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

	public Customer withMetaData(List<Object> metaData) {
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

	public Customer withLinks(Links links) {
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

	public Customer withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}