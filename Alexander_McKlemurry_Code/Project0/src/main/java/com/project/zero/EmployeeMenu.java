package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class EmployeeMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6119650484264261296L;
	private static final Logger mora = Logger.getLogger(EmployeeMenu.class);
	void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Check Customer Account Info");
		System.out.println("2. Erase Account");
		System.out.println("3. Suspend Customer");
		System.out.println("4. Close Customer File");
		System.out.println("5. Approve Customer Application");
		System.out.println("6. Deny Customer Application");
		System.out.println("7. Go To Main Menu");
		System.out.println("8. Access Joint Account");
		option=scanner.nextLine();
		
		do {

//			System.out.println("Hello");
//			option = scanner.nextLine();
//			System.out.println("\n");

			switch (option) {

			case "1":
				System.out.println("Check Customer Account Info");
				 option = scanner.nextLine();
				//System.out.println("\n");
				AccountInfo accountInfo = new AccountInfo();
				accountInfo.showMenu(store);
				mora.info(" Access Point for Customer Information ");
				break;

			case "2":

				System.out.println("Erase Account");
				 option = scanner.nextLine();
				System.out.println("Account Erased");
				mora.info(" Customer Account is Terminated ");
				break;

			case "3":

				System.out.println("Suspend Customer Account");
				 option = scanner.nextLine();
				System.out.println("Account Suspended");
				mora.info(" Customer Account is temporarily Suspended ");
				break;

			case "4":
				System.out.println("Close Customer File");
				 option = scanner.nextLine();
				System.out.println("File Closed");
				mora.info(" Customer File is Closed ");
				break;
				
			case "5":
				System.out.println("Approve Customer Application");
				 option = scanner.nextLine();
				System.out.println("Application Approved");
				mora.info(" Cusotmer Application is Approved ");
				break;
				
			case "6":
				System.out.println("Deny Customer Application");
				 option = scanner.nextLine();
				System.out.println("Application Denied");
				mora.info(" Customer Applicaiton is Denied ");
				break;
		
			case "7":
				System.out.println("Go to Main Menu");
				scanner = new Scanner(System.in);
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				mora.info(" Main Menu Access Point ");
				break;
				
			case "8":
				System.out.println("Access Joint Account");
				scanner = new Scanner(System.in);
				JointAccount jointAccount = new JointAccount();
				jointAccount.showMenu(store);
				mora.info(" Joint Account Access Point ");
				break;
				
			

			}

		} while (option != "2, 3, 4 ");
		System.out.println("Thank you for your time ");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);
	}

}
