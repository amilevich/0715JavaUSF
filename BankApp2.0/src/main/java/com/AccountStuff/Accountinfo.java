package com.AccountStuff;

import java.util.Scanner;

import com.bank.app.mainInterface.Accountinfoimpl;
import com.sequenceStuff.UpdateSequenceDAO;
import com.sequenceStuff.findSequenceaccountDAO;

public class Accountinfo {
	static long account_number;
	static double balance;
	static int status;
	static String username;
	
	
	public static void myCustRegistration(String username) {
		Accountinfoimpl acc = new Accountinfoimpl();
		Accountinfo acc2 = new Accountinfo();
		Accounts act = new Accounts();
		findSequenceaccountDAO findseq = new findSequenceaccountDAO();
		UpdateSequenceDAO upseq = new UpdateSequenceDAO();
		
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Account Number:");
		//account_number = sc.nextLong();
		//System.out.println("Balance:");
		//balance = sc.nextDouble();
		//Populating the Pojo!
		act.setAccount_number(findseq.selectSequence());
		act.setBalance(0);
		act.setStatus(status);
		act.setUsername(username);
		
		
		acc.insert(act);
		upseq.updateSequence();
	}

}
