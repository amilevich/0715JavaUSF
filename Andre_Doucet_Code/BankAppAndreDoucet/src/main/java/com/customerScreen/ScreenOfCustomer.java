package com.customerScreen;

import java.util.Scanner;

import com.mainmenu.MainScreen;
import com.uncertainty.Customer;

import dao.CustomerCreate;

public class ScreenOfCustomer {
public void menuBridge() {
	Customer customer = new Customer();
	Scanner in = new Scanner(System.in);
	System.out.println("Enter your id.");
	String id = in.nextLine();
	Scanner in2 = new Scanner(System.in);
	System.out.println("Enter your name.");
	String name = in2.nextLine();
	Scanner in3 = new Scanner(System.in);
	System.out.println("Enter your address.");
	String address = in3.nextLine();
	Scanner in4 = new Scanner(System.in);
	System.out.println("Enter your telephone number.");
	String telephonenumber = in4.nextLine();
	Scanner in5 = new Scanner(System.in);
	System.out.println("Enter your user name.");
	String username = in5.nextLine();
	Scanner in6 = new Scanner(System.in);
	System.out.println("Enter your password.");
	String password = in6.nextLine();
	
	customer.setId(id);
	customer.setName(name);
	customer.setAddress(address);
	customer.setTelephonenumber(telephonenumber);
	customer.setUsername(username);
	customer.setPassword(password);
	
	MainScreen.customer.add(customer);
	CustomerCreate thing = new CustomerCreate();
	thing.addtoDB(customer);
}
}
