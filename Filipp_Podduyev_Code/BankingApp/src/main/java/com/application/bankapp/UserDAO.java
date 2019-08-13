package com.application.bankapp;

import java.util.List;

public interface UserDAO {
	//CREATE
	public int createUser(User u);
	
	//READ
	public User selectUserByName(String userName);
	public List<User> selectAllUsers();
	public boolean logIn(String userName, String passWord);
	public User pendingAccountApplication();
	public void updateStatus(User u);
	
	//UPDATE
	public int updateUser(User u);
	
	//DELETE
	public int deleteUser(User u);


}
