package com.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CustomerCart;
import com.entity.User;
import com.repository.CustomerCartRepository;
import com.service.CustomerCartService;

@Service
public class CustomerCartServiceImpl implements CustomerCartService{

	@Autowired
	CustomerCartRepository cusCartRepo;
	
	public CustomerCart addCustomerCart(CustomerCart cuscart) {
		return cusCartRepo.save(cuscart);
	}
	
	public CustomerCart findCustomerCartByUserId(long userId) {
		return cusCartRepo.getByUserId(userId);
	}
	
	public CustomerCart addCustomerCartByUserId(long userId, long cartId) {
		CustomerCart exisitingcc= cusCartRepo.getByUserId(userId);
		if (exisitingcc==null) {
		CustomerCart cc = new CustomerCart();
		cc.setCartId(cartId);
		cc.setUserId(userId);
		return cusCartRepo.save(cc);
		}else {
			return exisitingcc;
		}	
//		Optional<CustomerCart> customerCart = Optional.of(cusCartRepo.getByUserId(userId));
//		if(customerCart.isPresent()){
//		  return customerCart.get();
//		}else{
//			CustomerCart cuscart = new CustomerCart();
//			cuscart.setUserId(userId);
//			cuscart.setCartId(cartId);
//			return cusCartRepo.save(cuscart);
//		}
		
	}
	
	
	public CustomerCart deleteCustomerCartByUserId(long userId) {
		CustomerCart cuscart = cusCartRepo.getByUserId(userId);
		 cusCartRepo.delete(cuscart);
		 return cuscart;
	}
	
	public String deleteCustomerCartById(long id) {
		cusCartRepo.deleteById(id);
		return "Removed successfully";

	}
}
