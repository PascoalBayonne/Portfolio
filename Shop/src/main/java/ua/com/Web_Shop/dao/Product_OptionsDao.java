package ua.com.Web_Shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.Web_Shop.entity.Product;

public interface Product_OptionsDao extends JpaRepository<Product, Integer> {

	
}
