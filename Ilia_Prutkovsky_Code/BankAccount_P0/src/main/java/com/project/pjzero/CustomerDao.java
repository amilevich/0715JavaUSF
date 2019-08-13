package com.project.pjzero;

import java.io.IOException;
import java.sql.SQLException;

public interface CustomerDao {

		
		public void insertPendingCustomer() throws SQLException, IOException;		
		
		public void copyToWorkDB() throws IOException, SQLException;		
				
		public void readCustomerInfoFromWorkDB() throws IOException;
		public void readFullInfoFromWorkDB() throws IOException;
				
		public void deletePendingCustomer() throws IOException;
		public void deleteFromWorkDB() throws IOException;
		
		public void customerDeposit() throws IOException;
		public void customerWithdraw() throws IOException; 
		public void customerBalanceTransfer() throws IOException;
		public void customerLogin() throws IOException, SQLException;
		
		public void joinCustomer() throws IOException;

}
