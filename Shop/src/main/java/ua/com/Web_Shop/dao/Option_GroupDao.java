package ua.com.Web_Shop.dao;

import java.util.List;

import ua.com.Web_Shop.entity.Options_group;

public interface Option_GroupDao {
	void save(Options_group options_group);
	List<Options_group> findAll();
	Options_group findOne(String optionGroupName);
	void delete(String optionGroupName);

}
