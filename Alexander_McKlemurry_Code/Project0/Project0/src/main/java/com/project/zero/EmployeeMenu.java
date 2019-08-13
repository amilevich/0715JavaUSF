package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class EmployeeMenu  {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -6119650484264261296L;
	private static final Logger mora = Logger.getLogger(EmployeeMenu.class);
	void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Check Customer Account Info");
		System.out.println("2. Go To Main Menu");
		System.out.println("3. Access Joint Account");
		System.out.println("4. Access Accountinfo Alex");
		System.out.println("5. Access Accountinfo Eliza");
		option=scanner.nextLine();
		
		do {

//			System.out.println("Hello");
//			option = scanner.nextLine();
//			System.out.println("\n");

			switch (option) {

			case "1":
				System.out.println("Check Customer Account Info");
				 option = scanner.nextLine();
				System.out.println("\n");
				AccountInfo accountInfo = new AccountInfo();
				accountInfo.showMenu(store);
				mora.info(" Access Point for Customer Information ");
				break;
		
			case "2":
				System.out.println("Go to Main Menu");
				scanner = new Scanner(System.in);
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				mora.info(" Main Menu Access Point ");
				break;
				
			case "3":
				System.out.println("Access Joint Account");
				scanner = new Scanner(System.in);
				if(option.equals("A67786")) {
				JointAccount jointAccount = new JointAccount();
				jointAccount.showMenu(store);
				mora.info(" Joint Account Access Point ");
				}else {
					EmployeeMenu employeeMenu = new EmployeeMenu();
					employeeMenu.showMenu(store);
				}
				break;
				
			case "4":
				System.out.println("Access Accountinfo Alex");
				scanner = new Scanner(System.in);
				CustomerAccounts customerAccounts = new CustomerAccounts();
				customerAccounts.showMenu(store);
				mora.info(" CustomerAccounts ");
				break;
				
			case "5":
				System.out.println("Access Accountinfo Eliza");
				scanner = new Scanner(System.in);
				InformationStorage infoStorage = new InformationStorage();
				infoStorage.showMenu(store);
				mora.info(" Joint Account Access Point ");
				break;
			

			}

		} while (option != "2");
		System.out.println("Thank you for your time ");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);
	}

}
