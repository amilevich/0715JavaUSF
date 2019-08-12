package src.com.john.dao;

import java.util.ArrayList;

import src.com.john.core.User;

public interface UserDAO
{
	public void insert(User user);
	
	public User selectUserByName(String username);
	
	public ArrayList<User> selectAllUsers();
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}