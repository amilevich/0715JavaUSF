package main.java.application.View;

import java.util.Scanner;

import main.java.application.Dao.AccountDaoImpl;
import main.java.application.Dao.UserDaoImpl;
import main.java.application.Domain.User;
import org.apache.log4j.Logger;

public class Login {
	static Scanner scan = new Scanner(System.in);

	private static AccountDaoImpl accountDao = new AccountDaoImpl();
	private static UserDaoImpl userDao = new UserDaoImpl();

	public Login() {
		super();
	}

	public static void loginMenu(User user) {
		System.out.println("\nSuccessfully logged in.");
		System.out.println("\nWelcome " + user.getUserName() );

		String userName;
		int accountNumber, to;
		double amount;
		
		String option; // = scan.nextLine().toLowerCase();
		do {
			// Display accounts
			
			System.out.println("\nPlease select an option:");
			System.out.println("(a) Apply for new account.");
			System.out.println("(j) Apply for Joint account.");
			System.out.println("(d) Deposit.");
			System.out.println("(w) Withdraw.");
			System.out.println("(t) Transfer between accounts");
			System.out.println("(l) Log out.");
			option = scan.nextLine().toLowerCase();
			switch (option) {
			case "a":
				// Apply for new account
				if(accountDao.createAccountApplication(user)) {
					System.out.println("New Account Application has been created");
					
				} else {
					System.out.println("New Account Application has not been created");
					
				}
				break;
			case "j":
				// Apply for jointAccount
				// second user name
				System.out.print("Please enter Username for Joint Account holder: ");
				userName = scan.nextLine();
				if(accountDao.createJointAccountApplication(user.getUserName(), userName)) {
					System.out.println("New Joint Account Application has been created");
					
				} else {
					System.out.println("New Joint Account Application has not been created");
					
				}
				break;
			case "d":
				// Deposit into an account
				System.out.println("Please enter Account Number: ");
				accountNumber = scan.nextInt();
				
				// if account present
				if(userDao.hasAccountAccess(user.getUserName(), accountNumber)) {
					
					// Check status of account
					if(accountDao.getAccountStatus(accountNumber).equalsIgnoreCase("Approved")) {
						
						// get balance
						System.out.println("Please enter amount to deposit: ");
						amount = scan.nextDouble();
						
						if(accountDao.deposit(accountNumber, amount)) {
							System.out.printf("%n%.2f has been deposited to your account %d%n", 
									amount, accountNumber);
							
						} else {
							System.out.printf("%n%.2f has not been deposited to your account %d%n", 
									amount, accountNumber);
							
						}
						
					} else {
						System.out.println("Your account application is not approved yet!");
					}
					
				} else {
					System.out.println("You don't have access to this account: " + accountNumber);
				}
				scan.nextLine();
				break;

			case "w":
				// Withdraw from account
				// Deposit into an account
				System.out.println("Please enter Account Number: ");
				accountNumber = scan.nextInt();
				
				// if account present
				if(userDao.hasAccountAccess(user.getUserName(), accountNumber)) {
					
					// Check status of account
					if(accountDao.getAccountStatus(accountNumber).equalsIgnoreCase("Approved")) {
						
						// get balance
						System.out.println("Please enter amount to Withdraw: ");
						amount = scan.nextDouble();
						
						if(accountDao.withdraw(accountNumber, amount)) {
							System.out.printf("%n%.2f has been withdrawn from your account %d%n", 
									amount, accountNumber); 
							
							
						} else {
							System.out.printf("%n%.2f has not been withdrawn from your account %d%n", 
									amount, accountNumber);
					
						}
						
					} else {
						System.out.println("Your account application is not approved yet!");
					}
					
				} else {
					System.out.println("You don't have access to this account: " + accountNumber);
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

				} else {
					
					System.out.println("Amount has not been transferred");
				}
				scan.nextLine();
				break;
			case "l":
				System.out.println("\nSuccessfully logged out.\n");
				break;
			default:
				System.out.println("Invalid selection.");
				break;
			}
		}while (!option.equals("l"));
	}
}
