package src.com.john.core;

import java.io.Serializable;

public class SavingsAccount extends Account implements Serializable
{
	private static final long serialVersionUID = -3195857445622513490L;
	
	double minBalance = 0;
	int maxMonthlyWithdrawals = 10;
	int currentMonthlyWithdrawals = 0;
	
	//Constructors for different sets of parameters
	public SavingsAccount(int id)
	{
		super(id);
		this.setJointOwner(null);
	}
	
	public SavingsAccount(int id, User primaryOwner, User jointOwner)
	{
		super(id);
		this.setJointOwner(jointOwner);
		this.setPrimaryOwner(primaryOwner);
	}
	
	@Override
	public double withdraw(double amount) {
		//Get difference between current account balance and amount to be potentially withdrawn
		double dif = this.getBalance() - amount;
		//Only complete withdrawal if there are monthlywithdrawals available and account wont drop below minimum balance
		if(currentMonthlyWithdrawals < maxMonthlyWithdrawals && dif >= minBalance) {
			this.setBalance(dif);
			//increment the number of withdrawals made this month
			currentMonthlyWithdrawals++;
			return this.getBalance();
		}
		//return -1 to indicate withdrawal failed
		return -1;
	}
	
	@Override
	public String toString()
	{
		if(this.isCancelled()) {
			return "Savings Account: "+this.getId()+" has been closed.";
		}
		
		String jointOwner = "";
		String primaryOwner = this.getPrimaryOwner().getUsername();
		if(!this.isApproved())
			return "Savings Account: "+this.getId()+" is not yet approved.";
		if(this.getJointOwner()!=null)
			jointOwner = ", Joint Owner: " + this.getJointOwner();
			
		return "Savings Account: "+this.getId()+", Balance: " +this.getBalance()+
				", Minimum Balance: "+this.minBalance+", Current Monthly Withdrawals: "+this.currentMonthlyWithdrawals+
				", Maximum Monthly Withdrawals: "+this.maxMonthlyWithdrawals+", Primary Owner: "+primaryOwner+jointOwner;
	}
}