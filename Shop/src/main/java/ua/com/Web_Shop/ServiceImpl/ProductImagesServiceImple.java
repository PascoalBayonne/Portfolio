package ua.com.Web_Shop.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.Service.ProductImageService;
import ua.com.Web_Shop.dao.ProdcutDao;
import ua.com.Web_Shop.dao.ProductImagesDao;
import ua.com.Web_Shop.entity.Product;
import ua.com.Web_Shop.entity.ProductImage;

@Service
public class ProductImagesServiceImple implements ProductImageService {
	@Autowired
	private ProductImagesDao productImagesDao;

	@Autowired
	private ProdcutDao prodcutDao;

	@Override
	public void save(ProductImage productImage) {
		productImagesDao.save(productImage);

	}

	@Override
	public List<ProductImage> findAll() {
		// TODO Auto-generated method stub
		return productImagesDao.findAll();
	}

	@Override
	public ProductImage findOne(int id) {
		// TODO Auto-generated method stub
		return productImagesDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		productImagesDao.delete(id);

	}

	@Override
	public void saveImage(int idProduct, MultipartFile[] multipartFiles) {

		Product product = prodcutDao.productWithimages(idProduct);

		for (MultipartFile multipartFile : multipartFiles) {

			String path = System.getProperty("catalina.home") + "/resources/" + product.getProduct_Name() + "/"
					+ multipartFile.getOriginalFilename();

			ProductImage productImage = new ProductImage(
					"resources/" + product.getProduct_Name() + "/" + multipartFile.getOriginalFilename());

			productImage.setProduct(product);

			File file = new File(path);

			try {
				file.mkdirs();
				multipartFile.transferTo(file);
			} catch (IOException e) {
				System.out.println("error with file");
			}

			productImagesDao.save(productImage);

		}
	}

}
