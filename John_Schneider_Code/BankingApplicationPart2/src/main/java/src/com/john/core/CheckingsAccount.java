package src.com.john.core;

import java.io.Serializable;

public class CheckingsAccount extends Account implements Serializable
{
	private static final long serialVersionUID = 7784222409964242376L;
	
	double overdraftFee = 10;
	
	public CheckingsAccount(int id)
	{
		super(id);
		this.setJointOwner(null);
	}
	
	public CheckingsAccount(int id, User primaryOwner, User jointOwner)
	{
		super(id);
		this.setJointOwner(jointOwner);
		this.setPrimaryOwner(primaryOwner);
	}
	
	public CheckingsAccount(int id, String primaryOwner, String jointOwner, double balance, double overdraftFee, boolean approved, boolean cancelled)
	{
		super(id);
		this.setPrimaryOwner(new Customer(primaryOwner,""));
		this.setJointOwner(new Customer(jointOwner,""));
		this.setBalance(balance);
		this.overdraftFee = overdraftFee;
		this.setApproved(approved);
		this.setCancelled(cancelled);
	}
	
	public double getOverdraftFee() {
		return this.overdraftFee;
	}
	
	@Override
	public double withdraw(double amount) {
		double dif = this.getBalance() - amount;
		this.setBalance(dif);
		
		if(dif < 0)
			this.setBalance(this.getBalance() - overdraftFee);
		
		return 1;	
	}
	
	@Override
	public String toString()
	{
		if(this.isCancelled()) {
			return "Checking Account: "+this.getId()+" has been closed.";
		}
		
		String jointOwner = "";
		String primaryOwner = this.getPrimaryOwner();
		if(!this.isApproved())
			return "Checking Account: "+this.getId()+" is not yet approved.";
		if(this.getJointOwner()!=null)
			jointOwner = ", Joint Owner: " + this.getJointOwner();
			
		return "Checking Account: "+this.getId()+", Balance: "+this.getBalance()+", Overdraft Fee: "+this.overdraftFee+", Primary Owner: "+primaryOwner+jointOwner;
	}
}