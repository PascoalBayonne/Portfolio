package ua.com.Web_Shop.Service;

import java.util.List;

import ua.com.Web_Shop.entity.Address;

public interface AddressService {

	void save(Address address);

	List<Address> findAll();

	Address findOne(int id);

	void delete(int id);

}
