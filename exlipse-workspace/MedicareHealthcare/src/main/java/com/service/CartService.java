package com.service;

import com.entity.Cart;
import com.entity.Item;

public interface CartService {
	
	public Cart addCart(Cart cart);
	
	public Cart viewCart(long id);
	
	public String deleteCart(long id);

	public Cart updateItem(Item item, long id);
}
