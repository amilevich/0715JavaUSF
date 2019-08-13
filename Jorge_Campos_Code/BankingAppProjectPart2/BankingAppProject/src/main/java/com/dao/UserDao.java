package com.dao;

import java.util.HashMap;

import com.bank.User;


public interface UserDao {
	
		//CREATE
		public void insertUser(User u);
		
		//READ
		public User selectUserByUserName(String username);
		public HashMap<String,User> selectAllUsers();
		
		//UPDATE
		public void updateUser(User u);
		
		//DELETE	
		public void deleteUser(User u);

}
