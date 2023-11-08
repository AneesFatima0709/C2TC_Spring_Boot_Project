package com.project.smms.repositories;

import java.io.Serializable;

	import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.project.smms.entity.ShopOwner;
	
	import org.springframework.stereotype.Repository;
	@Repository

	public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Serializable>{
}
