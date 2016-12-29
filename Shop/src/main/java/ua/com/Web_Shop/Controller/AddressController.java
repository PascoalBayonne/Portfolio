package ua.com.Web_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.Web_Shop.Service.AddressService;
import ua.com.Web_Shop.entity.Address;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="/Address", method= RequestMethod.GET)
	public String Address(){
		//model.addAttribute("", arg1)
		return "Address";
	}
	
	//numberOfBuild;
	//private int numberOfFlat;
	
	@RequestMapping(value="/saveAddress", method= RequestMethod.GET)
	public String saveAddress(@RequestParam Integer numberOfBuild, @RequestParam Integer numberOfFlat)
	{
		Address address = new Address(numberOfBuild, numberOfFlat);
		addressService.save(address);
		return "redirect:/STREET";
	}
	

}
