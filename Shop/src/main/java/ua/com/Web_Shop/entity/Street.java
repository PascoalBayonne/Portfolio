package ua.com.Web_Shop.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Street {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfStreet;

	@ManyToOne
	private City city;

	@OneToMany(mappedBy = "street")
	private List<Address> addresses;

	@OneToMany(mappedBy = "street")
	private List<User> users;

	public Street() {

	}

	public Street(String nameOfStreet) {
		super();
		this.nameOfStreet = nameOfStreet;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getNameOfStreet() {
		return nameOfStreet;
	}

	public void setNameOfStreet(String nameOfStreet) {
		this.nameOfStreet = nameOfStreet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
