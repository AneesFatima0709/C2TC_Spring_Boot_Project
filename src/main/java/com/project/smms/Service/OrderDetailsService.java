package com.project.smms.Service;
import com.project.smms.entity.OrderDetails;

import com.project.smms.repositories.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.smms.entity.Item;

public interface OrderDetailsService {
    
    public OrderDetails addOrder(OrderDetails order);
    
    public OrderDetails updateOrder(OrderDetails order);
    
    public OrderDetails searchOrder(long id);
    
    boolean cancelMall(long id);
    
    public Item addItem(Item item);
    
    public Item getById(Integer id);

	String upsert(org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item item);

	org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item addItem(
			org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item item);
	
}
