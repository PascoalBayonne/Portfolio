package ua.com.Web_Shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product_Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double optionPiceIncrement;

	@ManyToOne
	private Product product;
	@ManyToOne
	private Options options;

	@ManyToOne
	private Options_group options_group;

	public Product_Options() {

	}

	public Product_Options(double optionPiceIncrement, Product product, Options options, Options_group options_group) {
		super();
		this.optionPiceIncrement = optionPiceIncrement;
		this.product = product;
		this.options = options;
		this.options_group = options_group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public Options_group getOptions_group() {
		return options_group;
	}

	public void setOptions_group(Options_group options_group) {
		this.options_group = options_group;
	}

}
