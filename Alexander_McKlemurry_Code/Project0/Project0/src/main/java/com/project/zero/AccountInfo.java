package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class AccountInfo  {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 202365229529529803L;
	private static final Logger mora = Logger.getLogger(AccountInfo.class);
	<BankingApplication> void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Customer Identification");
		System.out.println("2. Customer SSI");
		System.out.println("3. Exit Application");
		System.out.println("4. Account Alex");
		System.out.println("5. Account Eliza");
		option = scanner.nextLine();

		do {

			switch (option) {

			case "1":
				System.out.println("Type your First and Last name");
				option = scanner.nextLine();
				if(option.equals("Alexander Mcklemurry")) {
				CustomerAccount customerAccount= new CustomerAccount();
				 customerAccount.showMenu(store);
				 mora.info(" Full name " + "Typed Full Name.");
				 }else {
					 AccountInfo accInfo = new AccountInfo();
						accInfo.showMenu(store);
				 }
				break;
				

			case "2":
				System.out.println("Customer SSI");
				 option = scanner.nextLine();
				 if(option.equals("A67786")) {
					 CustomerAccount customerAccount1= new CustomerAccount();
				 customerAccount1.showMenu(store);
				 }else if(option.equals("A54403")) {
				 mora.info(" SSI Number " + "Customer SSI Access.");
				 }else {
					 AccountInfo accInfo = new AccountInfo();
						accInfo.showMenu(store);
				 }
				break;
			
			case "3":
				System.out.println("Exit Application");
				 option = scanner.nextLine();
				System.out.println("Have a good day");
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				mora.info(" Close Program " + "Closign application.");
				break;
				
			case "4":
				System.out.println("Account Alexander");
				 option = scanner.nextLine();
				 if(option.equals("A67786")) {
				CustomerAccount customerAccount2= new CustomerAccount();
				 customerAccount2.showMenu(store);
				 mora.info(" Alexander Account Info  " + "Information on Customer.");
			 }else {
				 AccountInfo accInfo = new AccountInfo();
					accInfo.showMenu(store);
				 
			 }
				break;
				
			case "5":
				System.out.println("Account Elizabeth");
				 option = scanner.nextLine();
				 if(option.equals("A54403")) {
				BankAccounts bankApp = new BankAccounts();
				 bankApp.showMenu(store);
				 mora.info(" Elizabeth Account info  " + "Information on Customer.");
				 }else {
					 AccountInfo accInfo1 = new AccountInfo();
						accInfo1.showMenu(store);
					 
				 }
				break;

			}

		} while (option == "3");
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);
	}
}
