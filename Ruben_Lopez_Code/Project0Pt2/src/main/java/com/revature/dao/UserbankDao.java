package com.revature.dao;

import java.util.List;



import com.revature.model.Userbank;

public interface UserbankDao {
	
	
	//CREATE
	public int createNewUserbank(String newusername, String newpassword);
	
	//READ
		
		//Gets all users
	public List<Userbank> selectAllUserbank();
	
		//checks for password
	public boolean checkForUserAndPassword(String username1,String password1);
	
		//returns an object of user
	public Userbank getUserbankByName(String usertracker);
	
		//Checks if user exist
	public boolean checkForForUser(String usertracker);
	
	
	
	
	//UPDATE
		//A setter for user name
	public int setUsernameByOldName(String usertracker , String newusername);
	
		//A setter for password
	public int setPasswordByUserName(String usertracker , String newpassword);
	
		//A setter for privilege
	public int setPrivilegeByUserName(String usertracker, int newPrivilege);
	
	
	//DELETE
	public int deleteUserbankByUsername(String oldname);

}
