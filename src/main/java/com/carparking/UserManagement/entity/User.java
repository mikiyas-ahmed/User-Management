package com.carparking.UserManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;


//@Validated
@Entity
@Table(name = "user_accounts")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_accounts_seq")
	@SequenceGenerator(name = "user_accounts_seq", allocationSize = 1)
	@Column(name = "user_id")
	private long userID;
	
	@Column(nullable = false)
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Column(unique = true)
	private String plateNumber;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String password;

	public User() {	}

	public User(String firstName, String lastName, String plateNumber, String email, String password) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.plateNumber = plateNumber;
		this.email = email;
		this.password = password;
	}

	public String getPassword() { return password; }

	public void setPassword(String password) {	this.password = password;	}
	
	public String getFirstName() {	return firstName;	}

	public void setFirstName(String firstName) {	this.firstName = firstName;	}

	public String getLastName() {	return lastName;	}

	public void setLastName(String lastName) {	this.lastName = lastName;	}

	public long getUserID() {	return userID;	}

	public void setUserID(long userID) {	this.userID = userID;	}

	public String getPlateNumber() {	return plateNumber;	}

	public void setPlateNumber(String plateNumber) {	this.plateNumber = plateNumber;	}

	public String getEmail() {	return email;	}

	public void setEmail(String email) {	this.email = email;	}

}
