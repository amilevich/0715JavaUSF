package com.revature.nick.views;

import java.util.Scanner;

import com.revature.nick.utility.Printer;

public interface View
{
	Printer p = new Printer();
	
	Scanner scanner = new Scanner(System.in);
	
	void show();
}
