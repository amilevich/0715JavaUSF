package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Mainmenu  {

	
	/**
	 * 
	 */
	//private static final long serialVersionUID = -4245793057771473318L;
	private static final Logger mora = Logger.getLogger(Mainmenu.class);
	void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Create Account");
		System.out.println("2. Create Joint Account");
		System.out.println("3  Login");
		System.out.println("4. Quit");
		System.out.println("5. Employee Access");
		System.out.println("6. Admin Access");
		option = scanner.nextLine();

		do {

			switch (option) {

			case "1":
				System.out.println("Create Account");
				// option = scanner.nextLine();
				System.out.println("\n");
				mora.info(" Account Creation " + "Account Created.");
				break;

			case "2":

				System.out.println("Create Joint Account");
				// option = scanner.nextLine();
				System.out.println("\n");
				mora.info(" JAccount Creation " + "Joint account created.");
				break;

			case "3":

				System.out.println("Login");
				 option = scanner.nextLine();
				System.out.println("\n");
				if(option.equals("Alexander")) {
					LoginAccount loginAccount = new LoginAccount();
					loginAccount.showMenu(store);
				mora.info(" Loggin in " + "Login Access.");
				}else {
					System.out.println("Access Denied");
					Mainmenu mainMenu = new Mainmenu();
					mainMenu.showMenu(store);
				}
				break;

			case "4":

				System.out.println("Quit");
				option = scanner.nextLine();
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				System.out.println("Have a good day");
				mora.info(" Exit application " + "Closing Application.");
				
			case "5":
				System.out.println("Employee Access");
				 option = scanner.nextLine();
				if(option.equals("Employee")) {
				EmployeeMenu employeeMenu = new EmployeeMenu();
				employeeMenu.showMenu(store);
				mora.info(" Employee only  " + "Access for Employee.");
				 }else {
					 Mainmenu mainMenu1 = new Mainmenu();
					 mainMenu1.showMenu(store);
					 System.out.println("Access Denied");}
				break;
				
			case "6":
				System.out.println("Admin Access");
				 option = scanner.nextLine();
				System.out.println("Input Admin");
				if(option.equals("Admin")) {
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.showMenu(store);
				mora.info(" Admin only  " + "Access for Adminisrator.");
				 }else {
					 Mainmenu mainMenu1 = new Mainmenu();
					 mainMenu1.showMenu(store);
					 System.out.println("Access Denied");}
				break;
				
			}

		} while (option != "4");
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);

	}

	
}
