package com.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entity.Cart;
import com.entity.CustomerCart;
import com.entity.Item;
import com.entity.Medicine;
import com.entity.User;
import com.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addCart")
	public Cart addcart(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addCartBycheckingUserId/{userId}")
	public Cart addcart(@RequestBody Cart cart, @PathVariable("userId") long userId) {
		
		String url1 = "http://localhost:8085/findCustomerCartbyuserid/";
		String url2 = "http://localhost:8085/findbyCartId/";
		Cart existingCart;
		RestTemplate rt = new RestTemplate();
		CustomerCart cc = rt.getForObject(url1+userId, CustomerCart.class);
		if (cc==null) {
			return cartService.addCart(cart);
		}else {
			long cartId = cc.getCartId();
			return existingCart = rt.getForObject(url1+cartId, Cart.class);
		}
		
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findbyCartId/{id}")
	public Cart findById(@PathVariable ("id") long id) {
		return cartService.viewCart(id);	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findTotalbyCartId/{id}")
	public double findTotalById(@PathVariable ("id") long id) {
		Cart cart = cartService.viewCart(id);
		List<Item> item = cart.getItem();
		double totalPrice = 0;
		
		for(int i = 0;i<item.size();i++) {
			Item newitem = item.get(i);
			double price = newitem.getPrice();
			long quantity = newitem.getQuantity();
			double newPrice = price*quantity;
			totalPrice = totalPrice+newPrice;
		}
		return totalPrice;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("findCartByUsername/{userName}")
	public long getCartIdByUserName(@PathVariable("userName") String userName) {
		String url1 = "http://localhost:8085/findbyUsername/";
		String url2 = "http://localhost:8085/findCustomerCartbyuserid/";
		System.out.println(userName);
		RestTemplate rt = new RestTemplate();
		User user = rt.getForObject(url1+userName, User.class);
		long userId = user.getUserId();
		System.out.println(user);
		System.out.println(userId);
		
		CustomerCart cc = rt.getForObject(url2+userId, CustomerCart.class);
		System.out.println(cc);
		long cartId = cc.getCartId();
		return cartId;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateCart/{id}")
		public String updateCartById(@RequestBody Item item, @PathVariable ("id") long id ) {
		 long orderedQuantity = item.getQuantity();
		 String name = item.getName();
		 System.out.println(name);
		String url1 = "http://localhost:8085/findByName/";
		String url2 = "http://localhost:8085/update/";
		RestTemplate rt = new RestTemplate();
		Medicine medicine = rt.getForObject(url1+name, Medicine.class);
		System.out.println(medicine);
		
		long availableQuantity = medicine.getAvailableQuantity();
		long medicneId = medicine.getId();
		
		if(availableQuantity>orderedQuantity) {
			System.out.println(item);
			Cart cart = cartService.updateItem(item, id);
			long newQuantity = availableQuantity-orderedQuantity;
			medicine.setAvailableQuantity(newQuantity);
			rt.put(url2+medicneId, medicine, Medicine.class);
			return "item updated";
		}else {
			return "Please check the quantity";
		}
	}
	
	
	@DeleteMapping("/deleteCart/{id}")
	public String deletecart(@PathVariable ("id") long id) {
		return cartService.deleteCart(id);
	}

}
