package com.project.smms.Service;

import com.project.smms.entity.User;
import com.project.smms.entity.Shop;


public interface MallAdminService {
    public Boolean approveNewShop(Shop shop);
    public String upsert (User user);
    public String loginUser(User user);
	public boolean logOutUser();
}