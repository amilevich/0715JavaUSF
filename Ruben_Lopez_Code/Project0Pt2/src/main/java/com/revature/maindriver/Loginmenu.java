package com.revature.maindriver;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.dao.UserbankDaoImpls;
import com.revature.model.Userbank;



public class Loginmenu {
	
	
	
	final static Logger loggy = Logger.getLogger(Loginmenu.class);
	
	
	
	
	static public void login(String input) throws IOException {
		
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		
		
		
		
		
		
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//Keeps account open if its login is valid
		boolean flag = true;
		
		//Keeps track of the login User name
		String usertracker ="";
		
		//A flag to determine if the account is Employee, Customer, or Administration.

		
		while (!(input.equals("LO"))) {
			
				
			if ( flag ) {
			//Input a UserName and password
				while ( !(userbankdaoimpls.checkForUserAndPassword( usertracker , input)) ) {
					
					
					
					
					System.out.println("\n Please input User Name");
					usertracker = sc.next();
					
					System.out.println("\n Please input password");
					input = sc.next();
				}
			}
			loggy.info(" User " + usertracker + " Was logged in");
			//Retrieves the account number from the database by user name
			JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
			int key = junctionDaoImpls.getAccountNumberByUserName(usertracker);
			
			int tempStatus = accountdaoimpls.getStatusByAccountNumber(key);
			
			if (tempStatus == 0) {
				System.out.println("\n Sorry, your account is pending");
				input = "LO";
			}
			
			//Marking in that the login was a success 
			flag = false;
			
		
			
			
			//getting privilege of the user name that was successfully logged in
			int tempPrivilege = ((Userbank)userbankdaoimpls.getUserbankByName(usertracker)).getPrivilege();
			
			
			if (tempStatus != 0) {
				System.out.println(	"\n	You are log in!");
				System.out.println(	"\n What would you like to do?"
					+ "\n");
				System.out.println(	"\n Logout?			LO" +
									"\n Customer Login Menu		CLM");
				if (tempPrivilege > 1) {
				
					//messages out Employee login
					System.out.println("\n Employee login menu		EL");
				}
				
				input = sc.next();
			}
			
			
			if ("EL".equals(input)) {
				
				//employee menu
				EmployeeMenu.empolyeeMenu(usertracker,tempPrivilege);
				
			} else if ("LO".equals(input)) {
				input = "LO";
			} else if ("CLM".equals(input)) {
				//customer menu
			
				
				CustomerMenu.customerMenu(usertracker);
				
			} else {
				System.out.println("\n try again");
			}
			
		}
		
	}
}
