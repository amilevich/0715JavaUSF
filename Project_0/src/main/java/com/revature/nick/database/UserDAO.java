package com.revature.nick.database;

import java.util.ArrayList;

import com.revature.nick.data.UserData;
import com.revature.nick.events.DataEventProcessor;
import com.revature.nick.events.Event;
import com.revature.nick.events.Subscriber;

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
