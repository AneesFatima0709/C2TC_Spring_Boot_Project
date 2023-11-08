package com.project.smms.Service;

import java.util.List;

import com.project.smms.entity.Employee;

public interface EmployeeService {

	public String upsert (Employee employee);

	public Employee getById(Integer id);

	public List<Employee> getAllEmployee();
	
	public Employee searchEmployee(long id);

	public String deleteById(Integer id);

}