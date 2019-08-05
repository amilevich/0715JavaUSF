package com.bank.project.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.bank.project.MainEntry;
import com.bank.project.model.Account;
import com.bank.project.model.Customer;
import com.bank.project.model.JointAccount;
import com.bank.project.services.JointAccountService;

public class JointAccountScreen {
	
	public void jointAccount(Customer customer) {
		Scanner sc = new Scanner(System.in);		
		List<Account> acct = new ArrayList<>();
		ListIterator<Account> iterator =  MainEntry.account.listIterator();
		Account account = new Account();
		JointAccount jAccount = new JointAccount();
		while(iterator.hasNext()) {
			account = iterator.next();
			if(account.getId().equals(customer.getId()) && account.getStatus() == 'A') {
				acct.add(account);
			}
		}
		
		for(Account jc: acct) {
			System.out.println(jc.getAccountNumber());
		}
		
		System.out.println("Enter the account to joint: ");
		String accountJoint = sc.nextLine();
		System.out.println("Enter the Customer Id: ");
		String customerId = sc.nextLine();
		
		jAccount.setIdCustomer(accountJoint);
		jAccount.setAccountNumber(customerId);
		jAccount.setStatus('P');
		
		JointAccountService jAcctService = new JointAccountService();
		
		jAcctService.createRegister(jAccount);
		
	}

}
