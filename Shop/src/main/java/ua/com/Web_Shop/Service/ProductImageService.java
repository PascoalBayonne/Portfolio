package ua.com.Web_Shop.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.entity.ProductImage;

public interface ProductImageService {
	
	void save(ProductImage productImage );
    List<ProductImage> findAll();
    ProductImage findOne(int id);
    void delete(int id);

    void saveImage(int idProduct, MultipartFile [] multipartFiles);

}
