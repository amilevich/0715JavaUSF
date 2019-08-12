package com.bank.user;

import com.bank.user.User;

public interface UserDAO {

	public void insertUser(User u);
	public User selectUserByUsername(String name);
	public User selectUserByUsernameAndPassword(String name, String password, int input);
}