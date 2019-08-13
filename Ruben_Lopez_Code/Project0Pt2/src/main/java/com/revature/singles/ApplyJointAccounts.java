package com.revature.singles;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.dao.UserbankDaoImpls;
import com.revature.model.Userbank;

public class ApplyJointAccounts {
	
	
	
	final static Logger loggy = Logger.getLogger(ApplyJointAccounts.class);

	public static void applyjointaccount(int key, String usertracker) {
		// TODO Auto-generated method stub
		System.out.println("\n Here are all of the available");
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		
		List<Userbank> userbanklist = userbankdaoimpls.selectAllUserbank();
		
		//gets all of the user names
		for (int i = 0; i < userbanklist.size(); i++) {
			System.out.println(" " + userbanklist.get(i).getUsername());
		}
		
		
		// checks if the user name exist while not being the user the original not applying for the joint account
		String inputusername = " ";
		while( usertracker.equals(inputusername)  |   ( !(userbankdaoimpls.checkForForUser(inputusername) ) ) )   {
			//inputs user name
			System.out.println("\n Please enter a current User name that you wish to have a joint account with ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			inputusername = sc.nextLine();
		}
		
		//grabs the account number that is desired to make an joint account with
		int tempNumber = junctionDaoImpls.getAccountNumberByUserName(inputusername);
		
		accountdaoimpls.setStatus(key, tempNumber);
		loggy.info("Account number " + key + " is pending on " + tempNumber);
	}

}
