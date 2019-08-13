package com.bankdb.project.screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.dao.implement.JointAccountDaoImpl;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.JointAccount;
import com.bankdb.project.model.Person;

public class JointAccountScreen {
	final static Logger loggy = Logger.getLogger(JointAccountScreen.class);
	public void jointAccount(Person customer) {
		Scanner scanner = new Scanner(System.in);
		List<Account> accounts = new ArrayList<>();
		AccountDAOImpl acc = new AccountDAOImpl();
		HashMap<Long, Account> accountMap = new HashMap<>();
		VerifyNumber vf = new VerifyNumber();
		AccesJointAccount jAccount = new AccesJointAccount();
		Person psn = new Person();
		long count = 1;
		long accountTemp = 0;
		String acctNumber;
		long number = 0;
		Account acct = new Account();
		JointAccount jAccnt = new JointAccount();
		JointAccountDaoImpl jAcountDAO = new JointAccountDaoImpl();
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("**********************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("J O I N T    A C C O U N T S   S C R E E N");
		System.out.println("");
		System.out.println("");
		System.out.println("**********************************************");
		
		psn = jAccount.accsesSystem("C", customer);
		
		if(psn != null) {
			accounts = acc.finAllRegister(psn, "A","I");
			
			if(accounts != null) {			
				for(Account a : accounts) {
					System.out.println(count +" -> # Account: " + a.getAccountNumber() + " Kind Account: " + (a.getKindAccount().equals("S") ? "Saving":"Checking") + " ---- available ---- " + a.getAmount());
					accountMap.put(count, a);
					++count;
				}
				accountTemp = --count;
				do {
					System.out.println("Enter the option ");
					acctNumber = scanner.nextLine();				
				}while(!vf.verifyNum(accountTemp, acctNumber) );
		
				number = Long.parseLong(acctNumber);			
				acct = accountMap.get(number);
				acctNumber = acct.getAccountNumber();
				
				jAccnt.setUsername(customer.getUser());
				jAccnt.setAccountnumber(acct.getAccountNumber());	
				jAccnt.setStatus("P");
				jAcountDAO.createRegister(jAccnt);
				loggy.info(" Account created successful ");
			}			
		}		
	}
}
