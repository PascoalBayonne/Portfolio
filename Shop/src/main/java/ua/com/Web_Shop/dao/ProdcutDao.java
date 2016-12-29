package ua.com.Web_Shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.Web_Shop.entity.Product;

public interface ProdcutDao extends JpaRepository<Product, Integer>{


	@Query("select p from Product p left join fetch p.productImages where p.id =:id")
    Product productWithimages(@Param("id") int id);

    @Query("select p from Product p left join fetch p.productImages")
    List<Product> productImages();
	
}
