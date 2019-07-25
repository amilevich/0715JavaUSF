package com.revature.nick.database;

import java.util.ArrayList;
import java.util.HashMap;

import com.revature.nick.data.UserData;

public class UserTable
{
	private static UserTable instance = null;
	
	private HashMap<Integer, UserData> userMap;
	
	private UserTable()
	{
		userMap = new HashMap<Integer, UserData>();
	}
	
	public static UserTable getInstance()
	{
		if (instance == null)
		{
			instance = new UserTable();
		}
		return instance;
	}
	
	public String getPassword(String username)
	{
		String result = "";
		
		for (Integer i : userMap.keySet())
		{
			if (userMap.get(i).getUsername().equals(username))
			{
				result = userMap.get(i).getPassword();
			}
		}
		return result;
	}
	
	public UserData getUser(int id)
	{
		UserData user = null;
		
		for (Integer data : userMap.keySet())
		{
			if (userMap.get(data).getId() == id)
			{
				user = userMap.get(data);
			}
		}
		
		return user;
	}
	
	public ArrayList<UserData> getAllUsers()
	{
		ArrayList<UserData> list = new ArrayList<>();
		
		for (Integer i : userMap.keySet())
		{
			list.add(userMap.get(i));
		}
		
		return null;
	}
	
	public void insertUser(UserData user)
	{
		userMap.put(user.getId(), user);
	}
	
	public void deleteUser(int id)
	{
		for (Integer i : userMap.keySet())
		{
			if(userMap.get(i).getId() == id)
			{
				userMap.remove(i);
			}
		}
	}
	
	public UserData getUserByUsername(String username)
	{
		UserData user = null;
		for (Integer i : userMap.keySet())
		{
			if (userMap.get(i).getUsername().equals(username))
			{
				user = userMap.get(i);
			}
		}
		return user;
	}
}
