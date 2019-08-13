package com.revature.singles;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;


public class Withdraw {
	final static Logger loggy = Logger.getLogger(Withdraw.class);
	
	public static void withdraw(int key, int tempbalance) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		
		boolean flag = true;
		while (flag) {
			System.out.println("\n How much would you like to withdraw");
			
			
			int input = sc.nextInt();
		
		
			if ((input > tempbalance) | (input < 0)) {
				System.out.println("\n Error, insuffient funds");
				System.out.println("\n Or trying to input a negative amount");
			} else if (input == 0) {
				
				System.out.println("\n EXITING");
				
				flag = false;
			} else if ( input < tempbalance){
				
				
				System.out.println("\n .....Withdrawing");
				
				//simple arithmetic
				
				tempbalance = tempbalance - input;
				
				//setting the balance
				AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
				accountdaoimpls.setBalacne( key, tempbalance);
				flag = false;
				
				System.out.println("\n Balance is now " + tempbalance );
				loggy.info(" Amount withdrawn " + input);
			}
		
		
		}
		
	}

}
