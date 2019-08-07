package com.banking.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.dao.AccountAccess;


public class CustomerMenu {
	final static Logger loggy = Logger.getLogger(CustomerMenu.class);

	static Scanner scanner = new Scanner(System.in);
	private static String username;
	public CustomerMenu(String username) {
		this.username = username;
		printMenu();
	}

	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome Back " + username +"!\n");
		System.out.println("\t 1. Withdrawl");
		System.out.println("\t 2. Deposit");
		System.out.println("\t 3. Account Balance");
		System.out.println("\t 4. Access Joint Account");
		System.out.println("\t 0. Back to main Menu");
		menuSelect(scanner.nextLine());
	}

	
	
	private static void menuSelect(String selection) { 
		switch (selection) {
		case "1":
			{Scanner scanner = new Scanner(System.in);
			String client = username;
			System.out.println("Please enter amount to withdraw: ");
			double cashOut = scanner.nextDouble();
			validateWithdrawl(client, cashOut);
				scanner.nextLine();
				printMenu();
			}
			break;
		case "2":
//			Scanner scanner = new Scanner(System.in);
			String client = username;
			System.out.println("Please enter amount to Deposit: ");
			double cashIn = scanner.nextDouble();
			if(cashIn >0)
			AccountAccess.deposit(client, cashIn);
			scanner.nextLine();
			loggy.info(client + "Deposited "+ cashIn + " into account");
			printMenu();
			
			break;
		case "3":
			AccountAccess.printBalance(username);
			loggy.info(username + "Checked current account balance");
			printMenu();
			break;
		case "4":
			System.out.println("Validating Account Connection...");
			scanner.nextLine();
			checkForJointAccount();
			
			break;
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
		loggy.info(client + "Withdrew "+ withdrawAmount + " from account");             /////////*******////Example on how to implement a log/////******//////////
		System.out.println("Here is your CashMoney! A Cool "+ withdrawAmount + " Dollars! ");
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
	
	public static void checkForJointAccount() {
		String jointKey = AccountAccess.validJointKey(username);
		if(AccountAccess.validKey(jointKey)) {
			CustomerJointMenu newMenu = new CustomerJointMenu(username,jointKey);
			loggy.info(username + "Accessed Joint account");
		}
	}
	
	

}
