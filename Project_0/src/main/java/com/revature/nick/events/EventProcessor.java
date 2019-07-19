package com.revature.nick.events;

import java.util.ArrayList;

import com.revature.nick.views.ViewFactory;

public class EventProcessor
{
	private static ArrayList<Subscriber> subscribers;
	
	public EventProcessor()
	{
		subscribers = new ArrayList<Subscriber>();
		subscribers.add(new ViewFactory());
	}
	
	public void publish(String message)
	{
		for (Subscriber s : subscribers)
		{
			s.notify(message);
		}
	}
}
