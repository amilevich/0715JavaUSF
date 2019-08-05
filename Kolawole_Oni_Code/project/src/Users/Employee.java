package Users;

//import java.util.logging.Logger;

import Menus.EmployeeMenu;
import bankapp.Account;
import bankapp.ApprovedApplication;
import bankapp.PendingApplication;

public class Employee {
	private final String username = "emp";
	private final String password = "emp";
	//private static Logger log = Logger.getLogger(Employee.class);
	
	
	public String getUsername() {
		return username;
	}



	public String getPassword() {
		return password;
	}



	public static void approve(Account account){
			try { account.setApproved(true);
			ApprovedApplication.addOne(account.getUsername(), account);
			PendingApplication.removeOne(account.getUsername());
			System.out.println("Application approved.");
			//log.info(account.getUsername() + " was approved.");
			}
			catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println("Unable to approve a null account xP");
			}
			
			EmployeeMenu.actionMenu();
	}
	public static void deny(Account account){
		PendingApplication.removeOne(account.getUsername());
		System.out.println("Application denied, user removed from pending accounts.");
		//log.info(account.getUsername() + " was denied.");
}
	}
