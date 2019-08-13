package com.bankdb.project.AdminManager;


import java.util.Scanner;

import com.bankdb.project.model.Person;
import com.bankdb.project.screen.AccesScreen;
import com.bankdb.project.screen.CustomerConsult;
import com.bankdb.project.screen.CustomerScreen;
import com.bankdb.project.screen.JointAccountScreen;
import com.bankdb.project.screen.OpenAccountScreen;
import com.bankdb.project.screen.TransactionScreen;
import com.bankdb.project.screen.TransferScreen;


public class MainEntry {
	public static void  accessSystem() {
		Person person = new Person();
		Scanner scanner = new Scanner(System.in);
		String option = new String();;	
		do {
			System.out.println("1 -> Long in       ");
			System.out.println("2 -> Customer Enroll.       ");
			System.out.println("3 -> Log Out.       ");
			System.out.println("Which option do you like,..?  ");
			option = scanner.nextLine();
			
			switch(option) {			
			case "1": AccesScreen access = new AccesScreen();
					  person = access.accsesSystem("C");
					  if(person != null) {
						  mainMenu(person);
					  }else System.out.println("Customer not found...");
					  break;			
			case "2": CustomerScreen customerScreen = new CustomerScreen();
					  person = customerScreen.personAcces("C");
					  if(person == null) {
						  System.out.println("Sorry.. Customer could not be created");
					  }
					  break;
			default: 
				      if(!option.equals("3")) System.out.println("No is a valid option"); 
					  break;
			
			};
		}while(!option.equals("3"));			
	}
		
		static void mainMenu(Person person) {	
			OpenAccountScreen openApplic = new OpenAccountScreen();
			JointAccountScreen  jacccount = new JointAccountScreen();
			TransferScreen transfer = new TransferScreen();
			TransactionScreen transactionScreen = new TransactionScreen();
			CustomerConsult cConsult = new CustomerConsult();
			Scanner scanner = new Scanner(System.in);
			String option = new String();
			do {
				System.out.println("1 -> Account  Application     ");
				System.out.println("2 -> Joint Accounts Application      ");
				System.out.println("3 -> Deposit        ");
				System.out.println("4 -> Withdraw      ");
				System.out.println("5 -> transfer funds        ");
				System.out.println("6 -> Consult Transaction        ");
				System.out.println("7 -> Exit                ");
				System.out.println("Which option do you like,..?  ");
				option = scanner.nextLine();
				switch(option) {
					case "1": openApplic.openAccount(person);
							  break;
					case "2": jacccount.jointAccount(person);
							  break;
					case "3": transactionScreen.addTransaction(person, "D");
							  break;
					case "4": transactionScreen.addTransaction(person, "W");
							  break;
					case "5": transfer.addTransfer(person);
							break;
					case "6": cConsult.consultCust(person);
							break;
					default : if(!option.equals("7")) System.out.println("No is a valid option");
				
				}				
				
			}while(!option.equals("7"));
		}		

} 

