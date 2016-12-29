package ua.com.Web_Shop.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.entity.Product;

public interface ProductService {

	void save(Product product,MultipartFile image);

	List<Product> findAll();

	Product findOne(int id);

	void delete(int id);

	List<Product> productImages();
	

//	void update(Product product);

}
