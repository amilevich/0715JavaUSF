package com.example.demo.database;

import com.example.demo.data.UserData;

import java.util.ArrayList;


public class UserDAO implements Insert<UserData>, Delete<UserData>, Select<UserData>
{
	private UserTable table = UserTable.getInstance();

	@Override
	public UserData selectOne(int id)
	{
		return table.getUser(id);
	}

	@Override
	public ArrayList<UserData> selectAll()
	{
		return table.getAllUsers();
	}

	@Override
	public void delete(int id)
	{
		table.deleteUser(id);
	}

	@Override
	public void insert(UserData obj)
	{
		table.insertUser(obj);
	}

	public UserData selectByUsername(String username)
	{
		return table.getUserByUsername(username);
	}
}
