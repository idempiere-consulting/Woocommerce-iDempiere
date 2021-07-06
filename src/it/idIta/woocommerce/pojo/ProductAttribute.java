package it.idIta.woocommerce.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"name",
	"slug",
	"type",
	"order_by",
	"has_archives",
	"_links"
})
public class ProductAttribute {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("slug")
	private String slug;
	@JsonProperty("type")
	private String type;
	@JsonProperty("order_by")
	private String orderBy;
	@JsonProperty("has_archives")
	private boolean hasArchives;
	@JsonProperty("_links")
	private Links links;
	@JsonProperty("options")
	private List<ProductAttributeTerm> pat;
	@JsonProperty("position")
	private int position;
	@JsonProperty("visible")
	private boolean visible;
	@JsonProperty("variation")
	private boolean variation;

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	public ProductAttribute withId(int id) {
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

	public ProductAttribute withName(String name) {
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

	public ProductAttribute withSlug(String slug) {
		this.slug = slug;
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

	public ProductAttribute withType(String type) {
		this.type = type;
		return this;
	}

	@JsonProperty("order_by")
	public String getOrderBy() {
		return orderBy;
	}

	@JsonProperty("order_by")
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public ProductAttribute withOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	@JsonProperty("has_archives")
	public boolean isHasArchives() {
		return hasArchives;
	}

	@JsonProperty("has_archives")
	public void setHasArchives(boolean hasArchives) {
		this.hasArchives = hasArchives;
	}

	public ProductAttribute withHasArchives(boolean hasArchives) {
		this.hasArchives = hasArchives;
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

	public ProductAttribute withLinks(Links links) {
		this.links = links;
		return this;
	}

	@JsonProperty("options")
	public List<ProductAttributeTerm> getPat() {
		return pat;
	}

	@JsonProperty("options")
	public void setPat(List<ProductAttributeTerm> pat) {
		this.pat = pat;
	}

	@JsonProperty("position")
	public int getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(int position) {
		this.position = position;
	}

	@JsonProperty("visible")
	public boolean isVisible() {
		return visible;
	}

	@JsonProperty("visible")
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@JsonProperty("variation")
	public boolean isVariation() {
		return variation;
	}

	@JsonProperty("variation")
	public void setVariation(boolean variation) {
		this.variation = variation;
	}
	
	
	

}