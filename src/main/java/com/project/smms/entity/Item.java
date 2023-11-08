package com.project.smms.entity;
//Entity class

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item_details")

public class Item 
{ @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

private long id;
private String name;
private String category;
private float price;
private LocalDate manufacturing;
private LocalDate expiry;
public Item() 
{
}
public Item(long id, String name, float price, LocalDate manufacturing, LocalDate expiry, String category)  
{
this.id = id;
this.name = name;
this.price = price;
this.manufacturing = manufacturing;
this.expiry = expiry;
this.category = category;
}


public long getId() 
{
return id;
}
public void setId(long id) 
{
this.id = id;
}
public String getName() 
{
return name;
}
public void setName(String name) 
{
this.name = name;
}
public float getPrice() 
{
return price;
}
public void setPrice(float price) 
{
this.price = price;
}

public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public LocalDate getManufacturing() {
	return manufacturing;
}
public void setManufacturing(LocalDate manufacturing) {
	this.manufacturing = manufacturing;
}
public LocalDate getExpiry() {
	return expiry;
}
public void setExpiry(LocalDate expiry) {
	this.expiry = expiry;
}
@Override
public String toString() {
	return "Item [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", manufacturing="
			+ manufacturing + ", expiry=" + expiry + "]";
}

}
