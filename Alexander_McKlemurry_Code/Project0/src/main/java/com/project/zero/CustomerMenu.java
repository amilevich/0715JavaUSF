package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CustomerMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 764069344972153348L;
	private static final Logger mora = Logger.getLogger(CustomerMenu.class);
	public static void main(String[] args) {

	}

	void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Login ");
		System.out.println("2. Sign up ");
		System.out.println("3. Exit Application ");
		option = scanner.nextLine();

		do {

//			System.out.println("Welcome To Your HomePage");
//			option = scanner.nextLine();
//			System.out.println("\n");

			switch (option) {

			case "1":
				System.out.println("Login");
				// option = scanner.nextLine();
				System.out.println("\n");
				LoginAccount loginInfo = new LoginAccount();
				loginInfo.showMenu(store);
				mora.info(" Login Entry " + "Login into account.");
				break;

			case "2":

				System.out.println("Sign up");
				// option = scanner.nextLine();
				System.out.println("\n");
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				mora.info(" Sigh up for account " + "Create Account.");
				break;

			case "3":

				System.out.println("Quit");
				 option = scanner.nextLine();
				System.out.println("Thank you for your time");
				mora.info(" Exit application " + "Closing Application.");
				break;

			}

		} while (option != "3");
		System.out.println("Have a good day");
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);
	}

}
