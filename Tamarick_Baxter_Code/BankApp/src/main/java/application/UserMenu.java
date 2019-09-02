package main.java.application;

import java.util.Scanner;
import main.java.application.Dao.UserDaoImpl;
import main.java.application.Domain.User;
import main.java.application.View.AdminLogin;
import main.java.application.View.EmployeeLogin;
import main.java.application.View.Login;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class UserMenu {

	static Scanner scan = new Scanner(System.in);
	private static final Logger log = Logger.getLogger(UserMenu.class);

	public static void main(String[] args) {
		//PropertyConfigurator.configure("main/java/log4j.properties");
		System.out.println("Welcome.");
		String option = "";
		User user = null;
		String userName="", password1="", password2="";
		UserDaoImpl userDao = new UserDaoImpl();
		
		//display menu until user selects to exit
		while(!option.equals("e")) {
			System.out.println("Please select an option:");
			System.out.println("(c) Create an account.");
			System.out.println("(l) Log in.");
			System.out.println("(e) Exit.");
			option = scan.nextLine().toLowerCase();//accept upper and lower case letters
			switch(option) {
			case "c":
				System.out.println("\nCreate user option selected:");
				
				System.out.println("\nEnter user name: ");
				userName = scan.nextLine();
				//if passwords don't match allow user to try again
				do {
					System.out.println("\nEnter password: ");
					password1 = scan.nextLine();
					
					System.out.println("\nConfirm password: ");
					password2 = scan.nextLine();
					
					if(!password1.equals(password2))
						System.out.println("\nPasswords do not match.");
				}while(!password1.equals(password2));
					
					user = new User(userName, password1, "CUSTOMER");
					if(userDao.saveUser(user) ){
						log.info(userName + " created an account.");
					} else {
						log.error("Could not successfuly create user : " + user.getUserName() );
					}
				break;
				
			case "l":
				// Confirm login
				System.out.println("\nEnter user name: ");
				userName = scan.nextLine();
				
				System.out.println("\nEnter password: ");
				password1 = scan.nextLine();
				
				// Send the confirmed user to the appropriate view menu
				
				user = userDao.confirmLogin(userName, password1);
				
				if(user != null) {
					
					log.info(userName + " Login Successful.");
					
					if(user.getRole().equalsIgnoreCase("Customer")) {
						Login.loginMenu(user);
					} else if(user.getRole().equalsIgnoreCase("Employee")) {
						EmployeeLogin.userAccount(userName);
					} else if(user.getRole().equalsIgnoreCase("Admin")) {
						AdminLogin.adminMenu(user);
					} 					
					
				} else {
					log.error("Could not successfuly authenticate the user : " + userName );
				}
				
				break;
				
			case "e":
				System.out.println("\nGoodbye.\n");
				break;
				
			default:
				System.out.println("Invalid selection.");
				break;
			}
			
			System.out.println();
		}
	}

}