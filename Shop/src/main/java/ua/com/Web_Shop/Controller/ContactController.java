package ua.com.Web_Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.Web_Shop.entity.User;

@Controller
public class ContactController {

	@RequestMapping(value={"/contact"}, method=RequestMethod.GET)
	public String contact(Model model){
		
		return "contact";
	}
}
