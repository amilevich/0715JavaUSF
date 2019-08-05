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
		String primaryOwner = this.getPrimaryOwner().getUsername();
		if(!this.isApproved())
			return "Checking Account: "+this.getId()+" is not yet approved.";
		if(this.getJointOwner()!=null)
			jointOwner = ", Joint Owner: " + this.getJointOwner().getUsername();
			
		return "Checking Account: "+this.getId()+", Balance: "+this.getBalance()+", Overdraft Fee: "+this.overdraftFee+", Primary Owner: "+primaryOwner+jointOwner;
	}
}