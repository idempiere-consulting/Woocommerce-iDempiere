package it.idIta.woocommerce.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"name",
	"position",
	"visible",
	"variation",
	"options"
})
public class AttributeIntoProduct {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("position")
	private int position;
	@JsonProperty("visible")
	private boolean visible;
	@JsonProperty("variation")
	private boolean variation;
	@JsonProperty("options")
	private List<String> options = null;

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	public AttributeIntoProduct withId(int id) {
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

	public AttributeIntoProduct withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("position")
	public int getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(int position) {
		this.position = position;
	}

	public AttributeIntoProduct withPosition(int position) {
		this.position = position;
		return this;
	}

	@JsonProperty("visible")
	public boolean isVisible() {
		return visible;
	}

	@JsonProperty("visible")
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public AttributeIntoProduct withVisible(boolean visible) {
		this.visible = visible;
		return this;
	}

	@JsonProperty("variation")
	public boolean isVariation() {
		return variation;
	}

	@JsonProperty("variation")
	public void setVariation(boolean variation) {
		this.variation = variation;
	}

	public AttributeIntoProduct withVariation(boolean variation) {
		this.variation = variation;
		return this;
	}

	@JsonProperty("options")
	public List<String> getOptions() {
		return options;
	}

	@JsonProperty("options")
	public void setOptions(List<String> options) {
		this.options = options;
	}

	public AttributeIntoProduct withOptions(List<String> options) {
		this.options = options;
		return this;
	}

}