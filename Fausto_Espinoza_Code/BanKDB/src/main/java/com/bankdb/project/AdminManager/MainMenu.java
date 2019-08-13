package com.bankdb.project.AdminManager;

import java.util.Scanner;

import com.bankdb.project.model.Person;
import com.bankdb.project.screen.AccesScreen;

public class MainMenu {

	public static void main(String[] args) {
//		DataBaseConnect t = new DataBaseConnect();
//		t.connectorDB();
		mainMenu();
		System.out.println("Thanks for using the system");
	}
	
	static void mainMenu() {
		Person person = new Person();
		AccesScreen access = new AccesScreen();
		Scanner scanner = new Scanner(System.in);		
		String option = new String();
		
		do {
			System.out.println("1 -> Admin");
			System.out.println("2 -> Employee");
			System.out.println("3 -> Customer");
			System.out.println("4 -> Exit");
			
			option = scanner.nextLine();
			
			switch(option) {
				case "1": person = access.accsesSystem("A");
						  if(person != null) {
							  AdminMenu.accessSystem(person);
						  }
						  break;
				case "2": EmployeeMenu.accessSystem();
						  break;						
				case "3": MainEntry.accessSystem();
						  break;
				default: if(!option.equals("4")) System.out.println("No is a valid option");
			}
		}while(!option.equals("4"));		
	}
}
