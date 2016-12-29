package ua.com.Web_Shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Options_group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String optionGroupName;

	@OneToMany(mappedBy = "options_group")
	private List<Options> options;

	@OneToMany(mappedBy = "options_group")
	private List<Product_Options> product_Options;

	public Options_group() {

	}

	public Options_group(String optionGroupName, List<Options> options, List<Product_Options> product_Options) {
		super();
		this.optionGroupName = optionGroupName;
		this.options = options;
		this.product_Options = product_Options;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionGroupName() {
		return optionGroupName;
	}

	public void setOptionGroupName(String optionGroupName) {
		this.optionGroupName = optionGroupName;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	public List<Product_Options> getProduct_Options() {
		return product_Options;
	}

	public void setProduct_Options(List<Product_Options> product_Options) {
		this.product_Options = product_Options;
	}

}
