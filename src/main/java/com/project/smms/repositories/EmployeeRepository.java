package com.project.smms.repositories;

import java.io.Serializable;

	import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.project.smms.entity.Employee;
	
	import org.springframework.stereotype.Repository;
	@Repository

	public interface EmployeeRepository extends JpaRepository<Employee, Serializable>{
}
