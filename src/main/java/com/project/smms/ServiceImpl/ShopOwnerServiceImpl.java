package com.project.smms.ServiceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smms.entity.ShopOwner;
import com.project.smms.repositories.ShopOwnerRepository;
import com.project.smms.Service.ShopOwnerService;

@Service
public class ShopOwnerServiceImpl implements ShopOwnerService {

	@Autowired 
	private ShopOwnerRepository shopownerRepo;
	
	@Override
	public String upsert(ShopOwner shopowner) {
		shopownerRepo.save(shopowner); //upsert (insert / update on PK)
		return "success";
	}

	@Override
	public ShopOwner getById(Integer id) {
		Optional<ShopOwner> findById=shopownerRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<ShopOwner> getAllShopOwner() {
		return shopownerRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(shopownerRepo.existsById(id)) {
			shopownerRepo.deleteById(id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
	}

}
