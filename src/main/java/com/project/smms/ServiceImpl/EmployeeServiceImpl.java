package com.project.smms.ServiceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smms.entity.Employee;
import com.project.smms.repositories.EmployeeRepository;
import com.project.smms.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired 
	private EmployeeRepository employeeRepo;
	
	@Override
	public String upsert(Employee employee) {
		employeeRepo.save(employee); //upsert (insert / update on PK)
		return "success";
	}

	@Override
	public Employee getById(Integer id) {
		Optional<Employee> findById= employeeRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	@Override
	public Employee searchEmployee(long id) {
	    // Use the EmployeeRepository to find an employee by ID
	    Optional<Employee> optionalEmployee = employeeRepo.findById(id);

	    return optionalEmployee.orElse(null);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
	}

}
