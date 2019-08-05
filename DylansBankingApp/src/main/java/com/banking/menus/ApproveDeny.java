package com.banking.menus;

import java.util.Scanner;

import com.banking.dao.AccountAccess;

public class ApproveDeny {

	
	static void approvalMenu(String client) {
		System.out.println("Approve account? ");
		System.out.println("\t 1. Approve");
		System.out.println("\t 2. Deny");
		Scanner scanner = new Scanner(System.in);
		String selection = scanner.nextLine();
		
		switch(selection) {
		case "1":
			System.out.println("Client is CashMoney Certified!");
			AccountAccess.approveAccount(client);
			scanner.nextLine();
			EmployeeMenu.printMenu();
			break;
		case "2":
			System.out.println("Account Denied...That Client was not very CashMoney");
			AccountAccess.denyAccount(client);
			scanner.nextLine();
			EmployeeMenu.printMenu();
			break;
		default:
			System.out.println("Please Input a number Selection");
			scanner.nextLine();
			approvalMenu(client);
			break;
		}
		
	}
}
