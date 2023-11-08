package com.project.smms.entity;

import java.time.LocalDateTime;
import com.project.smms.entity.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateOfPurchase;
    private float total;
    private Customer customer_id;
    private String paymentMode;
    private Shop shop_id;

    public OrderDetails() {
    }

    public OrderDetails(int id, LocalDateTime dateOfPurchase, float total, Customer customer_id, String paymentMode, Shop shop_id) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.total = total;
        this.customer_id = customer_id;
        this.paymentMode = paymentMode;
        this.shop_id = shop_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Shop getShop_id() {
        return shop_id;
    }

    public void setShop_id(Shop shop_id) {
        this.shop_id = shop_id;
    }

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", total=" + total + ", customer_id="
				+ customer_id + ", paymentMode=" + paymentMode + ", shop_id=" + shop_id + "]";
	}

	public void setItem(Item item) {
		// TODO Auto-generated method stub
		
	}
    
}
