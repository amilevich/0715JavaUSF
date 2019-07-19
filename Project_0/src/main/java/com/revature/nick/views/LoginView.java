package com.revature.nick.views;

import com.revature.nick.events.Event;
import com.revature.nick.events.EventProcessor;

public class LoginView implements View
{	
	EventProcessor processor = new EventProcessor();
	
	@Override
	public void show()
	{
		p.print("Welcome to Big Bank.");
		
		processor.publish("back");
	}
}
