package com.banking.menus;

import java.util.Scanner;

import com.banking.dao.AccountAccess;

public class AdminMenu {
	private static String username;
	
	public AdminMenu(String username) {
		this.username = username;
		printMenu();
	}

	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome Back CashMoney Admin " + username +"!\n" );
		System.out.println("What would you like to see?\n");
		System.out.println("\t 1. View Pending Accounts");
		System.out.println("\t 2. View Active Accounts");
		System.out.println("\t 3. Delete an Account");
		System.out.println("\t 4. Edit an Account");
		System.out.println("\t 0. Back to Main Menu");
		menuSelect(scanner.nextLine());
	}
	
	private static void menuSelect(String selection) { 
		switch(selection) {
		case "1":
			AccountAccess.adminPrintAllAccounts();
			System.out.println("Who's Account would you like to see?");
			getAccountInfo();
			break;
		case "2":
			AccountAccess.adminPrintAllActiveAccounts();
			getActiveAccountInfo();
			printMenu();
			break;
		case "3":
			System.out.println("Choose Your Victim\n");
			AccountAccess.adminPrintAllActiveAccounts();
			Scanner scanner = new Scanner(System.in);
			deleteAccount(scanner.nextLine());
			printMenu();
			break;
		case "4":
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("\tType in a valid Username to edit that Account: ");
			String username = scanner2.nextLine();
			if(username.equals(AccountAccess.validJointKey(username))){                        
				CustomerJointMenu newMenu = new CustomerJointMenu(AccountAccess.validUserKey(username),AccountAccess.validJointKey(username));
			}else {                                                
			checkForAccount(username);
			}
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
		AdminAproveDeny.adminApprovalMenu(client);
		return client;
	}
	
	private static Object getActiveAccountInfo() {  
		Scanner scanner = new Scanner(System.in);
		String client = scanner.nextLine();
		AccountAccess.getActiveAccount(client);
		return client;
	}
	
	private static void deleteAccount(String client) {
		AccountAccess.deleteAccount(client);
		System.out.println("You have swung the Ban Hammer...the Admin has Spoken!");
	}
	
	private static void checkForAccount(String username) {
		if(AccountAccess.validKey(username)==false) {
			System.out.println("No Account found for Given Username\n");
			printMenu();
		}else {
			CustomerMenu menuCustomer = new CustomerMenu(username);
		}
}
	
	public static void checkForJointAccount() {
		String jointKey = AccountAccess.validJointKey(username);
		if(AccountAccess.validKey(jointKey)) {
			CustomerJointMenu newMenu = new CustomerJointMenu(username,jointKey);
		}else {
			
		}
	}
	
	
}
