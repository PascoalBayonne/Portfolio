package ua.com.Web_Shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category_Of_Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name_Of_category;

	@OneToMany(mappedBy="category_Of_Product")
	private List<Product>products;
	
	public Category_Of_Product(){
		
	}

	public Category_Of_Product(String name_Of_category, List<Product> products) {
		super();
		this.name_Of_category = name_Of_category;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_Of_category() {
		return name_Of_category;
	}

	public void setName_Of_category(String name_Of_category) {
		this.name_Of_category = name_Of_category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
