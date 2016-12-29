package ua.com.Web_Shop.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.Web_Shop.entity.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer>{

	@Query("select distinct o from Orders o left join fetch  o.users ct")
	List<Orders> findOrdersWithUser();
	
	@Query("select  o from Orders o left join o.users ct where o.id =:id")
	Orders findOrdersWithUsers(@Param("id") int id);
	
}
