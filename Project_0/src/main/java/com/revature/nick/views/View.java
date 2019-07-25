package com.revature.nick.views;

import java.util.Scanner;

import com.revature.nick.events.Subscriber;
import com.revature.nick.utility.Printer;

public interface View extends Subscriber
{
	Printer p = new Printer();
	
	Scanner scanner = new Scanner(System.in);
	
	void show();
}
