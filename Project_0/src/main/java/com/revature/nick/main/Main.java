package com.revature.nick.main;

import com.revature.nick.views.ViewController;

public class Main {

	public static void main(String[] args) 
	{
		ViewController controller = ViewController.getInstance();
		controller.start();
	}

}
