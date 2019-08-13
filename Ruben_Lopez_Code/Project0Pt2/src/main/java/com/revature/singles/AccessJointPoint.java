package com.revature.singles;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.maindriver.Loginmenu;




public class AccessJointPoint {
	
	final static Logger loggy = Logger.getLogger(AccessJointPoint.class);
	
	public static void access(String tracker, int key) {
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		loggy.info("Account number " + key + " was access");
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		while ( !("EXIT".equals(input))) {
			
			
			//get balance
			int tempbalance = accountdaoimpls.getBalanceByAccountNumber(key);
			System.out.println(	"\n What would you like to do? ");
			System.out.println(	"\n Here is your Joint Account number " +
								"\n");
			System.out.println("    " + " " + tracker);
			System.out.println(	"\n balance		" + tempbalance);

			//System.out.println(((Customer) FileIn.getLmao().get(UserInterface.getObjectTypeByUserName(tracker))).getBalance());
			System.out.println(	"\n What would you like to do?" +
								"\n Withdraw? 					DRAW" +
								"\n Deposit? 					DEPOS" +
								"\n Transfer Funds?				TRANS"  +
								"\n Exit?						EXIT");
		
			input = sc.next();
			//1.withdraw,
			if ("DRAW".equals(input)) {
				
				//Withdrawing
				Withdraw.withdraw(key, tempbalance);
				
			//1.Account information	
			} else if ("DEPOS".equals(input)) {
				
				//Depositing
				Deposit.deposit(key, tempbalance);
			
			} else if ("TRANS".equals(input)) {
				
				//make a transaction
				Transferfunds.transferFunds(key, tempbalance);
				
			} else if ("EXIT".equals(input)){
				
				input = "EXIT";
			} else   {
				System.out.println("Try again!");
			}
			
			/////////////////////////////////////////////////////////////////////////////////////
		}	
		
		
		
	}
}
