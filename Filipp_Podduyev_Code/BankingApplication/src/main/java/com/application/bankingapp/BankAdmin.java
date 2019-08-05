package com.application.bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAdmin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7780078698544239148L;
	private String aUserName;
	private String aPassWord;


	public String getAUserName() {
		return aUserName;
	}

	public void setAUserName(String eUserName) {
		this.aUserName = eUserName;
	}

	public String getAPassWord() {
		return aPassWord;
	}

	public void setAPassWord(String ePassWord) {
		this.aPassWord = ePassWord;
	}

	@Override
	public String toString() {
		return "Admin [aUserName=" + aUserName + "]" + " [aPassWord=" + aPassWord + "]";
	}

	public BankAdmin(String aUserName, String aPassWord) {
		super();
		this.aUserName = aUserName;
		this.aPassWord = aPassWord;
	}

	public static boolean logIn(ArrayList<BankAdmin> admin, String aUserName, String aPassword) {
		// Checking the array for the username and password
		for (BankAdmin a : admin) {
			if (a.getAUserName().equals(aUserName) && a.getAPassWord().equals(aPassword)) {
				return true;
			}
		}
		return false;
	}
	
	public static void withdrawAdmin(ArrayList<Customer> customers, String userName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you like to withdraw:");
		// Check for wrong inputs
		if (sc.hasNextDouble()) {
			// Checking if they are trying to withdraw more than Customer have in their accout
			Double withdraw = sc.nextDouble();
			if (withdraw >= 0) {
				if (Customer.getUser(customers, userName).getBalance() >= withdraw) {
					Customer.getUser(customers, userName)
							.setBalance(Customer.getUser(customers, userName).getBalance() - withdraw);
					System.out.println("Withdrew $" + withdraw + " from the account!");
				} else {
					System.out.println("Not enough money in the account");
				}
			} else {
				System.out.println("Negative Amount");
			}
		} else {
			System.out.println("Please input numbers");
		}
	}
	
	public static void depositAdmin(ArrayList<Customer> customers, String userName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you like to deposit:");
		// Check for wrong inputs
		if (sc.hasNextDouble()) {
			Double deposit = sc.nextDouble();
			System.out.println("");
			if (deposit >= 0) {
				Customer.getUser(customers, userName)
						.setBalance(Customer.getUser(customers, userName).getBalance() + deposit);
				System.out.println("Added $" + deposit + " to the account");
			} else {
				System.out.println("Negative Amount!");
			}
		} else {
			System.out.println("Please enter a valid sum to deposit");
		}
	}
	
	public static void transferFundsAdmin(ArrayList<Customer> customers, String userName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the username of the account you would like to transfer money to");
		String toUser = sc.nextLine();
		// If the account exists
		if (Customer.hasUser(customers, toUser)) {
			System.out.println("Enter an amount to send: ");
			// Checking input
			if (sc.hasNextDouble()) {
				Double toSend = sc.nextDouble();
				// Updating amount from both user
				if (Customer.getUser(customers, userName).getBalance() >= toSend) {
					Customer.getUser(customers, userName)
							.setBalance(Customer.getUser(customers, userName).getBalance() - toSend);

					Customer.getUser(customers, toUser)
							.setBalance(Customer.getUser(customers, toUser).getBalance() + toSend);
					System.out.println("Sent $" + toSend + " to " + toUser);
				} else {
					System.out.println("Not enough money in the account");
				}
			} else {
				System.out.println("Invalid amount");
			}
		} else {
			System.out.println("Could not find any user with that Username");
		}
	}
	
	public static void removeAccount(ArrayList<Customer> customers, String userName) {
		System.out.println("Are you sure? Type the username again to confirm:");
		Scanner sc = new Scanner(System.in);
		String removeUser = sc.nextLine();
		
		for(Customer c : customers) {
			if(c.getUserName().equals(removeUser)){
				customers.remove(c);
			} else {
				System.out.println("The customer you've entered doesn't exist");
			}
		}
	}

}
