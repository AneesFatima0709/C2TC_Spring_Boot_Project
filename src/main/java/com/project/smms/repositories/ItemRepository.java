package com.project.smms.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.project.smms.entity.Item;
	
	import org.springframework.stereotype.Repository;
	@Repository

	public interface ItemRepository extends JpaRepository<Item, Serializable>{

		List<Item> findByItemNameContaining(String itemName);//used for customer
}