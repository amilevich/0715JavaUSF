package com.customerScreen;

import java.io.File;
import java.util.Scanner;

import com.mainmenu.MainScreen;
import com.uncertainty.Admin;
import com.uncertainty.Customer;
import com.uncertainty.Employee;

public class Login {
public boolean custLogin() {
	Scanner scanner = new Scanner(System.in);

	
	System.out.println("Please enter your username.");
	String inputName = scanner.nextLine();
	
	System.out.println("Please enter your password.");
	String inputPass = scanner.nextLine();
	
	for (Customer c : MainScreen.customer) {
		if (c.getUsername().equals(inputName) && c.getPassword().equals(inputPass))
		{
			return true;
		}
		
	}
	return false;
}


public boolean emplyLogin() {
	System.out.println("Please enter your username.");
	Scanner logName = new Scanner(System.in);
	String inputName = logName.nextLine();
	System.out.println("Please enter your password.");
	Scanner logPass = new Scanner(System.in);
	String inputPass = logPass.nextLine();
	
	for (Employee e : MainScreen.employee) {
		if (e.getEmployeeLogin().equals(inputName) && e.getEmployeePassword().equals(inputPass))
		{
			return true;
		}
		
	}
	return false;
}

public boolean adminLogin() {
	System.out.println("Please enter your username.");
	Scanner logName = new Scanner(System.in);
	String inputName = logName.nextLine();
	System.out.println("Please enter your password.");
	Scanner logPass = new Scanner(System.in);
	String inputPass = logPass.nextLine();
	
	for (Admin a : MainScreen.admin) {
		if (a.getAdminLogin().equals(inputName) && a.getAdminPassword().equals(inputPass))
		{
			return true;
		}
		
	}
	return false;
	
}
}
