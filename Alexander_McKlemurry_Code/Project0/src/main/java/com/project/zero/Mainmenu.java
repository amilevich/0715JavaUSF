package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Mainmenu implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4245793057771473318L;
	private static final Logger mora = Logger.getLogger(Mainmenu.class);
	void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Create Account");
		System.out.println("2. Create Joint Account");
		System.out.println("3  Login");
		System.out.println("4. Quit");
		System.out.println("6. Employee Access");
		System.out.println("7. Admin Access");
		option = scanner.nextLine();

		do {

			switch (option) {

			case "1":
				System.out.println("Create Account");
				// option = scanner.nextLine();
				System.out.println("\n");
				LoginAccount loginAccount = new LoginAccount();
				loginAccount.showMenu(store);
				mora.info(" Account Creation " + "Account Created.");
				break;

			case "2":

				System.out.println("Create Joint Account");
				// option = scanner.nextLine();
				System.out.println("\n");
				LoginAccount loginAccount2 = new LoginAccount();
				loginAccount2.showMenu(store);
				mora.info(" JAccount Creation " + "Joint account created.");
				break;

			case "3":

				System.out.println("Login");
				// option = scanner.nextLine();
				System.out.println("\n");
				LoginAccount loginAccount3 = new LoginAccount();
				loginAccount3.showMenu(store);
				if(option.equals("Alexander")||option.equals("Elizabeth")) {
				mora.info(" Loggin in " + "Login Access.");
				}else {
					System.out.println("Access Granted");
				}
				break;

			case "4":

				System.out.println("Quit");
				option = scanner.nextLine();
				System.out.println("Have a good day");
				mora.info(" Exit application " + "Closing Application.");
				
			case "5":
				System.out.println("Employee Access");
				 option = scanner.nextLine();
				System.out.println("Input Employee");
				if(option.equals("Employee")) {
				EmployeeMenu employeeMenu = new EmployeeMenu();
				employeeMenu.showMenu(store);
				mora.info(" Employee only  " + "Access for Employee.");
				 }else {
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
					 System.out.println("Access Denied");}
				break;
				
			}

		} while (option != "6");
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);

	}

	
}
