package ua.com.Web_Shop.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Web_Shop.Service.StreetService;
import ua.com.Web_Shop.dao.AddreesDao;
import ua.com.Web_Shop.dao.StreetDao;
import ua.com.Web_Shop.entity.Address;
import ua.com.Web_Shop.entity.Street;

@Service("StreetService")
public class StreetServiceImpl implements StreetService {

	@Autowired
	private StreetDao streetDao;
	
	@Autowired
	private AddreesDao addressdao;

	@Override
	public void create(Street street) {
		streetDao.save(street);
	}

	@Override
	public List<Street> findAll() {
		return streetDao.findAll();
	}

	@Override
	public Street findOne(int id) {
		return streetDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		streetDao.delete(id);
	}

	@Override
	public void addAddressToStreet(Street street, int idAddress) {
		streetDao.saveAndFlush(street);
		Address address = addressdao.findOne(idAddress);
		
		address.setStreet(street);
		addressdao.save(address);
	}

}
