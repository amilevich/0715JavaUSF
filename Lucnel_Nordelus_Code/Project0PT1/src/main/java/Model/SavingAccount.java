package Model;

import Exceptions.AccountLimitException;
import Utils.BankingFileIOOperations;
import Utils.MyLogger;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.InvalidBalanceException;

public class SavingAccount extends Account {
	
	SavingAccount(){
		
	}

	public SavingAccount(char[] accountHolder,Double  balance , char type) {
		
		super(accountHolder, balance , type);
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
			
			Double limitBalance = 25000 - twbalance ;
			
			if(withdrawBalance > limitBalance ){
				
				// Throw Over Limit Exception.........
				throw new AccountLimitException("You are try to withdraw Over the limit." 
				                                + "\nYour Remaining withdraw limit is " + limitBalance);
				
			}
			
			else if ( (this.currentBalance >= 5000) && (withdrawBalance <= 5000)){
				
				char user_input ;
				boolean iscorrect = false ;
				Double temp = this.currentBalance - withdrawBalance ;
				
				if (temp > 4999){
					
					this.currentBalance -= withdrawBalance;
                                        String msg = ("Account Holder with name " 
                                                + String.valueOf(this.getAccountHolder()) + " has performed transaction of withdrawal.\n" 
                                                + "You have successfully withdraw " + withdrawBalance 
						+ " from your saving account." + "Remaining Balance = " + this.currentBalance);
					MyLogger.log(msg);
                                        System.out.println("You have successfully withdraw " + withdrawBalance 
							+ " from your saving account." + "Remaining Balance = " + this.currentBalance);
				}
				
				else {
					
					do{
						
						System.out.println("Insufficient Balance Amount:" + "\nYour Current Balance = " + this.currentBalance 
							       + "\nYour request for withdraw Amount = " + withdrawBalance + 
							       "\nIf you want to withdraw your requested Amount then Your account will be closed." + 
							       "\nDo you want to conitnue withdraw? Y/N");
						user_input = input.next().charAt(0);
						
						if (user_input == 'Y'){
							
							withdrawBalance += temp ;
							
							this.currentBalance -= withdrawBalance;
							iscorrect = true ;
							System.out.println("You have successfully withdraw " + withdrawBalance 
									          + " from your saving account." + "Remaining Balance = " + this.currentBalance);
						}
						
						else if (user_input == 'N'){
							
							iscorrect = true ;
						}
						else{
							
							System.out.println("Please Enter the valid input.");
						}
					}while(!iscorrect);
				}
			}
			
			else if(this.currentBalance > withdrawBalance){
				
				this.currentBalance -= withdrawBalance;
				System.out.println("You have successfully withdraw " + withdrawBalance + " from your saving account."
				                  + "Remaining Balance = " + this.currentBalance);
				
			}
		}
		
		catch(InvalidBalanceException e){
			
			Withdraw(twbalance);
			
		} catch (AccountLimitException e) {
			
			Withdraw(twbalance);
			
			e.printStackTrace();
		}
	}

}
