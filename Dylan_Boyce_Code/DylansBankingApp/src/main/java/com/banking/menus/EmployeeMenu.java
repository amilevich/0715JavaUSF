package com.banking.menus;

import java.util.Scanner;

import com.banking.dao.AccountAccess;

public class EmployeeMenu  {
	private static String username;
	
	public EmployeeMenu(String username) {
		this.username = username;
		printMenu();
	}

	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome back " + username +"!");
		System.out.println("What would you like to see?\n");
		System.out.println("\t 1. View Pending Accounts");
		System.out.println("\t 2. View Active Accounts");
		System.out.println("\t 0. Back to Main Menu");
		menuSelect(scanner.nextLine());
		
	}
	
	private static void menuSelect(String selection) {
		switch(selection) {
		case "1":
			AccountAccess.printAllAccounts();
			System.out.println("Who's Account would you like to see?");
			getAccountInfo();
			break;
		case "2":
			AccountAccess.printAllActiveAccounts();
			System.out.println("Who's Account would you like to see?");
			getActiveAccountInfo();
			printMenu();
			break;
		case "0":
			MainMenu menu = new MainMenu();
			break;
		default:
				System.out.println("Please Input a number selection");
				printMenu();
				break;
		}
	}

	
	private static Object getAccountInfo() {  //Also calls for the Approve/Deny Function
		Scanner scanner = new Scanner(System.in);
		String client = scanner.nextLine();
		AccountAccess.getAccount(client);
		ApproveDeny.approvalMenu(client);
		return client;
	}
	
	private static Object getActiveAccountInfo() {  
		Scanner scanner = new Scanner(System.in);
		String client = scanner.nextLine();
		AccountAccess.getActiveAccount(client);
		return client;
	}
	
	
	
	

}
