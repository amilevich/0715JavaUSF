package com.revature.driver;

import java.sql.SQLException;
import java.util.Scanner;

public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// starts the bank app
		// new Driver().start();

		int response;

		do {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Welcome to Revature Bank");
			System.out.println("Are you a ");
			System.out.println("1. Bank Admin");
			System.out.println("2. Bank Customer");
			System.out.println("3. Bank Employee");
			response = keyboard.nextInt();

			switch (response) {

			case 1:
				menu1();
				break;

			case 2:
				menu2();
				break;

			case 3:
				System.out.println("You have selected option 3.");
				break;
			default:
				if (response != 4)
					System.out.println("Bye!.");
				break;
			}
		} while (response != 4);

	}
	
	static void menu1() {
		
		Scanner keyboard = new Scanner(System.in);
		int response;
		
		do {
			
			System.out.println("Welcome to the Admin menu. Please make your selection.");
			System.out.println("1. Admin Login");
			System.out.println("2. Create Admin Login");
			System.out.println("3. Exit");
			response = keyboard.nextInt();

			switch (response) {

			case 1:
				System.out.println("You have selected option 1.");
				break;

			case 2:
				System.out.println("You have selected option 2.");
				break;

			default:
				if (response != 3)
					System.out.println("Bye!.");
				break;
			}
		} while (response != 3);

	}
	
static void menu2() {
		
		Scanner keyboard = new Scanner(System.in);
		int response;
		
		do {
			
			System.out.println("Welcome to the Bank Customer menu. Please make your selection.");
			System.out.println("1. Customer Login");
			System.out.println("2. Create Customer Login");
			System.out.println("3. Apply for an account");
			System.out.println("4. Exit");
			response = keyboard.nextInt();

			switch (response) {

			case 1:
				System.out.println("You have selected option 1.");
				break;

			case 2:
				System.out.println("You have selected option 2.");
				break;
			
			case 3:
				System.out.println("You have selected option 3.");
				break;
			
			default:
				if (response != 4)
					System.out.println("Bye!.");
				break;
			}
		} while (response != 4);

	}

static void menu3() {
	
		Scanner keyboard = new Scanner(System.in);
		int response;
	
		do {
		
			System.out.println("Welcome to the Employee menu. Please make your selection.");
			System.out.println("1. Employee Login");
			System.out.println("2. Create Employee Login");
			System.out.println("3. Exit");
			response = keyboard.nextInt();

			switch (response) {

			case 1:
				System.out.println("You have selected option 1.");
			break;

			case 2:
				System.out.println("You have selected option 2.");
			break;

			default:
				if (response != 3)
					System.out.println("Bye!.");
				break;
			}
		} while (response != 3);
	
	}	
}