package com.bankdb.project.screen;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.log4j.Logger;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.VerifyNumberTwo;
import com.bankdb.project.AdminManager.MainEntry;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.dao.implement.TransactionDaoImpl;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;
import com.bankdb.project.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class TransferScreen {
	final static Logger loggy = Logger.getLogger(TransferScreen.class);
	public void addTransfer(Person customer) {
		Scanner scanner = new Scanner(System.in);
		AccountDAOImpl acc = new AccountDAOImpl();
		Transaction transaction = new Transaction();
		Transaction transaction1 = new Transaction();
		TransactionDaoImpl tscService  = new TransactionDaoImpl();
		List<Account> accounts = new ArrayList<>();
		VerifyNumber vf = new VerifyNumber();
		Account acct = new Account();
		Account acct1 = new Account();
		VerifyNumberTwo vf2 = new VerifyNumberTwo();
		long number = 0;
		HashMap<Long, Account> accountMap = new HashMap<>();
		long count = 1;
		String acctNumber1;
		String acctNumber2;
		long accountTemp = 0;
		
		System.out.println("");
		System.out.println("");
		System.out.println("**********************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("T R A N S F E R    S C R E E N");
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
				System.out.println("Enter account number from: ");
				acctNumber1 = scanner.nextLine();				
			}while(!vf.verifyNum(accountTemp, acctNumber1) );
			
			number = Long.parseLong(acctNumber1);
			acct = accountMap.get(number);
			acctNumber1 = acct.getAccountNumber();
			
			do {
				System.out.println("Enter account number to:");
				acctNumber2 = scanner.nextLine();
				if(acctNumber2.equals(acctNumber1)) System.out.println("You can't transfer on the same account");
			}while(!vf.verifyNum(accountTemp, acctNumber2) || acctNumber2.equals(acctNumber1));
						
			number = Long.parseLong(acctNumber2);
			acct1 = accountMap.get(number);
			acctNumber2 = acct1.getAccountNumber();
			double amount;
			String amountString;
			do {
				System.out.print("Enter amount to Transfer: ");
				amountString = scanner.nextLine();
			}while(!vf2.verifyNum(amountString));
			
			amount = Double.parseDouble(amountString);
			
			if(amount >  0) {		
				String kindTrans = new String();
//				acct.setAccountNumber(acctNumber1);
//				acct.setStatus("A");
//				acct = acc.findById(acct);
				if(acct != null) {
					if(acct.getAmount() >= amount) {
						Date dateTime = Date.valueOf(LocalDate.now());
						kindTrans = "W";
						transaction.setAccountnumber(acctNumber1);
						transaction.setAmount(amount);
						transaction.setDateTime(dateTime);
						transaction.setKindTransaction(kindTrans);			
						transaction.setObservation("Accounts transfer from " + acctNumber1 + " to "+ acctNumber2 +" day " + " dateTime " + " for a mount of: " + amount);
						tscService.createRegister(transaction);
						acct.setAmount(acct.getAmount() - amount);
						acc.updateRegister(acct);
						
						
						kindTrans = "D";
						transaction1.setAccountnumber(acctNumber2);
						transaction1.setAmount(amount);
						transaction1.setDateTime(dateTime);
						transaction1.setKindTransaction(kindTrans);			
						transaction1.setObservation("Accounts transfer from " + acctNumber1 + " to "+ acctNumber2 +" day " + " dateTime " + " for a mount of: " + amount);
						tscService.createRegister(transaction1);
						acct1.setAmount(acct1.getAmount() + amount);
						acc.updateRegister(acct1);
						loggy.info(" Accounts transfer from " + acctNumber1 + " to "+ acctNumber2 +" day " + " dateTime " + " for a mount of: " + amount);
					}else {
						System.out.println("You balance is: " + acct.getAmount() + " and the amount required "
								+ " is bigger and the balance " + amount );
						loggy.fatal("You balance is: " + acct.getAmount() + " and the amount required "
								+ " is bigger and the balance " + amount);
					}
				}
			}else {
				System.out.println("Negative or zero amount ");
				loggy.error( "Negative or zero amount " );
			}
		}else System.out.println("No accounts for this time");

	}

}
