package com.banking.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.accounts.CustomerAccount;
import com.banking.dao.AccountAccess;

public class LogInMenu {
	final static Logger loggy = Logger.getLogger(LogInMenu.class);
	
	static String username;
	static String password;
	
	public LogInMenu() {
		printMenu();
	}
	
	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Who are you?\n");
		System.out.println("\t 1. Customer");
		System.out.println("\t 2. Employee");
		System.out.println("\t 3. Administrator");
		System.out.println("\t 0. Back to main Menu");
		System.out.println();
		menuSelect(scanner.nextLine());
	}

	
	public static String logIn() {
		System.out.println("Please input your Username ");
		Scanner scanner = new Scanner(System.in);
		username = scanner.nextLine();
		System.out.println("Please input your Password: ");
		password = scanner.nextLine();
		return username;
	}
	
	private static void checkForAccount(String username) {
		if(AccountAccess.validKey(username)==false) {
			System.out.println("No Account found for Given Username\n");
			printMenu();
		}else {
			loggy.info(username + " Logged In");
			CustomerMenu menuCustomer = new CustomerMenu(username);
		}
		
	}
	
	private static void menuSelect(String selection) {
		switch(selection) {
		case "1":
			checkForAccount(logIn());
			break;
		case "2":
			EmployeeMenu menuEmployee = new EmployeeMenu(logIn());
			break;
		case "3":
			AdminMenu menuAdmin = new AdminMenu(logIn());
			break;
		case "0":
			MainMenu.printMenu();
			break;
		default:
			System.out.println("Please Input a number Selection");
			printMenu();
			break;
		
		}
	}

}
