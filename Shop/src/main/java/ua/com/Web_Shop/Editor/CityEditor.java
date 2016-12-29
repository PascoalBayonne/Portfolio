package ua.com.Web_Shop.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Web_Shop.Service.CityService;

public class CityEditor extends PropertyEditorSupport{
	private final CityService cityService;
	
	public CityEditor(CityService cityService){
		this.cityService = cityService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(cityService.findOne(Integer.parseInt(text)));
	}
	

}
