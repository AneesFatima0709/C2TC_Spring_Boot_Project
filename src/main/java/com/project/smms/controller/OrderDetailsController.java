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

//import com.project.exceptions.OrderDetailsNotFound;
import com.project.smms.entity.OrderDetails;
import com.project.smms.Service.OrderDetailsService;
import com.project.smms.entity.Item;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/orders")
public class OrderDetailsController {
    
    @Autowired
    private OrderDetailsService orderService;

    @PostMapping("/add")
    public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order) {
        OrderDetails createdOrder = orderService.addOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order) {
    	OrderDetails updatedOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> searchOrder(@PathVariable long id) {
        OrderDetails order = orderService.searchOrder(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Boolean> cancelMall(@PathVariable long id) {
        boolean canceled = orderService.cancelMall(id);
        return new ResponseEntity<>(canceled, HttpStatus.OK);
    }

    @PostMapping("/items/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item addedItem = orderService.addItem(item);
        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
    }
}
