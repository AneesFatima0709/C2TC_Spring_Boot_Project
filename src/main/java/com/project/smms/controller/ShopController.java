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


//import com.project.exceptions.ShopNotFound;

import com.project.smms.entity.Shop;
import com.project.smms.Service.ShopService;
import com.project.smms.entity.Employee;
import com.project.smms.entity.Item;
import com.project.smms.Service.EmployeeService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/addShop")
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @PutMapping("/updateShop")
    public Shop updateShop(@RequestBody Shop shop) {
        return shopService.updateShop(shop);
    }

    @GetMapping("/searchShop/{id}")
    public Shop searchShopById(@PathVariable long id) {
        return shopService.searchShopById(id);
    }

    @PostMapping("/addEmployee")
    public Boolean addEmployee(@RequestBody Employee employee) {
        return shopService.addEmployee(employee);
    }

    @PutMapping("/updateEmployee")
    public Boolean updateEmployee(@RequestBody Employee employee) {
        return shopService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteShop/{id}")
    public Boolean deleteShop(@PathVariable long id) {
        return shopService.deleteShop(id);
    }

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item) {
        return shopService.addItem(item);}
}

