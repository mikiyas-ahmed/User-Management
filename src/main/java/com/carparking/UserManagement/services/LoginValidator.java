package com.carparking.UserManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carparking.UserManagement.dao.UserRepository;
import com.carparking.UserManagement.entity.User;

@Service
public class LoginValidator {
	
	@Autowired
	UserRepository userRepo;
	
	
	public boolean validateUser(String email, String password) 
	{
		Iterable<User> userList= userRepo.findAll();
		for(User user : userList)
			if(user.getEmail().equals(email)&&user.getPassword().equals(password))
				return true;
		return false;
		
	}
	public User userInfo(String email, String password) 
	{
		User nouser= null;
		Iterable<User> userList= userRepo.findAll();
		for(User user : userList)
			if(user.getEmail().equals(email)&&user.getPassword().equals(password))
				return user;
		return nouser;
		
	}

}
