package com.comtroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entity.Cart;
import com.entity.CustomerCart;
import com.entity.Item;
import com.entity.User;
import com.service.CustomerCartService;

@RestController
public class CustomerCartController {
	
	@Autowired
	CustomerCartService cusCartService;
	
	@PostMapping("/addCustomerCart")
	public CustomerCart addCustomerCart(@RequestBody CustomerCart customerCart) {
		return cusCartService.addCustomerCart(customerCart);
	}
	
	@GetMapping("/findCustomerCartbyuserid/{userId}")
	public CustomerCart findccByUserId(@PathVariable("userId") long userId) {
		return cusCartService.findCustomerCartByUserId(userId);
	}
	
	
    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addCustomerCart/{userName}")
	public CustomerCart addCustomerCartByUserId(@PathVariable ("userName") String userName) {
		String url1 = "http://localhost:8085/findbyUsername/";
		String url2 = "http://localhost:8085/addCartBycheckingUserId/";
		RestTemplate rt = new RestTemplate();
		User user = rt.getForObject(url1+userName, User.class);
		System.out.println(user);
		long userId = user.getUserId();
		System.out.println(userId);
		
		Cart cart = new Cart();
		 List<Item>item = new ArrayList<>();
//		cart.setItem(item);
		Cart newCart = rt.postForObject(url2+userId, cart, Cart.class);
		long cartId = newCart.getId();
		System.out.println(userId );
		System.out.println(cartId);
		return cusCartService.addCustomerCartByUserId(userId, cartId); 
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteCustomerCartByUserId/{userId}")
	public CustomerCart findCustomerCart(@PathVariable ("userId") long userId) {
		CustomerCart cuscart = cusCartService.findCustomerCartByUserId(userId);

		long cuscartCartId = cuscart.getCartId();
		long cusCartId = cuscart.getId();
		cusCartService.deleteCustomerCartById(cusCartId);
		
		RestTemplate rt = new RestTemplate();
		String url1 = "http://localhost:8085/deleteCart/";
		rt.delete(url1+cuscartCartId, Cart.class);
		return cuscart;
	}

	@DeleteMapping("/deleteCustomerCart/{id}")
	public String removeCustomerCart(@PathVariable ("id") long id) {
		return cusCartService.deleteCustomerCartById(id);
	}
}
