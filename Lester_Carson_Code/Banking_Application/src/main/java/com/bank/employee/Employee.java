package com.bank.employee;

import java.util.Scanner;

public class Employee {

	public static void EmployeeRun() {
		int input;
		String name, password;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Boolean run = true, what;
		EmployeeDAOImpl use = new EmployeeDAOImpl();
		
		while (run) {
			
			System.out.println("Type out the number of your desired operation");
			System.out.println("1. View Account information");
			System.out.println("2. Approve/Deny an Account");
			System.out.println("3. Exit");
			
			input = sc.nextInt();sc.nextLine();
			
			if (input == 1) {
				System.out.println("Please enter a username for the account you want to view:");
				name = sc.nextLine();
				System.out.println("Please enter the password for the account you want to view:");
				password = sc.nextLine();
				use.View(name, password);
			} else if (input == 2) {
				System.out.println("Please enter a username for the account you want to approve/deny:");
				name = sc.nextLine();
				System.out.println("Please enter the password for the account you want to approve/deny:");
				password = sc.nextLine();
				System.out.println("Now enter true for approved, or false for denied");
				what = sc.nextBoolean();
				use.Approve(name, password, what);
			} else if (input == 3) {
				run = false;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}
}