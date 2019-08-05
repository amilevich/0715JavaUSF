package com.bank.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.project.model.*;
import com.bank.project.screen.AccesScreen;
import com.bank.project.screen.CustomerScreen;
import com.bank.project.screen.JointAccountScreen;
import com.bank.project.screen.OpenAccountScreen;
import com.bank.project.screen.TransactionScreen;
import com.bank.project.screen.TransferScreen;

public class MainEntry {
	public static List<Employee> employee = new ArrayList<>();
	public static List<Customer> custumer = new ArrayList<>();
	public static List<Account> account = new ArrayList<>();
	public static List<JointAccount> jtAccount = new ArrayList<>();
	public static List<Transaction> transaction = new ArrayList<>();
	public static Customer cstomer = new Customer();
	public static PullAllOfThem pullAll = new PullAllOfThem();
	public static long numberAccount;
	

	public static void main(String[] args) {
		pullAll.pullAll();		
		accessSystem();
		
		
	}
	
	//Access to menu customer
	static void  accessSystem() {
		Scanner scanner = new Scanner(System.in);
		int option;	
		do {
			pullAll.pullAll();
			System.out.println("1 -> Long in       ");
			System.out.println("2 -> Customers Enroll.       ");
			System.out.println("3 -> Log Out.       ");
			System.out.println("Which option do you like,..?  ");
			option = scanner.nextInt();
			
			switch(option) {			
			case 1:	AccesScreen access = new AccesScreen();
					cstomer = access.accsesSystem();
					if(cstomer != null) {
						mainMenu();
					}else System.out.println("Customer not found...");
					break;			
			case 2: CustomerScreen customerScreen = new CustomerScreen();
					cstomer = customerScreen.customerAcces();
					if(cstomer == null) {
						System.out.println("Sorry.. Customer could not be created");
					}
					break;
			default: 
				     if(option != 3) System.out.println("No is a valid option"); 
					 break;
			
			};
		}while(option != 3);			
	}
		
		static void mainMenu() {
			TransactionScreen transactionScreen = new TransactionScreen();
			TransferScreen transfer = new TransferScreen();
			Scanner scanner = new Scanner(System.in);
			int option;	
			do {
				pullAll.pullAll();
//				
//				}for(Account a : account) {
//					System.out.println(a);
				System.out.println("1 -> Accounts  Application     ");
				System.out.println("2 -> Joint Accounts Application      ");
				System.out.println("3 -> Deposit        ");
				System.out.println("4 -> Withdraw      ");
				System.out.println("5 -> transfer funds        ");
				System.out.println("6 -> Exit                ");
				System.out.println("Which option do you like,..?  ");
				option = scanner.nextInt();
				switch(option) {
					case 1: OpenAccountScreen openApplic = new OpenAccountScreen();
							openApplic.openAccount(cstomer);
							break;
					case 2: JointAccountScreen  jacccount = new JointAccountScreen();
							jacccount.jointAccount(cstomer);
							break;
					case 3: transactionScreen.addTransaction(cstomer, 'D');
							break;
					case 4: transactionScreen.addTransaction(cstomer, 'W');
							break;
					case 5: transfer.addTransfer(cstomer);
							break;
					default : if(option !=6) System.out.println("No is a valid option");
				
				}				
				
			}while(option != 6);
		}		

} 

