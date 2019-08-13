package com.revature.singles;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.maindriver.Loginmenu;
import com.revature.model.Junction;

public class AP {
	final static Logger loggy = Logger.getLogger(AP.class);
	
	public static void approveApplication() {
		
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		
		
		//Grabs pending accounts 
		JunctionDaoImpls junctiondaoimpls = new JunctionDaoImpls();
		List<Junction> alist = junctiondaoimpls.seeUnapprovedAccountsbyJunctiontable();
		
		for (int i = 0; i < alist.size(); i++) {
			System.out.println(alist.get(i).getAccountnumber() + " " + alist.get(i).getUsername());
		}
		
		System.out.println(	"\n Input the account number" +
							"\n ");

		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		String input = "";
		int inputKey = sc.nextInt();
		boolean flag = true;
		while (flag) {
			if ( accountdaoimpls.checkForaccount(inputKey) ) {

				accountdaoimpls.setStatus( inputKey, 1);
				loggy.info(inputKey + " was approved ");
		
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
