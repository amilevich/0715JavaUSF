package com.bank.project.dao.customer;

import java.util.ArrayList;
import java.util.List;

import com.bank.project.MainEntry;
import com.bank.project.model.Customer;

public class FindAllCustomerDao {
	
	public List<Customer> findAll(){
		return MainEntry.custumer;
	}
	
	

}
