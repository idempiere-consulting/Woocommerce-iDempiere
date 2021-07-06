package it.idIta.woocommerce.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"name",
	"slug",
	"description",
	"menu_order",
	"count",
	"_links"
})
public class ProductAttributeTerm {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("slug")
	private String slug;
	@JsonProperty("description")
	private String description;
	@JsonProperty("menu_order")
	private int menuOrder;
	@JsonProperty("count")
	private int count;
	@JsonProperty("_links")
	private Links links;

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	public ProductAttributeTerm withId(int id) {
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

	public ProductAttributeTerm withName(String name) {
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

	public ProductAttributeTerm withSlug(String slug) {
		this.slug = slug;
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

	public ProductAttributeTerm withDescription(String description) {
		this.description = description;
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

	public ProductAttributeTerm withMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
		return this;
	}

	@JsonProperty("count")
	public int getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(int count) {
		this.count = count;
	}

	public ProductAttributeTerm withCount(int count) {
		this.count = count;
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

	public ProductAttributeTerm withLinks(Links links) {
		this.links = links;
		return this;
	}

}