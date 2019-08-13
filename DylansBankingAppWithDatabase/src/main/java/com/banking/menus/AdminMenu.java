package com.banking.menus;

import java.util.Scanner;


import com.banking.dao.AccountAccessDao;
import com.banking.dao.BankDao;
import com.banking.dao.CustomerDao;

public class AdminMenu {
	static Scanner scanner = new Scanner(System.in);
	
	static CustomerDao customerDao = new CustomerDao();
	static BankDao bankDao = new BankDao();
	static AccountAccessDao accessDao = new AccountAccessDao();
	
	private static String username;
	
	public AdminMenu(String username) {
		this.username = username;
		printMenu();
	}

	
	public static void printMenu() {
		System.out.println("Welcome Back CashMoney Admin " + username +"!\n" );
		System.out.println("What would you like to see?\n");
		System.out.println("\t 1. View Pending Accounts");
		System.out.println("\t 2. View Active Accounts");
		System.out.println("\t 3. Delete an Account");
		System.out.println("\t 4. Edit an Account");
		System.out.println("\t 5. View All Customer Information");
		System.out.println("\t 6. View Denied Accounts");
		System.out.println("\t 0. Back to Main Menu");
		menuSelect(scanner.nextLine());
	}
	
	private static void menuSelect(String selection) { 
		switch(selection) {
		case "1":
			for(Object a : bankDao.selectAllPendingAccounts())
				System.out.println(a);
			System.out.println("Type in an accountID to Approve or Deny It.");
			int customerID = scanner.nextInt();
			ApproveDeny approveMenu = new ApproveDeny(customerID, username);
			break;
		case "2":
			for(Object a : bankDao.selectAllActiveAccounts())
			System.out.println(a);
			scanner.nextLine();
			printMenu();
			break;
		case "3":
			System.out.println("Choose Your Victim...pick an accountID\n");
			System.out.println(bankDao.selectAllActiveAccounts());
			
			bankDao.denyAccount(scanner.nextInt());
			System.out.println("You have swung the Ban Hammer...the Admin has Spoken!");
			printMenu();
			break;
		case "4":
			       //NEEDS DAO IMPLEMENTATION and JOINT account implemented
			System.out.println("\tType in a valid Username to edit that Account:...input 0 to back out. ");
			String customerUsername = scanner.nextLine();
			if(customerUsername.contentEquals("0")) {
			MainMenu mainMenu = new MainMenu();
			}else {
			LogInMenu.checkForValidAccount(customerUsername);
			}
			break;
		case "5":
			for(Object a : customerDao.selectAllCustomers())
				System.out.println(a);
			printMenu();
			break;
		case "6":
			for(Object a : bankDao.selectAllDeniedAccounts())
				System.out.println(a);
				scanner.nextLine();
				printMenu();
				break;
		case "0":
			MainMenu mainMenu = new MainMenu();
			break;
		default:
				System.out.println("Please Input a number selection");
				printMenu();
				break;
		
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
