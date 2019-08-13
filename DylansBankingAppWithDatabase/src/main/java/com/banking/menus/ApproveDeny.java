package com.banking.menus;

import java.util.Scanner;


import com.banking.dao.BankDao;

public class ApproveDeny {
	static BankDao bankDao = new BankDao();
	private static int accountID;
	private static String username;
	
	ApproveDeny(int accountID, String username){
		this.accountID=accountID;
		this.username=username;
		approvalMenu();
	}

	
	static void approvalMenu() {
		System.out.println("Approve account? ");
		System.out.println("\t 1. Approve");
		System.out.println("\t 2. Deny");
		System.out.println("\t 3. Back to Menu");
		Scanner scanner = new Scanner(System.in);
		String selection = scanner.nextLine();
		
		switch(selection) {
		case "1":
			System.out.println("Client is CashMoney Certified!");
			bankDao.approveAccount(accountID);
			scanner.nextLine();
			whichMenu(username);
			
			break;
		case "2":
			System.out.println("Account Denied...That Client was not very CashMoney");
			bankDao.denyAccount(accountID);
			scanner.nextLine();
			whichMenu(username);
			break;
		case "3":
			whichMenu(username);
			break;
		default:
			System.out.println("Please Input a number Selection");
			scanner.nextLine();
			approvalMenu();
			break;
		}
	}
	
	static void whichMenu(String username) {
	if(username.equals("boss") || username.equals("Boss")) {
		AdminMenu adminMenu = new AdminMenu(username);
	}else {
		EmployeeMenu empmenu = new EmployeeMenu(username);
	}
	}
}
