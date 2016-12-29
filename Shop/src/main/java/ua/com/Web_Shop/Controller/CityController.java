package ua.com.Web_Shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.Web_Shop.entity.City;
import ua.com.Web_Shop.Service.CityService;
import ua.com.Web_Shop.Service.StreetService;

@Controller
public class CityController {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private StreetService streetservice;



	@RequestMapping(value = "/City", method = RequestMethod.GET)
	public String City(Model model) {
//		List<City> citiesFromDB = cityService.findAll();
//		model.addAttribute("cities", citiesFromDB);
//		model.addAttribute("cities", new City());
//		model.addAttribute("streets", streetservice.findAll());
//		model.addAttribute("cities", cityService.findAll());
		model.addAttribute("cities", cityService.findCityWithStreets());
		model.addAttribute("streets", streetservice.findAll());
		return "City";
	}

	@RequestMapping(value = "/saveCity", method = RequestMethod.GET)
	private String saveCity(@ModelAttribute City city) {
		cityService.save(city);
		return "redirect:/City";

	}

	

	@RequestMapping(value = "/deleteCity/{id}", method = RequestMethod.GET)
	public String City(@PathVariable String id) {
		cityService.delete(Integer.parseInt(id));
		return "redirect:/City";
	}

	@RequestMapping(value = "/GotoHome", method = RequestMethod.GET)
	public String home() {

		return "index";
	}
}
