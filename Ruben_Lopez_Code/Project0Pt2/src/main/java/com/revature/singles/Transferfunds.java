package com.revature.singles;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;



public class Transferfunds {
	
	final static Logger loggy = Logger.getLogger(Transferfunds.class);
	
	public static void transferFunds(int key, int tempbalance) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		
		
		System.out.println("\n Which account would you like to transfer funds to ?");
		
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		System.out.println(accountdaoimpls.selectAllAccount());
		
		int otherKey = sc.nextInt();
			
		
				
		//checking for unique account selection
		boolean flag1 = true;
		while (flag1) {
				
			if ((key == otherKey) | (!(accountdaoimpls.checkForaccount(otherKey)))) {
				System.out.println(	"\n try again, can't transfer to yourself "+
									"\n Or account does not exist!!!");
			}else if (key != otherKey) {
				
				// A valid account to transfer to is found
				flag1 = false;
				System.out.println("\n Alright");
				
				
			}
		}		
			
			
		System.out.println("\n What is the amount you would like to transfer");
			
		int input = sc.nextInt();
		
		flag1 = true;
		while (flag1) {	
			if ((input > tempbalance) | (input < 0)) {
					System.out.println("\n Error, insuffient funds");
			} else if (input == 0) {
			
				System.out.println("\n EXITING");
			
				flag1 = false;
			} else if ( input < tempbalance){
				
				
			System.out.println("\n .....Transfering funds");
			
			
			//setting the balance
			accountdaoimpls.setBalacne( key, tempbalance - input);
			accountdaoimpls.setBalacne( otherKey , tempbalance + input);
			loggy.info(" Accountnumber " + key + "transfers " + (input) + " into " + otherKey);
			
			flag1 = false;
			
			System.out.println("\n Your Balance is now " + (tempbalance - input) );
			
			
			
			System.out.println("\n Thier balance is now " + tempbalance + input);
		
			}
		}
	}

}
