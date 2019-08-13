package com.bankdb.project.screen;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Scanner;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.AdminManager.EmployeeMenu;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;

public class CancelAccount {
	public void cnncel(Person customer) {
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		VerifyNumber vf = new VerifyNumber();
		String kind = new String();
		List<Account> accounts = new ArrayList<>();
		long count = 1;
		long accountTemp = 0;
		long number = 0;
		String accountNumber;
		AccountDAOImpl acc = new AccountDAOImpl();
		HashMap<Long, Account> accountMap = new HashMap<>();
		
		accounts = acc.finAllRegister(customer, "C");
		
		if(accounts != null) {	
			
			for(Account a : accounts) {
				System.out.println(count +" -> # Account: " + a.getAccountNumber() + " Kind Account: " + (a.getKindAccount().equals("S") ? "Saving":"Checking") + " ---- available ---- " + a.getAmount());
				accountMap.put(count, a);
				++count;
			}
			accountTemp = --count;
			
			do {
				System.out.println("Enter the Account to cancel ");
				accountNumber = scanner.nextLine();				
			}while(!vf.verifyNum(accountTemp, accountNumber) );
	
			number = Long.parseLong(accountNumber);
			account = accountMap.get(number);
			
			account.setStatus("C");
			
			if(!acc.updateRegister(account)) {
				System.out.println("It  couldn't update the account");
			}
		}
	}
}
