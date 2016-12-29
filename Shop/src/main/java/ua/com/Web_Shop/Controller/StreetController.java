package ua.com.Web_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.Web_Shop.Service.StreetService;
import ua.com.Web_Shop.entity.Street;

@Controller
public class StreetController {
	
	@Autowired
	private StreetService streetService;
	
	@RequestMapping(value="/STREET", method = RequestMethod.GET)
	public String STREET(Model model){
		model.addAttribute("streets", streetService.findAll());
		return "Street";
	}
	
	@RequestMapping(value="/saveStreet", method =RequestMethod.GET )
	public String saveStreet(@RequestParam String  nameOfStreet){
		Street street = new Street(nameOfStreet);
		streetService.create(street);
		return "redirect:/City";
	}
	
	@RequestMapping(value="/deleteStreet", method= RequestMethod.GET)
	public String deleteStreet(@PathVariable String id){
		streetService.delete(Integer.parseInt(id));
		return"City";
	}
}
