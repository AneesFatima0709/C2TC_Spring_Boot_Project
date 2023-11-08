package com.project.smms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

//import com.project.exceptions.CustomerNotFound;
import com.project.smms.entity.User;
import com.project.smms.entity.Item;
import com.project.smms.entity.Mall;
import com.project.smms.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/searchItem")
    public ResponseEntity<List<Item>> searchItem(@RequestParam String itemName) {
        List<Item> items = customerService.searchItem(itemName);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/orderItem")
    public ResponseEntity<Item> orderItem(@RequestBody Item item) {
        Item orderedItem = customerService.orderItem(item);
        return new ResponseEntity<>(orderedItem, HttpStatus.OK);
    }

    @GetMapping("/searchMall/{id}")
    public ResponseEntity<Mall> searchMall(@PathVariable long id) {
        Mall mall = customerService.searchMall(id);
        if (mall != null) {
            return new ResponseEntity<>(mall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public ResponseEntity<Boolean> cancelOrder(@PathVariable long orderId) {
        boolean result = customerService.cancelOrder(orderId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = customerService.login(user);
        if (loggedInUser != null) {
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/logOut")
    public ResponseEntity<Boolean> logOut() {
        boolean loggedOut = customerService.logOut();
        return new ResponseEntity<>(loggedOut, HttpStatus.OK);
    }
}