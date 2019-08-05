package com.bank.customer;

public interface CustomerDAO {

	public boolean Open(String name, String pass);
	public double Withdraw(Double amt);
	public double Deposit(Double amt);
	public double Transfer(String name, String password, Double bal, String relate);
	public void add(String name, String pass);
	
}