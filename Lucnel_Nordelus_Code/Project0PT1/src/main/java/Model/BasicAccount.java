package Model;

import Exceptions.AccountLimitException;
import Utils.BankingFileIOOperations;
import Utils.MyLogger;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.InvalidBalanceException;

public class BasicAccount extends Account {

	
	// Default constructor.....
	BasicAccount(){
	}

	public BasicAccount(char[] accountHolder,   Double ballance , char type) {
	
		super(accountHolder,ballance , type);
	}
	
	public void Withdraw(Double twbalance){
		
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
			
			Double limitBalance = 30000 - twbalance ;
			
			if(withdrawBalance > limitBalance ){
				
				// Throw Over Limit Exception.........
				throw new AccountLimitException("You are try to withdraw Over the limit." 
				                                + "\nYour Remaining withdraw limit is " + limitBalance);
				
			}
			
			else if(this.currentBalance >= withdrawBalance){
				
				this.currentBalance -= withdrawBalance;
                                String msg = ("Account Holder with name " 
                                                + String.valueOf(this.getAccountHolder()) + " has performed transaction of withdrawal.\n" 
                                                + "You have successfully withdraw " + withdrawBalance 
						+ " from your basic account." + "Remaining Balance = " + this.currentBalance);
					MyLogger.log(msg);
				System.out.println("You have successfully withdraw " + withdrawBalance 
						+ " from your basic account." + "Remaining Balance = " + this.currentBalance);		
			}
		}
		catch(InvalidBalanceException e){
			
			Withdraw(twbalance);
			
		} catch (AccountLimitException e) {
			
			Withdraw(twbalance);
			//e.printStackTrace();
		}
	}
}
