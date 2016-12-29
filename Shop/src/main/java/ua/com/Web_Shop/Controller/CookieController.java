package ua.com.Web_Shop.Controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.Web_Shop.Service.ProductService;
import ua.com.Web_Shop.Service.UserService;

@Controller
public class CookieController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/buyProduct/{id}", method = RequestMethod.GET)
	public String buyBook(@PathVariable String id, HttpServletRequest request,
	HttpServletResponse response) {

	userService.intoBasket(Integer.parseInt(id), request, response);

	return "redirect:/";
	}
	
	
	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	public String getOrder(Principal principal, @PathVariable String id, 
	HttpServletRequest request,
	HttpServletResponse response) {

	userService.getOrder(principal, id, request.getCookies(), response);

	return "redirect:/profile";
	}
	
	@RequestMapping(value = "/deleteFromOrder/{id}", method = RequestMethod.GET)
	public String deleteCookie(@PathVariable String id, HttpServletRequest request,
	HttpServletResponse response) {

	userService.deleteCookieFromOrder(id, request, response);

	return "redirect:/basket";
	}
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basket(HttpServletRequest request, Model model){

	model.addAttribute("books", userService.userProductsCookie(request));

	return "basket";
	}
	
	

}
