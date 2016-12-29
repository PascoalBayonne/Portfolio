package ua.com.Web_Shop.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Web_Shop.Service.CountryService;

public class CountryEditor extends PropertyEditorSupport {
	private final CountryService countryService;

	public CountryEditor(CountryService countryService) {
		this.countryService = countryService;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		setValue(countryService.findOne(Integer.parseInt(text)));
	}

}
