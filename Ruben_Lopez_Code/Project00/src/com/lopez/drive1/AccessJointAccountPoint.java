package com.lopez.drive1;
import com.lopez.drive1.Customer;

import java.util.Scanner;

public class AccessJointAccountPoint {

	public static void access(String tracker, int key) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		while ( !("EXIT".equals(input))) {
			
			double pbalance = ((Customer) FileIn.getLmao().get(key)).getBalance();
			System.out.println(	"\n What would you like to do? ");
			System.out.println(	"\n Here is your Joint Account number " +
								"\n");
			System.out.println("    " +Customer.getKeyByUser(tracker) + " " + tracker);
			System.out.println(	"\n balance		" + pbalance);

			//System.out.println(((Customer) FileIn.getLmao().get(UserInterface.getObjectTypeByUserName(tracker))).getBalance());
			System.out.println(	"\n What would you like to do?" +
								"\n Withdraw? 					DRAW" +
								"\n Deposit? 					DEPOS" +
								"\n Transfer Funds?				TRANS"  +
								"\n Make Joint accounts				MJA"  +
								"\n Access Joint account			AJA" +
								"\n Exit?						EXIT");
		
			input = sc.next();
			//1.withdraw,
			if ("DRAW".equals(input)) {
				
				//Withdrawing
				Withdraw.withdraw(tracker, key);
				
			//1.Account information	
			} else if ("DEPOS".equals(input)) {
				
				Deposit.deposit(tracker,key);
			
			//3.Personal information
			} else if ("TRANS".equals(input)) {
				
				TransferFunds.transferFunds(tracker,key);
				
			} else if ("MJA".equals(input)) {
				
				JointAccounts.jointAccount(key);
				
			} else if ("EXIT".equals(input)){
				
				input = "EXIT";
			} else   {
				System.out.println("Try again!");
			}
			
			/////////////////////////////////////////////////////////////////////////////////////
		}	
		
		
		
	}

	

}
