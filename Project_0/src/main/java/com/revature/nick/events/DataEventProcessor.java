package com.revature.nick.events;

import java.util.ArrayList;

import com.revature.nick.views.LoginView;

public class DataEventProcessor implements EventProcessor
{
	private ArrayList<Subscriber> dataSubs;
	
	private static DataEventProcessor instance = null;
	
	private DataEventProcessor()
	{
		this.dataSubs = new ArrayList<Subscriber>();
		this.dataSubs.add(new LoginView());
	}
	
	public static DataEventProcessor getInstance()
	{
		if (instance == null)
		{
			instance = new DataEventProcessor();
		}
		return instance;
	}

	@Override
	public void publish(Event event)
	{
		for (Subscriber s : dataSubs)
		{
			s.notify(event);
		}
	}

}
