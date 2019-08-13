package com.revature.singles;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.dao.UserbankDaoImpls;
import com.revature.model.Userbank;

public class APJ {
	
	final static Logger loggy = Logger.getLogger(APJ.class);

	public static void approve() {
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		
		
		
		//gets accounts that are viable for joints
		
		List<Userbank> userbanklist =  userbankdaoimpls.selectAllUserbank();
		
		
		for (int i = 0; i < userbanklist.size(); i++) {
			
			if (accountdaoimpls.checkIfJoinable(userbanklist.get(i).getUsername())) {
				System.out.println(userbanklist.get(i).getUsername());
			}
		}
		
		System.out.println(	"\n Here are all of the userAccounts that are viable for joint accounts" +
							"\n please select the user name that you would like to approve for joint accounts");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String usernameinput = sc.next();
		
		
		System.out.println("\n Please wait");
		
		
		int firstAccount = junctionDaoImpls.getAccountNumberByUserName(usernameinput);
		int secondAccount = accountdaoimpls.getStatusByAccountNumber(firstAccount);
		
		loggy.info(firstAccount + " " + secondAccount + " Accounts were approved");
		//creates an empty slot
		accountdaoimpls.createNewAccount();
		
		
		//grabs empty slot
		int thirdAccount = accountdaoimpls.gethighestAccountNumber();
		//resets the status to 1
		accountdaoimpls.setStatus(firstAccount, 1);
		//resets the status to 1
		accountdaoimpls.setStatus(secondAccount, 1);
		
		accountdaoimpls.setThirdAccount(firstAccount, thirdAccount);
		
		accountdaoimpls.setThirdAccount(secondAccount, thirdAccount);
		
		

	}

}
