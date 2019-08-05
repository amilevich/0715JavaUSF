package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.log4j.Logger;

class BankAccounts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3816116954105741560L;
	private static final Logger mora = Logger.getLogger(BankAccounts.class);
	double balance;
	
	String Elizabeth;
	String A54403;
	

	public BankAccounts() {

	}

	void BankAccount(String cname, String cid) {

		Elizabeth = cname;
		A54403 = cid;
	}

	void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			System.out.println(amount);
		}
	}

	void withdraw(double amount2) {
		if (amount2 > 0 && amount2 <= balance) {
			balance = balance = amount2;
			System.out.println(amount2);
			
		}
	}

	
	

	void showMenu(ObjectStorage store) {

		String option = "";
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;

		do {
			System.out.println("Welcome Elizabeth");
			System.out.println("Your ID is A54403");
			System.out.println("A. Check Balance ");
			System.out.println("B. Deposit");
			System.out.println("C. Withdraw");
			System.out.println("D. Transfer Funds");
			System.out.println("E. Exit");
			System.out.println("F. Access Joint Account");
			System.out.println("Enter an option");
			option = scanner.nextLine();
			scanner=new Scanner(System.in);
			System.out.println("\n");

			switch (option) {

			case "A":
				System.out.println("Check Balance =" + balance);
				scanner = new Scanner(System.in);
				double amount = scanner.nextDouble();
				mora.info("Balance $" + balance+" Check Total Balance.");
				System.out.println("\n");
				break;

			case "B":

				System.out.println("Enter an amount to deposit:");
				scanner = new Scanner(System.in);
				double amount1 = scanner.nextDouble();
				deposit(amount1);
				mora.info("Deposited $" + balance+"	Deposit into Main Account.");
				System.out.println("Total Balance " + balance);
				break;

			case "C":

				System.out.println("Enter an amount to withdraw:");
				scanner = new Scanner(System.in);
				double amount2 = scanner.nextInt();
				if(amount2 < balance) {
					withdraw(amount2);
					mora.info("WithDraw $" + balance+" Withdraw from Primary Account.");
				}else {
					System.out.println("Insufficient Balance");
				}
				System.out.println("Total Balance " + balance);
				break;

			case "D":
				System.out.println("Enter Amount");
				scanner = new Scanner(System.in);
				double ammount = scanner.nextDouble();
				if(ammount<=balance) {
				store.get3CustomerSSI1("A54403").getJoint().deposit(ammount);
				balance-=ammount;
				mora.info("Transferred $" + balance+" Transfer to Joint Account.");
				System.out.println("Total Balance " + balance);
				}else {
					System.out.println("Insufficient Balance");
				}
				break;

			case "E":
				System.out.println("Exit");
				 mora.info(" Login Entry " + "Login into account.");
				break;
				
			case "F":
				System.out.println("Access Joint Account");
				scanner = new Scanner(System.in);
				JointAccount jointAccount = new JointAccount();
				jointAccount.showMenu(store);
				mora.info("Transferred $" + balance+" Accessing Joint Account");
				break;
				

			}

		} while (!option.equalsIgnoreCase("E"));
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
		Mainmenu mainMenu = new Mainmenu();
		mainMenu.showMenu(store);

	}

	

	
}
