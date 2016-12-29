package ua.com.Web_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.Web_Shop.Editor.CityEditor;
import ua.com.Web_Shop.Service.CityService;
import ua.com.Web_Shop.Service.ProductService;
import ua.com.Web_Shop.Service.UserService;
import ua.com.Web_Shop.entity.City;
import ua.com.Web_Shop.entity.Product;
import ua.com.Web_Shop.entity.User;

@Controller
public class HomeController {
	@Autowired
	private UserService userservice;
	
	@Autowired
	private CityService cityservice;
	
	@Autowired
	private ProductService productService;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(City.class, new CityEditor(cityservice) );
	}  //why this binder here?

	@RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("cities", cityservice.findAll());
		model.addAttribute("user", new User());
		return "index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String loginprocessing(){
		return "redirect:/index";
	}
	
	@RequestMapping(value="/signup")
	public String login(){
		return "signup";
	}
	
	@RequestMapping(value ="/logout", method =RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
	@RequestMapping(value="/single")
	public String single(Model model){
		model.addAttribute("messages");
		return "single";
	}
	
	@RequestMapping(value="/products")
	public String products(Model model){
		model.addAttribute("produts", productService.findAll());
		model.addAttribute("productes", new Product());
		return "products";
	}
	
	@RequestMapping(value="/checkout")
	public String checkout(){
		return "checkout";
	}
	
//	@RequestMapping(value="/contact")
//	public String contact(){
//		return "contact";
//	}
	
	
	
}