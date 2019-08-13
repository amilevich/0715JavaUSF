package data.dao;

import static data.db.DBConnector.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import model.BankAccount;
import value.AccountSharing;
import value.Currency;

public class BankAccountDAOI implements 
	CommonDAO<Integer, BankAccount>, GetAllModelDAO <Integer, BankAccount> {
	
	final static Logger logger = Logger.getLogger(BankAccountDAOI.class);
	private static TreeMap<Integer, BankAccount> bankaccounts = new TreeMap<Integer, BankAccount>();
	private static UserAccountDAOI userdao = new UserAccountDAOI();
	
	public BankAccount getOneCurrencyMatch(Integer id, Currency currency) {
		BankAccount bankAccount = null;
		bankAccount = this.getOne(id);
		if (bankAccount == null) {
			return bankAccount;
		} else {
			if (bankAccount.getCurrency().equals(currency) ) {
				return bankAccount;
			} 
		}
		return null;
	}
	
	@Override
	public BankAccount getOne(Integer id) {
		BankAccount bankaccount = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BANKACCOUNTS WHERE BA_ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bankaccount = new BankAccount(rs.getDouble("AMOUNT"), 
						Currency.valueOf( rs.getString("CURRENCY")), 
						AccountSharing.valueOf(rs.getString("SHARINGTYPE")), 
						rs.getInt("BA_ID"));
			}
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
		}
		
		return bankaccount;
	}

	@Override
	public Integer insertOne(BankAccount member) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean updateOne(BankAccount member) {
		try {
			PreparedStatement ps = 
					conn.prepareStatement("UPDATE BANKACCOUNTS SET AMOUNT = ? WHERE BA_ID = ?");
			ps.setDouble(1, member.getAmount());
			ps.setInt(2, member.getNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		logger.info(String.format("%1$s %2$s was the balance of Bank Account number %3$s", 
				member.getCurrency(), member.getAmount(), member.getNumber() ));
		return true;
	}

	@Override
	public Integer deleteOne(Integer id) {
		//Customer customer = null;
		Integer numOfRows = 0;
		try {
			userdao.deleteMany(id);
			PreparedStatement ps = 
					conn.prepareStatement("DELETE FROM BANKACCOUNTS WHERE BA_ID IN (SELECT BA_ID FROM BANKACCOUNTS WHERE BA_ID = ?) ");
			ps.setInt(1, id);
			numOfRows = ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			numOfRows = 0;
			return numOfRows;
		}
		logger.info( String.format("Deleted Bank Account number %1$s", id) );
		return numOfRows;
	}

	@Override
	public TreeMap<Integer, BankAccount> getAll() {
		
		try {
			PreparedStatement ps = 
					conn.prepareStatement("SELECT * FROM BANKACCOUNTS");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BankAccount bankaccount = new BankAccount(rs.getDouble("AMOUNT"),
							Currency.valueOf( rs.getString("CURRENCY") ),
							AccountSharing.valueOf( rs.getString("SHARINGTYPE") ),
							rs.getInt("BA_ID")
						);
				bankaccounts.put(rs.getInt("BA_ID"), bankaccount);
			}
			
		} catch (SQLException e) {
			System.out.println("Having connectivity problems");
			//e.printStackTrace();
		}
		return bankaccounts;
	}

	
	@Override
	public String[][] getTable() {
		Integer rowCount = 0;
		Integer colCount = 0;
		String[][] table = null;
		try {
			PreparedStatement ps = 
					conn.prepareStatement
					("SELECT * FROM ALL_BANKACCOUNTS2",
							ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			rs.last();
			rowCount = rs.getRow();
			rs.beforeFirst();
			
			colCount = rs.getMetaData().getColumnCount();
			table = new String[rowCount][colCount];
			int i = 0 ,j = 0;
			while(rs.next()) {
				table[ i ][ j++ ] = rs.getString("BA_ID");
				table[ i ][ j++ ] = rs.getString("ACCTHOLDERS");
				table[ i ][ j++ ] = rs.getString("CURRENCY");
				table[ i ][ j++ ] = rs.getString("SHARINGTYPE");
				table[ i ][ j++ ] = rs.getString("AMOUNT");
				i++;
				j = 0;
			}
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
		}
		
		return table;
	}
}
