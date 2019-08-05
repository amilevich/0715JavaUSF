package com.userinterface;
import java.util.Scanner;

import com.userinterface.UserInterface;

public class Register {
	
	Register()  {
		
	}
	
	
	static void register(String input) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println(" Please input an account number ");
		input = sc.next();
		//Converts input to an integer
		int result = Integer.parseInt(input);
		UserInterface.tempAccount.setTempAccountNumber(result);
		
		
		//Inputs first name
		System.out.println("Please input First Name");
		input = sc.next();
		UserInterface.tempAccount.setTempFirstName(input);
		
		
		//Inputs last name
		System.out.println("Please input Last Name");
		input = sc.next();
		UserInterface.tempAccount.setTempLastName(input);
		
		
		//Inputs address
		System.out.println("Please input address");
		input = sc.next();
		UserInterface.tempAccount.setTempAddress(input);
		
		//Inputs City
		System.out.println("Please input City");
		input = sc.next();
		UserInterface.tempAccount.setTempCity(input);
		
		//Inputs City
		System.out.println("Please input User Name");
		input = sc.next();
		UserInterface.tempAccount.setTempUser(input);
		

		//Input user
		System.out.println("Please input password");
		input = sc.next();
		UserInterface.tempAccount.setTempUser(input);
		
		System.out.println("\n Please await for administration to approve your account \n");
	}
}
