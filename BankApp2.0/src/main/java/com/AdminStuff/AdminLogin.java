package com.AdminStuff;

import java.util.Scanner;

import com.AccountStuff.AcctTransactions;

public class AdminLogin {
	
	public static void myAdminLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username:");
		String username = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		
		
	}
	
	public static void adminMenu2() {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
		System.out.println("Please select an option");
		System.out.println("1. Review accounts  ");
		System.out.println("2. Deposit    ");
		System.out.println("3. Withdraw    ");
		System.out.println("4. Transfer funds    ");
		System.out.println("5. Exit    ");
		option = sc.nextInt();
		
		switch(option) {
		case 1:
			//acctAppl();
			break;
		case 2:
			Scanner scan = new Scanner(System.in);
			System.out.println("Amount:");
			int amount = sc.nextInt();
			AcctTransactions.myDeposit(amount);
			break;
		case 3:
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Amount:");
			int amount2 = sc.nextInt();
			AcctTransactions.myWithdraw(amount2);
			break;
		case 4:
			//transFunds();
			break;
		case 5:
			//mainMenu();
			break;
		}
		
	}while(option != 5);
	

}
}
