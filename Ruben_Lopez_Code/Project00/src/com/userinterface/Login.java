package com.userinterface;
import java.io.IOException;

import java.util.Scanner;
import com.lopez.drive1.*;
import com.staff.Admin;
import com.staff.Employee;
import com.userinterface.UserInterface;


public class Login {
	
	
	
	Login(){
		
	}
	static public void login(String input) throws IOException {
		String input1 = " ";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//Keeps account open if its login is valid
		boolean flag = true;
		
		//Keeps track of the login User name
		String tracker ="";
		
		//A flag to determine if the account is Employee, Customer, or Administration.

		
		while (!(input.equals("Logout"))) {
			
				
			if ( flag ) {
			//Input a UserName and password
				while ( !(UserInterface.userNameIsTrue(input) ) && !(UserInterface.passwordIsTrue(input) ) ) {
					System.out.println("Please input User Name");
					input = sc.next();
					tracker = input;
					System.out.println("Please input password");
					input1 = sc.next();
				}
			}
			//Marking in that the login was a success 
			flag = false;
			
		
			
			//Input a Password
			
			
			System.out.println("You are log in!");
			System.out.println(	"\n What would you like to do? " +
								"\n Logout?" +
								"\n Customer Login Menu		CLM");
			if (UserInterface.getObjectTypeByUserName(tracker) instanceof Employee) {
				System.out.println("\n Employee login menu		EL");
			}
			if (UserInterface.getObjectTypeByUserName(tracker) instanceof Admin) {
				System.out.println("\n Admin login menu		ADMIN");
			}
			input = sc.next();
			if ("EL".equals(input) && (UserInterface.getObjectTypeByUserName(tracker) instanceof Employee)) {
				
				Employee.empolyeeMenu();
				
				
			} else if ("Logout".equals(input)) {
				input = "Logout";
			} else if ("CLM".equals(input)) {
				Customer.customerMenu(tracker);
			} else if ("ADMIN".equals(input) && (UserInterface.getObjectTypeByUserName(tracker) instanceof Admin)){
				Admin.admin();
			}
			
		}
		
	}
}
