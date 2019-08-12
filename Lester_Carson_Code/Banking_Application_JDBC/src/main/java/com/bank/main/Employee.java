package com.bank.main;

import java.util.Scanner;
import com.bank.account.AccountImpl;

public class Employee {

	public static void EmployeeRun() {

		String input;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		AccountImpl acc = new AccountImpl();
		
		while (true) {
			
			System.out.println("Type out the number of your desired operation");
			System.out.println("1. View Account information");
			System.out.println("2. Approve an Account");
			System.out.println("3. Exit");
			
			input = sc.nextLine();
			
			if (input.equals("1")) {
				System.out.println("Please enter a accountID for the account you want to view:");
				input = sc.nextLine();
				acc.View(Integer.valueOf(input));
			} else if (input.equals("2")) {
				System.out.println("Please enter a accountID for the account you want to approve:");
				input = sc.nextLine();
				acc.Approve_Deny(Integer.valueOf(input), 1);
			} else if (input.equals("3")) {
				break;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}	
}