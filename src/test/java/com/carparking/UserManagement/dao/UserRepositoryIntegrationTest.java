package com.carparking.UserManagement.dao;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.carparking.UserManagement.entity.User;


@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup(@Sql( executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql","classpath:data.sql"}))
public class UserRepositoryIntegrationTest {
	@Autowired 
	UserRepository userRepo;
	
	@Test
	public void ifNewUserSaved_thenSuccess() {
		User newUser= new User("new user test","last name test user","testplatenumber","udertest@gmail.com","testpassword");
		userRepo.save(newUser);
		assertEquals(6,userRepo.findAll().size());
	}
}
