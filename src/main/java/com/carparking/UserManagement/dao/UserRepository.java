package com.carparking.UserManagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.carparking.UserManagement.entity.User;

public interface UserRepository extends CrudRepository <User, Long>{

}
