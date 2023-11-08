package com.project.smms.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mall_admin")
public class MallAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    private Mall mall;
    private String phone;

    public MallAdmin() {
    }

    public MallAdmin(int id, String name, String password, Mall mall, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mall = mall;
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Mall getMall() {
        return mall;
    }

    public void setMall(Mall mall) {
        this.mall = mall;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	@Override
	public String toString() {
		return "MallAdmin [id=" + id + ", name=" + name + ", password=" + password + ", mall=" + mall + ", phone="
				+ phone + "]";
	}

}
