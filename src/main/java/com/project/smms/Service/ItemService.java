package com.project.smms.Service;

import java.util.List;

import com.project.smms.entity.Item;

public interface ItemService {

	public String upsert (Item item);

	public Item getById(Integer id);

	public List<Item> getAllItems();

	public String deleteById(Integer id);


}