package com.revature.nick.views;

import com.revature.nick.events.Event;
import com.revature.nick.events.Subscriber;

public class ViewFactory implements Subscriber
{	
	public void generateView(String type)
	{
		switch(type)
		{
		case "login" : 
			View loginView = new LoginView();
			ViewController.getNextView(loginView);
			break;
			
		case "back" :
			ViewController.getLastView();
			break;
			
		default: 
			break;
		}
	}

	@Override
	public void notify(Event event)
	{
		this.generateView(event.getMessage());	
	}
}
