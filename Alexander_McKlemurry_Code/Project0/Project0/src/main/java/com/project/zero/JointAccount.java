package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class JointAccount  {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -1183052624477023337L;
	private static final Logger mora = Logger.getLogger(JointAccount.class);
	double balance;
	String Alexander, Elizabeth;
	String A67786, E54403;

	void BankAccount(String cname, String cid) {

		Alexander = cname;
		A67786 = cid;
		Elizabeth = cname;
		E54403 = cid;
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
			System.out.println("Welcome Mr Alexander");
			System.out.println("Your ID is A67786");
			System.out.println("1. Check Balance ");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transfer Funds");
			System.out.println("5. Exit");
			System.out.println("6. Main Menu");	
			scanner = new Scanner(System.in);
			option = scanner.nextLine();

			switch (option) {

			case "1":
				System.out.println("Check Balance " + balance);
				mora.info("Check Balance $" + balance+" Total Balance.");
				JointAccount jAccount = new JointAccount();
				jAccount.showMenu(store);
				break;

			case "2":

				System.out.println("Enter an amount to deposit:");
				scanner = new Scanner(System.in);
				double amount1 = scanner.nextDouble();
				deposit(amount1);
				mora.info("Deposit $" + balance+" Deposit into Account.");
				System.out.println("Total Balance " + balance);
				break;

			case "3":

				System.out.println("Enter an amount to withdraw:");
				scanner = new Scanner(System.in);
				double amount2 = scanner.nextInt();
				if (amount2 < balance) {
					withdraw(amount2);
					mora.info("Withdraw $" + balance+" A67786 or A54405 Withdraw from Account.");
				} else {
					System.out.println("Insufficient Balance");
				}
				System.out.println("Total Balance " + balance);
				break;

			case "4":
				System.out.println("Transfer:");
				scanner = new Scanner(System.in);
				String ssi = scanner.nextLine();
				System.out.println("Enter Amount");
				scanner = new Scanner(System.in);
				double ammount = scanner.nextDouble();
				if (ammount <= balance) {
					if (ssi.equals("A54403")) {
						store.get3CustomerSSI1("A54403").getAccounts().deposit(ammount);
						mora.info("Transferred $" + balance+" from joint to either account.");
					} else if (ssi.equals("A67786")) {
						store.getCustomerSSI("A67786").getAccount().deposit(ammount);
						mora.info("Transferred $" + balance+" from joint to A67786.");
					} else {
						System.out.println("Account does not exist");
					}

					balance -= ammount;
					System.out.println("Total Balance " + balance);
				} else {
					System.out.println("Insufficient funds.");
				}
				break;

			case "5":
				System.out.println("Exit");
				option = scanner.nextLine();
				JointAccount jAccount1 = new JointAccount();
				jAccount1.showMenu(store);
				mora.info(" Exiting Application " + "Close Application.");
				break;
			case "6":
				System.out.println("Main Menu");
				option = scanner.nextLine();
				Mainmenu mainMenu = new Mainmenu();
				mainMenu.showMenu(store);
				mora.info(" Exiting Application " + "Close Application.");
				break;
			}

		} while (!option.equalsIgnoreCase("6"));
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);
	}
}
