package ua.com.Web_Shop.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Web_Shop.Service.OrdersService;

public class OrderEditor extends PropertyEditorSupport{
	private final OrdersService ordersService;
	
	public OrderEditor(OrdersService ordersService){
		this.ordersService = ordersService;
	}

	public void setAsText(String text) throws IllegalArgumentException{
		setValue(ordersService.findOne(Integer.parseInt(text)));
	}
}
