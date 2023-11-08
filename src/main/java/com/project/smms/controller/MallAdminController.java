package com.project.smms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.project.exceptions.MallAdminNotFound;
import com.project.smms.Service.MallAdminService;
import com.project.smms.entity.User;
import com.project.smms.entity.Shop;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mall-admin")
public class MallAdminController {

    @Autowired
    private MallAdminService mallAdminService;

    @PostMapping("/approve-shop")
    public ResponseEntity<Boolean> approveNewShop(@RequestBody Shop shop) {
        Boolean result = mallAdminService.approveNewShop(shop);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

	@PutMapping("/update-user")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		String status = mallAdminService.upsert(user);
		return new ResponseEntity<>(status, HttpStatus.OK);
		}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String loggedInUser = mallAdminService.loginUser(user);
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
@PostMapping("/logout")
public ResponseEntity<Boolean> logOut() {
    boolean result = mallAdminService.logOutUser();
    return ResponseEntity.ok(result);
}
}
