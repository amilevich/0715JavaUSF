package Users;

import Menus.AdminMenu;
import bankapp.Account;
import bankapp.ApprovedApplication;
import bankapp.PendingApplication;

public class Customer {
	private final String username="one";
	private final String password="one";

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean deposit() {
		System.out.println("Deposit inside of customer");
		return true;
	};
	public static boolean withdraw() {
		System.out.println("withdraw inside of customer");
		return true;
	};
	public static  boolean transfer() {
		System.out.println("transfer inside of customer");
		return true;
	};
	public static boolean cancelAccount() {
		System.out.println("cancel inside of customer");
		return true;
	}

	public  String getUsername() {
		return username;
	}

	public  String getPassword() {
		return password;
	}

	
	public static void approve(Account account){
		try { account.setApproved(true);
		ApprovedApplication.addOne(account.getUsername(), account);
		PendingApplication.removeOne(account.getUsername());
		System.out.println("Application approved.");
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Unable to approve a null account xP");
		}
		
		AdminMenu.actionMenu(account);
}
public static void deny(Account account){
	PendingApplication.removeOne(account.getUsername());
	System.out.println("Application denied -- redirecting");
	AdminMenu.mainMenu();
}
	
	
}