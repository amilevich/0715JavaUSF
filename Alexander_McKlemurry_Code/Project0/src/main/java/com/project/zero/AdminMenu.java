package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class AdminMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2003745656578789110L;
	private static final Logger mora = Logger.getLogger(AdminMenu.class);
	void showMenu(ObjectStorage store) {
		String option = "option";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Access Customer Private Information");
		System.out.println("2. Erase Account");
		System.out.println("3. Suspend Customer Account");
		System.out.println("4. Approve Customer Application");
		System.out.println("5. Deny Customer Application");
		System.out.println("6. Go To Main Menu");
		System.out.println("7. Close Application");
		System.out.println("8. Access Joint Account");
		option = scanner.nextLine();

		do {
			
			switch (option) {

			case "1":
				System.out.println("Enter User Name");
				 option = scanner.nextLine();
				System.out.println("Enter Customer SSI ");
				scanner = new Scanner(System.in);
				String ssi = scanner.nextLine();
				AccountInfo accountInfo = new AccountInfo();
				accountInfo.showMenu(store);
				mora.info(" Customer UserName  " + "NAme of the customer.");
				break;

			case "2":

				System.out.println("Erase Account");
				 option = scanner.nextLine();
				System.out.println("Account Terminated ");
				mora.info(" Eraseed Account " + "Account has been terminated.");
				break;

			case "3":

				System.out.println("Suspend Customer Account");
				 option = scanner.nextLine();
				System.out.println("Account Suspended");
				mora.info(" Suspended Customer Account " + "Account Suspended.");
				break;

			case "4":
				System.out.println("Approve Customer Application");
				 option = scanner.nextLine();
				System.out.println("Application Accepted");
				mora.info(" Approved Application " + "Account has been approved.");
				break;

			case "5":
				System.out.println("Deny Customer Application");
				 option = scanner.nextLine();
				System.out.println("Application Denied");
				mora.info(" Denied Application  " + "Application Denied.");
				break;
				
			case "6":
				System.out.println("Go To Main Menu");
				 option = scanner.nextLine();
				System.out.println("\n");
				mora.info(" Go to Main Menu  " + "Arrived at main menu.");
				break;
				
			case "7":
				System.out.println("Close Application");
				 option = scanner.nextLine();
				System.out.println("\n");
				mora.info("Exit Application  " + "Application Closing.");
				break;
				
			case "8":
				System.out.println("Access Joint Account");
				 option = scanner.nextLine();
				 JointAccount jointAccount = new JointAccount();
					jointAccount.showMenu(store);
				System.out.println("\n");
				mora.info(" Joint Account Access " + "Access Joint Account.");
				break;
	
			}

		} while (option != "2, 3, 5, 7");
		System.out.println("Thank you for your time ");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);
	}
}
