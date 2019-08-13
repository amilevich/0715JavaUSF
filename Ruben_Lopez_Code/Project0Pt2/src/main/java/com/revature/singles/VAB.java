package com.revature.singles;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;



public class VAB {
	
	
	
	
	
public static void vAB() {
	
	
		
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		
		System.out.println(	"\n Input the account number" +
							"\n ");
		
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		String input = "";
		int inputKey = sc.nextInt();
		boolean flag = true;
		while (flag) {
			if ( accountdaoimpls.checkForaccount(inputKey) ) {

				int tempbalance = accountdaoimpls.getBalanceByAccountNumber(inputKey);
				System.out.println(	"\n The balance amount for account " +
							inputKey + 
							"\n is " + 
							"\n" + tempbalance);
				flag = false;
			} else {
				
				//Incorrectly put in a non existing account
				System.out.println(	"\n Account not found!" +
									"\n Want to 'Try again' "+
									"\n Or 'exit' ");
				input = sc.next();
				if ( "exit".equals(input)) {
					flag = false;
				} else {
					System.out.println(	"\n Input the account number" +
										"\n ");
					inputKey = sc.nextInt();
				}
			}
		}
	}

}
