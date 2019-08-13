package com.bank.main;

import com.bank.user.UserImpl;
import java.util.Scanner;

public class Console {
	
	public static void Run() {
		
		String name, password, input;
		Scanner sc = new Scanner(System.in);
		UserImpl use = new UserImpl();
		
		while (true) {
			
			System.out.println("Welcome to Barton's Banking App!");
			System.out.println("Please type in the number that best corresponds to you:");
			System.out.println("1. Customer");
			System.out.println("2. Employee");
			System.out.println("3. Bank Adminstrator");
			System.out.println("4. Exit");
			
			input = sc.nextLine();
			
			if (input.equals("1")) {
				Customer.CustomerRun();
			} else if (input.equals("2")) {
				System.out.println("Please enter a username for your account:");
				name = sc.nextLine();
				System.out.println("Now enter your password: ");
				password = sc.nextLine();
				if(use.Login(name, password, 2, 0)) {
					Employee.EmployeeRun();
				}
			} else if (input.equals("3")) {
				System.out.println("Please enter a username for your account:");
				name = sc.nextLine();
				System.out.println("Now enter your password: ");
				password = sc.nextLine();
				if(use.Login(name, password, 3, 0)) {
					Bank_Admin.Bank_AdminRun();
				}
			} else if (input.equals("4")) {
				System.out.println("Exiting...");
				break;
			} else {
				System.out.println("Error..., Please enter the number that bests corresponds to you.");
			}
		}
		sc.close();
	}
}