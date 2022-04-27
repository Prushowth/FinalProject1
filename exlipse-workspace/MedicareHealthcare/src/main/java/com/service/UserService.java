package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public List<User> findAllUser();
	
	public User findByUsername(String username);

}
