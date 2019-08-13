package com.application.bankapp;

import java.util.Scanner;

public class Main {
	static Boolean running = true;
	private static AccountDAOImpl accountDao = new AccountDAOImpl();

	
	public static void customerMenu() {
		Account acc = new Account();
		System.out.println(
				"Your Current Balance is: $" + acc.getBalance());
		System.out.println("Would you like to: ");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Transfer");
		System.out.println("4. Exit");
		
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		switch(userInput) {
		case "1":			
			System.out.println("Enter the Amount to Deposit:");
		while(!sc.hasNextDouble()) {
			System.out.println("Please Enter a Dollar Amount");
			sc.next();
		}
		double deposit = sc.nextDouble();
		if(deposit < 0) {
			System.out.println("Invalid Amount. Please Enter a Dollar Amount to Deposit");
		}else{
			
			double prev = Account.balance;
			double amount = prev + deposit;
			accountDao.updateAccount(amount, Account.userName);
			System.out.println("You have deposited $" + deposit +" dollars.");
			System.out.println("Your balance is now: $" + Account.balance);
			break;
		}
		case "2":
			System.out.println("Enter the Amount to Withdraw:");
			while(!sc.hasNextDouble()) {
				System.out.println("Please Enter a Dollar Amount");
				sc.next();
			}
			double withdraw = sc.nextDouble();
			if(withdraw < 0) {
				System.out.println("Invalid Amount. Please Enter a Dollar Amount to Deposit");
			} else if(Account.balance < withdraw) {
				System.out.println("You do not have enough money on this account");
			}
			else{
				double prev = Account.balance;
				double amount = prev - withdraw;
				accountDao.updateAccount(amount, Account.userName);
				System.out.println("You have taken out $" + withdraw +" dollars.");
				System.out.println("Your balance is now: $" + Account.balance);
				break;
			}
		case "3":
			System.out.println("Enter the account number to transfer money to:");
			int transferId = sc.nextInt();
			System.out.println("Enter the amount to transfer:");
			while(!sc.hasNextDouble()) {
				System.out.println("Please Enter a Dollar Amount");
				sc.nextLine();
			}
			
			double transferAmount = sc.nextDouble();
			double prev = Account.balance;
			if(transferAmount < 0) {
				System.out.println("Invalid Amount. Please enter a Dollar Amount to Transfer");
			}else if(prev < transferAmount) {
				System.out.println("You do not have enough money on this account");
			}else {
				double amount = prev - transferAmount;
				accountDao.updateAccount(amount, Account.userName);
				//AccountDAOImpl.updateAccount(transferAmount, transferId);
				break;
			}
		case "4":
			sc.close();
		}
	}
	
	public static void employeeLogin() {
		System.out.println("Please enter employee Id");
		Scanner sc = new Scanner(System.in);
		String empId = sc.nextLine();
		System.out.println("Please enter your password");
		String empPass = sc.nextLine();
		
		if(empId.equals("e") && empPass.equals("e")) {
			System.out.println("Welcome, Employee");
			System.out.println("Select an option from Below");
			System.out.println("1. View Specific User");
			System.out.println("2. View All Users");
			System.out.println("3. Pending Applications");
			System.out.println("4. Log Out");
			running = false;
			
			String userInput = sc.nextLine();
			switch(userInput) {
			case "1":
				UserDAOImpl userDAOImpl = new UserDAOImpl();
				System.out.println("Select User by Username:");
				String UserName = sc.nextLine();
				userDAOImpl.selectUserByName(UserName);
				running = false;
			case "2":
			UserDAOImpl userDAOImpl1 = new UserDAOImpl();
			userDAOImpl1.selectAllUsers();
			break;

				
			case "3":
				UserDAOImpl userDAOImpl2 = new UserDAOImpl();
				System.out.println(userDAOImpl2.pendingAccountApplication());
				System.out.println("1. Approve ");
				System.out.println("2. Deny ");
				String userIn = sc.nextLine();
				switch(userIn) {
				case"1":
					UserDAOImpl userDao = new UserDAOImpl();
					userDao.updateStatus(User.userName);
				case"2":
					UserDAOImpl userDAOImpl3 = new UserDAOImpl();
					UserDAOImpl.deleteUser(userDAOImpl3);
					System.out.println("No More Accounts in Review.");
					sc.nextLine();
				}
				break;
			case "4":
				running = true;
			}
		}else {
			System.out.println("invalid");
		}
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		User c1 = new User("thomas", "p4ssw0rd", "Tom", "Sawyer", "Approved");
		User c2 = new User("huck99", "pass", "Huckelberry", "Finn", "Approved");
		UserDAOImpl CustomerDAOImpl = new UserDAOImpl();
//		CustomerDAOImpl.createUser(c1);
//		CustomerDAOImpl.createUser(c2);
		
		String option; // menu choice
		
		while (running) {
			System.out.println("Welcome to the Bank of Mississippi!");
			System.out.println("Select an option that best describes you:");
			System.out.println("1. Customer");
			System.out.println("2. Employee");
			System.out.println("3. Exit");
			option = sc.nextLine();
			
			switch (option) {
			// If user chose 1 for Customer
			case "1":
				// Choice Customer
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
					UserDAOImpl userDAOImp = new UserDAOImpl();
					userDAOImp.logIn(userName, passWord);
					customerMenu();
					running = false;
				case "2":
					UserDAOImpl userDAOImpl = new UserDAOImpl();
					System.out.println("Create new Username:");
					String userName1 = sc.nextLine();
					System.out.println("Create new Password:");
					String passWord1 = sc.nextLine();
					System.out.println("Success");
					System.out.println("########Application for a new Bank Account########");
					System.out.println("Please Enter your First Name");
					String firstName1 = sc.nextLine();
					System.out.println("Please Enter your Last Name");
					String lastName1 = sc.nextLine();
					String status = "Pending";
					User u1 = new User(userName1, passWord1, firstName1, lastName1, status);
					userDAOImpl.createUser(u1);
					System.out.println("Thank you. Your Account is Pending Approval");
					sc.nextLine();
				}
			break;
			case "2":
				employeeLogin();
			}
		}
	}

}
