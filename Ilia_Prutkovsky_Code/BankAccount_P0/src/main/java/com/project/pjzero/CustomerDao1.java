package com.project.pjzero;

import java.io.IOException;
import java.sql.SQLException;

public interface CustomerDao1 {

	public int createCustomer() throws SQLException, IOException;

	public void changeCustomerStatusToApproved() throws IOException, SQLException;	

	public void readCustomersInfo() throws IOException;
	
	public void readCustomerInfo() throws IOException;

	public void changeCustomerStatusToCancel() throws IOException;	

	public void customerDeposit() throws IOException;

	public void customerWithdraw() throws IOException;

	public void customerBalanceTransfer() throws IOException;

	public void customerLogin() throws IOException, SQLException;

	public void joinCustomer() throws IOException;

}
