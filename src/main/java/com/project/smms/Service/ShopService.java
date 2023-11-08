package com.project.smms.Service;
	
import java.util.List;

import com.project.smms.entity.Shop;
import com.project.smms.entity.Employee;
import com.project.smms.entity.Item;

public interface ShopService {
    Shop addShop(Shop shop);
    Shop updateShop(Shop shop);
    Shop searchShopById(long id);
    Boolean addEmployee(Employee employee);
    Boolean updateEmployee(Employee employee);
    Boolean deleteShop(long id);
    Item addItem(Item item);
}