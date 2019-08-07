package com.banking.dao;

import com.banking.accounts.PendingAccount;
import com.banking.accounts.JointAccount;
import com.banking.database.AccountDataBase;
import com.banking.database.PendingDataBase;

public class AccountAccess {
	
	
	
	///////////////////////////////////////// ~ ~ ~ PendingDataBase ~ ~ ~ ////////////////////////////////////////////////////
	
	
	public static void saveAccount(Object client) {
		PendingDataBase.setPendingAccounts(client);

		}	
	
	
	public static void printAllAccounts() {
		PendingDataBase.printAccounts();
	}
	
	public static Object getAccount(String client) {
		System.out.println(PendingDataBase.viewAccount(client));
		return PendingDataBase.viewAccount(client);
	}
	
	public static void denyAccount(String client) {
		PendingDataBase.deleteAccount(client);
	}
	
	public static void approveAccount(String client) {
		if(((PendingAccount) PendingDataBase.getPendingAccount(client)).getStatus()=="pending") {
		((PendingAccount) PendingDataBase.getPendingAccount(client)).setStatus("Active");
		((PendingAccount) PendingDataBase.getPendingAccount(client)).setAccountNumber((int)(Math.random()*100000+1));
		PendingDataBase.pendingAccountApprovedToClientAccount(client);
		PendingDataBase.deleteAccount(client);
		}else if(((JointAccount) PendingDataBase.getPendingAccount(client)).getStatus()=="joint"){
			((JointAccount) PendingDataBase.getPendingAccount(client)).setAccountNumber((int)(Math.random()*100000+1));
			PendingDataBase.pendingAccountApprovedToClientAccount(client);
			PendingDataBase.deleteAccount(client);
		}
	}
	
	///////////////////////////////////////// ~ ~ ~ AccountDataBase ~ ~ ~ ////////////////////////////////////////////////
	
	
	public static void assignJointAccess(String username1, String username2) {  ////Joint Access Modifier
		AccountDataBase.assignJointAccess(username1, username2);
	}
	
	public static String validJointKey(String username) {//returns Valid Joint Key
		return AccountDataBase.validJointKey(username);
	}
	
	public static String validUserKey(String username) {//returns Valid USER Key --
		return AccountDataBase.validJointKey(username);
	}
	
	
	public static boolean validKey(String username) {
		return AccountDataBase.validKey(username);
	}
	
	
	
	public static void printAllActiveAccounts() {
		AccountDataBase.printAccounts();
	}
	
	public static void getActiveAccount(String client) {
		System.out.println( AccountDataBase.viewAccount(client));
	}
	
	public static void deposit(String client, double cashIn) { 
		double currentBalance = ((PendingAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance();
		((PendingAccount) AccountDataBase.getActiveAccount(client)).setAccountBalance(currentBalance + cashIn);
		double newAccountBalance = ((PendingAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance();
		System.out.println("You have deposited " + cashIn + " dollars. Your account balance is now: " + newAccountBalance);
	}
	
	public static void jointDeposit(String client, double cashIn) { 
		double currentBalance = ((JointAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance();
		((JointAccount) AccountDataBase.getActiveAccount(client)).setAccountBalance(currentBalance + cashIn);
		double newAccountBalance = ((JointAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance();
		System.out.println("You have deposited " + cashIn + " dollars. Your account balance is now: " + newAccountBalance);
	}
	
	
	public static void printBalance(String client) {
		System.out.println("You have " + ((PendingAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance() + " in your Checking account!");
	}
	
	public static void printJointBalance(String client) {///Testing
		System.out.println("You have " + ((JointAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance() + " in your Joint account!");
	}
	
	public static double getBalance(String client) {
		return ((PendingAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance();
	}
	
	public static void withdraw(String client,double cashOut) {
		double currentBalance = ((PendingAccount) AccountDataBase.getActiveAccount(client)).getAccountBalance();
		if(currentBalance > cashOut)
		((PendingAccount) AccountDataBase.getActiveAccount(client)).setAccountBalance(currentBalance - cashOut);	
	}
	
	public static void deleteAccount(String client) {
		AccountDataBase.deleteAccount(client);
	}
	
	//////////////////////////////////////////////~~~~~ADMIN~~~~~///////////////////////////////////////
	public static void adminPrintAllActiveAccounts() {
		AccountDataBase.adminPrintAccounts();
	}

	public static void adminPrintAllAccounts() {
		PendingDataBase.adminPrintAccounts();
	}
}
