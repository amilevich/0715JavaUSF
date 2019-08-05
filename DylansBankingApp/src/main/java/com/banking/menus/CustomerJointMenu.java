package com.banking.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.dao.AccountAccess;

public class CustomerJointMenu {
	
	final static Logger loggy = Logger.getLogger(CustomerJointMenu.class);

	private static String username;
	private static String jointAccess;
	public CustomerJointMenu(String username, String jointAccess) {
		this.username = username;
		this.jointAccess=jointAccess;
		printMenu();
	}

	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome Back " + username +"!\n");
		System.out.println("\t 1. Withdrawl");
		System.out.println("\t 2. Deposit");
		System.out.println("\t 3. Account Balance");
		System.out.println("\t 4. Transfer funds into Joint");
		System.out.println("\t 5. Transfer funds from Joint");
		System.out.println("\t 0. Back to main Menu");
		menuSelect(scanner.nextLine());
	}

	
	
	private static void menuSelect(String selection) { 
		switch (selection) {
		case "1":
			{Scanner scanner = new Scanner(System.in);
			String client = jointAccess;
			System.out.println("Please enter amount to withdraw: ");
			double cashOut = scanner.nextDouble();
			validateWithdrawl(client, cashOut);
				scanner.nextLine();
				printMenu();
			}
			break;
		case "2":
			{Scanner scanner = new Scanner(System.in);
			String client = jointAccess;
			System.out.println("Please enter amount to Deposit: ");
			double cashIn = scanner.nextDouble();
			if(cashIn >0)
			AccountAccess.deposit(client, cashIn);
			scanner.nextLine();
			loggy.info(client + "Deposited "+ cashIn + " into account");
			printMenu();
			}
			break;
		case "3":
			AccountAccess.printJointBalance(jointAccess);
			printMenu();
			break;
		case "4":
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("How  much Money would you like to Transfer into your Joint Account?");
			double cashOut = scanner.nextDouble();
			validateWithdrawl(username, cashOut);
			AccountAccess.jointDeposit(jointAccess, cashOut);
			System.out.println("You moved " + cashOut + " Dollars from your Checking Account into your Joint Account.");
			scanner.nextLine();
			loggy.info(username + " Transfered " + cashOut + " from Checking into Joint");
			printMenu();
			break;
		}
		case "5":
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("How much money would you like to Transfer into Your Checking Account?");
			double cashIn = scanner.nextDouble();
			validateWithdrawl(jointAccess, cashIn);
			AccountAccess.deposit(username, cashIn);
			System.out.println("You moved " + cashIn + " Dollars from your Joint Account into your Checking Account.");
			scanner.nextLine();
			loggy.info(username + " Transfered " + cashIn + " from Joint into Checking");
			printMenu();
			break;
		}
		case "0":
			MainMenu menu = new MainMenu();
			break;
		default:
			System.out.println("Please Input a number Selection");
			printMenu();
			break;

		
		}
	}
	
	
	private static void withdraw(String client, double withdrawAmount) {
		AccountAccess.withdraw(client, withdrawAmount);
		loggy.info(client + "Withdrew "+ withdrawAmount + " from account");
		System.out.println( withdrawAmount + " Dollars removed from Checking ");
	}
	
	public static boolean isPositive(double number) {
		if( number <= 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static void validateWithdrawl(String client, double cashOut) {
		if(isPositive(cashOut) == false) {
			System.out.println("Please choose a positive amount");
			printMenu();
		}else if(isPositive(cashOut) == true && (AccountAccess.getBalance(client) < cashOut)) {
			System.out.println("You cant withdraw more than what is in your account!");
		}else if(isPositive(cashOut) == true && (AccountAccess.getBalance(client) > cashOut)) {
			withdraw(client, cashOut);
			}
	}
	
	
	

}
