package com.banking.dao;

import java.util.List;

import com.banking.accounts.EmployeeAccount;

public interface EmployeeDaoInt {

	//CREATE
		public void insertEmployeeAccount(EmployeeAccount emp);
		
		//READ
		public EmployeeAccount selectEmployeeByName(String firstName);
		public List<EmployeeAccount> selectAllEmployees();
		
		//UPDATE
		public double updateEmployeeTitle(EmployeeAccount emp);
		
		//DELETE
		public void deleteEmployeeAccount(EmployeeAccount emp);
}
