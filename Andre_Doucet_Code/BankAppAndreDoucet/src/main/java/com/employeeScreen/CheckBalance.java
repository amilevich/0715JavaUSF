package com.employeeScreen;

import com.mainmenu.MainScreen;
import com.uncertainty.Account;
import com.uncertainty.Customer;

public class CheckBalance {
	public void chequeBal() {
	for(Account a: MainScreen.account) {
		System.out.println(a.getAccountNumber() + "|" + a.getId() + "|$" + a.getAmount());
//		System.out.println(a.getAccountNumber());
//		System.out.println(a.getId());
	}
	}
}
