package com.bankdb.project.AdminManager;


import java.util.Scanner;


import com.bankdb.project.model.Person;
import com.bankdb.project.screen.AccesScreen;
import com.bankdb.project.screen.CancelAccount;
import com.bankdb.project.screen.CustomerInformationScreen;
import com.bankdb.project.screen.CustomerScreen;
import com.bankdb.project.screen.EmployeeTransantionScreen;
import com.bankdb.project.screen.TransactionScreen;
import com.bankdb.project.screen.TransferScreen;

public class AdminMenu {	
	public static void  accessSystem(Person admin) {
		Person person = new Person();		 
		Scanner scanner = new Scanner(System.in);
		String option = new String();	
		do {						
			System.out.println("1 -> Main System       ");
			System.out.println("2 -> Employee/Admin Enroll.       ");
			System.out.println("3 -> Log Out.       ");
			System.out.println("Which option do you like,..?  ");
			option = scanner.nextLine();
			
			switch(option) {			
			case "1":	if(admin != null) {
							menuEmployee();
						}else System.out.println("Employee not found...");
						break;			
			case "2":   CustomerScreen customerScreen = new CustomerScreen();
					    person = customerScreen.personAcces("A");
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
	
	static void menuEmployee() {		
			CustomerInformationScreen info = new CustomerInformationScreen();
			Person cstomer = new Person();
			Scanner scanner = new Scanner(System.in); 
			EmployeeTransantionScreen tre = new EmployeeTransantionScreen();
			String option = new String();
			TransactionScreen  cst = new TransactionScreen();
			TransferScreen tranf = new TransferScreen();
			CancelAccount clc = new CancelAccount();
			do {
				System.out.println("1 -> Custumer Information ");				
				System.out.println("2 -> Deposit");				
				System.out.println("3 -> Withdraw");				
				System.out.println("4 -> Transfer ");				
				System.out.println("5 -> Cancel account ");	
				System.out.println("6 -> Exit ");	
				option = scanner.nextLine();
				
				switch(option) {									
					case "1":
							cstomer = tre.transferEmployee();
							if(cstomer != null) {
								info.infCustomer(cstomer);
							}	
							break;
					case "2": 
							cstomer = tre.transferEmployee();
							if(cstomer != null) {
								cst.addTransaction(cstomer, "D");
							}
							break;
					case "3": 
							cstomer = tre.transferEmployee();
							if(cstomer != null) {
								cst.addTransaction(cstomer, "W");
							}					
							break;
					case "4": 
							cstomer = tre.transferEmployee();
							if(cstomer != null) {
								tranf.addTransfer(cstomer);
							}
							break;
					case "5": 
							cstomer = tre.transferEmployee();
							if(cstomer != null) {
								clc.cnncel(cstomer);
							}
							break;
					default: if(!option.equals("6"))  System.out.println("No is a valid option");
				}
				
			}while(!option.equals("6"));
	}
	
	
}
