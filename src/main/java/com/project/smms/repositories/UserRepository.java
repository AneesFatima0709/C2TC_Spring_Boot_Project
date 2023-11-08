package com.project.smms.repositories;


import java.io.Serializable;


	import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.project.smms.entity.User;
	
	import org.springframework.stereotype.Repository;
	@Repository

	public interface UserRepository extends JpaRepository<User, Serializable> {

		User findByUsername(Object username);

		//User findByNameAndPassword(String name, String password);
	    // can define custom query methods here if needed.
	}


