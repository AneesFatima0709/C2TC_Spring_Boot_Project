package com.project.smms.ServiceImpl;


import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smms.entity.User;
import com.project.smms.repositories.UserRepository;
import com.project.smms.Service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private Map<String, User> loggedInUsers = new HashMap<>(); // Track logged-in users


	@Autowired 
	private UserRepository userRepo;
	
	@Override
	public String upsert(User user) {
		userRepo.save(user); //upsert (insert / update on PK)
		return "success";
	}

	@Override
	public User getById(Integer id) {
		Optional<User> findById=userRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
	}
	
	@Override
    public String loginUser(User user) {
		if (!loggedInUsers.containsKey(user.getName())) {
		String exampleUsername = "Anees Fatima";
        String examplePassword = "pwd04";

        if (exampleUsername.equals(user.getName()) && examplePassword.equals(user.getPassword())) {
        	loggedInUsers.put(user.getName(), user);
                return "User logged in successfully";
            } else {
                return "Login failed. Invalid username or password.";
            }
		}else {
            return "Login failed. User is already logged in.";
        }
        }
    

    @Override
    public boolean logoutUser() {
    	  loggedInUsers = null;
          return true;
    }

    // Additional method to validate user credentials
    private boolean isValidUserCredentials(User user) {
        // In a real application, you would validate user credentials against the database
        // For demonstration purposes, we use hardcoded credentials
        return "Anees Fatima".equals(user.getName()) && "pwd04".equals(user.getPassword());
    }

}
