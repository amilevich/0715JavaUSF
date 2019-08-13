package com.project.actions;

import com.project.db.LocalDB;
import com.project.db.ScanReader;
import com.project.members.Customer;
import com.project.pjzero.*;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class EmployeeActions {
	static ScanReader sc = new ScanReader(System.in);
	static LocalDB localDB = new LocalDB();
	
	final static Logger logTracker = Logger.getLogger(EmployeeActions.class);
			
	public static void adminLogin() throws IOException, SQLException {		
//		String username = "admin";
//		String password = "admin123";
		String username = "1";
		String password = "1";
		
		System.out.println("-=Please enter your *User name*=-");
		String inputUser = sc.scanString();		
		System.out.println("-=Please enter your *Password*=-");
		String inputPass = sc.scanString();
	    	    
	    if (inputUser.equals(username) && inputPass.equals(password)) {	    	
	    	System.out.println("-=Your in a system=-");
	    	System.out.println("*************************\n");
	    	Menu.adminMenu();
	    } else {
	    	System.out.println("-=Your *UserName* or *Password* don't match. Please try again=-");
	    	System.out.println("*************************\n");
	    	Menu.loginMenu();
	    }
	}
	
	public static void employeeLogin() throws IOException, SQLException {
//		String username = "employ";
//		String password = "employ123";
		
		String username = "1";
		String password = "1";
				
		System.out.println("-=Please enter your *User name*=-");		
		String inputUser = sc.scanString();
		System.out.println("-=Please enter your *Password*=-");
	    String inputPass = sc.scanString();
	    	    
	    
	    if (inputUser.equals(username) && inputPass.equals(password)) {	    	
	    	System.out.println("-=Your in a system=-");
	    	System.out.println("*************************\n");
	    	Menu.employeeMenu();
	    } else {
	    	System.out.println("-=Your *UserName* or *Password* don't match. Please try again=-");
	    	System.out.println("*************************\n");
	    	Menu.loginMenu();
	    }
	}
	
	public static void userLogin() throws IOException, SQLException {
//			String username = "user";
//			String password = "user123";
				
			//String password = "1";
			
			System.out.print("Please enter your \"username\": ");
			String inputUser = sc.scanString();			
			Object account = LocalDB.getWorkDB().get(inputUser);
			String username = ((Customer) account).getUsername();
			
			System.out.print("Please enter your \"Password\": ");
		    String inputPass = sc.scanString();
		    Object account2 = LocalDB.getWorkDB().get(inputPass);
			String password = ((Customer) account2).getUsername();
		   
		    if (inputUser.equals(username) && inputPass.equals(password)) {	    	
		    	System.out.print("Your in a system");
		    	System.out.println("\n");
		    	logTracker.info("Customer log in the system");
		    	Menu.customerMenu();
		    } else {
		    	System.out.print("Your \"UserName\" or \"Password\" don't match");
		    	System.out.println("\n");
		    	logTracker.warn("Customer tried to log in with wrong username\\password");
		    	Menu.loginMenu();
		    }
	 }
}
