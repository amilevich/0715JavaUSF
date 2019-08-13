package com.revature.singles;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.JunctionDaoImpls;
import com.revature.dao.UserbankDaoImpls;



public class Register {
	
	final static Logger loggy = Logger.getLogger(Register.class);
	
	public static void register() {
		
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		JunctionDaoImpls junctionDaoImpls = new JunctionDaoImpls();
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		
		
		String userinput = "LopezR013";
		while(userbankdaoimpls.checkForForUser(userinput)) {
			//inputs user name
			System.out.println("\n Please create an original User name ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			userinput = sc.nextLine();
		}
		
		String password1 = "foo";
		String password2 = "goo";
		while (!(password1.equals(password2))) {
			//inputs password
			System.out.println("\n Please enter a password ");
		
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);
			password1 = sc1.nextLine();
		
			//inputs password
			System.out.println("\n Please reenter a password  ");
			@SuppressWarnings("resource")
			Scanner sc2 = new Scanner(System.in);
			password2 = sc2.nextLine();
		}
		
		accountdaoimpls.createNewAccount();
		int newaccountnumber = accountdaoimpls.gethighestAccountNumber();
		
		
		junctionDaoImpls.createNewJunction(userinput, newaccountnumber);
		userbankdaoimpls.createNewUserbank(userinput,password1);
		System.out.println("Success");
		
		
		loggy.info("New account created. Accounnumber " + newaccountnumber + "Password " + password1);
		
		
	}

}
