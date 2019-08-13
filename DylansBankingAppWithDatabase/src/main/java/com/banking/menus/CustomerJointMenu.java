package com.banking.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;


import com.banking.dao.AccountAccessDao;
import com.banking.dao.BankDao;
import com.banking.dao.CustomerDao;

public class CustomerJointMenu {
	static Scanner scanner = new Scanner(System.in);
	final static Logger loggy = Logger.getLogger(CustomerJointMenu.class);
	static CustomerDao customerDao = new CustomerDao();
	static BankDao bankDao = new BankDao();
	static AccountAccessDao accessDao = new AccountAccessDao();
	

	private static String username;
	private static String jointAccess;
	private static int accountid;
	private static int customerid;
	public CustomerJointMenu(String username, String jointAccess, int accountid, int customerid) {
		this.username = username;
		this.jointAccess=jointAccess;
		this.accountid=accountid;
		this.customerid=customerid;
		printMenu();
	}

	
	public static void printMenu() {
		System.out.println("Welcome Back " + username +"!\n");
		System.out.println("\t 1. Withdrawl");
		System.out.println("\t 2. Deposit");
		System.out.println("\t 3. Account Balance");
		System.out.println("\t 4. Transfer funds from Checking into Joint");
		System.out.println("\t 5. Transfer funds from Joint into Checking");
		System.out.println("\t 0. Back to Checking Menu");
		menuSelect(scanner.nextLine());
	}

	
	
	private static void menuSelect(String selection) { 
		switch (selection) {
		case "1":
			System.out.println("Please enter amount to withdraw: ");
			double cashOut = scanner.nextDouble();
			validateJointWithdrawl(accountid, cashOut);
				scanner.nextLine();
				printMenu();
			break;
		case "2":
			System.out.println("Please enter amount to Deposit: ");
			double cashIn = scanner.nextDouble();
			if(cashIn >0)
			validDeposit(accountid, cashIn);
			scanner.nextLine();
			loggy.info(username + "Deposited $"+ cashIn + " into Joint account.");
			printMenu();
			break;
		case "3":
			printBalance(accountid);
			printMenu();
			break;
		case "4":
			
			System.out.println("How  much Money would you like to Transfer into your Joint Account?");
			double cashOutT = scanner.nextDouble();
			CustomerMenu.validateCheckingWithdrawl(customerid, cashOutT);
			validDeposit(accountid, cashOutT);
			System.out.println("You moved " + cashOutT + " Dollars from your Checking Account into your Joint Account.");
			scanner.nextLine();
			loggy.info(username + " Transfered " + cashOutT + " from Checking into Joint");
			printMenu();
			break;
			
		case "5":
			System.out.println("How much money would you like to Transfer into Your Checking Account?");
			double cashInT = scanner.nextDouble();
			validateJointWithdrawl(accountid, cashInT);
			CustomerMenu.validDeposit(customerid, cashInT);
			System.out.println("You moved " + cashInT + " Dollars from your Joint Account into your Checking Account.");
			scanner.nextLine();
			loggy.info(username + " Transfered " + cashInT + " from Joint into Checking");
			printMenu();
			break;
		case "0":
			CustomerMenu custMenu = new CustomerMenu(username, customerid);
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
	
	public static void validateJointWithdrawl(int accountid, double cashOut) {  //IS DAO COMPLIANT
		
		double accountBalance = bankDao.getAccountBalance(accountid);
		if(isPositive(cashOut) == false) {
			System.out.println("Please choose a positive amount");
			printMenu();
		}else if(isPositive(cashOut) == true && (accountBalance < cashOut)) {
			System.out.println("You cant withdraw more than what is in your account!");
		}else if(isPositive(cashOut) == true && (accountBalance > cashOut)) {
			double newBalance = (accountBalance - cashOut);
			bankDao.updateAccountBalance(accountid, newBalance);
			loggy.info(username + "with Account ID " + accountid + " Withdrew $"+ cashOut + " from Joint Account");
			System.out.println("You withdrew $" + cashOut + " in CashMoney!...new Account Balance is $" + newBalance );
			
			}
	}
	
	public static void validDeposit(int accountid, double cashIn) { //IS DAO COMPLIANT
		double accountBalance = bankDao.getAccountBalance(accountid);
		if(isPositive(cashIn) == false) {
			System.out.println("Please choose a positive amount");
			printMenu();
		}else if(isPositive(cashIn) == true) {
			double newBalance = (accountBalance + cashIn);
			bankDao.updateAccountBalance(accountid, newBalance);
			loggy.info(username + "with account ID " + accountid + " Deposited $"+ cashIn + " from account");
			System.out.println("You Deopsit $" + cashIn + " in CashMoney!...new Joint Account Balance is $" + newBalance );
			
			}
	}
	
	public static void printBalance (int accountid) {
		System.out.println("You have $" + bankDao.getAccountBalance(accountid) + " inside your Joint Account." );
	}
	

}
