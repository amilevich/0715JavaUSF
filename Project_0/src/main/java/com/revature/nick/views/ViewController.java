package com.revature.nick.views;

import java.util.Stack;

public class ViewController
{
	private static ViewController instance;
	
	private static Stack<View> viewStack;
	
	private ViewController()
	{
		instance = new ViewController();
		viewStack = new Stack<View>();
	}
	
	public static ViewController getInstance()
	{
		if(instance == null)
		{
			new ViewController();
		}
		return instance;
	}
	
	public void start()
	{
		while(true) 
		{
			if (!viewStack.isEmpty())
			{
				if (viewStack.peek() != null)
				{
					viewStack.peek().show();
				}
				else
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
	}
	
	public void getNextView(View view)
	{
		viewStack.push(view);
	}
	
	public void getLastView()
	{
		viewStack.pop();
	}
}
