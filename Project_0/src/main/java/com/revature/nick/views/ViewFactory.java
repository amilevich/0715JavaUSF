package com.revature.nick.views;

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
			System.out.println("Not a valid view");
		}
	}

	@Override
	public void notify(String message)
	{
		this.generateView(message);	
	}
}
