package com.bank.employee;

import com.bank.customer.Customer;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void View(String username, String password) {
		if (Customer.Search(username, password, 1) != null) {
			System.out.println(Customer.Search(username, password, 1).toString());
		} else {
			System.out.println("Account could not be found...");
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
}