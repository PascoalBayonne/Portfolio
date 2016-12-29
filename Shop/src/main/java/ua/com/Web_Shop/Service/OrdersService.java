package ua.com.Web_Shop.Service;

import java.util.List;

import ua.com.Web_Shop.entity.Orders;

public interface OrdersService {

	void save(Orders order);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	public void addOrderToUser(Orders orders, String[] idUser);

	void deleteOrderToUser(String idUser);

	List<Orders> findOrdersWithUsers();

}
