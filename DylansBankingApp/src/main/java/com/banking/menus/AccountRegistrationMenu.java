package com.banking.menus;

import java.util.Scanner;

import org.omg.CORBA.DynAnyPackage.Invalid;

import com.banking.accounts.JointAccount;
import com.banking.accounts.PendingAccount;
import com.banking.dao.AccountAccess;
import com.banking.database.PendingDataBase;

public class AccountRegistrationMenu  {
	
	public AccountRegistrationMenu(){
		printMenu();
	}

	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome New Cash Money Customer!");
		System.out.println("What kind of Account would you like to make today?");
		System.out.println("\n Choose an Option:");
		System.out.println("\t 1. Checking Account **Sign Up now for a free $20 in CASHMONEY**");
		System.out.println("\t 2. Joint Account (Must have 2 Valid Checking Accounts)");
		System.out.println("\t 0. Back To Main Menu");
		menuSelect(scanner.nextLine());
	}
	
	private static void menuSelect(String selection) {
		switch(selection) {
		case "1":
			checkingMenu();
			break;
		case "2":
			jointMenu();
			break;
		case "0":
			MainMenu mainMenu= new MainMenu();
			break;
		default:
			System.out.println("Please Input a number Selection");
			printMenu();
			break;
		}
	}
	
	private static void checkingMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Fill in the Following Information\n");
		System.out.println("What is your name:\n");
		String name = scanner.nextLine();
		System.out.println("How old are you:\n");
		String age = scanner.nextLine();
		System.out.println("What is your PhoneNumber:\n ");
		String phoneNumber = scanner.nextLine();
		System.out.println("Choose a Username:\n");
		String username = scanner.nextLine();
		System.out.println("Choose a Password:");
		String password = scanner.nextLine();
		createAccount(name, phoneNumber, age, username, password);
		System.out.println("Your Account is undergoing Aproval.\n");
		System.out.println("Rerouting to main menu...press Enter");
		scanner.hasNextLine();
		MainMenu.printMenu();
		scanner.close();
	}
	
	
	
	private static void jointMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Fill in the Following Information as accurately as Possible!\n");
		System.out.println("What is your Username of Joint Account member 1:\n");
		String username1 = scanner.nextLine();
		System.out.println("What is the Username of Joint Account member 2 :\n");
		String username2 = scanner.nextLine();
		createJointAccount(username1, username2);
		System.out.println("Your Account is undergoing Aproval.\n");
		System.out.println("Rerouting to main menu...press Enter");
		scanner.hasNextLine();
		MainMenu.printMenu();
	}
	
	private static void createAccount(String name, String phoneNumber, String age, String username, String password) {
		PendingAccount pendingAccount = new PendingAccount(name,phoneNumber, age, username, password);
		AccountAccess.saveAccount(pendingAccount);
	}
	
	private static void createJointAccount(String username1, String username2) {
		String jointAccess = username1 + username2;
		if(AccountAccess.validKey(username1)==false & AccountAccess.validKey(username2)==false) {
			System.out.println("One or more Usernames are Invalid...Try Again");
			printMenu();
		}else if(AccountAccess.validKey(username1)==true & AccountAccess.validKey(username2)==true) {//checks if both usernames are valid
		JointAccount jointAccount = new JointAccount(username1,username2,jointAccess);
		assignJointAccess(username1, username2);//assigns joint access to both user account Objects.
		AccountAccess.saveAccount(jointAccount); //saves to pendingAccounts Data Structure
		}
		
	}
	
	private static void assignJointAccess(String username1, String username2) {
		AccountAccess.assignJointAccess(username1, username2);
	}

	
	

	
}
