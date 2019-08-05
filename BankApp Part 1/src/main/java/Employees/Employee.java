package Employees;

import java.util.Scanner;

import Accounts.Account;
import Application.Application;
import Customers.Customer;
import Driver.MainDriver;

public class Employee {

	protected Account customerAccount;
	protected Customer myCustomer;
	
	private Scanner keyboard = new Scanner(System.in);

	private String name;

	/**
	 * @param name
	 */
	public Employee(String name) {
		super();
		this.name = name;
	}

	public void start() {
		String response;
		System.out.println("Hello and welcome to the Revature Bank!");
		System.out.println("My name is " + this.name + ". What is your name?");
		System.out.println("Full Name: ");
		String userName = keyboard.nextLine();
		System.out.println("Nice to meet you " + userName + ".");
		System.out.println("Are you a new or returning customer or"
				+ " do you have an open application with the Revature Bank? (new/returning/open)");

		boolean isChecked = false;
		int numTimes = 1;
		while (!isChecked) {
			response = keyboard.nextLine();

			if (response.equalsIgnoreCase("new")) {

				isChecked = true;

				if (!checkIfReturning(userName)) {
					newCustomer(userName);
				} else {
					System.out.println("The system shows that you already hold an account with us.");

					do {
						returningCustomer();
						System.out.println("Is there anything I can help you with today? (yes/no)");
						response = keyboard.nextLine();
					} while (response.equalsIgnoreCase("yes"));

				}
			} else if (response.equalsIgnoreCase("returning")) {

				isChecked = true;

				if (checkIfReturning(userName)) {

					do {
						returningCustomer();
						System.out.println("Do you have anything I can help you with? (yes/no)");
						response = keyboard.nextLine();
					} while (response.equalsIgnoreCase("yes"));

				} else {
					System.out.println(
							"Our system has not found any accounts belonging to your name. Please submit an application for a new account.");
					newCustomer(userName);
				}
			} else if (response.equalsIgnoreCase("open")) {

				Application app = Application.findCustomer(userName);

				if (app != null) {
					initialDeposit(app);
				} else {
					System.out.println("We don't have an application in the system for you.");
					System.out.println("Would you like to start a new application?(yes/no)");
					response = keyboard.nextLine();
					if (response.equalsIgnoreCase("yes")) {
						newCustomer(userName);
					} else {
						stop();
					}
				}
			} else {

				if (numTimes >= 3) {
					System.out.println("I'm sorry I can't understand that and we don't "
							+ "have any translators onboard.");
					stop();
				} else {
					System.out.println("I'm sorry, I don't understand your answer. Please try telling me again.");
				}
				numTimes++;
			}
		}

	}


	public void stop() {
		MainDriver.stop();
	}

	public void newCustomer(String userName) {

		System.out.println("Would you like to open a new account with us"
			+ " or would you like to apply for a joint account with one of our existing customers?");
		System.out.println("(new/joint/exit)");

		String response;
		boolean isChecked = false;
		int numTimes = 1;
		while (!isChecked) {
			response = keyboard.nextLine();

			if (response.equalsIgnoreCase("new")) {
				isChecked = true;
				Application a = new Application();
				a.startApplication();
				analyzeApplication(userName, a);

			} else if (response.equalsIgnoreCase("joint")) {
				isChecked = true;
				System.out.println("Excellent, I will refer you to my manager to get you started.");

				new Admin("Sandra").joint(userName);

			} else if (response.equalsIgnoreCase("exit")) {
				stop();

			} else {
				if (numTimes >= 3) {
					System.out.println("I'm sorry I can't understand that and we don't "
							+ "have any translators onboard.");
					stop();
				} else {
					System.out.println("I'm sorry I don't understand your answer. Please try telling me again.");
				}
				numTimes++;
			}
		}
	}

	public void returningCustomer() {

		if (checkLogin()) {

			System.out.println("How may I help you today?(Deposit/Withdraw/Transfer/Balance/Cancel)");

			String response = keyboard.nextLine();
			if (response.equalsIgnoreCase("deposit")) {
				System.out.println("How much money would you like to deposit?");

				response = keyboard.nextLine();
				double amount = 0.0;
				try {
					if (response.subSequence(0, 1).equals("$")) {
						amount = Double.parseDouble(response.substring(1));
					} else {
						amount = Double.parseDouble(response);
					}
				} catch (Exception e) {
					System.out.println("That's not a number, please try another time."); //stops if the customer's input is incorrect
					stop();
				}

				this.customerAccount.deposit(amount);

			} else if (response.equalsIgnoreCase("withdraw")) {

				System.out.println("How much money would you like to withdraw?");

				response = keyboard.nextLine();
				double amount = 0.0;
				try {
					if (response.subSequence(0, 1).equals("$")) {
						amount = Double.parseDouble(response.substring(1));
					} else {
						amount = Double.parseDouble(response);
					}
				} catch (Exception e) {
					System.out.println("That's not a number, please try another time.");
					stop();
				}

				this.customerAccount.withdraw(amount);

			} else if (response.equalsIgnoreCase("transfer")) {

				System.out.println("How much money would you like to tranfer?");

				response = keyboard.nextLine();
				double amount = 0.0;
				try {
					if (response.subSequence(0, 1).equals("$")) {
						amount = Double.parseDouble(response.substring(1));
					} else {
						amount = Double.parseDouble(response);
					}
				} catch (Exception e) {
					System.out.println("That's not a number, please try another time.");
					stop();
				}

				System.out.println("What is the account ID of the account you are transferring money to?");
				response = keyboard.nextLine();
				Account a = Account.findAccount(response);
				if (a != null)
					this.customerAccount.transfer(amount, a);
				else {
					System.out.println("We could not find an account with that ID.");
				}

			} else if (response.equalsIgnoreCase("balance")) {
				System.out.println("Your balance is $" + checkBalance());

			} else if (response.equalsIgnoreCase("cancel")) {
				System.out.println("We're sorry to let you go. I will refer you to my manager to cancel your account.");
				new Admin("Bob").cancelAccount(this.customerAccount, this.myCustomer);
			} else {
				stop();
			}
		}
	}

	public void analyzeApplication(String userName, Application app) {
		System.out.println("Taking a look at your application.");
		System.out.println("I will let you know if you have been approved or denied momentarily.");
		
		if (!userName.equalsIgnoreCase(app.getName())) {
			deny();
		} else {
			approve(app);
		}
	}

	public void approve(Application app) {

		System.out.println("Thank you for waiting. Your application has been approved.");
		String id = Account.generateAccountID();
		System.out.println("Here is your account ID: " + id);
		app.setAccount_id(id);
		initialDeposit(app);
	}

	public void deny() {
		System.out.println("I'm sorry but your application has been denied.");
		stop();

	}

	public void initialDeposit(Application app) {
		System.out.println("Do you have your initial deposit at this time?(yes/no)");
		String response = keyboard.nextLine();
		
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("How much money would you like to deposit?");
			System.out.println("Reminder: the minimum initial deposit is $50.00");
			System.out.println("Your account will NOT be activated and you will have to finish your application "
					+ "another time if you deposit less than the required minimum amount.");
			
			response = keyboard.nextLine();
			double amount = 0.0;
			try {
				if (response.subSequence(0, 1).equals("$")) { //still accepts the input even if the user starts with $
					amount = Double.parseDouble(response.substring(1));
				} else {
					amount = Double.parseDouble(response);
				}
			} catch (Exception e) {
				System.out.println(
						"Please come back another time and we can finish setting up your account with us.");
				Application.addApplication(app);
				stop();
			}

			if (amount >= 50.0) {
				Customer.addCustomer(new Customer(app));
				Account.addAccount(new Account(app, amount));
			} else {
				System.out.println(
						"Please come back another time and we can finish setting up your account with us.");
				Application.addApplication(app);
				stop();
			}
		} else {
			System.out.println("Please come back another time and we can finish setting up your account with us.");
			Application.addApplication(app);
			stop();
		}
	}

	public boolean checkIfReturning(String name) {
		// if name is in customers list return true
		// also set checkedAccount = Account.findAccount(customer.getAccount_id)
		// else false
		if (Customer.findCustomer(name) == null) {
			return false;
		}

		this.myCustomer = Customer.findCustomer(name);
		this.customerAccount = Account.findAccount(this.myCustomer.getAccount_id());
		return true;

	}

	public boolean checkLogin() {
		System.out.println("What is your username?");
		String username = keyboard.nextLine();
		System.out.println("What is your password?");
		String password = keyboard.nextLine();
		return customerAccount.checkLogin(username, password);

	}

	public double checkBalance() {
		return customerAccount.getBalance();
	}
	
	public String checkCustomerInfo() { //returns the string value for the customer
		return myCustomer.toString();
	}

	// non-static getters & setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the customerAccount
	 */
	public Account getCustomerAccount() {
		return customerAccount;
	}

	/**
	 * @param customerAccount the customerAccount to set
	 */
	public void setCustomerAccount(Account customerAccount) {
		this.customerAccount = customerAccount;
	}

	/**
	 * @return the myCustomer
	 */
	public Customer getMyCustomer() { //gets the current customer that the employee is talking to
		return myCustomer;
	}

	/**
	 * @param myCustomer the myCustomer to set
	 */
	public void setMyCustomer(Customer myCustomer) { //sets the current customer that the employee is talking to
		this.myCustomer = myCustomer;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}
