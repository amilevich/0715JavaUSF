package com.CustomerStuff;

import java.util.Scanner;

import com.AccountStuff.Accountinfo;
import com.AccountStuff.AcctTransactions;

public class CustomerLogin {
	
	public static String  myCustomerLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username:");
		String username = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		return username;
		
	}
	
	public static void customerMenu2(String username) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
		System.out.println("Please select an option");
		System.out.println("1. Open a new account");
		System.out.println("2. Open a joint account");
		System.out.println("3. Deposit    ");
		System.out.println("4. Withdraw    ");
		System.out.println("5. Transfer funds    ");
		System.out.println("6. Exit    ");
		option = sc.nextInt();
		
		switch(option) {
		case 1:
			Accountinfo.myCustRegistration(username);
			System.out.println("Please wait for your application to be approved");
			break;
		case 2:
			//jacctAppl();
			break;
		case 3:
			Scanner scan = new Scanner(System.in);
			System.out.println("Amount:");
			int amount = sc.nextInt();
			AcctTransactions.myDeposit(amount);
			break;
		case 4:
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Amount:");
			int amount2 = sc.nextInt();
			AcctTransactions.myWithdraw(amount2);
			break;
		case 5:
			//transFunds();
			break;
		case 6:
			//mainMenu();
			break;
		case 7:
			//mainMenu();
			break;
		}
		
	}while(option != 6);
	
//	public static void main(String[] args) {
//		myCustomerLogin();
//	}

}
}
