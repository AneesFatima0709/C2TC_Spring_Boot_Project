package com.project.smms.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.smms.repositories.MallAdminRepository;
import com.project.smms.entity.User;
import com.project.smms.entity.Shop;
import com.project.smms.Service.MallAdminService;
import com.project.smms.repositories.UserRepository;

@Service
public class MallAdminServiceImpl implements MallAdminService {

	@Autowired 
	private MallAdminRepository mallAdminRepo;
	
	@Override
    public Boolean approveNewShop(Shop shop) {
       
        if (shop != null) {
            // Example logic: Assume all shops are approved.
            return true;
        } else {
            // If the input shop is null, you might want to return false or handle the error.
            return false;
        }
    }
	
	
	@Autowired 
	private UserRepository userRepo;
	
	@Override
	public String upsert(User user) {
		userRepo.save(user); //upsert (insert / update on PK)
		return "success";
	}
	
	@Override
    public String loginUser(User user) {
        // Implement authentication logic for the user
        User existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Authentication successful"; // Authenticated
        } else {
            return null; // Authentication failed
        }
    }

    @Override
    public boolean logOutUser() {
        // Implement logout logic if needed
        return true;}// Return true if the user was successfully logged out   

    }
