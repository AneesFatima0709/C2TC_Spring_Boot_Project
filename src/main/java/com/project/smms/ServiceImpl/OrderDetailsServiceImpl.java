package com.project.smms.ServiceImpl;

import java.util.ArrayList;
import java.util.List;


import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.smms.entity.OrderDetails;
import com.project.smms.repositories.OrderDetailsRepository;
import com.project.smms.Service.OrderDetailsService;
import com.project.smms.repositories.CustomerRepository;
import com.project.smms.Service.ItemService;
import com.project.smms.repositories.ItemRepository;


@Service
public abstract class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetails addOrder(OrderDetails order) {
        // Your implementation to add an order
        // For example, you can save the order to the repository
        return orderDetailsRepository.save(order);
    }

    @Override
    public OrderDetails updateOrder(OrderDetails order) {
        // Your implementation to update an order
        // For example, you can check if the order exists and then update it
        Optional<OrderDetails> existingOrder = orderDetailsRepository.findById(order.getId());
        if (existingOrder.isPresent()) {
            OrderDetails updatedOrder = orderDetailsRepository.save(order);
            return updatedOrder;
        } else {
            // Handle the case where the order doesn't exist
            return null;
        }
    }

    @Override
    public OrderDetails searchOrder(long id) {
        // Your implementation to search for an order
        // For example, you can retrieve the order based on the provided ID
        Optional<OrderDetails> order = orderDetailsRepository.findById(id);
        return order.orElse(null);
    }

    @Override
    public boolean cancelMall(long id) {
        // Your implementation to cancel all orders associated with the given ID
        // For example, you can delete all orders with the provided ID
        List<OrderDetails> ordersToCancel = orderDetailsRepository.findByCustomerId(id);
        if (!ordersToCancel.isEmpty()) {
            orderDetailsRepository.deleteAll(ordersToCancel);
            return true; // Orders canceled successfully
        } else {
            // No orders to cancel
            return false;
        }
    }
    
    @Autowired 
	private ItemRepository itemRepo; 
    
    private List<Item> items = new ArrayList<>(); // You can replace this with a repository or database
    
    @Override
    public Item addItem(Item item) {
        // Implement the logic to add the item, e.g., to a list or a database
        items.add(item);
        return item;
    }


}
