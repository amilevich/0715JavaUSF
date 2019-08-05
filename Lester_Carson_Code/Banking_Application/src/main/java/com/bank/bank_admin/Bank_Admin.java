package com.bank.bank_admin;

import java.util.Scanner;

public class Bank_Admin {

	public static void Bank_AdminRun() {

		Bank_AdminDAOImpl use = new Bank_AdminDAOImpl();
		String name, password;
		Boolean what, run = true;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while (run) {
		
			System.out.println("Please Pick an Operation");
			System.out.println("1. Approve/Deny Accounts");
			System.out.println("2. Edit Account");
			System.out.println("3. Cancel/Delete Account");
			System.out.println("4. Exit");

			int input = sc.nextInt();sc.nextLine();
			if (input == 1) {
				System.out.println("Please enter a username for the account you want to approve/deny:");
				name = sc.nextLine();
				System.out.println("Please enter the password for the account you want to approve/deny:");
				password = sc.nextLine();
				System.out.println("Now enter true for approved, or false for denied");
				what = sc.nextBoolean();
				use.Approve(name, password, what);
			} else if (input == 2) {
				System.out.println("Please enter a username for your account:");
				name = sc.nextLine();
				System.out.println("Now enter your password: ");
				password = sc.nextLine();
				if(use.Open(name, password)) {
					AccountOpen(use);
				}
			} else if (input == 3) {
				System.out.println("Please enter the username for the account you want to delete");
				name = sc.nextLine();
				System.out.println("Now enter the password for the account you want to delete");
				password = sc.nextLine();
				use.Delete(name, password);
			} else if (input == 4) {
				run = false;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}

	public static void AccountOpen(Bank_AdminDAOImpl use) {

		String name, pass, how;
		Double bal;
		Boolean run = true;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while (run) {
			
			System.out.println("Select an option:");
			System.out.println("1. Withdraw:");
			System.out.println("2. Deposit: ");
			System.out.println("3. Transfer: ");
			System.out.println("4. Exit");

			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("Please enter the amount you wish to withdraw: ");
				bal = sc.nextDouble();
				use.Withdraw(bal);
			} else if (input == 2) {
				System.out.println("Please enter the amount you wish to deposit: ");
				bal = sc.nextDouble();
				use.Deposit(bal);
			} else if (input == 3) {
				System.out.println("Please enter the username of the account you want to transfer money to/from:");
				name = sc.nextLine();
				System.out.println("Please enter the password of the account you want to transfer money to/from:");
				pass = sc.nextLine();
				System.out.println("Now enter the amount of money you wish to transfer");
				bal = sc.nextDouble();sc.nextLine();
				System.out.println("Now enter 'to' or 'from' with regards to how the money is passing between accounts");
				how = sc.nextLine();
				use.Transfer(name, pass, bal, how);
			} else if (input == 4) {
				run = false;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}
}