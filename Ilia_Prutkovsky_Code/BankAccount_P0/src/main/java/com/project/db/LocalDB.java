package com.project.db;

import com.project.actions.EmployeeActions;
import com.project.members.*;
import com.project.pjzero.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class LocalDB {
	
	static ScanReader sc = new ScanReader(System.in);
	public static String name, name2;	

	final static Logger logTracker = Logger.getLogger(EmployeeActions.class);

	static HashMap<String, Object> tempDB = new HashMap<String, Object>(); 
	static HashMap<String, Object> workDB = new HashMap<String, Object>();
	static HashMap<String, Object> joinDB = new HashMap<String, Object>();
	
	

	public static HashMap<String, Object> getTempDB() {
		return tempDB;
	}

	public static void setTempDB(HashMap<String, Object> tempDB) {
		LocalDB.tempDB = tempDB;
	}

	public static HashMap<String, Object> getWorkDB() {
		return workDB;
	}

	public static void setWorkDB(HashMap<String, Object> workDB) {
		LocalDB.workDB = workDB;
	}

	public static void addToTempDB() throws IOException {
		Customer newCust = new Customer(null, null, null, null, null, 0, 0.0);
		tempDB.put(newCust.getUsername(), newCust);
		System.out.println("Your profile was created succesfully \n");
		logTracker.warn("new account was created");
		//Menu.mainMenu();
	}

	public static void readFromTempDB() throws IOException, SQLException {
		Iterator<Entry<String, Object>> itr = tempDB.entrySet().iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		logTracker.warn("information about account was read");
		Menu.mainMenu();
	}

	public static void copyToWorkDB(String key) throws IOException {
		System.out.println("Users that are waiting approving: \n" + tempDB.entrySet());
		System.out.println("Please input customer name for approving: ");
		name = sc.scanString();
		workDB.put(name, tempDB.get(name));		
		tempDB.remove(name);
		System.out.println("You account was approved: " + name);
		logTracker.warn("new account was approved");
	}

	public static void deleteFromTempDB() throws IOException {
		System.out.println("Please input customer name for canceling: ");
		Iterator<Entry<String, Object>> itr = tempDB.entrySet().iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		name = sc.scanString();
		tempDB.remove(name);
		logTracker.warn("new account was delete: " + name);
	}

	public static void deleteFromWorkDB() throws IOException {
		System.out.println("Please input customer name for canceling: ");
		Iterator<Entry<String, Object>> itr = workDB.entrySet().iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		name = sc.scanString();
		workDB.remove(name);
		logTracker.warn("approved account was delete: " + name);
	}

	public static void readFromWorkDB() throws IOException {
		Iterator<Entry<String, Object>> itr = workDB.entrySet().iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}

	public static void customerDeposit(String key, double depositAmount) throws IOException {
		System.out.print("Please input your \"username\" to make deposit: ");		
		name = sc.scanString();		        
		if (workDB.get(name) != null) {
			Object account = workDB.get(name);
			double currentBalance = ((Customer) account).getAccountBalance();
			System.out.println("Please input amount of your deposit");
			double custAmount = sc.scanDouble();
			if (currentBalance >= 0) {
				currentBalance += custAmount;
				((Customer) account).setAccountBalance(currentBalance);
				System.out.println("Your balance now: " + ((Customer) account).getAccountBalance());
			} else {
				System.out.println("You current balance 0.0");
			}
		}		
	}

	public static void customerWithdraw(String key, double withdrawAmount) throws IOException {
		System.out.print("Please input your \"username\" to make withdraw: ");		
		name = sc.scanString();		
		if (workDB.get(name) != null) {
			Object account = workDB.get(name);
			double currentBalance = ((Customer) account).getAccountBalance();
			System.out.println("Your balance: " + currentBalance);
			System.out.println("Please input amount of your withdraw");
			double custAmount = sc.scanDouble();
			if ((currentBalance >= custAmount) && (currentBalance > 0)) {
				currentBalance -= custAmount;
				((Customer) account).setAccountBalance(currentBalance);
				System.out.println("Your balance now: " + ((Customer) account).getAccountBalance());
			} else {
				System.out.println("You don't have enough money on your account");
			}
		}
	}

	public static void customerBalanceTransfer(String key, double transferAmount) throws IOException {
		System.out.print("Please input your name: ");		
		name = sc.scanString();		
		if (workDB.get(name) != null) {
			Object account = workDB.get(name);
			double currentBalance = ((Customer) account).getAccountBalance();
			System.out.println("Your balance: " + currentBalance);
			System.out.println("Please input amount to transfer");
			double custAmount = sc.scanDouble();
			if ((currentBalance >= custAmount) && (currentBalance > 0)) {
				currentBalance -= custAmount;
				((Customer) account).setAccountBalance(currentBalance);
				System.out.println("Your balance now: " + ((Customer) account).getAccountBalance());
			} else {
				System.out.println("You don't have enough money to make a transfer");
			}
			System.out.print("Please input name of customer to make the transfer: ");
			name2 = sc.scanString();
			if (workDB.get(name2) != null) {
				Object account2 = workDB.get(name2);
				double currentBalance2 = ((Customer) account2).getAccountBalance();
				((Customer) account).setAccountBalance(currentBalance2 + custAmount);
				System.out.println("Balance of " + name2 + " now: " + ((Customer) account).getAccountBalance());
			}
		}
	}

//	public static void customersJoin(String key) throws IOException {
//		System.out.print("Please input name of first account(main) for joining: ");
//		name = sc.scanString();
//		if (workDB.get(name) != null) {
//			
//			System.out.print("Please input name of second account for joining: ");
//			name2 = sc.scanString();
//			if (workDB.get(name2) != null) {
//				
//				System.out.println("Please wait two accounts try to join: ");
//				//joinDB.put(name, (workDB.get(name) + workDB.get(name)));
//				Object account = workDB.get(name);
//				Object account2 = workDB.get(name2);
//				//Object joinAccount = ((Customer) joinAccount).setFirstName(((Customer) account).getFirstName() + ((Customer) account2).getFirstName());
//				//Check and create new class for Join Accounts
//				workDB.remove(name);
////				joinDB.put(name, workDB.get(name2));		
//				workDB.remove(name2);
//				System.out.println("Two accounts was joined: " + name);
//				Object account3 = joinDB.get(name);				
//				System.out.println(account);
//			}
//		}
//	}	
}
