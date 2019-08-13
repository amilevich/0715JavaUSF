package com.bank.main;

import java.util.Scanner;
import com.bank.account.AccountImpl;

public class Bank_Admin {

	public static void Bank_AdminRun() {

		String input, app;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		AccountImpl acc = new AccountImpl();
		
		while (true) {
		
			System.out.println("Please Pick an Operation");
			System.out.println("1. Approve/Cancel Accounts");
			System.out.println("2. Edit Account");
			System.out.println("3. View Account Information");
			System.out.println("4. Exit");

			input = sc.nextLine();
			if (input.equals("1")) {
				System.out.println("Please enter the accountID for the account you want to approve/cancel:");
				input = sc.nextLine();
				System.out.println("Now enter 0 for cancel, or 1 for approve:");
				app = sc.nextLine();
				acc.Approve_Deny(Integer.valueOf(input), Integer.valueOf(app));
			} else if (input.equals("2")) {
				System.out.println("Please enter an accountID for your account:");
				input = sc.nextLine();
				if(acc.Open(Integer.valueOf(input))) {
					Customer.CustomerOpen(acc);
				}
			} else if (input.equals("3")) {
				System.out.println("Please enter a accountID for the account you want to view:");
				input = sc.nextLine();
				acc.View(Integer.valueOf(input));
			} else if (input.equals("4")) {
				break;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}
}