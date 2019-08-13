package data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import model.Customer;
import static data.db.DBConnector.conn;

public class CustomerDAOI implements 
	CommonDAO<String, Customer>, GetAllModelDAO <String, Customer> {
	final static Logger logger = Logger.getLogger(CustomerDAOI.class);
	private TreeMap<String, Customer> customers = new TreeMap<String, Customer>();
	
	public Customer getOneWithID(Integer id) {
		Customer customer = new Customer();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BANKACCOUNTSOFCUSTOMERS WHERE BA_ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer.setUsername(rs.getString("USERNAME"));
				customer.setBankAccountNumber(rs.getInt("BA_ID"));
			}
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
			customer = null;
		}
		
		return customer;
	}
	
	@Override
	public Customer getOne(String un) {
		Customer customer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CUSTOMER_BANKACCOUNTS WHERE USERNAME = ?");
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer = new Customer(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), 
						rs.getString("USERNAME"), rs.getInt("BANKACCOUNTNUMBER")); 
			}
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
			customer = null;
		}
		
		return customer;
	}

	@Override
	public String insertOne(Customer member) {
		// must return primary key
		try {
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO CUSTOMERS (USERNAME,FIRSTNAME,LASTNAME) VALUES (?,?,?)");
			ps.setString(1, member.getUsername());
			ps.setString(2, member.getFirstName());
			ps.setString(3, member.getLastName());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
			return "";
		}
		return member.getUsername();
	}

	@Override
	public boolean updateOne(Customer member) {
		try {
			PreparedStatement ps = 
					conn.prepareStatement("UPDATE CUSTOMERS SET FIRSTNAME = ?, LASTNAME = ? WHERE USERNAME = ?");
			ps.setString(1, member.getFirstName());
			ps.setString(2, member.getLastName());
			ps.setString(3, member.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		logger.info(String.format("Changed firstname and lastname of customer %1$s", member.getUsername()));
		return true;
	}
	
	@Override
	public Integer deleteOne(String un) {
		Integer numOfRows = 0;
		try {
			PreparedStatement ps = 
					conn.prepareStatement("DELETE FROM CUSTOMERS WHERE USERNAME IN (SELECT USERNAME FROM CUSTOMERS WHERE USERNAME = ?) ");
			ps.setString(1, un);
			numOfRows = ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			numOfRows = 0;
			return numOfRows;
		}
		logger.info( String.format("Unregistred customer %1$s", un) );
		return numOfRows;
	}

	@Override
	public TreeMap<String, Customer> getAll() {
		Customer customer;
		try {
			PreparedStatement ps = 
					conn.prepareStatement
					("SELECT * FROM CUSTOMER_BANKACCOUNTS");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer = new Customer(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), 
						rs.getString("USERNAME"), rs.getInt("BA_ID")); 
				customers.put(rs.getString("USERNAME"), customer);
			}
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public String[][] getTable() {
		Integer rowCount = 0;
		Integer colCount = 0;
		String[][] table = null;
		try {
			PreparedStatement ps = 
					conn.prepareStatement
					("SELECT * FROM CUSTOMER_BANKACCOUNTS",
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
				table[ i ][ j++ ] = rs.getString("USERNAME");
				table[ i ][ j++ ] = rs.getString("BANKACCOUNTNUMBER");
				table[ i ][ j++ ] = rs.getString("FIRSTNAME");
				table[ i ][ j++ ] = rs.getString("LASTNAME");
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
