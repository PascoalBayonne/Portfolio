package ua.com.Web_Shop.Service;

import java.util.List;

import ua.com.Web_Shop.entity.Street;

public interface StreetService {
	void create(Street street);

	List<Street> findAll();

	Street findOne(int id);

	void delete(int id);
	
	void addAddressToStreet(Street street, int idAddress);

}
