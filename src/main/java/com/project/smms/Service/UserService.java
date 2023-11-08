package com.project.smms.Service;


import java.util.List;



import com.project.smms.entity.User;

public interface UserService {

	public String upsert (User user);

	public User getById(Integer id);

	public List<User> getAllUsers();

	public String deleteById(Integer id);
	
	//method for user login
    public String loginUser(User user);

    //method for user logout
    public boolean logoutUser();


}
