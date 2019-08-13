package com.revature.singles;

import java.util.List;
import java.util.Scanner;


import com.revature.dao.UserbankDaoImpls;
import com.revature.model.Userbank;

public class VPI {
	
	
	//View user bank table
	public static void vPI() {
		
		
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		List<Userbank> alist = userbankdaoimpls.selectAllUserbank();
		
		
		//Prints out all user names
		for (int i = 0; i < alist.size(); i++) {
			System.out.println(alist.get(i).getUsername());
		}
		
		System.out.println(	"\n Input the Username " +
							"\n ");

		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		String input = "";
		String usernameKey = sc.next();
		
		Userbank aUser = userbankdaoimpls.getUserbankByName(usernameKey);
		boolean flag = true;
		while (flag) {
			if ( userbankdaoimpls.checkForForUser(usernameKey) ) {

				System.out.println("\n Username: " + usernameKey);
				System.out.println("\n Password :" + aUser.getPassword());
				int privilegeKey = aUser.getPrivilege();
				if (privilegeKey == 1) {
					System.out.println("\n Privilege : Customer");
				} else if (privilegeKey == 2) {
					System.out.println("\n Privileges : Employee");
				} else {
					System.out.println("\n Privileges : Admin");
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
					usernameKey = sc.next();
				}
			}
		}
	}

	

}
