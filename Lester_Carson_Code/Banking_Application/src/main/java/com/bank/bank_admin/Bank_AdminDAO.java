package com.bank.bank_admin;

import com.bank.employee.EmployeeDAO;

public interface Bank_AdminDAO extends EmployeeDAO {
	
	public void Delete(String username, String password);
}