package com.example.demo.events;

import com.example.demo.database.UserDAO;

import javax.swing.text.ViewFactory;
import java.util.ArrayList;


public class UIEventProcessor implements EventProcessor
{
	private ArrayList<Subscriber> uiSubs;
	
	private static UIEventProcessor instance = null;
	
	private UIEventProcessor()
	{
		this.uiSubs = new ArrayList<Subscriber>();
		if(uiSubs.isEmpty())
		{
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
