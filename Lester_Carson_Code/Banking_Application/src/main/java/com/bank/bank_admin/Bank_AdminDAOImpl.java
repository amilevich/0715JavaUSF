package com.bank.bank_admin;

import org.apache.log4j.Logger;
import com.bank.customer.Customer;
import com.bank.customer.CustomerDAOImpl;

public class Bank_AdminDAOImpl extends CustomerDAOImpl implements Bank_AdminDAO {

	private static final long serialVersionUID = -4267041104972105313L;
	final static Logger loggy = Logger.getLogger(Bank_AdminDAOImpl.class);

	@Override
	public void View(String username, String password) {
		if (Customer.Search(username, password, 1) != null) {
			System.out.println(Customer.Search(username, password, 1).toString());
		} else {
			System.out.println("Account could not be found");
		}
	}

	@Override
	public void Approve(String username, String password, Boolean what) {
		if (what == true && Customer.Search(username, password, 1) != null) {
			Customer.Search(username, password, 1).setApproved(true);
			System.out.println("Account approved!");
		} else if (what == false && Customer.Search(username, password, 1) != null) {
			Customer.Search(username, password, 1).setApproved(false);
			System.out.println("Account denied...");
		} else {
			System.out.println("Account could not be found...");
		}
	}

	@Override
	public void Delete(String username, String password) {
		if (Customer.Search(username, password, 1) != null) {
			CustomerDAOImpl.customers.remove(Customer.Search(username, password, 1));
			System.out.println("Account has been removed...");
		} else {
			System.out.println("Account could not be found...");
		}
	}	
}