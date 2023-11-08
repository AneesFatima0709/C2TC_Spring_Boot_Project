package com.project.smms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//import com.project.exceptions.EmployeeNotFound;

import com.project.smms.entity.Employee;
import com.project.smms.Service.EmployeeService;


@RestController

public class EmployeeController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 
 @Autowired
 private EmployeeService employeeService;//reference variable

	@PostMapping("/employee")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		String status = employeeService.upsert(employee);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Employee employee = employeeService.getById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
	    Employee employee = employeeService.searchEmployee(id);
	    if (employee != null) {
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<>(allEmployee, HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		String status = employeeService.upsert(employee);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		String status = employeeService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}


}

