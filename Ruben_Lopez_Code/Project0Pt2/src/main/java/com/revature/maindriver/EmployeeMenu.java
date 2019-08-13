package com.revature.maindriver;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.dao.UserbankDaoImpls;
import com.revature.model.Account;
import com.revature.model.Userbank;
import com.revature.singles.VPI;
import com.revature.singles.Withdraw;
import com.revature.singles.VAB;
import com.revature.singles.VAI;
import com.revature.singles.AP;
import com.revature.singles.APJ;
import com.revature.singles.Delete;
import com.revature.singles.Deposit;
import com.revature.singles.EditAccount;


public class EmployeeMenu {
	
	public static void empolyeeMenu(String usertracker, int tempPrivilege) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();

		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		while ( !("EXIT".equals(input))) {
			
			if(tempPrivilege == 3) {
				System.out.println(	"\n Hello admin ");
			}
			
			System.out.println(	"\n What would you like to do? ");
			System.out.println(	"\n Here are all of the account numbers " +
								"\n");
			
			List<Account> alist = accountdaoimpls.selectAllAccount();
			for (int i = 0; i < alist.size(); i++) {
				System.out.print(" " +alist.get(i).getAccountnumber() + " ");
			}
			System.out.println(	"\n What would you like to do?" +
								"\n View account balance? 			VAB" +
								"\n View account information? 		VAI" +
								"\n View personnal information?		VPI"  +
								"\n Approve application			AP"  +
								"\n Approve joint accounts			APJ" +
								"\n Exit?					EXIT");
			if(tempPrivilege == 3) {
				System.out.println(	"\n Welcome admin" +
						"\n Edit an account			ADMINEDIT"+
						"\n Withdraw				ADMINDRAW"+
						"\n Depositing				ADMINDEPOS"+
						"\n Delete account				DEL");
			}
			
			input = sc.next();
			//2.Account balances
			if ("VAB".equals(input)) {
				
				//View account balance
				VAB.vAB();
				
			} else if ("VAI".equals(input)) {
				//views the account table for a given account number
				VAI.vAI();
			
			
			} else if ("VPI".equals(input)) {
				
				//View user bank table
				VPI.vPI();
				
			} else if ("AP".equals(input)) {
				
				AP.approveApplication();
				
			} else if ("EXIT".equals(input)){
				
				input = "EXIT";
			} else if("APJ".equals(input)) {
				
				//I'm doing this last lmao
				APJ.approve();
				
			} else if(("ADMINEDIT".equals(input)) && (tempPrivilege == 3)){
				
				//edit account menu
				EditAccount.editaccount();
				
				
			} else if (("ADMINDRAW".equals(input)) && (tempPrivilege == 3)) {
				
				List<Userbank> userbank = userbankdaoimpls.selectAllUserbank();
				
				for (int i = 0; i < userbank.size(); i++) {
					System.out.println(" " + userbank.get(i).getUsername());
				}
				System.out.println(	"\n Here is a list of all current users" +
									"\n which of the following would you like to withdraw");
				String tempUsername = sc.next();
				//administrative with draw
				
				int tempaccount = junctionDaoImpls.getAccountNumberByUserName(tempUsername);
				int tempbalacne = accountdaoimpls.getBalanceByAccountNumber(tempaccount);
				
				Withdraw.withdraw(tempaccount, tempbalacne);
				
				
			} else if (("ADMINDEPOS".equals(input)) && (tempPrivilege == 3)) {
				
				List<Userbank> userbank = userbankdaoimpls.selectAllUserbank();
				
				for (int i = 0; i < userbank.size(); i++) {
					System.out.println(" " + userbank.get(i).getUsername());
				}
				System.out.println(	"\n Here is a list of all current users" +
									"\n which of the following would you like to deposit");
				String tempUsername = sc.next();
				//administrative with draw
				
				int tempaccount = junctionDaoImpls.getAccountNumberByUserName(tempUsername);
				int tempbalacne = accountdaoimpls.getBalanceByAccountNumber(tempaccount);
				
				Deposit.deposit(tempaccount, tempbalacne);
				
				
			} else if (("DEL".equals(input)) && (tempPrivilege == 3)) {
				
				//Delete account
				Delete.delete();
				
			} else {
				System.out.println("Try again!");
			}
			
			/////////////////////////////////////////////////////////////////////////////////////
		}
		
	}

}
