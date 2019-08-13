package main.java.application.View;

import main.java.application.Dao.AccountDaoImpl;
import main.java.application.Dao.UserDaoImpl;
import main.java.application.Domain.Account;
import main.java.application.Domain.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminLogin {
	static Scanner scan = new Scanner(System.in);
	private static final Logger log = Logger.getLogger(AdminLogin.class);
	private static AccountDaoImpl accountDao = new AccountDaoImpl();
	private static UserDaoImpl userDao = new UserDaoImpl();
	
	//admin account menu
	public static void adminMenu(User user) {
		//PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("Welcome " + user.getUserName() );
		String option = "";
		Account acc;
		ArrayList<Integer> accounts; 
		int accountNumber, to;
		double amount;
		
		do {
			System.out.println("\nAdministrator menu: ");
			System.out.println("(v) View all accounts.");
			System.out.println("(b) view account balance.");
			System.out.println("(c) Cancel account.");
			System.out.println("(e) Deposit.");
			System.out.println("(w) Withdraw.");
			System.out.println("(t) transfer.");
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
				log.info(user.getUserName() + String.format(" Listed all the accounts"));
				break;
			
			case "b":
				System.out.print("Please enter Account Number to View Balance: ");
				accountNumber = scan.nextInt();
				acc = accountDao.getBalance(accountNumber);
				System.out.printf("The Balance of %d is %.2f%n", accountNumber, acc.getBalance());
				log.info(user.getUserName() + String.format(" Checked balance of %d account%n", accountNumber));
				scan.nextLine();
				break;
				
			case "c":
				System.out.print("Please enter Account Number to Cancel: ");
				accountNumber = scan.nextInt();
				if(accountDao.approveAccountApplication(accountNumber)) {
					System.out.printf("The account application of %d is approved%n", accountNumber);
					log.info(user.getUserName() + String.format(" cancelled %d account%n", accountNumber));
				} else {
					System.out.printf("The account application of %d is not approved%n", accountNumber);
					log.info(user.getUserName() + String.format(" failed to cancel %d account%n", accountNumber));
				}
				
				scan.nextLine();
				break;
				
			case "e":
				
				// Deposit into an account
				System.out.println("Please enter Account Number: ");
				accountNumber = scan.nextInt();
				
					// get balance
					System.out.println("Please enter amount to deposit: ");
					amount = scan.nextDouble();
					
					if(accountDao.deposit(accountNumber, amount)) {
						System.out.printf("%n%.2f has been deposited to account %d%n", 
								amount, accountNumber);
						log.info(user.getUserName() + String.format(" has deposited %.2f to account %d",
								amount, accountNumber));
					} else {
						System.out.printf("%n%.2f has not been deposited to account %d%n", 
								amount, accountNumber);
						log.info(user.getUserName() + String.format(" has failed to deposit %.2f to account %d",
								amount, accountNumber));
					}
					
				scan.nextLine();
				break;
				
			case "w":
				// withdraw into an account
				System.out.println("Please enter Account Number: ");
				accountNumber = scan.nextInt();
				
					// get balance
					System.out.println("Please enter amount to Withdraw: ");
					amount = scan.nextDouble();
					
					if(accountDao.withdraw(accountNumber, amount)) {
						System.out.printf("%n%.2f has been Withdraw from account %d%n", 
								amount, accountNumber);
						log.info(user.getUserName() + String.format(" has withdrawn from %.2f account %d",
								amount, accountNumber));
					} else {
						System.out.printf("%n%.2f has not been Withdraw from account %d%n", 
								amount, accountNumber);
						log.info(user.getUserName() + String.format(" has failed to withdraw %.2f from account %d",
								amount, accountNumber));
					}					
				scan.nextLine();

				break;
				
			case "t":
				// Transfer funds between accounts
				System.out.println("Please enter From Account Number: ");
				accountNumber = scan.nextInt();
				
				// to account
				System.out.println("Please enter To Account Number: ");
				to = scan.nextInt();
				
				// amount
				System.out.println("Please enter Amount to transfer: ");
				amount = scan.nextInt();
				
				// transfer
				if(accountDao.transfer(accountNumber,to, amount)) {
					System.out.printf("%n%.2f has been transferred from %d to %d Account%n", 
							amount, accountNumber, to);
					log.info(user.getUserName() + String.format(" transferred %.2f from %d to %d",amount, 
							accountNumber, to));
				} else {
					log.fatal(user.getUserName() + String.format(" failed to transfer %.2f from %d to %d",amount, 
							accountNumber, to));
					System.out.println("Amount has not been transferred");
				}
				scan.nextLine();
				break;
				
			case "a":
				System.out.print("Please enter Account Number to approve application: ");
				accountNumber = scan.nextInt();
				if(accountDao.approveAccountApplication(accountNumber)) {
					System.out.printf("The account application of %d is approved%n", accountNumber);
					log.info(user.getUserName() + String.format(" approved %d account application%n", accountNumber));
				} else {
					System.out.printf("The account application of %d is not approved%n", accountNumber);
					log.info(user.getUserName() + String.format(" failed to approve %d account application%n", accountNumber));
				}
				scan.nextLine();
				break;
			case "d":
				System.out.print("Please enter Account Number to Deny application: ");
				accountNumber = scan.nextInt();
				if(accountDao.denyAccountApplication(accountNumber)) {
					System.out.printf("The account application of %d is denied%n", accountNumber);
					log.info(user.getUserName() + String.format(" denied %d account application%n", accountNumber));
				} else {
					System.out.printf("The account application of %d is not denined%n", accountNumber);
					log.info(user.getUserName() + String.format(" failed to deny %d account application%n", accountNumber));
				}
				scan.nextLine();
				break;
				
			case "l":
				System.out.println("Successfully logged out.");
				log.info(user.getUserName() + " has been successfully logged out");
				break;
				
			default: 
				System.out.println("Invalid selection.");
				break;
			}
			System.out.println();
		}while(!"l".equals(option));
	}
}
