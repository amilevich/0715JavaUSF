package items;

import java.util.Scanner;

import Menus.AdminMenu;
import Menus.CustomerMenu;
import Menus.MainMenu;
import bankapp.Account;
import bankapp.ApprovedApplication;

public class UtilityMenus {
	static Scanner sc = new Scanner(System.in);

	public static void depositMenu(Account a) {
		System.out.println("How much would you like to deposit? ");
		double depositAmt = sc.nextDouble();
		// sc.next();
		System.out.println("Deposited " + depositAmt);
		Actions.deposit(a, depositAmt);
		CustomerMenu.actionMenu(a);
	}

	public static void withdrawMenu(Account a) {
		System.out.println("How much to withdraw?");
		double withdrawalAmt = sc.nextDouble();
		// sc.next();
		Actions.withdraw(a, withdrawalAmt);
		System.out.println("Withdrawing " + withdrawalAmt);
		CustomerMenu.actionMenu(a);
	}

	public static void transferMenu(Account a) {
		System.out.println("How much to transfer?");
		double transferAmt = sc.nextDouble();
		sc.next();
		System.out.println("Transfer to who? Enter a username.");
		String username = sc.nextLine();
		sc.next();
		Account transferTo = ApprovedApplication.fetchOne(username);
		if (transferTo != null) {
			Actions.transfer(a, transferAmt, transferTo);
			System.out.println("Transfer success");
			System.out.println("Transferred " + transferAmt);
		} else {
			System.out.println("Cannot transfer to that user; user not found.");
			CustomerMenu.actionMenu(a);
		}
		CustomerMenu.actionMenu(a);
	}

	public static void cancelMenu(Account a) {
		// System.out.println("Cancel whom? Enter a username.");
		// String cancelled = sc.nextLine();
		// sc.next();
		System.out.println("Are you sure? 1 for yes, 0 to return");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Actions.cancel(a);
			System.out.println("You no longer have an account, returning to main menu.");
			MainMenu.mainMenu();
			break;
		case 2:
			CustomerMenu.actionMenu(a);
			break;
		default:
			System.out.println("Returning to safety");
			CustomerMenu.actionMenu(a);
			break;
		}
	}

	public static void adminDepositMenu(Account a) {
		System.out.println("How much would you like to deposit? ");
		double depositAmt = sc.nextDouble();
		// sc.next();
		System.out.println("Deposited " + depositAmt);
		Actions.deposit(a, depositAmt);
		AdminMenu.actionMenu(a);
	}

	public static void adminWithdrawMenu(Account a) {
		System.out.println("How much to withdraw?");
		double withdrawalAmt = sc.nextDouble();
		// sc.next();
		Actions.withdraw(a, withdrawalAmt);
		System.out.println("Withdrawing " + withdrawalAmt);
		AdminMenu.actionMenu(a);
	}

	public static void adminTransferMenu(Account a) {
		System.out.println("How much to transfer?");
		double transferAmt = sc.nextDouble();
		sc.next();
		System.out.println("Transfer to who? Enter a username.");
		String username = sc.nextLine();
		sc.next();
		Account transferTo = ApprovedApplication.fetchOne(username);
		if (transferTo != null) {
			Actions.transfer(a, transferAmt, transferTo);
			System.out.println("Transfer success");
			System.out.println("Transferred " + transferAmt);
		} else {
			System.out.println("Cannot transfer to that user; user not found.");
		}
		AdminMenu.actionMenu(transferTo);
	}

	public static void adminCancelMenu(Account a) {
		System.out.println("Are you sure? 1 for yes, 0 to return");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Actions.cancel(a);
			AdminMenu.mainMenu();
			break;
		case 2:
			AdminMenu.mainMenu();
			break;
		default:
			System.out.println("Returning to safety");
			AdminMenu.actionMenu(a);
			break;
		}
	}}