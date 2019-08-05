package com.bank.project.dao.customer;

import java.util.ArrayList;
import java.util.List;

import com.bank.project.FileWriterTXT;
import com.bank.project.model.Customer;

public class CreateCustomerDao {
	
	public boolean createCustomer(Customer customer) {
		FileWriterTXT<Customer> filename = new FileWriterTXT();
		return filename.writerFile(customer, "./DataBase/Custumer.txt");
	}


}
