package com.bankdb.project.screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.dao.implement.TransactionDaoImpl;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;
import com.bankdb.project.model.Transaction;

public class CustomerConsult {
	
	public void consultCust(Person customer) {
		Scanner scanner = new Scanner(System.in);
		List<Transaction> transactionC = new ArrayList<>();
		List<Account> accounts = new ArrayList<>();
		Account acct = new Account();
		TransactionDaoImpl tscService  = new TransactionDaoImpl();
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		VerifyNumber vf = new VerifyNumber();
		HashMap<Long, Account> accountMap = new HashMap<>();
		long count = 1;
		long accountTemp = 0;
		String accountNumber ;
		long number = 0;
		
		System.out.println("");
		System.out.println("");
		System.out.println("****************************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("B A N K    A C C O U N T    M O V E M E N T S    S C R E E N");
		System.out.println("");
		System.out.println("");
		System.out.println("****************************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		if(customer != null) {
			System.out.println("Name: " + customer.getNmPerson());
			System.out.println("Address: " + customer.getAddress());
			System.out.println("Telephone Number: " + customer.getPhone());
			System.out.println("");
			System.out.println("");
		}
		
		accounts = accountDAO.finAllRegister(customer, "A");
		
		if(accounts != null) {
			for(Account a : accounts) {
				System.out.println(count +  " -> Account #:  " + a.getAccountNumber() + " available: " + a.getAmount() 
				+ " type of bank account: " + (a.getKindAccount().equals("S") ? "Saving account" : "checking account"));
				accountMap.put(count, a);
				++count;
			}			
		}
		accountTemp = --count;
		do {
			System.out.println("Enter the option ");
			accountNumber = scanner.nextLine();				
		}while(!vf.verifyNum(accountTemp, accountNumber) );
		
		number = Long.parseLong(accountNumber);
		acct = accountMap.get(number);
		
		transactionC = tscService.finAllRegister(acct);
		
		if(transactionC != null) {
			for(Transaction t : transactionC) {
				System.out.println("Date: " +  t.getDateTime() + " ammout: " + 
			    (t.getKindTransaction().equals("D") ? " Deposist of " : " Withdraw of ") 
			    + t.getAmount() + " " + t.getObservation());				
			}
			System.out.println("Press enter to continue");
			scanner.nextLine();
		}
		
	}

}
