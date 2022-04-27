package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.entity.Item;
import com.repository.CartRepository;
import com.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository cartRepo;
	
	public Cart addCart(Cart cart){
		return cartRepo.save(cart);
	}
	
	public Cart viewCart(long id) {
		return cartRepo.getById(id);
	}
	
	public Cart updateItem(Item item, long id) {
		Optional<Cart> op = cartRepo.findById(id);
		Cart cart = op.get();
		List<Item> existingList = cart.getItem();
		existingList.add(item);
		cart.setItem(existingList);
		return cartRepo.save(cart);	
	}
	
	
	public String deleteCart(long id) {
		 cartRepo.deleteById(id);
		 return "Deleted successfully";
	}

}
	


