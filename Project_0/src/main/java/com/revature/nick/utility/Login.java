package com.revature.nick.utility;

import com.revature.nick.data.UserData;
import com.revature.nick.database.UserDAO;

public class Login
{
	UserDAO dao = new UserDAO();
	
	public boolean login(String username, String password)
	{
		UserData user = dao.selectByUsername(username);
		
		boolean success = false;
		
		if (user.getPassword().equals(password))
		{
			success = true;
		}
		
		return success;
	}
}
