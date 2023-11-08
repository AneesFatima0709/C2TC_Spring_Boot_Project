package com.project.smms.Service;

import java.util.List;

import com.project.smms.entity.ShopOwner;

public interface ShopOwnerService {

	public String upsert (ShopOwner shopowner);

	public ShopOwner getById(Integer id);

	public List<ShopOwner> getAllShopOwner();

	public String deleteById(Integer id);



}
