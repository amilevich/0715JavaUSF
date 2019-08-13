package com.revature.singles;

import java.util.Scanner;

import com.revature.dao.AccountDaoImpls;



public class VAI {
	
	public static void vAI() {
	
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

				System.out.println("\n AccountNumber: " + inputKey);
				System.out.println("\n Balance :" + accountdaoimpls.getBalanceByAccountNumber(inputKey));
				int statusKey = accountdaoimpls.getStatusByAccountNumber(inputKey);
				if (statusKey == 1) {
					System.out.println("\n Status : Active");
				} else {
					System.out.println("\n Status : Pending");
				}
				
				flag = false;
			} else {
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
