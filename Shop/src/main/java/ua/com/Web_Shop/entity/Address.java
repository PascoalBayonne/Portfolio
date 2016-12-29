package ua.com.Web_Shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int numberOfBuild;
	private int numberOfFlat;
	
	

	@ManyToOne
	private Street street;
	public Address(){
		
	}

	public Address(int numberOfBuild) {
		super();
		this.numberOfBuild = numberOfBuild;
	}

	public int getNumberOfBuild() {
		return numberOfBuild;
	}

	public void setNumberOfBuild(int numberOfBuild) {
		this.numberOfBuild = numberOfBuild;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}
	public int getNumberOfFlat() {
		return numberOfFlat;
	}

	public void setNumberOfFlat(int numberOfFlat) {
		this.numberOfFlat = numberOfFlat;
	}

	public Address(int numberOfBuild, int numberOfFlat) {
		super();
		this.numberOfBuild = numberOfBuild;
		this.numberOfFlat = numberOfFlat;
		
	}
	
	

}
