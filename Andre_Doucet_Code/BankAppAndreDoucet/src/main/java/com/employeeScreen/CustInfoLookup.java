package com.employeeScreen;

import com.mainmenu.MainScreen;
import com.uncertainty.Account;
import com.uncertainty.Customer;

public class CustInfoLookup {
	public void custInfoLookup() {
		for(Customer c: MainScreen.customer) {
			System.out.println(c.getName());
			System.out.println(c.getAddress());
			System.out.println(c.getTelephonenumber());
	}

}}
