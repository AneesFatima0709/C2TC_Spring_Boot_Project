package com.project.smms.ServiceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smms.entity.Item;
import com.project.smms.repositories.ItemRepository;
import com.project.smms.Service.ItemService;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired 
	private ItemRepository itemRepo;
	
	@Override
	public String upsert(Item item) {
		System.out.print("item "+item.getId());
		itemRepo.save(item); //upsert (insert / update on PK)
		return "success";
	}

	@Override
	public Item getById(Integer id) {
		Optional<Item> findById=itemRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(itemRepo.existsById(id)) {
			itemRepo.deleteById(id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
	}

}
