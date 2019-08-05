package com.bank.project.dao.customer;

import java.util.ListIterator;

import com.bank.project.FileWriterTXT;
import com.bank.project.MainEntry;
import com.bank.project.model.Customer;

public class UpdateCustomerDao {
	
	public boolean updateCustomer(Customer customer) {
		FileWriterTXT<Customer> filename = new FileWriterTXT();		
		ListIterator<Customer> ctmriterator = MainEntry.custumer.listIterator();
		boolean flag = false;
		while(ctmriterator.hasNext()) {
			Customer cust = new Customer();
			cust = ctmriterator.next();
			if(cust.getId().equals(customer.getId())) {
				cust.setUser(customer.getUser());
				cust.setPwd(customer.getPwd());
				ctmriterator.set(cust);	
				flag = true;
				break;
				
			}
		}	
		
		if(flag) return filename.updateFile(MainEntry.custumer, "./DataBase/Custumer.txt");
		else return false;
		
		
//		for(Customer c : MainEntry.custumer) {
//			System.out.println(c);
//		}
		
	}

}
