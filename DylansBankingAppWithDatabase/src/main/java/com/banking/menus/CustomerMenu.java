package com.banking.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;


import com.banking.dao.AccountAccessDao;
import com.banking.dao.BankDao;
import com.banking.dao.CustomerDao;


public class CustomerMenu {
	static CustomerDao customerDao = new CustomerDao();
	static BankDao bankDao = new BankDao();
	static AccountAccessDao accessDao = new AccountAccessDao();
	final static Logger loggy = Logger.getLogger(CustomerMenu.class);

	static Scanner scanner = new Scanner(System.in);
	
	private static String username;
	private static int customerid;
	
	public CustomerMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerMenu(String username, int customerid) {
		this.username = username;
		this.customerid=customerid;
		printMenu();
		
	}

	
	public static void printMenu() {
		//Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome Back " + username +"!\n");
		System.out.println("\t 1. Withdrawl");
		System.out.println("\t 2. Deposit");
		System.out.println("\t 3. Account Balance");
		System.out.println("\t 4. Access Joint Account");
		System.out.println("\t 5. Register for a New Account!");
		System.out.println("\t 0. Back to main Menu");
		menuSelect(scanner.nextLine());
	}

	
	
	private static void menuSelect(String selection) { 
		switch (selection) {
		case "1":
			if(bankDao.getAccountStatus(username) == null || bankDao.getAccountStatus(username).equals("pending")) {
				System.out.println("You Do NOT have an active Checking Account");
				printMenu();
			}else {
			System.out.println("Please enter amount to withdraw: ");
			double cashOut = scanner.nextDouble();
			validateCheckingWithdrawl(customerid, cashOut);
				scanner.nextLine();
				printMenu();
			break;
			}
		case "2":
			if(bankDao.getAccountStatus(username) == null || bankDao.getAccountStatus(username).equals("pending")) {
				System.out.println("You Do NOT have an active Checking Account");
				printMenu();
			}else {
			System.out.println("Please enter amount to Deposit: ");
			double cashIn = scanner.nextDouble();
			if(cashIn >0)
			validDeposit(customerid, cashIn);
			scanner.nextLine();
			loggy.info(username + "Deposited $"+ cashIn + " into Checking Account.");
			printMenu();
			break;
			}
		case "3":
			if(bankDao.getAccountStatus(username) == null || bankDao.getAccountStatus(username).equals("pending")) {
				System.out.println("You Do NOT have an active Checking Account");
				printMenu();
			}else {
			printBalance(customerid);
			loggy.info(username + "Checked current account balance");
			printMenu();
			break;
			}
		case "4":
			System.out.println("Validating Account Connection...");
			if(bankDao.getJointAccess(username) == null) {
				System.out.println("No joint account found...Rerouting...Press Enter");
				scanner.nextLine();
				printMenu();
			}else {
				String jointAccess = accessDao.getJointAccess(customerid);
				int accountid = accessDao.getJointAccountID(customerid,jointAccess);
				CustomerJointMenu jointMenu = new CustomerJointMenu(username,jointAccess,accountid,customerid);
			}
//			if(checkForJointAccount(customerid)) {
//				String jointAccess = accessDao.getJointAccess(customerid);
//				int accountid = accessDao.getJointAccountID(customerid,jointAccess);
//				CustomerJointMenu jointMenu = new CustomerJointMenu(username,jointAccess,accountid,customerid);
//			}else {
//				System.out.println("No joint account found");
//				printMenu();
//			}
			break;
		case "5":
			AccountRegistrationMenu registrationMenu= new AccountRegistrationMenu(username, customerid);
			break;
		case "0":
			MainMenu mainMenu = new MainMenu();
			break;
		default:
			System.out.println("Please Input a number Selection");
			printMenu();
			break;
		}
	}
	
	public static boolean isPositive(double number) {
		if( number <= 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean inRangeOfBalance (int customerid, double cashOut) {
		int accountID = accessDao.getAccountID(customerid);
		double accountBalance = bankDao.getAccountBalance(accountID);
		if(accountBalance < cashOut) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static void validateCheckingWithdrawl(int customerid, double cashOut) {  //IS DAO COMPLIANT
		int accountID = accessDao.getAccountID(customerid);
		double accountBalance = bankDao.getAccountBalance(accountID);
		if(isPositive(cashOut) == false) {
			System.out.println("Please choose a positive amount");
			printMenu();
		}else if(isPositive(cashOut) == true && (accountBalance < cashOut)) {
			System.out.println("You cant withdraw more than what is in your Checking Account!");
		}else if(isPositive(cashOut) == true && (accountBalance > cashOut)) {
			double newBalance = (accountBalance - cashOut);
			bankDao.updateAccountBalance(accountID, newBalance);
			loggy.info(username + "with ID " + customerid + " Withdrew $"+ cashOut + " from Checking Account");
			System.out.println("You withdrew $" + cashOut + " in CashMoney!...new Account Balance is $" + newBalance );
			
			}
	}
	
	public static void validDeposit(int customerid, double cashIn) { //IS DAO COMPLIANT
		int accountID = (accessDao.getAccountID(customerid));
		double accountBalance = bankDao.getAccountBalance(accountID);
		if(isPositive(cashIn) == false) {
			System.out.println("Please choose a positive amount");
			printMenu();
		}else if(isPositive(cashIn) == true) {
			double newBalance = (accountBalance + cashIn);
			bankDao.updateAccountBalance(accountID, newBalance);
			loggy.info(username + "with ID " + customerid + " Deposited $"+ cashIn + " into Checking Account");
			System.out.println("You Deopsit $" + cashIn + " in CashMoney!...new Checking Account Balance is $" + newBalance );
			
			}
	}
	
	public static void printBalance (int customerid) {
		int accountID = accessDao.getAccountID(customerid);
		System.out.println("You have $" + bankDao.getAccountBalance(accountID) + " inside your Checking Account.");
	}
	
	
	public static boolean checkForJointAccount(int customerid) {
		String jointAccess = accessDao.getJointAccess(customerid);
		if(jointAccess!=null) {
			loggy.info(username + "Accessed Joint account");
			return true;
		}else {
			return false;
		}
		
		
			
		}
	
	
	

}
