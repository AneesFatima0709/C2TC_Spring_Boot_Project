package com.project.smms.ServiceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smms.Service.CustomerService;
import com.project.smms.entity.Item;
import com.project.smms.repositories.ItemRepository;
import com.project.smms.entity.Mall;
import com.project.smms.repositories.MallRepository;
import com.project.smms.entity.OrderDetails;
import com.project.smms.repositories.OrderDetailsRepository;
import com.project.smms.entity.User;
import com.project.smms.repositories.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
    @Autowired
    private MallRepository mallRepository; 

    @Autowired
    private ItemRepository itemRepo; 
    
	@Override
    public List<Item> searchItem(String itemName) {
        // Implement the searchItem logic, e.g., using a repository
        List<Item> items = itemRepo.findByItemNameContaining(itemName);
        return items;
    }

    @Override
    public Item orderItem(Item item) {
        // Implement the orderItem logic, e.g., create and save an order
        OrderDetails order = new OrderDetails();
        order.setItem(item);
        orderDetailsRepo.save(order);
        return item;
    }

    @Override
    public Mall searchMall(long id) {
        // Implement the searchMall logic, e.g., using a repository
        Mall mall = mallRepository.findById(id).orElse(null);
        return mall;
    }
    
    @Autowired
    private OrderDetailsRepository orderDetailsRepo;
    
    @Override
    public boolean cancelOrder(long orderId) {
        // Implement the cancelOrder logic, e.g., cancel the order in the database
        Optional<OrderDetails> order = orderDetailsRepo.findById(orderId);
        if (order.isPresent()) {
            orderDetailsRepo.delete(order.get());
            return true;
        } else {
            return false;
        }
    }

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public User login(User user) {
        // Implement authentication logic for the user
        User existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser; // Authentication successful
        } else {
            return null; // Authentication failed
        }
    }

    @Override
    public boolean logOut() {
        // Implement logout logic if needed
        return true;}// Return true if the user was successfully logged out
}