package ua.com.Web_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.Web_Shop.Service.CityService;
import ua.com.Web_Shop.Service.CountryService;
import ua.com.Web_Shop.entity.Country;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CityService cityservice;
	
	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	private String newCountry(Model model){
		model.addAttribute("countries", countryService.findCountryWithCities());
		model.addAttribute("cities", cityservice.findAll());
		return "newCountry";
	}
	
	@RequestMapping(value ="/saveCountry", method = RequestMethod.GET)
	private String saveCountry(@ModelAttribute Country country ){                          //@RequestParam String name, @RequestParam String []cityId){
		countryService.save(country);
		//Country country = new Country(name);
		//countryService.addCityToCountry(country, cityId);
		return "redirect:/newCountry";
		//no
	}
	@RequestMapping(value="/deleteCountry/{id}", method = RequestMethod.GET)
	private String newCountry(@PathVariable String id){
		countryService.delete(Integer.parseInt(id));
		return "redirect:/newCountry";
	}
	
	@RequestMapping(value ="/deleteCityFromCountry/{cityId}")
	private String deleteCityFromCountry(@PathVariable String idCity){
		countryService.deleteCityFromCountry(idCity);
		return "redirect:/newCountry";
	}

}
