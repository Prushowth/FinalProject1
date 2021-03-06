package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Item;
import com.repository.ItemRepository;
import com.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepo;
	
	public Item createItem(Item item) {
		return itemRepo.save(item);
	}
	
	public List<Item> findAllItems(){
		return itemRepo.findAll();
	}
	
	
}
