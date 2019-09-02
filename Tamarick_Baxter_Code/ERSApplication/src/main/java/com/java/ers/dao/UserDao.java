package com.java.ers.dao;

import com.java.ers.domain.User;

/*
 * Interface to provide the UserDao Layer to provide user interaction with
 * the database. 
 */

public interface UserDao {
	
	/*
	 * Function to check the login of the user. If the user exist with the
	 * given login credentials, return true otherwise return false. 
	 * 
	 * userName - of the user
	 * password - of the user
	 * return true of login is successful, false otherwise. 
	 */
	public boolean login(String userName, String password);
	
	/*
	 * Function to load the user data into the User Object and return it. 
	 * If no such user exist, return null. 
	 * 
	 * userName - of the user
	 * password - of the user
	 * return user if user exist, null otherwise.  
	 */
	public User getUser(String userName, String password); 
	
	/*
	 * Function to load the user data into the User Object and return it. If no such
	 * user exist, return null.
	 * 
	 * userId - of the user
	 * return user if user exist, null otherwise.
	 */
	public User getUser(int userId);
}
