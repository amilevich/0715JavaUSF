package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CustomerAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8497096725706276296L;
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
			System.out.println("Your ID is A67786");
			System.out.println("A. Check Balance ");
			System.out.println("B. Deposit");
			System.out.println("C. Withdraw");
			System.out.println("D. Transfer Funds");
			System.out.println("E. Exit");
			System.out.println("F. Access Joint Account");

			System.out.println("Hello");
			scanner= new Scanner(System.in);
			option = scanner.nextLine();
			System.out.println("Mr. Alexander");

			switch (option) {

			case "A":
				System.out.println("Check Balance " + balance);
				mora.info("Balnce $" + balance+" Check Balance.");
				System.out.println("Total Balance " + balance);
				break;

			case "B":

				System.out.println("Enter an amount to deposit:");
				scanner = new Scanner(System.in);
				double amount1 = scanner.nextDouble();
				deposit(amount1);
				mora.info("Depostit $" + balance+" Deposit into primary account.");
				System.out.println("Total Balance " + balance);
				break;

			case "C":

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

			case "D":
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

			case "E":
				System.out.println("Exiting application");
				 option = scanner.nextLine();
				 mora.info(" Exit Application " + "Closing Application.");
				break;
				
			case "F":
				System.out.println("Access Joint Account");
				 option = scanner.nextLine();
				 JointAccount jointAccount = new JointAccount();
				 jointAccount.showMenu(store);
				 mora.info("Joint Account $" + balance+" Access Joint Account.");
				break;
			}

		} while (!option.equalsIgnoreCase("E"));
		System.out.println("Thank you for your time");
		BankAccount bank = new BankAccount();
		bank.Save(store);
	}
}
