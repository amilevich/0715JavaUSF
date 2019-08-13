package com.revature.singles;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.UserbankDaoImpls;
import com.revature.model.Account;
import com.revature.model.Userbank;



public class EditAccount {
	
	final static Logger loggy = Logger.getLogger(EditAccount.class);
	
	public static void editaccount() {
		
		//Generating all list to iterate through
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		AccountDaoImpls accountdaoimples = new AccountDaoImpls();
		List<Userbank> userbanklist = userbankdaoimpls.selectAllUserbank();
		List<Account> accountlist = accountdaoimples.selectAllAccount();
		
		
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		// TODO Auto-generated method stub
		
		boolean flag = true;
		while (flag) {
			System.out.println(	"\n	What attirbute would you like to edit"+
							"\n	Username			USER"+
							"\n	password 			PASS"+
							"\n	privilege			PRIV"+
							"\n	status				STA"+
							"\n 	Exit				EXIT");
		
			input = sc.next();
			
			if ("USER".equals(input)){
				
				System.out.println(	"\n Here is a list of the Current usernames" +
									"\n Which one of the following would you like to edit");
				for (int i = 0; i < userbanklist.size(); i++) {
					System.out.println(" " + userbanklist.get(i).getUsername() );
				}
				
				String oldusername = sc.next();
				
				System.out.println(	"\n Please input a new username");
					
				String newusername = sc.next();
				//User name setter
				userbankdaoimpls.setUsernameByOldName( oldusername , newusername);					
				flag = false;
				loggy.info("Username was edited" + oldusername + " " + newusername + " ");
				
			} else if ("PASS".equals(input)) {
				
				System.out.println(	"\n Here is a list of the Current usernames" +
						"\n Which one of the following would you like to edit their password");
				for (int i = 0; i < userbanklist.size(); i++) {
					System.out.println(" " + userbanklist.get(i).getUsername() );
				}
	
				String oldusername = sc.next();
	
				System.out.println(	"\n Please input a new password");
		
				String newpassword = sc.next();
				//User name setter
				userbankdaoimpls.setPasswordByUserName( oldusername , newpassword);					
				flag = false;
				loggy.info("Password was edited" + oldusername + " " + newpassword + " ");
				
			} else if ("PRIV".equals(input)) {
				System.out.println(	"\n Here is a list of the Current usernames" +
						"\n Which one of the following users you would like to edit their privilege");
				for (int i = 0; i < userbanklist.size(); i++) {
					System.out.println(" " + userbanklist.get(i).getUsername() );
				}
	
				String oldusername = sc.next();
	
				System.out.println(	"\n Please input a new privilege"
						+ " 1 = Customer , 2 = Employee , 3 = Admin");
		
				int newprivilege = sc.nextInt();
				//User name setter
				userbankdaoimpls.setPrivilegeByUserName( oldusername , newprivilege);					
				flag = false;
				loggy.info("Privilege was edited" + oldusername + " " + newprivilege + " ");
				
			} else if ("STA".equals(input)) {
				System.out.println(	"\n Here is a list of the Current accounts" +
						"\n Which one of the following accounts you would like to edit their status");
				for (int i = 0; i < accountlist.size(); i++) {
					System.out.println(" " + accountlist.get(i).getAccountnumber() );
				}
	
				int currentaccountnumber = sc.nextInt();
	
				System.out.println(	"\n Please input a new status"
						+ " 1 = open , 0 = close ");
		
				
				int newstatus = sc.nextInt();
				//User name setter
				accountdaoimples.setStatus(currentaccountnumber, newstatus);			
				flag = false;
				loggy.info("Privilege was edited" + currentaccountnumber + " " + newstatus + " ");
			} else if ("EXIT".equals(input)) {
				
				flag = false;
				
			} else {
				
				System.out.println("Try again");
			}
		
		// TODO Auto-generated constructor stub
		}
		
	}

}
