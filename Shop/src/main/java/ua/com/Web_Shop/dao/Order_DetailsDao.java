package ua.com.Web_Shop.dao;

import java.util.List;

import ua.com.Web_Shop.entity.Order_Details;

public interface Order_DetailsDao {
	void save(Order_Details order_Details);
	List<Order_Details> findAll();
	Order_Details findOne(String details, int quantity, double price);
	void delete(String details);
}
