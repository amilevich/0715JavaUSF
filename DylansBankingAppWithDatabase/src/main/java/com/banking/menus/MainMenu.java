package com.banking.menus;

import java.util.Scanner;

import com.banking.accounts.CustomerAccount;
import com.banking.dao.CustomerDao;

public class MainMenu {
	
	public MainMenu() {
		printMenu();
	}

	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Cash Money Banking!\n");
		System.out.println("Please Choose an Option:\n" );
		System.out.println("\t 1. Login to Account");
		//System.out.println("\t 2. Register for CashMoney Banking");
		System.out.println("\t 2. Create Customer Account");
		menuSelect(scanner.nextLine());
	}
	
	private static void menuSelect(String option) {
		switch(option) {
		case "1":
			LogInMenu.logIn();
			break;
		case "3":
			AccountRegistrationMenu.printMenu();
		break;
		case "2":
			createCustomerAccount();
			break;
		default:
			System.out.println("Please Input a number Selection");
			printMenu();
			break;
				
		}
	}
	
	
	private static void createCustomerAccount() {  //Takes in all required constructor information
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Fill in the Following Information\n");
		System.out.println("What is your First Name:\n");
		String firstName = scanner.nextLine();
		System.out.println("What is your Last Name:\n");
		String lastName = scanner.nextLine();
		System.out.println("How old are you:\n");
		int age = scanner.nextInt();
		System.out.println("What is your PhoneNumber:\n ");
		long phoneNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Choose a Username:\n");
		String username = scanner.nextLine();
		System.out.println("Choose a Password:");
		String password = scanner.nextLine();
		createAccount(firstName,lastName, phoneNumber, age, username, password);
		System.out.println("Welcome NEW CASHMONEY Customer!\n");
		System.out.println("Rerouting to main menu...press Enter");
		scanner.hasNextLine();
		MainMenu.printMenu();
		scanner.close();
	}
	
	//updated to DAO
		private static void createAccount(String firstName,String lastName, long phoneNumber, int age, String username, String password) {
			CustomerAccount customerAccount = new CustomerAccount(firstName,lastName,phoneNumber, age, username, password);
			CustomerDao customerDao = new CustomerDao();
			customerDao.insertCustomerAccount(customerAccount);
		}
	
	
}
