package com.customerScreen;

import java.util.ListIterator;
import java.util.Scanner;

import com.drivers.DataDBDriver;
import com.mainmenu.MainScreen;
import com.uncertainty.Account;
import com.uncertainty.Customer;

public class BankingInterfaceDeposit {
	public void MoneyTime() {
		DataDBDriver<Account> v = new DataDBDriver();
		for(Customer customer: MainScreen.customer) {
			System.out.println(customer.getId());
			System.out.println(customer.getName());
		}
		System.out.println("Select customer");
		Scanner in = new Scanner(System.in);
		String acct = in.nextLine();
		
		for (Account account: MainScreen.account) {
			if(account.getStatus() == 'a')
			System.out.println(account.getAccountNumber() + "|$" + account.getAmount());
			
		}
		System.out.println("Select Account");
		String idAccount = in.nextLine();
		System.out.println("Enter the amount.");
		double amount = in.nextDouble();
		ListIterator<Account> it = MainScreen.account.listIterator();
		Account ac;
		while (it.hasNext()) {
			ac = it.next();
		if(ac.getAccountNumber().equals(idAccount)){
			ac.setAmount(ac.getAmount() + amount);
			it.set(ac);
			break;
			
		}
		}
		v.updateFile(MainScreen.account, "./account.txt");
	}

}
