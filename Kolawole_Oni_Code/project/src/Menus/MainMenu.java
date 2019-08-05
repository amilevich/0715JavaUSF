package Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import bankapp.ApprovedApplication;
import bankapp.Login;
import bankapp.PendingApplication;

public class MainMenu {
	
	static Scanner sc = new Scanner(System.in);
	static String[] optionsArray = { "1. Customer", "2. Employee", "3. Admin", "4. Return to login menu." };

	public static void LoginMenu() {
		Login.readData("./pendingaccounts.txt", "./approvedaccounts.txt");
		Object loadedDataPending = Login.readData("./pendingaccounts.txt");
		Object loadedDataApproved = Login.readData("./approvedaccounts.txt");
		if(loadedDataPending==null) {
			System.out.println("No pending accounts loaded.");
		} 
		if(loadedDataApproved==null) {
			System.out.println("No approved accounts loaded");
		}
		else { 
			PendingApplication.addAll(loadedDataPending);
			ApprovedApplication.addAll(loadedDataApproved);
		}
		System.out.println("1. Sign up.\n2. Sign in.\n3. Add test dummies.");
		try {
			int newUser = sc.nextInt();
			switch (newUser) {
			case 1:
				PendingApplication.createNewUser();
				break;
			case 2:
				MainMenu.mainMenu();
				break;
			case 3:
				ApprovedApplication.addDummies();
			default:
				LoginMenu();//Back to the Menu for customer employee and admin
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}

	public static void mainMenu() {
		for (String s : optionsArray) {
			System.out.println(s);
		}
		System.out.println("Please select an option to continue");
		 //choice = sc.nextInt();
		 int choice = sc.nextInt();
		// To get an input of the choice that will activate the x.menu
		 //using choice and choice b 
		 loginHandler(choice);
		try {
			// choice = sc.nextInt();
			loginHandler(choice);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Enter a numeric option.");
		}
	}

	public static void loginHandler(int choice) {
		boolean put = true;
		while (put) {

			switch (choice) {
			case 1:
				CustomerMenu.loginMenu();
				put = !put;
				break;
			case 2:
				ApprovedApplication.employeeLogin();
				put = !put;
				break;
			case 3:
				ApprovedApplication.adminLogin();
				put = !put;
				break;
			case 4:
				LoginMenu();
			default:
				System.out.println("Select a choice.");
				MainMenu.mainMenu();
				put = !put;
				break;
			}
		}
	}
}
