package com.bank.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CustomerDAOImpl implements CustomerDAO, Serializable  {

	final static Logger loggy = Logger.getLogger(CustomerDAOImpl.class);
	private static final long serialVersionUID = -3603729035321881717L;
	public static List<Customer> customers = new ArrayList<Customer>();
	public Customer cur;

	public CustomerDAOImpl(String name, String password, int type) {
		if (!customers.contains(Customer.Search(name, password, type))) {
			customers.add(new Customer(name, password, type));
			System.out.println("Account has been created!");
		} else {
			System.out.println("Could not complete, username or password already exists...");
		}
	}
	
	public CustomerDAOImpl() {}

	@Override
	public boolean Open(String name, String pass) {

		if (Customer.Search(name, pass, 1) != null && Customer.Search(name, pass, 1).getApproved() == true) {
			cur = Customer.Search(name, pass, 1);
			return true;
		}
		System.out.println("Could not find account, or account has not been approved...");
		return false;
	}

	@Override
	public double Withdraw(Double amt) {
		if (cur.getBalance() >= amt) {
			cur.setBalance(cur.getBalance() - amt);
			loggy.info(amt + " was withdrawn from " + cur.getName() + "'s Account");
			System.out.println("You now have " + cur.getBalance() + " in your account.");
			return cur.getBalance();
		} else {
			System.out.println("Cannot Complete, Insufficient Funds...");
			return cur.getBalance();
		}
	}

	@Override
	public double Deposit(Double amt) {
		if (amt > 0) {
			cur.setBalance(cur.getBalance() + amt);
			loggy.info(amt + " was deposited into " + cur.getName() + "'s Account");
			System.out.println("You now have " + cur.getBalance() + " in your account.");
			return cur.getBalance();
		} else {
			System.out.println("Cannot deposit a negative or zero amount...");
			return cur.getBalance();
		}
	}

	@Override
	public double Transfer(String name, String password, Double bal, String relate) {
		
		Customer cur2 = Customer.Search(name, password, 1);
		if (relate.equals("to")) {
			if (cur.getBalance() >= bal) {
				cur.setBalance(cur.getBalance() - bal);
				cur2.setBalance(cur2.getBalance() + bal);
				loggy.info(bal + " was withdrawn from " + cur.getName() + " and depositied into " + cur2.getName());
				System.out.println("You now have " + cur.getBalance() + " in your account.");
				return cur.getBalance();
			} else {
				System.out.println("Cannot Complete, Insufficient Funds");
				return cur.getBalance();
			}
		} else if (relate.equals("from")) {
			if (cur2.getBalance() >= bal) {
				cur2.setBalance(cur2.getBalance() - bal);
				cur.setBalance(cur.getBalance() + bal);
				loggy.info(bal + " was withdrawn from " + cur2.getName() + " and depositied into " + cur.getName());
				System.out.println("You now have " + cur.getBalance() + " in your account.");
				return cur.getBalance();
			} else {
				System.out.println("Cannot Complete, Insufficient Funds");
				return cur.getBalance();
			}
		} else {
			System.out.println("Error...");
			return cur.getBalance();
		}
	}

	@Override
	public void add(String name, String pass) {
		cur.name.add(name);
		cur.password.add(pass);
		System.out.println(name + " was added to the account");
		cur.setApproved(true);
	}
}