package com.bankdb.project.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;

public class FindAcounByCustomerDAO {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public List<Account> findAllAccounts(Person person, String typeAccount){
		final String SQLQUERY = "SELECT a.* FROM account a, jointaccount b WHERE"
				+ " a.accountnumber = b.accountnumber and a.status = ? and b.username = ?" 
				+ "  and b.status <> 'D' ORDER BY a.accountnumber ASC";
		
		List<Account> account = new ArrayList<>();
		boolean flag = false;
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, typeAccount);
				statement.setString(2, person.getUser());
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					Account acct = new Account();
					acct.setAccountNumber(rs.getString(1));
					acct.setAmount(rs.getDouble(2));
					acct.setKindAccount(rs.getString(3));
					acct.setDate(rs.getDate(4));
					acct.setStatus(rs.getString(5));
					account.add(acct);
					flag =  true;
				}
				if(!flag) return null;				
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
