package com.revature.maindriver;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.dao.UserbankDaoImpls;
import com.revature.model.Junction;
import com.revature.singles.APJ;
import com.revature.singles.Delete;

public class Test {
	
	
	public static void main(String[] args) {
		
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		
		
		System.out.println(accountdaoimpls.selectAllAccount());
		//System.out.println(userbankdaoimpls.selectAllUserbank());
		
		System.out.println(userbankdaoimpls.checkForUserAndPassword( "LopezR013" , "12345"));
		//accountdaoimpls.setBalacne( 8, 300);
		//System.out.println(junctionDaoImpls.getBalanceByUsername("LopezR013"));
		
		//System.out.println(accountdaoimpls.checkForaccount(8));
		//System.out.println(userbankdaoimpls.checkForForUser("LopezR013"));
		
		List<Junction> alist = junctionDaoImpls.seeUnapprovedAccountsbyJunctiontable();
		
		for (int i = 0; i < alist.size(); i++) {
			System.out.println(alist.get(i).getAccountnumber() + " " + alist.get(i).getUsername());
		}
		
		//userbankdaoimpls.setUsernameByOldName("LopezR015", "LopezR013");
		System.out.println(userbankdaoimpls.checkForForUser("LopezR013"));
		userbankdaoimpls.setPasswordByUserName( "LopezR013" , "12345");
		System.out.println(userbankdaoimpls.checkForUserAndPassword( "LopezR013" , "12345"));
		
		//accountdaoimpls.createNewAccount();
		//int newaccountnumber = accountdaoimpls.gethighestAccountNumber();
		//junctionDaoImpls.createNewJunction("Dan",newaccountnumber );
		//userbankdaoimpls.createNewUserbank("Dan","123");
		
		
//		String usertracker = "LopezR013";
//		String inputusername = " ";
//		while( usertracker.equals(inputusername)  |   ( !(userbankdaoimpls.checkForForUser(inputusername) ) ) )   {
//			//inputs user name
//			System.out.println("\n Please create a current User name ");
//			@SuppressWarnings("resource")
//			Scanner sc = new Scanner(System.in);
//			inputusername = sc.nextLine();
//		}
		//System.out.println(accountdaoimpls.checkIfJoinable("LopezR013"));
		//(!(userbankdaoimpls.checkForForUser(inputusername)))
		Delete.delete();
		//APJ.approve();
		System.out.println(accountdaoimpls.gethighestAccountNumber());
		System.out.println(accountdaoimpls.getThirdAccountByAccountnumber(8));
	}
		
}
