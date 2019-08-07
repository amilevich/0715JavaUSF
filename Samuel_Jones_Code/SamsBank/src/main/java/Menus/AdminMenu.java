package Menus;


import java.util.Scanner;

import Users.Admin;
import items.Account;
import items.ApprovedAccounts;
import items.PendingAccounts;
import utilities.Handler;

public class AdminMenu {
	static Scanner sc = new Scanner(System.in);
	private static String[] optionsArray1 = {"1. Find an approved account.", "2. Find a pending account","3. View all approved.", "4. View all pending.", "5. Return to prior menu (logout)."};
	private static String[] optionsArray2 = {"0. View account","1. Deposit", "2. Withdraw", "3. Transfer", "4. Cancel an Account ", "5. Return to admin menu."};
	private AdminMenu() {};
	
	public static void mainMenu() {
		System.out.println("Admin, what would you like to do?");
		
		for(int i =0; i<optionsArray1.length;i++) {
			System.out.println(optionsArray1[i]);
		}
		sc = new Scanner(System.in);
		String choice = sc.nextLine();
		firstInputHandler(choice);
	}
	
	public static void actionMenu(Account a) {
		for(int i =0; i<optionsArray2.length;i++) {
			System.out.println(optionsArray2[i]);
		}
		sc = new Scanner(System.in);
		String choice = sc.nextLine();
		Handler.actionHandler(choice, a, "admin");
	}
	
	public static void firstInputHandler(String choice)  {
		boolean flag = true;
		sc = new Scanner(System.in);
		while(flag) {
			
			switch(choice) {
			case "1": 
				System.out.println("Enter a username to fetch.");
				String username = sc.nextLine();
				Account a = ApprovedAccounts.fetchOne(username);
				if(a==null) {
					System.out.println("No such user exists.");
					AdminMenu.mainMenu();
				} 
				actionMenu(a);
				flag=!flag;
				break;
			case "2":
				System.out.println("Enter a username to fetch.");
				username = sc.nextLine();
				a = PendingAccounts.fetchOne(username);
				if(a!=null) {
					approveOrDenyMenu(a);
				} else {
					System.out.println("No account found.");
				}
				mainMenu();
				flag=!flag;
				break;
			case "3":
				ApprovedAccounts.displayAll();
				mainMenu();
				flag=!flag;
				break;
			case "4":
				PendingAccounts.displayAll();
				mainMenu();
				flag=!flag;
				break;
			case "5":
				MainMenu.mainMenu();
				flag=!flag;
				break;
			}
	}
	}
	public static void approveOrDenyMenu(Account a) {
		System.out.println("1. Approve\n2. Deny\n3.Return to previous menu");
		sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			Admin.approve(a);
			mainMenu();
			break;
		case "2":
			Admin.deny(a);
			mainMenu();
			break;
		case "3":
			MainMenu.mainMenu();
			;
		}
	}
	
//	// New code for altering user information (unimplemented code)*********************************************
//	private static Account editMenu(Account a) {
//		sc = new Scanner(System.in);
//		System.out.println("1. Edit?");
//		System.out.println("2. Return");
//		String choice = sc.nextLine();
//		
//		switch (choice) {
//		case "1":
//			String changeMe = editWhich();
//			System.out.println("Enter new value.");
//			String changeTo = sc.nextLine();
//			ApprovedAccounts.edit(a, changeMe, changeTo);
//			
//			break;
//
//		default:
//			break;
//		}
//		return a;
//	}
//	
//	private static String editWhich() {
//		
//		System.out.println("1. Edit first name.");
//		System.out.println("2. Edit last name.");
//		System.out.println("3. Edit joint user's first name.");
//		System.out.println("4. Edit joint user's last name.");
//		sc = new Scanner(System.in);
//		String choice = sc.nextLine();
//		switch(choice) {
//		case "1":
//			return "firstname";
//		case "2":
//			return "lastname";
//		case "3":
//			return "jointFirst";
//		case "4":
//			return "jointLast";
//		default:
//			return "";
//		}
//	}
}
