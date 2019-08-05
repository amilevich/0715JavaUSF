package com.bank.project.screen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.bank.project.MainEntry;
import com.bank.project.AdminManager.EmployeeMenu;
import com.bank.project.model.Account;
import com.bank.project.model.Customer;
import com.bank.project.model.Transaction;
import com.bank.project.services.EmmTransactionService;
import com.bank.project.services.TransactionService;

public class TransferScreenEmployee {
	
	public void addTransfer(Customer customer) {
		Scanner scanner = new Scanner(System.in);
		Transaction transaction = new Transaction();
		Transaction transaction1 = new Transaction();
		EmmTransactionService tscService  = new EmmTransactionService();
		List<Account> accounts = new ArrayList<>();
		Account acct = new Account();
		
		ListIterator<Account> iterator = EmployeeMenu.account.listIterator();
		boolean flag1 = false;
		while(iterator.hasNext()) {
			acct = iterator.next();
			if(acct.getId().equals(customer.getId())  && acct.getStatus() == 'A') {
				accounts.add(acct);
				flag1 = true;
			}
		}
		
		if(flag1) {
			for(Account a : accounts) {
				System.out.println("#  Account: " + a.getAccountNumber() + " Kind Account: " + (a.getKindAccount() == 'S' ? "Saving":"Cheking") + " ---- available ---- " + a.getAmount());
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			boolean flag = true;
			
			String acctNumber1;
			do {
				System.out.println("Enter account number from: ");
				acctNumber1 = scanner.nextLine();
				for(Account a : accounts) {
					if(a.getAccountNumber().equals(acctNumber1)) {
						flag = false;
					}
				}			
			}while(flag);
			
			flag = true;
			
			String acctNumber2;
			do {
				System.out.println("Enter account number to:");
				acctNumber2 = scanner.nextLine();
				for(Account a : accounts) {
					if(a.getAccountNumber().equals(acctNumber2)) {
						flag = false;
					}
				}			
			}while(flag);
			
			System.out.print("Enter amount to Transfer: ");
			double amount = scanner.nextDouble();
			
			if(amount >  0) {		
				char kindTrans = ' ';
				LocalDateTime dateTime = LocalDateTime.now();
				kindTrans = 'W';
				transaction.setId(customer.getId());
				transaction.setAccountNumber(acctNumber1);
				transaction.setAmount(amount);
				transaction.setDateTime(dateTime);
				transaction.setKindTransaction(kindTrans);			
				transaction.setObservation("Accounts transfer from " + acctNumber1 + " to "+ acctNumber2 +" day " + " dateTime " );
				tscService.createRegister(transaction);
				
				
				kindTrans = 'D';
				transaction1.setId(customer.getId());
				transaction1.setAccountNumber(acctNumber2);
				transaction1.setAmount(amount);
				transaction1.setDateTime(dateTime);
				transaction1.setKindTransaction(kindTrans);			
				transaction1.setObservation("Accounts transfer from " + acctNumber1 + " to "+ acctNumber2 +" day " + " dateTime " );
				tscService.createRegister(transaction1);
				
			}else {
				System.out.println("Negative or zero amount ");
			}
		}

	}

}
