package ua.com.Web_Shop.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Web_Shop.Service.CountryService;
import ua.com.Web_Shop.dao.CityDao;
import ua.com.Web_Shop.dao.CountryDao;
import ua.com.Web_Shop.entity.City;
import ua.com.Web_Shop.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Autowired
	private CityDao cityDao;

	public void save(Country country) {
		countryDao.save(country);
	}

	public List<Country> findAll() {
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		Country country = countryDao.findCountryWithCity(id);
		for (City cit : country.getCities()) {
			cit.setCountry(null);
			cityDao.save(cit);
		}
		countryDao.delete(country);

	}

	@Transactional
	public void deleteCityFromCountry(String idCity) {

		City city = cityDao.findOne(Integer.parseInt(idCity));

		city.setCountry(null);
		cityDao.save(city);

	}

	@Transactional
	public void addCityToCountry(Country country, String[] cityId) {

		countryDao.saveAndFlush(country);

		for (int i = 0; i < cityId.length; i++) {
			City city = cityDao.findOne(Integer.parseInt(cityId[i]));
			city.setCountry(country);
			cityDao.save(city);

		}
	}

	public List<Country> findCountryWithCities() {
		return countryDao.findCountryWithCities();
		// TODO Auto-generated method stub

	}

}
