package com.banking.menus;

import java.util.Scanner;

public class MainMenu {
	
	public MainMenu() {
		printMenu();
	}

	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Cash Money Banking!\n");
		System.out.println("Please Choose an Option:\n" );
		System.out.println("1. Login to Account\n");
		System.out.println("2. Register for an Account");
		menuSelect(scanner.nextLine());
	}
	
	private static void menuSelect(String option) {
		switch(option) {
		case "1":
			LogInMenu.printMenu();
			break;
		case "2":
			AccountRegistrationMenu.printMenu();
		break;
		default:
			System.out.println("Please Input a number Selection");
			printMenu();
			break;
				
		}
	}
	
	
}
