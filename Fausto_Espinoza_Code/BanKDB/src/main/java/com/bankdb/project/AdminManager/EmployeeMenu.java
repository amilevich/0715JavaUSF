package com.bankdb.project.AdminManager;

import java.util.Scanner;
import com.bankdb.project.model.Person;
import com.bankdb.project.screen.AccesScreen;
import com.bankdb.project.screen.ReviewApliScreen;
import com.bankdb.project.screen.ReviewJointApliScreen;

public class EmployeeMenu {
	
	public static void  accessSystem() {
		Person person = new Person();
		Scanner scanner = new Scanner(System.in);
		String option = new String();	
		do {		
			System.out.println("1 -> Long in       ");
			System.out.println("2 -> Log Out.       ");
			System.out.println("Which option do you like,..?  ");
			option = scanner.nextLine();
			
			switch(option) {			
			case "1":	AccesScreen access = new AccesScreen();
						person = access.accsesSystem("E");
						if(person != null) {
							menuEmployee();
						}else System.out.println("Employee not found...");
						break;			
			default: 
				     if(!option.equals("2")) System.out.println("No is a valid option"); 
					 break;
			
			};
		}while(!option.equals("2"));			
	}
	
	static void menuEmployee() {			
			Scanner scanner = new Scanner(System.in);
			String option = new String();
			do {
				System.out.println("1 -> Applications Accounts to review ");
				System.out.println("2 -> Applications Joint Accounts to review ");
				System.out.println("3 -> Exit ");
				option = scanner.nextLine();				
				switch(option) {
					case "1": ReviewApliScreen rv = new ReviewApliScreen();
							  rv.reviewApl();
							  break;					
					case "2": ReviewJointApliScreen jrv = new ReviewJointApliScreen();
							  jrv.reviewApl();
							  break;					
					default: if(!option.equals("3"))  System.out.println("No is a valid option");
				}
				
			}while(!option.equals("3"));
	}

}
