package com.revature.maindriver;

import java.io.IOException;
import java.util.Scanner;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.singles.AccessJointPoint;
import com.revature.singles.ApplyJointAccounts;
import com.revature.singles.Deposit;
import com.revature.singles.Transferfunds;
import com.revature.singles.Withdraw;



public class CustomerMenu {
	
public static void customerMenu(String usertracker) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		//1.withdraw,
		//2.deposit, and 
		//3.transfer funds between accounts
		//All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.

		while ( !("EXIT".equals(input))) {
			
			
			
			AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
			//Retrieves the account number from the database by user name
			JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
			int key = junctionDaoImpls.getAccountNumberByUserName(usertracker);
			
			
			//Retrieves the balance from the user name
			int tempbalance = junctionDaoImpls.getBalanceByUsername(usertracker);
			
			
			System.out.println(	"\n What would you like to do? ");
			System.out.println(	"\n Here is your Account number and Username" +
								"\n");
			System.out.println("    " + key + " " + usertracker);
			System.out.println(	"\n balance		" + tempbalance);
			
			
			System.out.println(	"\n What would you like to do?" +
								"\n Withdraw? 					DRAW" +
								"\n Deposit? 					DEPOS" +
								"\n Transfer Funds?				TRANS"  +
								"\n Apply Joint accounts				AJA"  +
								"\n Access Joint Menu				ACM"  +
								"\n Exit?						EXIT");
		
			input = sc.next();
			//1.withdraw,
			if ("DRAW".equals(input)) {
				
				//Withdrawing
				Withdraw.withdraw(key, tempbalance);
				
				
			//1.Account information	
			} else if ("DEPOS".equals(input)) {
				
				//Make a deposit
				Deposit.deposit(key, tempbalance);
			
			
			} else if ("TRANS".equals(input)) {
				
				//make a transaction
				Transferfunds.transferFunds(key, tempbalance);
				
			} else if ("AJA".equals(input)) {
				
				//apply for a joint account
				ApplyJointAccounts.applyjointaccount(key, usertracker);
				
			} else if ("EXIT".equals(input)){
				
				input = "EXIT";
			} else if ("ACM".equals(input)) {
				
				int thirdaccount = accountdaoimpls.getThirdAccountByAccountnumber(key);
				AccessJointPoint.access( usertracker, thirdaccount);
				
			} else {
				System.out.println("Try again!");
			}
			
			/////////////////////////////////////////////////////////////////////////////////////
		}
	}

}
