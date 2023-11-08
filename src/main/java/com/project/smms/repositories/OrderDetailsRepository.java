package com.project.smms.repositories;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.smms.entity.OrderDetails;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Serializable>{

    public Order save(Order order);

	public List<OrderDetails> findByCustomerId(long id);
}