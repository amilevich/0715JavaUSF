package com.banking.menus;

import java.util.Scanner;

import com.banking.dao.AccountAccessDao;
import com.banking.dao.BankDao;
import com.banking.dao.CustomerDao;

public class EmployeeMenu  {
	static CustomerDao customerDao = new CustomerDao();
	static BankDao bankDao = new BankDao();
	static AccountAccessDao accessDao = new AccountAccessDao();
	
	static Scanner scanner = new Scanner(System.in);
	
	
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
		System.out.println("\t 3. View All Customer Information");
		System.out.println("\t 4. View Denied Accounts");
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
			for(Object a : customerDao.selectAllCustomers())
				System.out.println(a);
			break;
		case "4":
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
