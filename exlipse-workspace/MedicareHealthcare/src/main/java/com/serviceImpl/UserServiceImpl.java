package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> findAllUser(){
		return userRepo.findAll();
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUserName(username);
	}
	
	

}
