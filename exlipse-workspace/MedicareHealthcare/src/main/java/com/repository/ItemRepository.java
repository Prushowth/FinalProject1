package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	

}
