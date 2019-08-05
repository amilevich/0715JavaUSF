package Model;

import Utils.BankingFileIOOperations;
import Utils.MyLogger;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.InvalidBalanceException;

public class CurrentAccount extends Account {
	
	CurrentAccount(){
		
	}
	
	public CurrentAccount(char[] accountHolder,Double ballance ,char type) {
	
		super(accountHolder,ballance , type);
	}
	
	public void Withdraw(Double wbalance){
		
		System.out.println("Enter the Amount you want to withdraw");
		double withdrawBalance = input.nextDouble();
		
		char cType = getCurrencyType(input);
		
		if (cType == 'D' || cType == 'd'){
			
			withdrawBalance = (withdrawBalance);
		}
		
		try{
			
			if (withdrawBalance <= 0){
				
				throw new InvalidBalanceException("Exception occur that Withdraw Amount Must be greater than zero.");
			}
			
			else if (this.currentBalance >= withdrawBalance){
				
				this.currentBalance -= withdrawBalance;
                                String msg = ("Account Holder with name " 
                                                + String.valueOf(this.getAccountHolder()) + " has performed transaction of withdrawal.\n" 
                                                + "You have successfully withdraw " + withdrawBalance 
						+ " from your current account." + "Remaining Balance = " + this.currentBalance);
                                MyLogger.log(msg);
				System.out.println("You have successfully withdraw " + withdrawBalance 
						+ " from your current account." + "Remaining Balance = " + this.currentBalance);
			}	
		}
		
		catch(InvalidBalanceException e){
			
			Withdraw(0.0);
		}	
	}
}
