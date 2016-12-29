package ua.com.Web_Shop.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Web_Shop.Service.OrdersService;
import ua.com.Web_Shop.dao.OrderDao;
import ua.com.Web_Shop.dao.UserDao;
import ua.com.Web_Shop.entity.User;
import ua.com.Web_Shop.entity.Orders;

@Service("OrdersService")
public class OrdersServiceImplement implements OrdersService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;

	@Override
	public void save(Orders order) {
		orderDao.save(order);
	}

	@Override
	public List<Orders> findAll() {
		return orderDao.findAll();
	}

	@Override
	public Orders findOne(int id) {
		return orderDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		Orders orders = orderDao.findOrdersWithUsers(id);
		orders.setUsers(null);
		orderDao.delete(orders);

	}

	@Override
	public void addOrderToUser(Orders orders, String[] idUser) {
		orderDao.saveAndFlush(orders);

		for (int i = 0; i < idUser.length; i++) {
			User user = userDao.findOne(Integer.parseInt(idUser[i]));
			user.setOrders((List<Orders>) orders);
			userDao.save(user);
		}

	}

	@Override
	public void deleteOrderToUser(String idUser) {

		User user = userDao.findOne(Integer.parseInt(idUser));
		user.setOrders(null);
		userDao.save(user);
	}

	@Override
	public List<Orders> findOrdersWithUsers() {
		return orderDao.findOrdersWithUser();
	}

}
