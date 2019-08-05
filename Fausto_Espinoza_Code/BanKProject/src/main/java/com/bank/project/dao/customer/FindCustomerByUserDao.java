package com.bank.project.dao.customer;

import com.bank.project.MainEntry;
import com.bank.project.model.Customer;

public class FindCustomerByUserDao {
	
	public Customer findUser(String user, String pwd) {		
		for(Customer a : MainEntry.custumer) {
			if(a.getPwd().equals(pwd) && a.getUser().equals(user)) {
				return a;
			}
		}
		
		return null;
	}

}
