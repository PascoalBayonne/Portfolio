package ua.com.Web_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.Web_Shop.Service.OrdersService;
import ua.com.Web_Shop.entity.Orders;
import ua.com.Web_Shop.Service.UserService;

@Controller
public class OrderController {
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/Order", method = RequestMethod.GET)
	private String Order(Model model){
		model.addAttribute("orders",ordersService.findOrdersWithUsers());
		model.addAttribute("users", userService.findAll());
		return "Order";
		
	}
	
	@RequestMapping(value="/saveOrder", method = RequestMethod.GET)
	private String saveOrder(@ModelAttribute Orders order){
		ordersService.save(order);
		return "redirect:/Order";
	}

	
}
