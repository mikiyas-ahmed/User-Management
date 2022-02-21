package com.carparking.UserManagement.model;

public class UserLogin {

	private  String emial;
	private  String password;
	
	public UserLogin(String getEmail, String getPassword) {
		
		this.emial = getEmail;
		this.password = getPassword;
	}
	public String getEmail() {
		return emial;
	}

	public void setEmail(String getEmail) {
		this.emial = getEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String getPassword) {
		this.password = getPassword;
	}

}
