package src.com.john.ui;

import java.util.Scanner;

public class UserInterface
{
	Scanner in;
	CoreStarter core;
	
	public void run()
	{
		in = new Scanner(System.in);
		
		core = new CoreStarter();
		
		Logging.log.info("Program started.");
		
		welcome();
		
		in.close();
	}
	
	public void welcome()
	{
		String line = "";
		
		System.out.println("***WELCOME TO JOHNBANK 2.0***");
		System.out.println("- Type 1 to log in");
		System.out.println("- Type 2 to create a new user");
		System.out.println("- Type exit to close the application");
		
		line = in.nextLine();
		
		Logging.log.info("Showing welcome screen.");
		
		switch(line)
		{
		case "1":
			Logging.log.info("User chose option 1 in welcome screen.");
			logIn();
			break;
		case "2":
			Logging.log.info("User chose option 2 in welcome screen.");
			createUser();
			break;
		case "exit":
			Logging.log.info("User chose exit in welcome screen. Saving resources and exiting application.");
			core.finish();
			System.exit(0);
			return;
		default:
			Logging.log.warn("User chose invalid option \""+line+"\" in welcome screen.");
			System.out.println("Invalid entry. Try again.");
			welcome();
			break;
		}
	}
	
	public void logIn()
	{
		String username, password;
		
		System.out.println("*LOG IN*");
		
		Logging.log.info("Showing log in screen.");
		
		System.out.println("Username: ");
		username = in.nextLine();
		System.out.println("Password: ");
		password = in.nextLine();
		
		Logging.log.info("Attempting to log in with Username: "+username+", Password: "+password);
		
		operateLogIn(username, password);
		
		welcome();
	}
	
	public void operateLogIn(String username, String password)
	{
		int status = core.tryLogin(username, password);
		
		switch(status)
		{
		case -1:
			System.out.println("Incorrect password.");
			Logging.log.warn("Log in unsuccessful. Incorrect username/password combination.");
			logIn();
			break;
		case 0:
			System.out.println("User does not exist.");
			Logging.log.warn("Log in unsuccessful. User does not exist.");
			welcome();
			break;
		case 1:
			Logging.log.info("Log in successful.");
			if(core.isEmployee(username) && !core.isAdmin(username))
				employeeLoggedIn(username);
			else if(core.isAdmin(username))
				adminLoggedIn(username);
			else
				customerLoggedIn(username);
			break;
		}
	}
	
	public void customerLoggedIn(String username)
	{
		System.out.println("*WELCOME: "+username+"*");
		System.out.println("- Type 1 to view accounts");
		System.out.println("- Type 2 to apply for a new account");
		System.out.println("- Type 0 to log out");
		
		Logging.log.info("Customer: "+username+" is logged in.");
		
		String option = in.nextLine();
		
		switch(option) {
		case "0":
			Logging.log.info("User chose option 0. Logging user out.");
			welcome();
			break;
		case "1":
			Logging.log.info("User chose option 1. Showing Accounts screen.");
			viewUsersAccounts(username);
			operateOnAccount(username);
			transferFundsMenu(username);
			customerLoggedIn(username);
			break;
		case "2":
			Logging.log.info("User chose option 2. Showing Account application screen.");
			applyForAccount(username);
			customerLoggedIn(username);
			break;
		default:
			Logging.log.warn("User chose invalid option \""+option+"\". Restarting customer logged in screen.");
			System.out.println("Invalid option choice. Try again.");
			customerLoggedIn(username);
			break;
		}
	}
	
	public void operateOnAccount(String username)
	{
		System.out.println("- Type 1 to deposit to an account");
		System.out.println("- Type 2 to withdraw an account");
		System.out.println("- Type 0 to return to menu");
		
		Logging.log.info("Showing operate on Accounts screen.");
		
		String decision = in.nextLine();
		
		switch(decision)
		{
		case "0":
			Logging.log.info("User chose option 0. Exiting the menu.");
			return;
		case "1":
			Logging.log.info("User chose option 1.");
			depositToAccount(username);
			break;
		case "2":
			Logging.log.info("User chose option 2.");
			withdrawFromAccount(username);
			break;
		default:
			Logging.log.warn("User chose invalid option \""+decision+"\". Restarting operate on Accounts screen.");
			System.out.println("Invalid option choice. Try again.");
			operateOnAccount(username);
			break;
		}
	}
	
	public void depositToAccount(String username)
	{
		Logging.log.info("Showing deposit to Account screen.");
		
		String ID;
		System.out.println("Type in ID of account to deposit to:");
		ID = in.nextLine();
		
		if(!core.isInt(ID)) {
			Logging.log.warn("User input invalid ID \""+ID+"\". Restarting deposit to Account screen.");
			System.out.println("Invalid ID. Try again.");
			depositToAccount(username);
		} else {
			double amount = 0;
			System.out.println("Type amount to deposit:");
			String s_Amount = in.nextLine();
		
			if(core.isDouble(s_Amount)) {
				amount = Double.parseDouble(s_Amount);
			
				if(amount > 0) {
					Logging.log.info("User input to depost $"+amount+" to Account: "+ID+". Attempting deposit.");
					core.depositToAccount(username, ID, amount);
				} else {
					Logging.log.warn("User input invalid deposit amount: $"+amount+". Restarting deposit to Account screen.");
					System.out.println("Invalid deposit amount. Try again");
					depositToAccount(username);
				}
			} else {
				Logging.log.warn("User input invalid number entry \""+s_Amount+"\". Restarting deposit to Account screen.");
				System.out.println("Invalid number entry. Try again.");
				depositToAccount(username);
			}
		}
	}
	
	public void withdrawFromAccount(String username)
	{
		Logging.log.info("Showing withdraw from Account screen.");
		
		String ID;
		System.out.println("Type in ID of account to withdraw from:");
		ID = in.nextLine();
		
		if(!core.isInt(ID)) {
			Logging.log.warn("User input invalid ID \""+ID+"\". Restarting withdraw from account screen.");
			System.out.println("Invalid ID. Try again.");
			withdrawFromAccount(username);
		} else {
			double amount = 0;
			System.out.println("Type amount to withdraw:");
			String s_Amount = in.nextLine();
		
			if(core.isDouble(s_Amount)) {
				amount = Double.parseDouble(s_Amount);
			
				if(amount > 0) {
					Logging.log.info("User input to withdraw $"+amount+" from Account: "+ID+". Attempting withdraw.");
					core.withdrawFromAccount(username, ID, amount);
				} else {
					Logging.log.warn("User input invalid withdraw amount: "+amount+". Restarting withdraw from Account screen.");
					System.out.println("Invalid withdraw amount. Try again");
					withdrawFromAccount(username);
				}
			} else {
				Logging.log.warn("User input invalid number entry \""+s_Amount+"\". Restarting withdraw from Account screen.");
				System.out.println("Invalid number entry. Try again.");
				withdrawFromAccount(username);
			}
		}
	}
	
	public void viewUsersAccounts(String username)
	{
		Logging.log.info("Showing user: "+username+"'s Accounts.");
		System.out.println("View "+username+"'s Accounts");
		core.printAccounts(username);
	}
	
	public void applyForAccount(String username)
	{
		System.out.println("Apply for an Account");
		System.out.println("- Type 1 for a new Checkings Account");
		System.out.println("- Type 2 for a new Savings Account");
		String option = in.nextLine();
		
		Logging.log.info("Showing apply for Account screen.");
		
		switch(option)
		{
		case "1":
			Logging.log.info("User chose option 1.");
			applyWithJointOwnerOption(username, 1);
			break;
		case "2":
			Logging.log.info("User chose option 2.");
			applyWithJointOwnerOption(username, 2);
			break;
		default:
			Logging.log.warn("User chose invalid option \""+option+"\". Restarting apply for Account screen.");
			System.out.println("Invalid option choice. Try again.");
			applyForAccount(username);
			break;
		}
	}
	
	public void applyWithJointOwnerOption(String username, int type)
	{
		System.out.println("Add a joint owner?");
		System.out.println("- Type 1 for yes:");
		System.out.println("- Type 2 for no:");
		String option = in.nextLine();
		
		Logging.log.info("Showing add joint owner option screen.");
		
		switch(option) 
		{
		case "1":
			System.out.println("Enter username of joint owner:");
			String jo = in.nextLine();
			Logging.log.info("User chose option 1. Attempting to apply for Account with joint owner: "+jo);
			boolean completed = operateCreateAccountByType(username, type, jo);
			if(!completed) {
				Logging.log.warn("Application for account failed. Joint owner does not exist.");
				System.out.println("Joint owner user does not exist. Try again.");
				applyWithJointOwnerOption(username, type);
			} else
				Logging.log.info("Account application completed.");
			break;
		case "2":
			Logging.log.info("User chose option 2. No joint owner will be added.");
			operateCreateAccountByType(username, type, "null");
			break;
		default:
			Logging.log.warn("User chose invalid option \""+option+"\". Restarting add joint owner option screen.");
			System.out.println("Invalid Option choice.");
			applyWithJointOwnerOption(username, type);
			break;
		}
	}
	
	public boolean operateCreateAccountByType(String username, int type, String jointOwner)
	{
		return core.addAccount(username, type, jointOwner);
	}
	
	public void employeeLoggedIn(String username)
	{
		System.out.println("*WELCOME EMPLOYEE: "+username+"*");
		System.out.println("- Type 1 to view active users");
		System.out.println("- Type 2 to view account applications");
		System.out.println("- Type 0 to log out");
		
		Logging.log.info("Employee: "+username+" is logged in.");
		
		String option = in.nextLine();
		
		switch(option) {
		case "0":
			Logging.log.info("User chose option 0. Logging user out.");
			welcome();
			break;
		case "1":
			Logging.log.info("User chose option 1. Showing all Users.");
			System.out.println("All Users:");
			printUsers(username);
			employeeLoggedIn(username);
			break;
		case "2":
			Logging.log.info("User chose option 2. Showing all Account applications.");
			System.out.println("All Applications:");
			printAllApplications(username);
			employeeLoggedIn(username);
			break;
		default:
			Logging.log.warn("User chose invalid option \""+option+"\". Restarting employee logged in screen.");
			System.out.println("Invalid option choice. Try again.");
			employeeLoggedIn(username);
			break;
		}
	}
	
	public void printUsers(String username)
	{
		core.printAllUsers();
		
		System.out.println("Type username of user to view accounts: ");
		String user = in.nextLine();
		
		Logging.log.info("User chose to view User: "+user+"'s Accounts.");
		
		core.printAccounts(user);
		
		if(core.isAdmin(username))
		{
			transferFundsMenu(username);
		}
	}
	
	public void transferFundsMenu(String username)
	{
		System.out.println("Would you like to transfer funds between two accounts?");
		System.out.println("- Type 1 for yes");
		System.out.println("- Type 2 for no");
		String decision = in.nextLine();
		
		Logging.log.info("Showing transfer funds menu screen.");
		
		String from, to;
		
		switch(decision)
		{
		case "1":
			Logging.log.info("User chose option 1. Prompting user to enter ID of accounts to transfer between.");
			System.out.println("Type ID of account to transfer from:");
			from = in.nextLine();
			System.out.println("Type ID of account to transfer to:");
			to = in.nextLine();
			
			if(!core.isInt(from) || !core.isInt(to)) {
				Logging.log.warn("User input invalid ID \""+from+" or "+to+"\". Restarting user logged in screen.");
				System.out.println("Invalid ID. Try again.");
				transferFundsMenu(username);
			} else {
				Logging.log.info("User input transfer from Accout ID: "+from+" to Account ID: "+to);
				operateTransferFunds(username, from, to);
			}
			
			break;
		case "2":
			Logging.log.info("User chose option 2. Exiting transfer funds menu screen.");
			return;
		default:
			Logging.log.info("User chose invalid option \""+decision+"\". Restarting transfer funds menu screen.");
			System.out.println("Invalid decision. Try again.");
			transferFundsMenu(username);
			break;
		}
	}
	
	public void operateTransferFunds(String username, String from, String to)
	{
		Logging.log.info("Showing transfer funds screen.");
		
		double amount;
		System.out.println("Enter amount of money to transfer:");
		String s_Amount = in.nextLine();
		
		Logging.log.info("Prompting user to input amount of money to transfer.");
		
		boolean isDouble = core.isDouble(s_Amount);
		
		if(isDouble) {
			amount = Double.parseDouble(s_Amount);
			Logging.log.info("User input transfer amount: $"+amount);
		
			if(amount < 0) {
				Logging.log.warn("Transfer amount: $"+amount+" is invalid. Restarting transfer funds screen.");
				System.out.println("Invalid transfer amount. Try again");
				operateTransferFunds(username, from, to);
			}
			else {
				core.transferFunds(username, from, to, amount);
				Logging.log.info("Attempting to transfer $"+amount+" from Account ID: "+from+" to Account ID: "+to);
			}
		} else {
			Logging.log.warn("User input invalid number \""+s_Amount+"\". Restarting transfer funds screen.");
			System.out.println("Invalid number entry. Try again.");
			operateTransferFunds(username, from, to);
		}
	}
	
	public void printAllApplications(String username)
	{
		Logging.log.info("Printing all open Account applications.");
		
		core.printApplications();
		
		System.out.println("Approve/Deny an account?");
		System.out.println("- Type 1 for yes");
		System.out.println("- Type 2 for no");
		String decision = in.nextLine();
		
		Logging.log.info("Prompting user to chose to approve or deny an account.");
		
		switch(decision)
		{
		case "1":
			Logging.log.info("User chose option 1. Showing approve an Account screen.");
			approveAnAccount(username);
			break;
		case "2":
			Logging.log.info("User chose option 2. Exiting print applications screen.");
			return;
		default:
			Logging.log.warn("User chose option invalid option \""+decision+"\". Restarting print applications screen.");
			System.out.println("Invalid option decision. Try again.");
			printAllApplications(username);
			break;
		}
	}
	
	public void approveAnAccount(String username)
	{
		Logging.log.info("Showing approve an Account screen.");
		Logging.log.info("Prompting user to input Account ID to approve or deny.");
		
		System.out.println("Type in ID of account to approve or deny:");
		String ID = in.nextLine();
		
		Logging.log.info("User input Account ID: "+ID+".");
		
		System.out.println(" - Type 1 to approve account");
		System.out.println(" - Type 2 to deny account");
		String decision = in.nextLine();
		
		switch(decision)
		{
		case "1":
			Logging.log.info("User chose option 1. Approving Account ID: "+ID);
			core.approveAccountByID(ID);
			break;
		case "2":
			Logging.log.info("User chose option 2. Denying Account ID: "+ID);
			core.denyAccountByID(username,ID);
			break;
		default:
			Logging.log.info("User chose invalid option \""+decision+"\". Restarting approve an Account screen.");
			System.out.println("Invalid decision. Try again.");
			approveAnAccount(username);
			break;
		}
	}
	
	public void adminLoggedIn(String username)
	{
		Logging.log.info("Admin: "+username+" is logged in.");
		
		System.out.println("*WELCOME ADMIN: "+username+"*");
		System.out.println("- Type 1 to view active users");
		System.out.println("- Type 2 to view account applications");
		System.out.println("- Type 3 to cancel an account");
		System.out.println("- Type 0 to log out");
		
		Logging.log.info("Prompting user to chose an action to take.");
		
		String option = in.nextLine();
		
		switch(option) {
		case "0":
			Logging.log.info("User chose option 0. Logging user out.");
			welcome();
			break;
		case "1":
			Logging.log.info("User chose option 1. Showing all active users.");
			System.out.println("All Users:");
			printUsers(username);
			operateOnAccount(username);
			adminLoggedIn(username);
			break;
		case "2":
			Logging.log.info("User chose option 2. Showing all Account applications.");
			System.out.println("All Applications:");
			printAllApplications(username);
			adminLoggedIn(username);
			break;
		case "3":
			Logging.log.info("User chose option 3. Showing cancel an account screen.");
			System.out.println("Type in ID of account to cancel:");
			String ID = in.nextLine();
			Logging.log.info("User input Account ID: "+ID+" to cancel.");
			Logging.log.info("Attempting to cancel Account ID: "+ID+".");
			
			if(core.isInt(ID)) {
				core.denyAccountByID(username, ID);
				adminLoggedIn(username);
			} else {
				Logging.log.warn("User input invalid ID \""+ID+"\". Restarting user logged in screen.");
				System.out.println("Invalid ID. Try again.");
				adminLoggedIn(username);
			}
			
			break;
		default:
			Logging.log.warn("User chose invalid option \""+option+"\". Restarting user logged in screen.");
			System.out.println("Invalid option choice. Try again.");
			adminLoggedIn(username);
			break;
		}
	}
	
	public void createUser()
	{
		Logging.log.info("Showing create new user screen.");
		
		String username, password;
		String empl;
		int type = 1;
		
		String adm;
		
		System.out.println("*CREATE A NEW USER*");
		
		System.out.println("Is this an Employee? (type 1 for yes, 2 for no)");
		empl = in.nextLine();
		
		Logging.log.info("Prompting user to input if new user is an employee or not.");
		
		switch(empl)
		{
		case "1":
			Logging.log.info("User chose option 1. Showing create new employee screen.");
			Logging.log.info("Prompting user to input employee authorization code.");
			
			System.out.println("Enter Authorization code:");
			String auth = in.nextLine();
			
			Logging.log.info("User input authorization code: "+auth);
			
			if(auth.equals(core.EMPLOYEE_AUTH)) {
				Logging.log.info("Authorization successful.");
				System.out.println("Authorization successful.");
				type = 2;
			} else {
				Logging.log.warn("Authorization unsuccessful. Restarting create a new user screen.");
				System.out.println("Authorization failed.");
				createUser();
			}
			
			Logging.log.info("Prompting user to input if new user is an Admin or not.");
			
			System.out.println("Is this an Admin? (type 1 for yes, 2 for no)");
			adm = in.nextLine();
			
			if(adm.contentEquals("1")) {
				Logging.log.info("User chose option 1. Showing create new admin screen.");
				Logging.log.info("Prompting user to input admin authorizatin code.");
				
				System.out.println("Enter Admin Authorication code:");
				auth = in.nextLine();
				
				Logging.log.info("User input authorization code: "+auth);
				
				if(auth.equals(core.ADMIN_AUTH)) {
					Logging.log.info("Authorization successful.");
					System.out.println("Authorization successful.");
					type = 3;
				} else {
					Logging.log.warn("Authorization unsuccessful. Restarting create new user screen.");
					System.out.println("Authorization failed.");
					createUser();
				}
			}
			break;
		case "2":
			Logging.log.info("User chose option 2. New user will be a customer.");
			break;
		default:
			Logging.log.warn("User chose invalid option \""+empl+"\". Restarting create new user screen.");
			System.out.println("Invalid option choice. Try again.");
			createUser();
			return;
		}
		
		System.out.println("Username: ");
		username = in.nextLine();
		System.out.println("Password: ");
		password = in.nextLine();
		
		Logging.log.info("Creating new user with username: "+username+", password: "+password+".");
		
		operateCreateUser(username, password, type);
		
		welcome();
	}
	
	public void operateCreateUser(String username, String password, int type)
	{
		boolean added = core.addUser(username, password, type);
		
		if(added) {
			Logging.log.info("New user successfully created.");
			System.out.println("Operation Complete.");
			welcome();
		}
		else {
			Logging.log.warn("New user not created. Username taken.");
			System.out.println("Username taken, try again");
			createUser();
		}
	}
}