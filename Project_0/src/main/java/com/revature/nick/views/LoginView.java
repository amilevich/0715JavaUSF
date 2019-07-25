package com.revature.nick.views;

import com.revature.nick.database.CustomerDAO;
import com.revature.nick.database.UserDAO;
import com.revature.nick.events.Event;
import com.revature.nick.events.UIEventProcessor;

public class LoginView implements View
{	
	@Override
	public void show()
	{
		UIEventProcessor processor = UIEventProcessor.getInstance();
		
		p.print("Welcome to Big Bank.");
		
		String message = "back";
		Event event = new Event("ui",message);
		
		processor.publish(event);
	}

	@Override
	public void notify(Event event)
	{
		
	}
}
