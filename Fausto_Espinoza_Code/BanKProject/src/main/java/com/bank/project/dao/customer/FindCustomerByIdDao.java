package com.bank.project.dao.customer;

import com.bank.project.MainEntry;
import com.bank.project.model.Customer;

public class FindCustomerByIdDao {
	
	public Customer findById(Customer customer) {	
		for(Customer a : MainEntry.custumer) {
			if(a.getId().equals(customer.getId())) {
				return a;
			}			
		}
		return null;
	}

}
