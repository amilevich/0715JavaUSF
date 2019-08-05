package com.application.bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Creating the list of Users
		ArrayList<Customer> customers = new ArrayList<Customer>();

		//Populate the list
		Customer c = new Customer("Huck", "Finn", "user", "pass");
		Customer c2 = new Customer("Tom", "Sawyer", "u", "p");
		customers.add(c);
		customers.add(c2);

		// Creating the list of New Account that are Not Yet Approved
		ArrayList<Customer> newCustomers = new ArrayList<Customer>();

		// Creating the list of Employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		// Populate the List
		Employee e = new Employee("Aunt", "Polly", "e", "e");
		employees.add(e);

		ArrayList<BankAdmin> admin = new ArrayList<>();
		BankAdmin a = new BankAdmin("admin", "admin");
		admin.add(a);

		String option; // menu choice
		Boolean running = true;

		while (running) {
			System.out.println("Welcome!");
			System.out.println("Select an option that best describes you:");
			System.out.println("1. Customer");
			System.out.println("2. Employee");
			System.out.println("3. Exit");
			option = sc.nextLine();

			switch (option) {
			// If user chose 1 for Customer
			case "1":
				// Chose Customer
				System.out.println("What would you like to do?");
				System.out.println("1. Login");
				System.out.println("2. Create a New Account");
				option = sc.nextLine();
				switch (option) {
				case "0":
					running = false;
					break;
				case "1":
					// Chose Login
					System.out.println("Enter your Username:");
					String userName = sc.nextLine();
					System.out.println("Enter your Password:");
					String passWord = sc.nextLine();
					// Checking if the user is in the list
					if (Customer.logIn(customers, userName, passWord)) {
						Boolean logIn = true;
						// Run Until Logged out
						while (logIn) {
							// User logged in

							System.out.println("Logged In as " + Customer.getUser(customers, userName).getFirstName());
							System.out.println(
									"Your Current Balance is: $" + Customer.getUser(customers, userName).getBalance());
							System.out.println("Would you like to: ");
							System.out.println("1. Deposit");
							System.out.println("2. Withdraw");
							System.out.println("3. Transfer");
							System.out.println("4. Exit");
							// Deposit Withdraw and Transfer
							option = sc.nextLine();
							switch (option) {
							case "0":
								running = false;
								logIn = false;
								break;
							case "1":
								// Deposit to Account
								Customer.deposit(customers, userName);
								sc.nextLine();
								break;
							case "2":
								// Withdraw from account
								Customer.withdraw(customers, userName);
								sc.nextLine();
								break;
							case "3":
								// Transfer to another account
								Customer.transferFunds(customers, userName);
								sc.nextLine();
								break;
							case "4":
								// log out
								System.out.println("Goodbye!");
								sc.nextLine();
								logIn = false;
								break;
							default:
								System.out.println("Invalid option!");
								sc.nextLine();
								break;
							}
						}

					} else {
						System.out.println("Username or Password is Incorrect!");
						sc.nextLine();
					}
					break;
				case "2":
					// Chose New Account
					System.out.println("What whould you like to do:");
					System.out.println("1. New Account");
					System.out.println("2. New Joint Account");
					option = sc.nextLine();
					switch (option) {
					case "0":
						running = false;
						break;
					case "1":
						// New Account
						System.out.println("Enter First Name:");
						String firstName = sc.nextLine();
						System.out.println("Enter Last Name:");
						String lastName = sc.nextLine();
						System.out.println("Enter Username:");
						String newUserName = sc.nextLine();
						System.out.println("Enter Password:");
						String newPassWord = sc.nextLine();
						// Check if Username exists
						Boolean userExisits = false;
						for (Customer i : customers) {
							if (i.getUserName().equals(newUserName)) {
								System.out.println("Username taken. Please enter a different username");
								userExisits = true;
								sc.nextLine();
								break;
							}
						}
						if (!userExisits) {
							// Create new User in another list for admin to approve.
							Customer c1 = new Customer(firstName, lastName, newUserName, newPassWord);
							newCustomers.add(c1);
							System.out.println("Account Request Send!");
							sc.nextLine();
							break;
						}
						break;
					case "2":
						// ########## JOINT ACCOUNT######
						System.out.println("Enter the first name of the first account holder:");
						String firstName1 = sc.nextLine();
						System.out.println("Enter the last name of the first account holder:");
						String lastName1 = sc.nextLine();
						System.out.println("Enter the first name of the second account holder:");
						String firstName2 = sc.nextLine();
						System.out.println("Enter the last name of the second account holder:");
						String lastName2 = sc.nextLine();
						System.out.println("Enter Username:");
						String newUserName1 = sc.nextLine();
						System.out.println("Enter Password:");
						String newPassWord1 = sc.nextLine();
						
						// Check if username exists
						Boolean userExisits1 = false;
						for (Customer i : customers) {
							if (i.getUserName().equals(newUserName1)) {
								System.out.println("Username taken. Please enter a different username");
								userExisits = true;
								sc.nextLine();
								break;
							}
						}
						if (!userExisits1) {
							// Create join account for admin to approve
							Customer c1 = new Customer(firstName1, lastName1, firstName2, lastName2, newUserName1, newPassWord1);
							newCustomers.add(c1);
							System.out.println("Account Request Send!");
							sc.nextLine();
							break;
						}
						break;
					default:
						System.out.println("Invalid option!");
						break;
					}
					break;

				case "3":
					running = false;
					break;
				default:
					System.out.println("Invalid option!");
					break;
				}
				break;

			// If user chose 2 for Employee
			case "2":
				System.out.println("Sign In As: ");
				System.out.println("1. Employee");
				System.out.println("2. Admin");
				option = sc.nextLine();

				switch (option) {
				case "0":
					running = false;
					break;
				case "1":
					// login as employee
					System.out.println("Enter Employee Username:");
					String eUserName = sc.nextLine();
					System.out.println("Enter Employee Password:");
					String ePassword = sc.nextLine();

					if (Employee.logIn(employees, eUserName, ePassword)) {
						Boolean logIn = true;

						while (logIn) {
							System.out.println("Select an option from Below");
							System.out.println("1. View Specific User");
							System.out.println("2. View All Users");
							System.out.println("3. Pending Applications");
							System.out.println("4. Log Out");
							option = sc.nextLine();
							// Employee Options
							switch (option) {
							// See User One at a time
							case "0":
								running = false;
								logIn = false;
								break;
							case "1":
								System.out.println("Enter The Username of the Customer");
								String customerName = sc.nextLine();

								// Check id user exists
								if (Customer.hasUser(customers, customerName)) {
									// printing the info to the screen
									Customer.printInfo(customers, customerName);
									sc.nextLine();
								} else {
									// if user is not found
									System.out.println("User not found");
									sc.nextLine();
								}
								break;
							case "2":
								// See All Users
								for (Customer c3 : customers) {
									Customer.printInfo(customers, c3.getUserName());
									System.out.println("");
								}
								sc.nextLine();
								break;
							case "3":
								// Approve Deny Accounts
								for (Customer c4 : newCustomers) {
									System.out.println("Main Account Holder: " + c4.getFirstName() + " " + c4.getLastName());
									System.out.println("Customer Name: " + c4.getFirstName2() + " " + c4.getLastName2());
									System.out.println("Username: " + c4.getUserName());
									System.out.println("Password: " + c4.getPassWord());

									System.out.println("1. Approve");
									System.out.println("2. Deny");
									option = sc.nextLine();
									switch (option) {
									case "1":
										customers.add(c4);
										System.out.println("Approved");
										sc.nextLine();
										break;
									case "2":
										System.out.println("Denied");
										sc.nextLine();
										break;
									default:
										break;
									}
								}
								// Clearing the Waitlist after Review
								newCustomers.removeAll(newCustomers);
								System.out.println("No More Accounts in Review.");
								sc.nextLine();
								break;
							case "4":
								System.out.println("Logging Out...\n");
								sc.nextLine();
								logIn = false;
								break;
							default:
								break;
							}

						}

					} else {
						System.out.println("Invalid username or password");
						sc.nextLine();
					}
					break;
				// Login As An ADMIN
				case "2":
					System.out.println("Enter Your Username:");
					String aUserName = sc.nextLine();
					System.out.println("Enter Your Password:");
					String aPassword = sc.nextLine();

					if (BankAdmin.logIn(admin, aUserName, aPassword)) {
						Boolean logIn = true;

						while (logIn) {
							System.out.println("Select an option:");
							System.out.println("1. View Specific User");
							System.out.println("2. View All Users");
							System.out.println("3. Pending Applications");
							System.out.println("4. Deposit to Account");
							System.out.println("5. Withdraw from Account");
							System.out.println("6. Transfer between Accounts");
							System.out.println("7. Remove Account");
							System.out.println("8. Log Out");
							option = sc.nextLine();
							switch (option) {
							// See users one at a time
							case "0":
								running = false;
								logIn = false;
								break;
							case "1":
								System.out.println("Enter The Username of the Customer");
								String customerName = sc.nextLine();

								// Check id user exists
								if (Customer.hasUser(customers, customerName)) {
									// printing the info to the screen
									Customer.printInfo(customers, customerName);
									sc.nextLine();
								} else {
									// if user is not found
									System.out.println("User not found");
									sc.nextLine();
								}
								break;
							case "2":
								// See All Users
								for (Customer c3 : customers) {
									Customer.printInfo(customers, c3.getUserName());
									System.out.println("");
								}
								sc.nextLine();
								break;
							case "3":
								// Approve Deny Accounts
								for (Customer c4 : newCustomers) {
									System.out.println("Customer Name: " + c4.getFirstName() + " " + c4.getLastName());
									System.out.println("Username: " + c4.getUserName());
									System.out.println("Password: " + c4.getPassWord());

									System.out.println("1. Approve");
									System.out.println("2. Deny");
									option = sc.nextLine();
									switch (option) {
									case "1":
										customers.add(c4);
										System.out.println("Approved");
										sc.nextLine();
										break;
									case "2":
										System.out.println("Denied");
										sc.nextLine();
										break;
									default:
										break;
									}
								}
								// Clearing the application list after review
								newCustomers.removeAll(newCustomers);
								System.out.println("No More Accounts in Review.");
								sc.nextLine();
								break;

							case "4":
								System.out.println("Enter the account username to deposit to:");
								String userNameDeposit = sc.nextLine();
								BankAdmin.depositAdmin(customers, userNameDeposit);
								sc.nextLine();
								break;
							case "5":
								System.out.println("Enter the account username to withdraw from:");
								String userNameWithdraw = sc.nextLine();
								BankAdmin.withdrawAdmin(customers, userNameWithdraw);
								sc.nextLine();
								break;
							case "6":
								System.out.println("Enter the account username to transfer from:");
								String userNameTransfer = sc.nextLine();
								BankAdmin.transferFundsAdmin(customers, userNameTransfer);
								sc.nextLine();
								break;
							case "7":
								System.out.println("Enter the account username to remove:");
								String userNameRemove = sc.nextLine();
								BankAdmin.removeAccount(customers, userNameRemove);
							case "8":
								System.out.println("Logging Out...");
								sc.nextLine();
								logIn = false;
								break;
							default:
								break;
							}

						}

					} else {
						System.out.println("Username or Password is Incorrect!");
						sc.nextLine();
					}
					break;
				default:
					break;
				}
				break;
			// If the option was not 1 or 2
			default:
				System.out.println("Goodbye!");
				sc.nextLine();
				break;
			}
		}

		System.out.println("");
		sc.close();
	}

}