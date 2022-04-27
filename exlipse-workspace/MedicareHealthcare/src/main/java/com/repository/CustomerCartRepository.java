package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CustomerCart;

@Repository
public interface CustomerCartRepository  extends JpaRepository<CustomerCart, Long>{
	
	public CustomerCart getByUserId(Long userId);

}
