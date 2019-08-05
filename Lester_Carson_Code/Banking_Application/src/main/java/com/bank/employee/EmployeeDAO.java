package com.bank.employee;

public interface EmployeeDAO{

	public void View(String username, String password);
	public void Approve(String username, String password, Boolean what);
}