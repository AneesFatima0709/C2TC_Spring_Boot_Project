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
@Table(name = "mall_details")


public class Mall {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String mallName;
	    private String location;
	    private String categories;
	    private MallAdmin mallAdmin;
	    private Shop shops_id;
	    public Mall() {
	    }
	    public Mall(long id, String mallName, String location, String categories, MallAdmin mallAdmin, Shop shops_id) {
	        this.id=id;
	        this.mallName=mallName;
	        this.location=location;
	        this.categories=categories;
	        this.mallAdmin=mallAdmin;
	        this.shops_id=shops_id;

	    }

	
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getMallName() {
			return mallName;
		}
		public void setMallName(String mallName) {
			this.mallName = mallName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getCategories() {
			return categories;
		}
		public void setCategories(String categories) {
			this.categories = categories;
		}
		public MallAdmin getMallAdmin() {
			return mallAdmin;
		}
		public void setMallAdmin(MallAdmin mallAdmin) {
			this.mallAdmin = mallAdmin;
		}
		public Shop getShops_id() {
			return shops_id;
		}
		public void setShops_id(Shop shops_id) {
			this.shops_id = shops_id;
		}
		@Override
		public String toString() {
			return "Mall [id=" + id + ", mallName=" + mallName + ", location=" + location + ", categories=" + categories
					+ ", mallAdmin=" + mallAdmin + ", shops_id=" + shops_id + "]";
		}
		

	}
