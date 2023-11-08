package com.project.smms.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smms.Service.MallService;
import com.project.smms.entity.Mall;
import com.project.smms.repositories.MallRepository;

@Service
public class MallServiceImpl implements MallService {

	@Autowired 
	private MallRepository itemRepo;
	
	@Override
	public String upsert(Mall mall) {
		itemRepo.save(mall); //upsert (insert / update on PK)
		return "success";
	}

	@Override
	public Mall getById(Integer id) {
		Optional<Mall> findById=itemRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Mall> getAllItems() {
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
