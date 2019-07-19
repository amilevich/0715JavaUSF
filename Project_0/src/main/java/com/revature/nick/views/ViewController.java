package com.revature.nick.views;

import java.util.Stack;

public class ViewController
{
	private static ViewController instance = null;
	
	private static Stack<View> viewStack;
	
	private ViewController()
	{
		viewStack = new Stack<View>();
		View loginView = new LoginView();
		viewStack.push(loginView);
	}
	
	public static ViewController getInstance()
	{
		if(instance == null)
		{
			instance = new ViewController();
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
	
	public static void getNextView(View view)
	{
		viewStack.push(view);
	}
	
	public static void getLastView()
	{
		viewStack.pop();
	}
}
