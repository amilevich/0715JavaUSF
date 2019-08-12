package src.com.john.core;

import java.io.Serializable;

public abstract class Account implements Serializable
{
	private static final long serialVersionUID = 5615859490979707406L;

	private int id;
	
	private double balance;
	
	private boolean approved;
	
	private String jointOwner;
	private String primaryOwner;
	
	private boolean cancelled = false;
	
	public Account(int id) {
		this.id = id;
		this.balance = 0;
		approved = false;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public double getBalance() {
		return balance;
	}
	void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getJointOwner() {
		return jointOwner;
	}

	void setJointOwner(User jointOwner) {
		if(jointOwner == null)
			this.jointOwner = null;
		else
			this.jointOwner = jointOwner.getUsername();
	}
	
	public String getPrimaryOwner() {
		return primaryOwner;
	}
	
	void setPrimaryOwner(User primaryOwner) {
		this.primaryOwner = primaryOwner.getUsername();
	}

	public void setApproved(boolean status) {
		this.approved = status;
	}
	
	public boolean isApproved() {
		return approved;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void cancelAccount()
	{
		this.cancelled = true;
	}
	
	public boolean isCancelled()
	{
		return this.cancelled;
	}
	
	public void setCancelled(boolean cancelled)
	{
		this.cancelled = cancelled;
	}

	public abstract double withdraw(double amount);
}