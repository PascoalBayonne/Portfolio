package ua.com.Web_Shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amount;

	@ManyToOne
	private User users;

	@OneToMany(mappedBy = "order")
	private List<Order_Details> order_Details;

	public Orders() {

	}

	public Orders(double amount, User users, List<Order_Details> order_Details) {
		super();
		this.amount = amount;
		this.users = users;
		this.order_Details = order_Details;
	}
	
	

	
	


	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public List<Order_Details> getOrder_Details() {
		return order_Details;
	}

	public void setOrder_Details(List<Order_Details> order_Details) {
		this.order_Details = order_Details;
	}


}
