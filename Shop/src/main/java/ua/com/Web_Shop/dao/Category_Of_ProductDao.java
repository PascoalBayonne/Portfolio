package ua.com.Web_Shop.dao;

import java.util.List;

import ua.com.Web_Shop.entity.Category_Of_Product;

public interface Category_Of_ProductDao {

	void save(Category_Of_Product category_Of_Product);

	List<Category_Of_Product> findAll();

	Category_Of_Product findOne(String name_Of_category);

	void delete(String name_Of_category);
}
