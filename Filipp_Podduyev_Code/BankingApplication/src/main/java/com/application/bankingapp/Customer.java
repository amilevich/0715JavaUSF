package com.application.bankingapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String firstName2;
	private String lastName2;
	private String userName;
	private String passWord;

	private Double balance;


	// Constructor using fields
	public Customer(String firstName, String lastName, String userName, String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.setBalance(0.0);

	}
	public Customer(String firstName, String lastName, String firstName2, String lastName2, String userName, String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.firstName2 = firstName2;
		this.lastName = lastName2;
		this.userName = userName;
		this.passWord = passWord;
		this.setBalance(0.0);

	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	// To String Format
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + "]";
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public static Boolean logIn(ArrayList<Customer> customers, String userName, String passWord) {
		// Checking the array for the username and password
		for (Customer c : customers) {
			if (c.getUserName().equals(userName) && c.getPassWord().equals(passWord)) {
				return true;
			}
		}
		return false;
	}

	public static Customer getUser(ArrayList<Customer> customers, String userName) {
		for (Customer c : customers) {
			if (c.getUserName().equals(userName)) {
				return c;
			}
		}
		return null;
	}

	// Checking if the list have the User
	public static boolean hasUser(ArrayList<Customer> customers, String toUser) {
		for (Customer c : customers) {
			if (c.getUserName().equals(toUser)) {
				return true;
			}
		}
		return false;
	}

	// Printing the Customer information for Employee
	public static void printInfo(ArrayList<Customer> customers, String customerName) {
		for (Customer c : customers) {
			if (c.getUserName().equals(customerName)) {
				System.out.println("Name: " + c.getFirstName() + " " + c.getLastName());
				System.out.println("UserName: " + c.getUserName() + "\nPassword: " + c.getPassWord());
				System.out.println("Account Balance: " + c.getBalance());
			}
		}
	}

	// Deposit Money to Account
	public static void deposit(ArrayList<Customer> customers, String userName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you like to deposit:");
		// Check for wrong inputs
		if (sc.hasNextDouble()) {
			Double deposit = sc.nextDouble();
			if (deposit >= 0) {
				Customer.getUser(customers, userName)
						.setBalance(Customer.getUser(customers, userName).getBalance() + deposit);
				System.out.println("Added $" + deposit + " to the Account");
			} else {
				System.out.println("Negative Amount!");
			}
		} else {
			System.out.println("Please enter a valid sum to deposit!");
		}
	}

	// Withdrawing Money from account
	public static void withdraw(ArrayList<Customer> customers, String userName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you like to withdraw:");
		// Check for wrong inputs
		if (sc.hasNextDouble()) {
			// Checking if they are trying to withdraw more than Customer have in their acc
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

	// Transfer Customer fund to another Customer by username
	public static void transferFunds(ArrayList<Customer> customers, String userName) {
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
	public String getFirstName2() {
		return firstName2;
	}
	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}
	public String getLastName2() {
		return lastName2;
	}
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

}