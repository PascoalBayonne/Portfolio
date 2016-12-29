package ua.com.Web_Shop.Service;

import java.util.List;

import ua.com.Web_Shop.entity.City;

public interface CityService {
	void save(City city);

	List<City> findAll();

	City findOne(int id);

	void delete(int id);

	public void addStreeetToCity(City city, String[] idStreet);

	void deleteStreetFromCountry(String idStreet);
	
	List<City> findCityWithStreets();

}
