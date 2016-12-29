package ua.com.Web_Shop.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Web_Shop.Service.AddressService;
import ua.com.Web_Shop.dao.AddreesDao;
import ua.com.Web_Shop.entity.Address;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddreesDao addreesDao;

	public void save(Address address) {
		addreesDao.save(address);
	}

	public List<Address> findAll() {
		return addreesDao.findAll();
	}

	public Address findOne(int id) {
		return addreesDao.findOne(id);
	}

	public void delete(int id) {
		addreesDao.delete(id);
	}

}
