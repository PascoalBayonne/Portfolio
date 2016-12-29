package ua.com.Web_Shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String product_Name;
	private String product_Description;
	private double price, weight;

	private String productImage;
	@OneToMany(mappedBy = "product")
	private List<Order_Details> order_Details;

	@ManyToOne
	private Category_Of_Product category_Of_Product;

	@OneToMany(mappedBy = "product")
	private List<Product_Options> product_Options;

	@ManyToMany
	@JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@OneToMany(mappedBy = "product")
	private List<ProductImage> productImages;
	
	public Product() {

	}

	

	public Product(int id, String product_Name, String product_Description, double price, double weight,
			String productImage, List<Order_Details> order_Details, Category_Of_Product category_Of_Product,
			List<Product_Options> product_Options, List<User> users, List<ProductImage> productImages) {
		super();
		this.id = id;
		this.product_Name = product_Name;
		this.product_Description = product_Description;
		this.price = price;
		this.weight = weight;
		this.productImage = productImage;
		this.order_Details = order_Details;
		this.category_Of_Product = category_Of_Product;
		this.product_Options = product_Options;
		this.users = users;
		this.productImages = productImages;
	}



	public List<ProductImage> getProductImages() {
		return productImages;
	}



	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}



	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Category_Of_Product getCategory_Of_Product() {
		return category_Of_Product;
	}

	public void setCategory_Of_Product(Category_Of_Product category_Of_Product) {
		this.category_Of_Product = category_Of_Product;
	}

	public List<Product_Options> getProduct_Options() {
		return product_Options;
	}

	public void setProduct_Options(List<Product_Options> product_Options) {
		this.product_Options = product_Options;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Description() {
		return product_Description;
	}

	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<Order_Details> getOrder_Details() {
		return order_Details;
	}

	public void setOrder_Details(List<Order_Details> order_Details) {
		this.order_Details = order_Details;
	}

}
