package ua.com.Web_Shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.Web_Shop.entity.ProductImage;

public interface ProductImagesDao extends JpaRepository<ProductImage, Integer>{

	
}
