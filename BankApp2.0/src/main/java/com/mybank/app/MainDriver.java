package com.mybank.app;

import java.util.Scanner;

import com.AdminStuff.AdminLogin;
import com.CustomerStuff.CustomerLogin;

import CustomerDAO.IndividualDaoImpl;

public class MainDriver {

	public static void main(String[] args) {

		mainMenu();

	}

	static void mainMenu() {

		Scanner sc = new Scanner(System.in);
		int option;

		do {
			System.out.println("Please select one of the options listed below    ");
			System.out.println("1. Employee    ");
			System.out.println("2. Admin    ");
			System.out.println("3. Customer    ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				employeeMenuDisplay();
				break;
			case 2:
				adminMenuDisplay();
				break;
			case 3:
				customerMenu();
				break;
			default:
				if (option != 3)
					System.out.println("Invalid Option");
			}
 
		} while (option != 3);
	}

	private static void employeeMenuDisplay() {

		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("Please select an option");
			System.out.println("1. Look up accounts");
			System.out.println("2. Exit");
			option = sc.nextInt();

			switch (option) {
			case 1:
				
				break;

			case 2:
				break;
				
			default:
				if (option != 2)
					System.out.println("Invalid Option");
				
			}

		} while (option != 2);
	}

	private static void adminMenuDisplay() {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("Please select an option below");
			System.out.println("1- Sign in");
			System.out.println("2- Exit");
			option = sc.nextInt();

			switch (option) {
			case 1:
				AdminLogin.myAdminLogin();
				AdminLogin.adminMenu2();
				break;
			case 2:
				mainMenu();
				break;
			}

		} while (option != 2);

	}
	
	private static void customerMenu() {
		String usern = new String();
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("Please select an option below");
			System.out.println("1- Sign in");
			System.out.println("2- Register");
			System.out.println("3- Exit");
			option = sc.nextInt();
			
			switch(option) {
			case 1: 
				usern = CustomerLogin.myCustomerLogin();
				CustomerLogin.customerMenu2(usern);
				break;
				
			case 2: 
				RegistrationPortal.myCustRegistration();
				
			
				System.out.println("Successful registration!!!");
				customerMenu();
				break;
				
			case 3:
				mainMenu();
				break;
				
			default:
				if (option != 3)
					System.out.println("Invalid Option");
				
				
			}
		}while(option != 3);
		
	}
}