package ua.com.Web_Shop.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Web_Shop.Service.CityService;
import ua.com.Web_Shop.dao.CityDao;
import ua.com.Web_Shop.dao.StreetDao;
import ua.com.Web_Shop.entity.City;
import ua.com.Web_Shop.entity.Street;

@Service("CityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;
	@Autowired
	private StreetDao streetdao;

	@Override
	public void save(City city) {
		cityDao.save(city);
	}

	@Override
	public List<City> findAll() {
		return cityDao.findAll();
	}

	@Override
	public City findOne(int id) {
		return cityDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		City city = cityDao.findCityWithstreets(id);
		for (Street street : city.getStreets()) {
			street.setCity(null);
			streetdao.save(street);
		}
		cityDao.delete(city);
	}

	@Transactional
	public void addStreeetToCity(City city, String[] idStreet) {
		cityDao.saveAndFlush(city);

		for (int i = 0; i < idStreet.length; i++) {
			Street street = streetdao.findOne(Integer.parseInt(idStreet[i]));
			street.setCity(city);
			streetdao.save(street);
		}
	}

	@Transactional
	public void deleteStreetFromCountry(String idStreet) {
		Street street = streetdao.findOne(Integer.parseInt(idStreet));
		street.setCity(null);
		streetdao.save(street);
	}

	public List<City> findCityWithStreets() {
		return cityDao.findCityWithStreets();
	}

}
