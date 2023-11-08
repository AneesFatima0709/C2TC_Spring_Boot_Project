package com.project.smms.controller;

import java.util.ArrayList;


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


//import com.project.exceptions.UserNotFound;

import com.project.smms.entity.User;
import com.project.smms.Service.UserService;
import com.project.smms.ServiceImpl.UserServiceImpl;
import com.project.smms.controller.UserController;
import com.project.smms.repositories.UserRepository;


@RestController

public class UserController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 
 @Autowired
 private UserService userService;//reference variable

	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		String status = userService.upsert(user);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		User user = userService.getById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		String status = userService.upsert(user);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		String status = userService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}


    private List<User> loggedInUsers = new ArrayList<>(); // Track the logged-in users

    // User login method
    @PostMapping("/user/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        // Check if the user is already logged in
        if (loggedInUsers.contains(user)) {
            return new ResponseEntity<>("Login failed. User is already logged in.", HttpStatus.BAD_REQUEST);
        }

        // Check if the provided credentials match a user in the database
        // You can replace this logic with actual authentication and authorization mechanisms
        if (isUserValid(user.getName(), user.getPassword())) {
            loggedInUsers.add(user);
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed. Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
    }

 // User logout method
    @PostMapping("/user/logout")
    public ResponseEntity<Boolean> logoutUser(@RequestBody User user) {
        if (loggedInUsers.contains(user)) {
            loggedInUsers.remove(user);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    
    private boolean isUserValid(String username, String password) {
        // Implement your user validation logic here (e.g., check if the user exists in the database)
        // Return true if the user is valid, otherwise return false
        // You can replace this with actual authentication and authorization logic
    	 return isValidUser("Anees Fatima", "pwd04", username, password) ||
    	           isValidUser("Amtul Noor Afza", "pwd03", username, password) ||
    	           isValidUser("Afrah Khatoon", "pwd01", username, password)||
    	           isValidUser("Humera Begum", "pwd12", username, password) ||
    	           isValidUser("Hajera Begum", "pwd11", username, password) ||
    	           isValidUser("Humera Siddiqua", "pwd13", username, password);
    	           
    	           
    	           
    }

    private boolean isValidUser(String validUsername, String validPassword, String username, String password) {
        return validUsername.equals(username) && validPassword.equals(password);
    }


}



 