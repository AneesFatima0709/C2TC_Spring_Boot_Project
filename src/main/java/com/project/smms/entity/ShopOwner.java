package com.project.smms.entity;

import java.time.LocalDate;

//Entity class
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shopowner_details")


public class ShopOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private LocalDate dob;
	    private String address;
	    private Shop shop_id;
	    
		public ShopOwner(int id, String name, LocalDate dob, String address, Shop shop_id) {
			super();
			this.id = id;
			this.name = name;
			this.dob = dob;
			this.address = address;
			this.shop_id = shop_id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Shop getShop_id() {
			return shop_id;
		}

		public void setShop_id(Shop shop_id) {
			this.shop_id = shop_id;
		}

		@Override
		public String toString() {
			return "ShopOwner [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", shop_id="
					+ shop_id + "]";
		}

		
}
