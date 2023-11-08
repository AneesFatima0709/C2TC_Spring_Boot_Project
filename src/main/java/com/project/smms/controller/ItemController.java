package com.project.smms.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//import com.project.exceptions.ItemNotFound;

import com.project.smms.entity.Item;
import com.project.smms.Service.ItemService;
import com.project.smms.ServiceImpl.ItemServiceImpl;
import com.project.smms.controller.ItemController;
import com.project.smms.repositories.ItemRepository;


@RestController

public class ItemController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 
 @Autowired
 private ItemService itemService;//reference variable

	@PostMapping("/item")
	public ResponseEntity<String> createItem(@RequestBody Item item) {
		String status = itemService.upsert(item);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getItem(@PathVariable Integer id) {
		Item item = itemService.getById(id);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> allItems = itemService.getAllItems();
		return new ResponseEntity<>(allItems, HttpStatus.OK);
	}

	@PutMapping("/item")
	public ResponseEntity<String> updateItem(@RequestBody Item item) {
		String status = itemService.upsert(item);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/item/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Integer id) {
		String status = itemService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}


}
