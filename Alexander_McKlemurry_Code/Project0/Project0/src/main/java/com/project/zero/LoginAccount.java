
package com.project.zero;

import java.io.Serializable; 
import java.util.Scanner;

import org.apache.log4j.Logger;


public class LoginAccount  {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -5413799998612719067L;
	private static final Logger mora = Logger.getLogger(LoginAccount.class);
	public void showMenu(ObjectStorage store) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. UserName");
		System.out.println("2. PassWord");
		System.out.println("3. Exit Application");
		System.out.println("4. Access Joint Account ");
		option = scanner.nextLine();

		do {

			switch (option) {

			case "1":
				System.out.println("UserName");
//				option = scanner.nextLine();
				String name = scanner.nextLine();
				if(option.equals("Alex")) {
				System.out.println("Name entered: " + name);
				AccountInfo accountInfo = new AccountInfo();
				accountInfo.showMenu(store);
				mora.info(" Account Name  " + "Entered Username. ");
				}else {
					LoginAccount loginAccount = new LoginAccount();
					loginAccount.showMenu(store);
				}
				break;

			case "2":
				System.out.println("Input your PassWord");
				option = scanner.nextLine();
				if(option.equals("Blade654")) {
				AccountInfo accountInfo1 = new AccountInfo();
				accountInfo1.showMenu(store);
				mora.info(" PassWord entered " + "Customer PassWord.");
				}else {
					LoginAccount loginAccount1 = new LoginAccount();
					loginAccount1.showMenu(store);
				}
				break;

			case "3":
				System.out.println("Exiting Application");
				option = scanner.nextLine();
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				mora.info(" Exit application " + "Closing application.");
				break;
				
			case "4":
				System.out.println("Access Joint Account");
				option = scanner.nextLine();
				if(option.equals("Alexander")) {
				JointAccount jointAccount = new JointAccount();
				jointAccount.showMenu(store);
				}else if(option.equals("Elizabeth")) {
				mora.info(" Access Joint Account " + "Joint Account Accessed.");
				 }else {
					 Mainmenu mainMenu1 = new Mainmenu();
						mainMenu1.showMenu(store);
					 System.out.println("Access Denied");}
				break;
			}

		} while (option != "3");
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		
	}

}
