package ua.com.Web_Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value ="/admin",method=RequestMethod.GET)
	public String newCountry(Model model){
		return "admin";
	}
}
