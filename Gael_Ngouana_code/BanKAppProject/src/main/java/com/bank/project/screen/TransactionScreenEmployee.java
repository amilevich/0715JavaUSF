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

public class TransactionScreenEmployee {
	
	public void addTransaction(Customer customer, char kindTrans) {
		Scanner scanner = new Scanner(System.in);
		Transaction transaction = new Transaction();
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
				System.out.println("#  Account: " + a.getAccountNumber() + " Kind Account: " + (a.getKindAccount() == 'S' ? "Saving":"Checking") + " ---- available ---- " + a.getAmount());
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			boolean flag = true;
			
			String acctNumber;
			do {
				System.out.println("Enter account number");
				acctNumber = scanner.nextLine();
				for(Account a : accounts) {
					if(a.getAccountNumber().equals(acctNumber)) {
						flag = false;
					}
				}			
			}while(flag);
			
			System.out.print("Enter amount: ");
			double amount = scanner.nextDouble();
			
			
			if(amount >  0) {		
			
				LocalDateTime dateTime = LocalDateTime.now();
			
				transaction.setId(customer.getId());
				transaction.setAccountNumber(acctNumber);
				transaction.setAmount(amount);
				transaction.setDateTime(dateTime);
				transaction.setKindTransaction(kindTrans);
				
				if(kindTrans == 'D' || kindTrans == 'W') {
					transaction.setObservation((kindTrans == 'D' ? "Deposit":"Withdraw") + " day " + " dateTime " + " Account number: " + acctNumber);
					 tscService.createRegister(transaction);
				} 
			}else {
				System.out.println("Negative or zero amount ");
			}
		}
	}
}
