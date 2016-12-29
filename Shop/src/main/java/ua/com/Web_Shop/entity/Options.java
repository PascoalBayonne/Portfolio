package ua.com.Web_Shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GeneratorType;

@Entity
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String optionName;

	@OneToMany(mappedBy = "options")
	private List<Product_Options> product_Options;
	
	@ManyToOne
	private Options_group options_group;

	public Options() {

	}

	
	public Options(String optionName, List<Product_Options> product_Options, Options_group options_group) {
		super();
		this.optionName = optionName;
		this.product_Options = product_Options;
		this.options_group = options_group;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public List<Product_Options> getProduct_Options() {
		return product_Options;
	}

	public void setProduct_Options(List<Product_Options> product_Options) {
		this.product_Options = product_Options;
	}

	public Options_group getOptions_group() {
		return options_group;
	}

	public void setOptions_group(Options_group options_group) {
		this.options_group = options_group;
	}

	

}
