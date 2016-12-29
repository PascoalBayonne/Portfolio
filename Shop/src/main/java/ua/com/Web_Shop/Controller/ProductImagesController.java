package ua.com.Web_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.Service.ProductImageService;
import ua.com.Web_Shop.Service.ProductService;

@Controller
public class ProductImagesController {
	@Autowired
	private ProductImageService productImageService;
	
	@Autowired
	private ProductService productService;
	
	  @GetMapping("/addImages/{idProduct}")
	    public String addImage(@PathVariable String idProduct, Model model){

	        model.addAttribute("product", productService.findOne(Integer.parseInt(idProduct)));

	        return "addProductImage";
	    }
	  
	  @PostMapping("/saveManyImages/{idProduct}")
	    public String saveManyImages(@PathVariable String idProduct, @RequestParam MultipartFile[] images){

		  productImageService.saveImage(Integer.parseInt(idProduct), images);


	        return "redirect:/";

	    }


}
