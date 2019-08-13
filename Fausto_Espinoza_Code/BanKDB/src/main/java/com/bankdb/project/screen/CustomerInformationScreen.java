package com.bankdb.project.screen;

import java.util.ArrayList;
import java.util.List;

import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;

public class CustomerInformationScreen {
	public void infCustomer(Person customer) {
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		List<Account> account = new ArrayList<>();
		
		System.out.println(" Name: " + customer.getNmPerson());
		System.out.println(" Address: " + customer.getAddress());
		System.out.println(" Phono: " + customer.getPhone());
		
		account = accountDAO.finAllRegister(customer, "A");
		
		if(account != null) {
			for(Account a : account) {
				System.out.println(" #. Account: " + a.getAccountNumber() + " Balances: "
						+ a.getAmount() + " type account: " + (a.getKindAccount() == "S"? "savin accoun" : "checking account"));
			}
		}
		
		
	}

}
