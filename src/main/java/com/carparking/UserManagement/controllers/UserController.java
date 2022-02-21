package com.carparking.UserManagement.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carparking.UserManagement.dao.UserRepository;
import com.carparking.UserManagement.entity.User;
import com.carparking.UserManagement.model.UserLogin;
import com.carparking.UserManagement.services.LoginValidator;

@RestController
@RequestMapping("/user")
public class UserController 
{
		
	@Autowired
	UserRepository userRepo;
	
	
	@Autowired
	LoginValidator loginValidator;
	
	@GetMapping("/")
	public Iterable<User> user() 
	{
		return userRepo.findAll();
	}
	
	
	@GetMapping("/{name}")
	public User user(@PathVariable("name") Long id) 
	{
		return userRepo.findById(id).get();
	}
	
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) 
	{
		return userRepo.save(user);
	}
	
	
	@PostMapping(path="/login", consumes="application/json")
	public User loginValidator(@RequestBody UserLogin user, HttpServletResponse response)
	{
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		if(loginValidator.validateUser(user.getEmail(),user.getPassword())) 
		{		
			return loginValidator.userInfo(user.getEmail(), user.getPassword());
		}
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return null;
	}
	
	
}