package com.revature.singles;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;



public class Deposit {
	
	final static Logger loggy = Logger.getLogger(Deposit.class);
	
	public static void deposit(int key, int tempbalance ) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		
		
		boolean flag = true;
		while (flag) {
			System.out.println("\n Please insert cash or check");
			
			
			int input = sc.nextInt();
		
		
			if ( (input < 0)) {
				System.out.println("\n Error, do you like losing money");
			} else if (input == 0) {
				
				System.out.println("\n EXITING");
				
				flag = false;
			} else if ( input > 0){
				
				
				System.out.println("\n .....depositing");
				loggy.info("Ammount deposited " + input);
				//Simple arithmetic
				tempbalance = tempbalance + input;
				
				//depositing, balance etc
				AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
				accountdaoimpls.setBalacne(key, tempbalance);
				flag = false;
				
				System.out.println("\n Balance is now " + tempbalance );
		
			}
		
		
		}
		
	}

}
