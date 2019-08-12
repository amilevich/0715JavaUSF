package com.bank.main;

import java.util.Scanner;
import com.bank.account.AccountImpl;
import com.bank.user.UserImpl;

public class Customer {
	
	static UserImpl use = new UserImpl();
	static AccountImpl acc = new AccountImpl();

	public static void CustomerRun() {
		
		String name, pass, input, id;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Type out the number of your desired operation");
			System.out.println("1. Create a new User");
			System.out.println("2. Create a new Account");
			System.out.println("3. Open an Account");
			System.out.println("4. Exit");
			
			input = sc.nextLine();
			
			if (input.equals("1")) {
				System.out.println("Please enter a username for your User:");
				name = sc.nextLine();
				System.out.println("Now enter your password for your User: ");
				pass = sc.nextLine();
				use.Create(name, pass);
			} else if (input.equals("2")) {
				System.out.println("Please enter the username that will correspond to your new Account:");
				name = sc.nextLine();
				System.out.println("Now enter your password that will correspond to your new Account:");
				pass = sc.nextLine();
				acc.Create(name, pass);
			} else if (input.equals("3")) {
				System.out.println("Please enter a username for your Account:");
				name = sc.nextLine();
				System.out.println("Now enter your password for your Account: ");
				pass = sc.nextLine();
				System.out.println("Now enter you AccountID for your Account: ");
				id = sc.nextLine();
				if(use.Login(name, pass, 1, Integer.valueOf(id)) && acc.Open(Integer.valueOf(id))) {
					CustomerOpen(acc);
				}
			} else if (input.equals("4")) {
				break;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}
	
	public static void CustomerOpen(AccountImpl acc) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name, bal, input;
		
		while (true) {

			System.out.println("Select an option:");
			System.out.println("1. Withdraw:");
			System.out.println("2. Deposit: ");
			System.out.println("3. Transfer: ");
			System.out.println("4. Add User to Account: ");
			System.out.println("5. Exit");
			
			input = sc.nextLine();
			
			if (input.equals("1")) {
				System.out.println("Please enter the amount you wish to withdraw: ");
				input = sc.nextLine();
				acc.Withdraw(Double.valueOf(input));
			} else if (input.equals("2")) {
				System.out.println("Please enter the amount you wish to deposit: ");
				input = sc.nextLine();
				acc.Deposit(Double.valueOf(input));
			} else if (input.equals("3")) {
				System.out.println("Please enter the AccountID of the account you want to transfer money to");
				name = sc.nextLine();
				System.out.println("Now enter the amount of money you wish to transfer");
				bal = sc.nextLine();
				acc.Transfer(Integer.valueOf(name), Double.valueOf(bal));
			} else if (input.equals("4")) {
				System.out.println("Please enter the username of the person you want to add to your account:");
				name = sc.nextLine();
				acc.AddUsername(name);
			} else if (input.equals("5")) {
				acc.Close();
				break;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}	
}