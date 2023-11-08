package com.project.smms.Service;

import java.util.List;

import com.project.smms.entity.Item;
import com.project.smms.entity.Mall;
import com.project.smms.entity.User;

public interface CustomerService {
    public List<Item> searchItem(String itemName);
    public Item orderItem(Item item);
    public Mall searchMall(long id);
    public boolean cancelOrder(long orderId);
    public User login(User user);
    public boolean logOut();
}