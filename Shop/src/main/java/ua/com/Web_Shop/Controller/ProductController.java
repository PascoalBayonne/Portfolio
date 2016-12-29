package ua.com.Web_Shop.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.Service.ProductService;
import ua.com.Web_Shop.Service.UserService;
import ua.com.Web_Shop.entity.Product;
import ua.com.Web_Shop.entity.User;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public String newProduct(Model model) {
		model.addAttribute("produts", productService.findAll());
		model.addAttribute("productes", new Product());

		return "newProduct";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveBook(@RequestParam String product_Name, @RequestParam String product_Description,
			@RequestParam double price, @RequestParam double weight, @RequestParam MultipartFile image) {

		Product product = new Product();
		product.setProduct_Name(product_Name);
		product.setProduct_Description(product_Description);
		product.setPrice(price);
		product.setPrice(weight);
		productService.save(product, image);

		return "redirect:/admin";
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public String newProduct(@PathVariable int id) {

		productService.delete(id);

		return "redirect:/newProduct";
	}
	
}
