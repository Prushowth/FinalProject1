package com.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.entity.Item;
import com.service.ItemService;


@RestController
public class ItemCOntroller {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/addItem")
	public Item addItem(@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	

}
