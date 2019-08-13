package com.project.bank;

public interface customerDAO {
	
	public void insertCustomer(customer c1);
	
	public customer selectCustomer(String userName,String passWord);
	
	public customer pendingApplications();
	
	public void updateCustomerAccStatus(customer c1);
	
	public void customerCheckJunctionTable(String userName);
	
	public void employeeSeeCustomerDetails(int accNo); //changed void to string to use user name to cancel an account.
	
	
	
	
	
}
