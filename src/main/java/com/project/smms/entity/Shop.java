package com.project.smms.entity;

//Entity class
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shop_details")


public class Shop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int shopId;
	    private String shopCategory;
	    private Employee EmployeeId;
	    private String name;
	    private String Customers;
	    private String ShopStatus;
	    private ShopOwner shopowner;
	    private String leaseStatus;
	    
	    public Shop() {
	    }

		public Shop(int shopId, String shopCategory, Employee employeeId, String name, String customers,
				String shopStatus, ShopOwner shopowner, String leaseStatus) {
			super();
			this.shopId = shopId;
			this.shopCategory = shopCategory;
			EmployeeId = employeeId;
			this.name = name;
			Customers = customers;
			ShopStatus = shopStatus;
			this.shopowner = shopowner;
			this.leaseStatus = leaseStatus;
		}

		public int getShopId() {
			return shopId;
		}

		public void setShopId(int shopId) {
			this.shopId = shopId;
		}

		public String getShopCategory() {
			return shopCategory;
		}

		public void setShopCategory(String shopCategory) {
			this.shopCategory = shopCategory;
		}

		public Employee getEmployeeId() {
			return EmployeeId;
		}

		public void setEmployeeId(Employee employeeId) {
			EmployeeId = employeeId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCustomers() {
			return Customers;
		}

		public void setCustomers(String customers) {
			Customers = customers;
		}

		public String getShopStatus() {
			return ShopStatus;
		}

		public void setShopStatus(String shopStatus) {
			ShopStatus = shopStatus;
		}

		public ShopOwner getShopowner() {
			return shopowner;
		}

		public void setShopowner(ShopOwner shopowner) {
			this.shopowner = shopowner;
		}

		public String getLeaseStatus() {
			return leaseStatus;
		}

		public void setLeaseStatus(String leaseStatus) {
			this.leaseStatus = leaseStatus;
		}

		@Override
		public String toString() {
			return "Shop [shopId=" + shopId + ", shopCategory=" + shopCategory + ", name=" + name + ", Customers="
					+ Customers + ", ShopStatus=" + ShopStatus + ", leaseStatus=" + leaseStatus +"]";
		}



	}
