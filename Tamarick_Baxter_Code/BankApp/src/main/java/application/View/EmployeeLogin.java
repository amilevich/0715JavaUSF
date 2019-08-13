package main.java.application.View;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import main.java.application.Dao.AccountDaoImpl;
import main.java.application.Domain.Account;

public class EmployeeLogin {
	static Scanner scan = new Scanner(System.in);
	private static final Logger log = Logger.getLogger(EmployeeLogin.class);
	private static AccountDaoImpl accountDao = new AccountDaoImpl();
	
	//employee account method
	public static void userAccount(String userName) {
		
		//PropertyConfigurator.configure("log4j.properties");
		System.out.println("\nWelcome " + userName);
		String option = "";
		ArrayList<Integer> accounts = null;
		int accountNumber;
		Account acc;
		
		do {
			System.out.println("\nEmployee menu:");
			System.out.println("(v) View all accounts.");
			System.out.println("(b) View account balance.");
			System.out.println("(a) Approve pending account.");
			System.out.println("(d) Deny pending account.");
			System.out.println("(l) Log out.");
			option = scan.nextLine().toLowerCase();
			switch(option) {
			case "v":
				accounts = accountDao.getAllAccounts();
				System.out.printf("%-10s %-15s %-12s %-20s %-20s%n", "AccNo", "Status", "Balance", 
						"FirstUser", "SecondUser");
				for(Integer an: accounts) {
					acc = accountDao.getAccount(an);
					System.out.printf("%-10d %-15s %-12.2f %-20s %-20s%n", 
							acc.getAccountNumber(), acc.getStatus(), acc.getBalance(), 
							acc.getUser1(), acc.getUser2());
				}
				System.out.println();
				log.info(userName + String.format(" Listed all the accounts"));
				break;
			
			case "b":
				System.out.print("Please enter Account Number to View Balance: ");
				accountNumber = scan.nextInt();
				acc = accountDao.getBalance(accountNumber);
				System.out.printf("The Balance of %d is %.2f%n", accountNumber, acc.getBalance());
				log.info(userName + String.format(" Checked balance of %d account%n", accountNumber));
				scan.nextLine();
				break;
				
			case "a":
				System.out.print("Please enter Account Number to approve application: ");
				accountNumber = scan.nextInt();
				if(accountDao.approveAccountApplication(accountNumber)) {
					System.out.printf("The account application of %d is approved%n", accountNumber);
					log.info(userName + String.format(" approved %d account application%n", accountNumber));
				} else {
					System.out.printf("The account application of %d is not approved%n", accountNumber);
					log.info(userName + String.format(" failed to approve %d account application%n", accountNumber));
				}
				scan.nextLine();
				break;
				
			case "d":
				System.out.print("Please enter Account Number to Deny application: ");
				accountNumber = scan.nextInt();
				if(accountDao.denyAccountApplication(accountNumber)) {
					System.out.printf("The account application of %d is denied%n", accountNumber);
					log.info(userName + String.format(" denied %d account application%n", accountNumber));
				} else {
					System.out.printf("The account application of %d is not denined%n", accountNumber);
					log.info(userName + String.format(" failed to deny %d account application%n", accountNumber));
				}
				scan.nextLine();
				break;
				
			case "l":
				System.out.println("Successfully logged out.");
				log.info(userName + " has been successfully logged out");
				break;
				
			default: 
				System.out.println("Invalid selection.");
				break;
			}
			System.out.println();
		}while(! "l".equals(option));
	}
}
