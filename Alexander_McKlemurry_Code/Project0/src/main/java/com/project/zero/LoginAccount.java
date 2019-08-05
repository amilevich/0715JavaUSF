package com.project.zero;

import java.io.Serializable; 
import java.util.Scanner;

import org.apache.log4j.Logger;


public class LoginAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5413799998612719067L;
	private static final Logger mora = Logger.getLogger(LoginAccount.class);
	public void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. FirstName LastName");
		System.out.println("2. UserName");
		System.out.println("3. PassWord");
		System.out.println("4. Forgot UserName");
		System.out.println("5. Forgot PassWord");
		System.out.println("6. Exit Application");
		System.out.println("7. Access Joint Account ");
		option = scanner.nextLine();

		do {

			switch (option) {

			case "1":
				System.out.println("First Name Last Name");
				option = scanner.nextLine();
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				mora.info(" Enter name " + " Full Name.");
				break;

			case "2":
				System.out.println("UserName");
				option = scanner.nextLine();
				AccountInfo accountInfo = new AccountInfo();
				accountInfo.showMenu(store);
				mora.info(" Account Name  " + "Entered Username.");
				break;

			case "3":
				System.out.println("PassWord");
				option = scanner.nextLine();
				System.out.println("Input your password");
				AccountInfo accountInfo1 = new AccountInfo();
				accountInfo1.showMenu(store);
				mora.info(" PassWord entered " + "Customer PassWord.");
				break;

			case "4":
				System.out.println("Forgot UserName");
				option = scanner.nextLine();
				AccountInfo accountInfo2 = new AccountInfo();
				accountInfo2.showMenu(store);
				mora.info(" Forgotten UserName " + "Username has been forgotten.");
				
				break;

			case "5":
				System.out.println("Forgot PassWord");
				option = scanner.nextLine();
				AccountInfo accountInfo3 = new AccountInfo();
				accountInfo3.showMenu(store);
				mora.info(" Forgotten Password  " + "Password has been forgotten.");
				break;

			case "6":
				System.out.println("Exiting Application");
				option = scanner.nextLine();
				mora.info(" Exit application " + "Closing application.");
				break;
				
			case "7":
				System.out.println("Access Joint Account");
				option = scanner.nextLine();
				JointAccount jointAccount = new JointAccount();
				jointAccount.showMenu(store);
				mora.info(" Access Joint Account " + "Joint Account Accessed.");
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
