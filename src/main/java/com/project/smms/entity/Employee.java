package com.project.smms.entity;

import java.io.Serializable;
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
@Table(name = "Employee_details")


public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private LocalDate dob;
	    private float salary;
	    private String address;
	    private String designation;
	    private Shop shop_id;
	    
		public Employee(int id, String name, LocalDate dob, float salary, String address, String designation,
				Shop shop_id) {
			super();
			this.id = id;
			this.name = name;
			this.dob = dob;
			this.salary = salary;
			this.address = address;
			this.designation = designation;
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

		public float getSalary() {
			return salary;
		}

		public void setSalary(float salary) {
			this.salary = salary;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public Shop getShop_id() {
			return shop_id;
		}

		public void setShop_id(Shop shop_id) {
			this.shop_id = shop_id;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", address="
					+ address + ", designation=" + designation + ", shop_id=" + shop_id + "]";
		}

		public Serializable getEmployeeId() {
			// TODO Auto-generated method stub
			return null;
		}

		
}
