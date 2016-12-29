package ua.com.Web_Shop.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.Service.ProductService;
import ua.com.Web_Shop.dao.ProdcutDao;
import ua.com.Web_Shop.entity.Product;

@Service
public class ProductServiceImple implements ProductService {

	@Autowired
	private ProdcutDao productDao;

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findOne(int id) {
		return productDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Transactional
	public void save(Product product, MultipartFile image) {

		String path = System.getProperty("catalina.home") + "/resources/" + product.getProduct_Name() + "/"
				+ image.getOriginalFilename();

		product.setProductImage("resources/" + product.getProduct_Name() + "/" + image.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(new File(
						System.getProperty("catalina.home") + "/resources/" + product.getProduct_Name() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
		productDao.save(product);

	}

	@Override
	public List<Product> productImages() {
		return productDao.productImages();
	}


}
