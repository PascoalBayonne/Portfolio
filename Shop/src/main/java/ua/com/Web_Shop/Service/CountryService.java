package ua.com.Web_Shop.Service;

import java.util.List;

import ua.com.Web_Shop.entity.Country;

public interface CountryService {
	void save(Country country);

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	public void addCityToCountry(Country country, String[] cityId);

	void deleteCityFromCountry(String idCity);

	List<Country> findCountryWithCities();
	
}
