package com.example.demo.database;

import com.example.demo.data.UserData;
import com.example.demo.events.DataEventProcessor;
import com.example.demo.events.Event;
import com.example.demo.events.Subscriber;

import java.util.ArrayList;


public class UserDAO implements Insert<UserData>, Delete<UserData>, Select<UserData>, Subscriber
{
	private UserTable table = UserTable.getInstance();
	
	DataEventProcessor eventProcessor;

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

	@Override
	public void notify(Event event)
	{
		switch(event.getMessage())
		{
		case "username" :
//			Message<UserData> newMessage = new Message<>("user", ) 
//			this.eventProcessor.publish(event);
			break; 
		}
	}
	
}
