package com.service;

import com.entity.CustomerCart;

public interface CustomerCartService {

	public CustomerCart addCustomerCart(CustomerCart cuscart);

	public CustomerCart deleteCustomerCartByUserId(long userId);

	public String deleteCustomerCartById(long id);
	
	public CustomerCart addCustomerCartByUserId(long userId, long cartId);
	
	public CustomerCart findCustomerCartByUserId(long userId);

}
