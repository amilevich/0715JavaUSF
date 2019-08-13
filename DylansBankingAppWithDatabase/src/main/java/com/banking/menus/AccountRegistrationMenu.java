package com.banking.menus;

import java.util.Scanner;




import com.banking.accounts.BankAccount;

import com.banking.dao.AccountAccessDao;
import com.banking.dao.BankDao;
import com.banking.dao.CustomerDao;


public class AccountRegistrationMenu  {
	private static String username;
	private static int customerID;
	static CustomerDao customerDao = new CustomerDao();
	static BankDao bankDao = new BankDao();
	static AccountAccessDao accessDao = new AccountAccessDao();
	
	
	
	
	public AccountRegistrationMenu(String username, int customerID) {
		super();
		this.username = username;
		this.customerID = customerID;
		printMenu();
	}

	

	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome New Cash Money Customer!");
		System.out.println("What kind of Account would you like to make today?");
		System.out.println("\n Choose an Option:");
		System.out.println("\t 1. Checking Account     *Free $20 upon Acceptance*");
		System.out.println("\t 2. Joint Account        (Requires 2 Valid Checking Accounts)");
		System.out.println("\t 0. Back To Main Menu");
		menuSelect(scanner.nextLine());
	}
	
	private static void menuSelect(String selection) {
		switch(selection) {
		case "1":
			checkingRegistrationMenu();
			break;
		case "2":
			jointMenu();
			break;
		case "0":
			MainMenu mainMenu= new MainMenu();
			break;
		default:
			System.out.println("Please Input a number Selection");
			printMenu();
			break;
		}
	}
	
	private static void checkingRegistrationMenu() {  //IS DAO Compliant
		Scanner scanner = new Scanner(System.in);
		System.out.println("Processing...");
		BankAccount account = new BankAccount("checking","pending",20.0); //Create Account
		bankDao.insertBankAccount(account, username);  //insert account into database
		int accountid=bankDao.getAccountId(username);
		accessDao.insertAccountJunction(customerID, accountid); //insert into junction tables
		System.out.println("Your Account is undergoing Approval.\n");
		System.out.println("Rerouting to Customer menu...press Enter");
		scanner.nextLine();
		CustomerMenu menu = new CustomerMenu(username, customerID);
		scanner.close();
	}
	
	
	
	private static void jointMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Fill in the Following Information as accurately as Possible!\n");
		System.out.println("What is your Username of Joint Account member 1:\n");
		String username1 = scanner.nextLine();
		System.out.println("What is the Username of Joint Account member 2 :\n");
		String username2 = scanner.nextLine();
		createJointAccount(username1, username2);
		System.out.println("Your Account is undergoing Aproval.\n");
		System.out.println("Rerouting to main menu...press Enter");
		scanner.hasNextLine();
		MainMenu.printMenu();
	}
	
			
	
	private static void createJointAccount(String username1, String username2) {
		String jointAccess = username1 + username2;
		
		if(username1.equals(((customerDao.selectCustomerByUsername(username1)).getUsername())) & //Validates usernames are in System
			username2.equals(((customerDao.selectCustomerByUsername(username2)).getUsername()))) 
		{
				int customerid1 = (customerDao.selectCustomerByUsername(username1)).getCustomerID(); //Gets Customer ID's from username input
				int customerid2 = (customerDao.selectCustomerByUsername(username2)).getCustomerID();
			
				customerDao.setJointAccess(customerid1, jointAccess); //Sets jointAccess for both customer accounts
				customerDao.setJointAccess(customerid2, jointAccess);
				
				BankAccount jointAccount = new BankAccount("joint","pending",0,jointAccess); //create joint account object
				bankDao.insertJointBankAccount(jointAccount, username1);   //inserts into bank_accounts table with username1 as primary JointHolder
				
				int accountID =bankDao.getJointAccountId(username1, jointAccess); //gets jointaccountI
				
				accessDao.insertAccountJunction(customerid1, accountID, jointAccess); //assigns relationship from both customers to the one JointAccount
				accessDao.insertAccountJunction(customerid2, accountID, jointAccess);
				
		}else {
			System.out.println("One or more Usernames are Invalid...Try Again\n");
			printMenu();
		}
		}
		

	
}
