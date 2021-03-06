package com.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> findAllUser(){
		return userService.findAllUser();
	}
	
	
	@GetMapping("/findbyUsername/{userName}")
	public User findByUsername(@PathVariable ("userName") String userName) {
		return userService.findByUsername(userName);	
	}
	
	@GetMapping("/login/{userName}/{encrytedPassword}")
	public boolean findByUser(@PathVariable ("userName") String userName, @PathVariable ("encrytedPassword") String encrytedPassword) {
		User user =  userService.findByUsername(userName);
		String password = user.getEncrytedPassword();
		if(password.equals(encrytedPassword)) {
			return true;
		}else {
			return false;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200") 
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User userData){
		User user = userService.findByUsername(userData.getUserName());
		if(user.getEncrytedPassword().equals(userData.getEncrytedPassword())) {
			return ResponseEntity.ok(user);
		}else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
		
	}

}
