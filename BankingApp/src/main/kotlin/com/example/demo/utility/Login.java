package com.example.demo.utility;

import com.example.demo.data.UserData;
import com.example.demo.DAO.UserDAO;

public class Login
{
	UserDAO dao = new UserDAO();
	
	public boolean login(String username, String password)
	{
		UserData user = dao.selectByUsername(username);
		
		boolean success = false;

		if (user != null)
		{
			if (user.getPassword().equals(password))
			{
				success = true;
			}
		}

		return success;
	}
}
