package ua.com.Web_Shop.dao;

import java.util.List;

import ua.com.Web_Shop.entity.Options;

public interface OptionDao {
	void save(Options options);
	List<Options> findAll();
	Options findOne(String optionName);
	void delete(String optionName);

}
