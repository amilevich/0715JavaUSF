package com.revature.singles;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.dao.UserbankDaoImpls;

import com.revature.model.Userbank;

public class Delete {
	
	
	final static Logger loggy = Logger.getLogger(Delete.class);
	
	static public void delete() {
		
		
		//Generating all list to iterate through
				UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
				AccountDaoImpls accountdaoimples = new AccountDaoImpls();
				List<Userbank> userbanklist = userbankdaoimpls.selectAllUserbank();

				JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				
				System.out.println(	"\n Here is a list of the Current usernames" +
						"\n Which one of the following would you like to delete!");
				for (int i = 0; i < userbanklist.size(); i++) {
					System.out.println(" " + userbanklist.get(i).getUsername() );
				}
	
				String oldusername = sc.next();
	
				
		
				int deletednumber = junctionDaoImpls.getAccountNumberByUserName(oldusername );
				
				//deleting the account table
				accountdaoimples.deleteAccountbyAccountNumber(deletednumber);
				
				//deleting from junction table
				junctionDaoImpls.deleteByAccountNumber(deletednumber);
				
				//deleting from user bank
				 userbankdaoimpls.deleteUserbankByUsername( oldusername);
				 
				 System.out.println(	"\n Account deleted");
				
		
	}
}
