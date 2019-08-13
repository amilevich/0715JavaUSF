package com.bank.account;

import org.apache.log4j.Logger;

public class AccountImpl {

	private final static Logger loggy = Logger.getLogger(AccountImpl.class);
	AccountDAOImpl use = new AccountDAOImpl();
	Account acc, acc2;
	
	public void Create(String name, String pass) {
		use.insertAccount(new Account(), name);
		System.out.println("Account +  Created...");
	}
	
	public boolean Open(int accID) {
		acc = use.selectAccountByID(accID);
		if (acc != null && acc.getIsapproved() == 1) {
			System.out.println("Account " + acc.getAccountID() + " has been opened...");
			return true;
		}
		System.out.println("Could not find account, or account has not been approved...");
		return false;
	}
	
	public void AddUsername(String name) {
		use.insertUsernameToAccount(acc, name);
		System.out.println(name + " has been added to your account...");
	}
	
	public double Withdraw(Double amt) {
		if (acc.getBalance() >= amt) {
			acc.setBalance(acc.getBalance() - amt);
			loggy.info(amt + " was withdrawn from Account " + acc.getAccountID() + "'s Account");
			System.out.println("Deposit Successful...");
			System.out.println("You now have " + acc.getBalance() + " in your account.");
			return acc.getBalance();
		} else {
			System.out.println("Cannot Complete, Insufficient Funds...");
			return acc.getBalance();
		}
	}

	public double Deposit(Double amt) {
		if (amt > 0) {
			acc.setBalance(acc.getBalance() + amt);
			loggy.info(amt + " was deposited into Account " + acc.getAccountID() + "'s Account");
			System.out.println("Withdraw Successful...");
			System.out.println("You now have " + acc.getBalance() + " in your account.");
			return acc.getBalance();
		} else {
			System.out.println("Cannot deposit a negative or zero amount...");
			return acc.getBalance();
		}
	}

	public double Transfer(int id, Double bal) {
		
		acc2 = use.selectAccountByID(id);
		if (acc.getBalance() >= bal) {
			acc.setBalance(acc.getBalance() - bal);
			acc2.setBalance(acc2.getBalance() + bal);
			use.updateAccountBalance(acc2);
			loggy.info(bal + " was withdrawn from Account " + acc.getAccountID() + " and deposited into Account " + acc2.getAccountID());
			System.out.println("Transfer Successful...");
			System.out.println("You now have " + acc.getBalance() + " in your account.");
			return acc.getBalance();
		} else {
			System.out.println("Cannot Complete, Insufficient Funds");
			return acc.getBalance();
		}
	}
	
	public void Close() {
		use.updateAccountBalance(acc);
		System.out.println("Account has been closed...");
	}
	
	public void View(int accID) {
		acc = use.selectAccountByID(accID);
		if (acc != null) {
			System.out.println(acc.toString());
			System.out.println("For isapproved: 0 = not approved, 1 = approved.");
		} else {
			System.out.println("Account could not be found...");
		}
	}
	
	public void Approve_Deny(int accID, int app) {
		acc = use.selectAccountByID(accID);
		if (acc != null && app == 1) {
			acc.setIsapproved(1);
			use.updateAccountisapproved(acc);
			System.out.println("Account approved!");
		} else if (acc != null && app == 0) {
			acc.setIsapproved(0);
			use.updateAccountisapproved(acc);
			System.out.println("Account cancelled...");
		} else {
			System.out.println("Error: Account could not be found or incorrect input was entered...");
		}
	}
}