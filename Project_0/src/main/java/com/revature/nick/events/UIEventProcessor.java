package com.revature.nick.events;

import java.util.ArrayList;

import com.revature.nick.database.UserDAO;
import com.revature.nick.views.LoginView;
import com.revature.nick.views.ViewFactory;

public class UIEventProcessor implements EventProcessor
{
	private ArrayList<Subscriber> uiSubs;
	
	private static UIEventProcessor instance = null;
	
	private UIEventProcessor()
	{
		this.uiSubs = new ArrayList<Subscriber>();
		if(uiSubs.isEmpty())
		{
			this.uiSubs.add(new ViewFactory());
			this.uiSubs.add(new UserDAO());
		}
	}
	
	public static UIEventProcessor getInstance()
	{
		if(instance == null)
		{
			instance = new UIEventProcessor();
		}
		return instance;
	}
	
	@Override
	public void publish(Event event)
	{
		for (Subscriber s : uiSubs)
		{
			s.notify(event);
		}
	}
}
