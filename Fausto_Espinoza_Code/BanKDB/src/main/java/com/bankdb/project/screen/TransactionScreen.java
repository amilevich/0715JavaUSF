package com.bankdb.project.screen;

import java.sql.Date;
import java.time.LocalDate;
import org.apache.log4j.Logger;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.VerifyNumberTwo;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.dao.implement.TransactionDaoImpl;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;
import com.bankdb.project.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TransactionScreen {
	final static Logger loggy = Logger.getLogger(TransactionScreen.class);
	public void addTransaction(Person customer, String kindTrans) {
		Scanner scanner = new Scanner(System.in);
		AccountDAOImpl acc = new AccountDAOImpl();
		Transaction transaction = new Transaction();
		TransactionDaoImpl tscService  = new TransactionDaoImpl();
		List<Account> accounts = new ArrayList<>();
		VerifyNumber vf = new VerifyNumber();
		Account acct = new Account();
		VerifyNumberTwo vf2 = new VerifyNumberTwo();
		long number = 0;
		HashMap<Long, Account> accountMap = new HashMap<>();
		long count = 1;
		long accountTemp = 0;
		String acctNumber;
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("**********************************************");
		System.out.println("");
		System.out.println("");
		System.out.println(kindTrans.equals("D") ? "D E P  O S I T    S C R E E N" : "W I T H D R A W    S C R E E N");
		System.out.println("");
		System.out.println("");
		System.out.println("**********************************************");
		
		accounts = acc.finAllRegister(customer, "A");
		
		if(accounts != null) {
			for(Account a : accounts) {
				System.out.println(count +" -> # Account: " + a.getAccountNumber() + " Kind Account: " + (a.getKindAccount().equals("S") ? "Saving":"Checking") + " ---- available ---- " + a.getAmount());
				accountMap.put(count, a);
				++count;
			}
			accountTemp = --count;
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			do {
				System.out.println("Enter the option ");
				acctNumber = scanner.nextLine();				
			}while(!vf.verifyNum(accountTemp, acctNumber) );
	
			number = Long.parseLong(acctNumber);			
			acct = accountMap.get(number);
			acctNumber = acct.getAccountNumber();
			
			System.out.print("Enter amount: ");
			double amount;
			String amountString;
			do {
				System.out.print("Enter amount: ");
				amountString = scanner.nextLine();
			}while(!vf2.verifyNum(amountString));
			
			amount = Double.parseDouble(amountString);
			
			
			if(amount >  0) {	
				if(acct != null) {
					if((acct.getAmount() > amount && kindTrans.equals("W")) || kindTrans.equals("D")) {
						Date dateTime = Date.valueOf(LocalDate.now());
						transaction.setAccountnumber(acctNumber);
						transaction.setAmount(amount);
						transaction.setDateTime(dateTime);
						transaction.setKindTransaction(kindTrans);			
						
						
						if(kindTrans.equals("D")  || kindTrans.equals("W") ) {					
							transaction.setObservation((kindTrans.equals("D")  ? "Deposit":"Withdraw") + " day " +  dateTime + " Account number: " + acctNumber + " for a mount of: " + amount);
							loggy.info("You made a "+(kindTrans.equals("D") ? "Deposit":"Withdraw") + " day " +  dateTime + " Account number: " + acctNumber + " for a mount of: " + amount);
							if(kindTrans.equals("D")){
								acct.setAmount(acct.getAmount() + amount);
								acc.updateRegister(acct);
								tscService.createRegister(transaction);
							}else if(kindTrans.equals("W")){
								if(acct.getAmount() >= amount) {
									acct.setAmount(acct.getAmount() - amount);
									acc.updateRegister(acct);
									tscService.createRegister(transaction);
								}else System.out.println("the amount exceeds your balance");
							}
						} 
					}
				}
			}else {
				System.out.println("Negative or zero amount ");
				loggy.error("Negative or zero");
			}
		}else System.out.println("No accounts for this time");
	}
}
