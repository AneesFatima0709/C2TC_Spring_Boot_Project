package com.project.smms.entity;

import java.util.Objects;

//Entity class
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_details")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private String type;
	    private String password;
	    public User() {
	    }
	    public User(int id, String name, String type, String password) {
	        this.id=id;
	        this.name=name;
	        this.type=type;
	        this.password=password;
	    }

		public long getId() {
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
		}
		
		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        User user = (User) o;
	        return Objects.equals(name, user.name);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(name);
	    }
		public Object getUsername() {
			// TODO Auto-generated method stub
			return null;
		}
	    
	}


