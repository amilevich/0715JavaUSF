package menus;

import java.util.Scanner;

import beans.Account;
import beans.User;
import dao.AccountDimple;
import dao.Transaction;

public class MainMenu {
	static Scanner sc;
	static String[] optionsArray = { "1. I am a customer", "2. I am an employee", "3. I am an admin", "4. Return to login menu." };
	
	public void firstLoginMenu() {
//		Dummies.addDummies();
		Transaction t = new Transaction();
		t.insertAdmins();
		sc = new Scanner(System.in);
		boolean flag = true;
		System.out.println("Welcome to Stacks of Cache Bank.");
		System.out.println("Please sign up or login.");
		System.out.println("1. Sign up.\n2. Sign in.");
		while (flag) {

			String newUser = sc.nextLine();
			switch (newUser) {
			case "1":
				createNewUser();
				flag = !flag;
				break;
			case "2":
				mainMenu();
				flag = !flag;
				break;
			default:
				firstLoginMenu();
				flag = !flag;
				break;
			}
		}
	}

	public void mainMenu() {
		System.out.println("Main Menu");
		for (String s : optionsArray) {
			System.out.println(s);
		}
		System.out.println("Please select an option to continue");
		String choice = sc.nextLine();
		loginHandler(choice);
	}

	public void loginHandler(String choice) {
		UtilityMenus utilMenu = new UtilityMenus();

		boolean flag = true;
		while (flag) {

			switch (choice) {
			case "1":
//				CustomerMenu.loginMenu();
				CustomerMenu custMenu = new CustomerMenu();
				custMenu.loginMenu();
				flag = !flag;
				break;
			case "2":
//				ApprovedAccounts.employeeLogin();
				EmployeeMenu empMenu = new EmployeeMenu();
				empMenu.loginMenu();
				flag = !flag;
				break;
			case "3":
//				ApprovedAccounts.adminLogin();
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.loginMenu();
				flag = !flag;
				break;
			case "4":
				firstLoginMenu();
			default:
				System.out.println("Select a choice.");
				mainMenu();
				flag = !flag;
				break;
			}
		}
	}

	public Account createNewUser() {
//		AccountDimple adi = new AccountDimple();
		User newUser = null;
		sc = new Scanner(System.in);
		Account newAccount = null;
		System.out.println("Enter a username.");
		String username = sc.nextLine();
		System.out.println("Enter a password.");
		String pw = sc.nextLine();
		System.out.println("Enter a balance");
		Double balance = sc.nextDouble();
		System.out.println("Joint account? 1 for yes, 2 for no.");
		sc = new Scanner(System.in);
		String joint = sc.nextLine();
		switch (joint) {
		case "1":
			System.out.println("Enter a second username");
			String un = sc.nextLine();
			System.out.println("Password for joint holder.");
			String passw = sc.nextLine();
			User secondUser = new User(un, passw);
			Transaction jointT = new Transaction(); // add user to user table
			jointT.createUser(secondUser);
			
			// logic for non-joints.
			newAccount = new Account(null,balance, 0);
			newUser = new User(username, pw);
//			Transaction addJunction = 
			break;
		case "2":
			newAccount = new Account(null,balance, 0);
			newUser = new User(username, pw);
//			addJunction = 
			Transaction t = new Transaction(); // add user to user table
			t.createUser(newUser); // add user to db
			t.createAccount(newAccount); // adds account to DB, where it gets an AID...
			t.insertIntoJunction(newUser.getUsername());
			
			mainMenu();
			break;
		}
		
		Transaction t = new Transaction(); // add user to user table
		t.createUser(newUser);
		t.createAccount(newAccount);
		mainMenu();
		

//		firstLoginMenu();
		return newAccount;
	}
}
