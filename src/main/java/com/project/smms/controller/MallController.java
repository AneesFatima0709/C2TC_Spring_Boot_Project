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


//import com.project.exceptions.MallNotFound;

import com.project.smms.entity.Mall;
import com.project.smms.Service.MallService;


@RestController

public class MallController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 
 @Autowired
 private MallService mallService;//reference variable

	@PostMapping("/mall")
	public ResponseEntity<String> createMall(@RequestBody Mall mall) {
		String status = mallService.upsert(mall);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/mall/{id}")
	public ResponseEntity<Mall> getMall(@PathVariable Integer id) {
		Mall mall = mallService.getById(id);
		return new ResponseEntity<>(mall, HttpStatus.OK);
	}

	@GetMapping("/malls")
	public ResponseEntity<List<Mall>> getAllMalls() {
		List<Mall> allMalls = mallService.getAllItems();
		return new ResponseEntity<>(allMalls, HttpStatus.OK);
	}

	@PutMapping("/mall")
	public ResponseEntity<String> updateMall(@RequestBody Mall mall) {
		String status = mallService.upsert(mall);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/mall/{id}")
	public ResponseEntity<String> deleteMall(@PathVariable Integer id) {
		String status = mallService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}

