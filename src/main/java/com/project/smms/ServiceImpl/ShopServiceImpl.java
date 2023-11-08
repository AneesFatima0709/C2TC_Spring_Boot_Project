package com.project.smms.ServiceImpl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smms.entity.Employee;
import com.project.smms.entity.Item;
import com.project.smms.entity.Shop;
import com.project.smms.repositories.ShopRepository;
import com.project.smms.repositories.EmployeeRepository;
import com.project.smms.repositories.ItemRepository;
import com.project.smms.Service.ShopService;
import com.project.smms.Service.ItemService;
import com.project.smms.Service.EmployeeService;
@Service
 public class ShopServiceImpl  {

    private final ShopRepository shopRepository;
    private final EmployeeRepository employeeRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, EmployeeRepository employeeRepository, ItemRepository itemRepository) {
        this.shopRepository = shopRepository;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
    }

    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Shop updateShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Shop searchShopById(long id) {
        return shopRepository.findById(id).orElse(null);
    }

    public Boolean addEmployee(Employee employee) {
        // You can add custom logic here, e.g., checking if the employee is already in the database
        // If needed, return true if the employee is successfully added, otherwise, return false.
        employeeRepository.save(employee);
        return true; // Modify this based on your business logic.
    }

    public Boolean updateEmployee(Employee employee) {
        // Similar to addEmployee, you can add custom logic for updating an employee.
        if (employeeRepository.existsById(employee.getEmployeeId())) {
            employeeRepository.save(employee);
            return true;
        }
        return false; // Modify this based on your business logic.
    }

    public Boolean deleteShop(long id) {
        // You can add custom logic to check if the shop has dependencies (e.g., employees) before deletion.
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
            return true;
        }
        return false; // Modify this based on your business logic.
    }

    public Item addItem(Item item) {
    	return itemRepository.save(item);}
}


