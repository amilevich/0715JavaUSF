package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CustomerAccount  {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 8497096725706276296L;
	private static final Logger mora = Logger.getLogger(CustomerAccount.class);
	double balance;
	
	String Alexander;
	String A67786;

	void BankAccount(String cname, String cid) {

		Alexander = cname;
		A67786 = cid;
	}

	void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			
			System.out.println(amount);
		}
	}

	void withdraw(double amount2) {
		if (amount2 > 0 && amount2 <= balance) {
			balance = balance - amount2;
			
		}
	}

	

	void showMenu(ObjectStorage store) {

		String option = "";
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Welcome Mr Alexander" );
			System.out.println("Your ID is 67786");
			System.out.println("1. Check Balance ");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transfer Funds");
			System.out.println("5. Exit");
			System.out.println("6. Access Joint Account");

			System.out.println("Hello");
			scanner= new Scanner(System.in);
			option = scanner.nextLine();
			System.out.println("Mr. Alexander");

			switch (option) {

			case "1":
				System.out.println("Check Balance " + balance);
				mora.info("Balnce $" + balance+" Check Balance.");
				System.out.println("Total Balance " + balance);
				CustomerAccount customerAccount1= new CustomerAccount();
				 customerAccount1.showMenu(store);
				break;

			case "2":

				System.out.println("Enter an amount to deposit:");
				scanner = new Scanner(System.in);
				double amount1 = scanner.nextDouble();
				deposit(amount1);
				mora.info("Depostit $" + balance+" Deposit into primary account.");
				System.out.println("Total Balance " + balance);
				break;

			case "3":

				System.out.println("Enter an amount to withdraw:");
				scanner = new Scanner(System.in);
				double amount2 = scanner.nextInt();
				if(amount2 < balance) {
					withdraw(amount2);
					mora.info("Withdraw $" + balance+" Withdraw from primary account.");
				}else {
					System.out.println("Insufficient Balance");
				}
				
				System.out.println("Total Balance " + balance);
				break;

			case "4":
				System.out.println("Enter Amount");
				scanner = new Scanner(System.in);
				double ammount = scanner.nextDouble();
				if(ammount<=balance) {
				store.get3CustomerSSI1("A67786").getJoint().deposit(ammount);
				balance-=ammount;
				mora.info("Transfeered $" + balance+" Transfer to Joint Account ");
				System.out.println("Total Balance " + balance);
				}else {
					System.out.println("Insufficient Balance");
				}
				break;

			case "5":
				System.out.println("Exiting application");
				 option = scanner.nextLine();
				 Mainmenu mainMenu = new Mainmenu();
					mainMenu.showMenu(store);
				 mora.info(" Exit Application " + "Closing Application.");
				break;
				
			case "6":
				System.out.println("Access Joint Account");
				 option = scanner.nextLine();
				 JointAccount jointAccount = new JointAccount();
				 jointAccount.showMenu(store);
				 mora.info("Joint Account $" + balance+" Access Joint Account.");
				break;
			}

		} while (!option.equalsIgnoreCase("5"));
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);
	}
}
