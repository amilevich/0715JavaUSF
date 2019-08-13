package com.bankdb.project.screen;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bankdb.project.dao.account.JointAccountDao;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.dao.implement.ParametorDaoImpl;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.JointAccount;
import com.bankdb.project.model.ParametersDB;
import com.bankdb.project.model.Person;

public class OpenAccountScreen {
	final static Logger loggy = Logger.getLogger(OpenAccountScreen.class);
	public void openAccount(Person customer) {
		ParametorDaoImpl parameterDAO = new ParametorDaoImpl();
		AccountDAOImpl accountImplDAO = new AccountDAOImpl();
		ParametersDB parameterDB = new ParametersDB();
		JointAccountDao jAcountDAO = new JointAccountDao();
		Account account = new Account();
		JointAccount jAccount = new JointAccount();
		
		System.out.println("");
		System.out.println("");
		System.out.println("********************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("A C C O U N T    A P P L I C A T I O N       S C R E E N");
		System.out.println("");
		System.out.println("");
		System.out.println("********************************************************");
		
		parameterDB.setIdparameter(1);
		Scanner scanner = new Scanner(System.in);				
		System.out.println("Select kind account");
		String numberAcct = new String();
		parameterDB.setIdparameter(1);
		parameterDB = parameterDAO.findById(parameterDB);
		
		numberAcct +=  parameterDB.getSeqaccount();
		if(numberAcct.length() > 0) {
			String temp = new String();
			for(int i = 0 ; i <= 14 - numberAcct.length() ; i++) {
				temp += "0";
			}
			numberAcct = temp + numberAcct;
		}
		String kdAcct = new String();		
		int option;
		do {
			System.out.println("1 -> Checking account");
			System.out.println("2 -> Saving account");
			option = scanner.nextInt();
			switch(option){
			case 1: kdAcct = "C";
				    break;
			case 2: kdAcct = "S";
					break;
			default: System.out.println("No is a valid option");
					break;
			
			}		
		}while(option != 1 && option != 2 );
		
		double amount = 0.00;
		Date date = Date.valueOf(LocalDate.now());	
		String status = "P";//The application is pending
						
		account.setAccountNumber(numberAcct);
		account.setKindAccount(kdAcct);
		account.setAmount(amount);
		account.setDate(date);
		account.setStatus(status);
		
		jAccount.setUsername(customer.getUser());
		jAccount.setAccountnumber(account.getAccountNumber());	
		jAccount.setStatus("I");
		
		if(accountImplDAO.createRegister(account)) {
			jAcountDAO.createJoint(jAccount);
			parameterDAO.updateRegister(parameterDB);
			loggy.info(" Account created successful ");
		}
	}
}
