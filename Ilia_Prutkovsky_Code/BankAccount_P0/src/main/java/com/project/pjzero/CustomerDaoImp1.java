package com.project.pjzero;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.project.actions.EmployeeActions;
import com.project.db.ScanReader;
import com.project.members.Customer1;

public class CustomerDaoImp1 implements CustomerDao1 {

	static ScanReader sc = new ScanReader(System.in);
	final static Logger logTracker = Logger.getLogger(EmployeeActions.class);

	private static String url = "jdbc:oracle:thin:@db0715usf.cb69xbtxd0so.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String u_name = "user0715";
	private static String p_word = "awe7some5q";
	
	static String inputUser;

	public int createCustomer() throws SQLException, IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query;

			Customer1 cst = new Customer1(null, null, null, null, null, 0, 0, null);
			query = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setObject(1, cst.getUsername());
			ps.setObject(2, cst.getPassword());
			ps.setObject(3, cst.getFirstName());
			ps.setObject(4, cst.getLastName());
			ps.setObject(5, cst.getPhoneNumber());
			ps.setObject(6, cst.getCustomerID());
			ps.setObject(7, cst.getAccountBalance());
			ps.setObject(8, cst.getStatus());
			ps.executeUpdate();
			System.out.println("-=Account was created=-");
			System.out.println("*************************\n");
			ps.close();
		} catch (SQLException e) {
			System.out.println("-=Your username match with another one=-");
			System.out.println("-=Please try again=-");
			System.out.println("*************************\n");
			Menu.mainMenu();
			e.printStackTrace();
		}
		return 0;

	}

	public void changeCustomerStatusToApproved() throws IOException, SQLException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, num;

			// Reading from "pending_customer" TABLE
			query = "SELECT * FROM customer";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + ": Status = " + rs.getString(8)
						+ " ] \n");
			}
			System.out.println();
			// ------------------------------------

			// Update status of customer from "pending"
			System.out.println("-=Please input *Username* for approving=-");
			num = sc.scanString();
			query2 = "UPDATE customer SET status =? WHERE user_name =?";
			ps = conn.prepareStatement(query2);
			ps.setString(1, "approved");
			ps.setString(2, num);
			System.out.println("-=Customer was approved succefully=-");
			System.out.println();
			System.out.println("*************************\n");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readCustomerInfo() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, num;

			// Reading from "customer" TABLE
			num = inputUser;
			query = "SELECT * FROM customer WHERE user_name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			System.out.println("-=Information about your account=-");
			System.out.println();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + ": Status = " + rs.getString(8)
						+ " ] \n");
			}
			System.out.println("*************************\n");
			// ------------------------------------

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readCustomersInfo() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query;

			// Reading from "customer" TABLE
			query = "SELECT * FROM customer";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			System.out.println("-=List of all customers=-");
			System.out.println();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + ": Status = " + rs.getString(8)
						+ " ] \n");
			}
			System.out.println("*************************\n");
			// ------------------------------------

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changeCustomerStatusToCancel() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, num;

			// Reading from "pending_customer" TABLE
			query = "SELECT * FROM customer";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + ": Status = " + rs.getString(8)
						+ " ] \n");
			}
			System.out.println();
			// ------------------------------------

			// Update status of customer to "cancelled"
			System.out.println("-=Please input *Username* for canceling=-");
			num = sc.scanString();
			query2 = "UPDATE customer SET status =? WHERE user_name =?";
			ps = conn.prepareStatement(query2);
			ps.setString(1, "cancelled");
			ps.setString(2, num);
			System.out.println("-=Customer was cancelled succefully=-");
			System.out.println();
			System.out.println("*************************\n");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void customerDeposit() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, num;
			double amount, balance;			
			
			num = inputUser;
			query = "SELECT * FROM customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Account Balance = " + rs.getString(7) + " ] \n");
				balance = rs.getDouble(7);
				System.out.println("-=Please input amount of deposit=-");
				amount = sc.scanDouble();
				balance += amount;
				query2 = "UPDATE customer SET account_balance =? WHERE user_name =?";
				ps = conn.prepareStatement(query2);
				ps.setDouble(1, balance);
				ps.setString(2, num);
				ps.executeUpdate();
			}
			// ------------------------------------

			// Read customer info from "approved_customer" TABLE
			query3 = "SELECT * FROM customer WHERE user_name =?";
			ps = conn.prepareStatement(query3);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("-=Your balance now: " + rs.getString(7) + " =-\n");				
			}
			// ------------------------------------

			System.out.println("*************************\n");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void customerWithdraw() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, num;
			double amount, balance;

			// Read customer info from "customer" TABLE & add input amount to
			// balance
			num = inputUser;			
			query = "SELECT * FROM customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Account Balance = " + rs.getString(7) + " ] \n");
				balance = rs.getDouble(7);
				System.out.println("-=Please input amount of withdraw=-");
				amount = sc.scanDouble();
				if (balance >= amount) {
					balance -= amount;
					query2 = "UPDATE customer SET account_balance =? WHERE user_name =?";
					ps = conn.prepareStatement(query2);
					ps.setDouble(1, balance);
					ps.setString(2, num);
					ps.executeUpdate();
				} else {
					System.out.println("-=You don't have enough money on your account=-");
				}
			}
			// ------------------------------------

			// Read customer info from "approved_customer" TABLE
			query3 = "SELECT * FROM customer WHERE user_name =?";
			ps = conn.prepareStatement(query3);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("-=Your balance now: " + rs.getString(7) + " =-\n");
			}
			// ------------------------------------
			System.out.println("*************************\n");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void customerBalanceTransfer() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, query4, query5, num, num2;
			double amount, balance, balance2;

			// Read customer info from "customer" TABLE & add input amount to
			// balance
			num = inputUser;
			query = "SELECT * FROM customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Account Balance = " + rs.getString(7) + " ] \n");
				balance = rs.getDouble(7);
				System.out.println("-=Please input amount of your transfer=-");
				amount = sc.scanDouble();
				if (balance >= amount) {
					balance -= amount;
					query2 = "UPDATE customer SET account_balance =? WHERE user_name =?";
					ps = conn.prepareStatement(query2);
					ps.setDouble(1, balance);
					ps.setString(2, num);
					ps.executeUpdate();
					rs.close();
					System.out.println("-=Please input *Username* you want to transfer=-");
					num2 = sc.scanString();
					query3 = "SELECT * FROM customer WHERE user_name =?";
					ps = conn.prepareStatement(query3);
					ps.setString(1, num2);
					rs = ps.executeQuery();

					while (rs.next()) {
						balance2 = rs.getDouble(7);
						query4 = "UPDATE customer SET account_balance =? WHERE user_name =?";
						ps = conn.prepareStatement(query4);
						balance2 += amount;
						ps.setDouble(1, balance2);
						ps.setString(2, num2);
						ps.executeUpdate();
					}

				} else {
					System.out.println("-=You don't have enough money on your account=-");
					logTracker.warn("Attempt taking more that customer has");
				}
			}
			// ------------------------------------

			// Read customer info from "approved_customer" TABLE
			query5 = "SELECT * FROM customer WHERE user_name =?";
			ps = conn.prepareStatement(query5);
			ps.setString(1, num);			
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("-=Your balance now: " + rs.getString(7) + " =-\n");
			}
			// ------------------------------------
			System.out.println("*************************\n");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void customerLogin() throws IOException, SQLException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String inputPass, username, password, query, query2;

			// Read username from "approved_customer" TABLE
			System.out.println("-=Please input *Username*=-");
			inputUser = sc.scanString();
			query = "SELECT * FROM customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, inputUser);			
			ResultSet rs = ps.executeQuery();
			rs.next();
			username = rs.getString(1);
			// ------------------------------------

			// Read password from "approved_customer" TABLE
			System.out.println("-=Please input *Password*=-");
			inputPass = sc.scanString();
			query2 = "SELECT * FROM customer WHERE pass_word =?";
			ps = conn.prepareStatement(query2);
			ps.setString(1, inputPass);			
			rs = ps.executeQuery();
			rs.next();
			password = rs.getString(2);
			// ------------------------------------

			// Check for matching username & password
			if (inputUser.equals(username) && inputPass.equals(password)) {
				System.out.println("-=Your in a system=-");
				System.out.println("*************************\n");
				logTracker.info("Customer log in the system");
				Menu.customerMenu();
			}
			ps.close();
		} catch (SQLException e) {
			// Check for matching username & password - "else"
			System.out.println("-=Your *Username* or *Password* don't match=-");
			System.out.println("*************************\n");
			logTracker.warn("Customer tried to log in with wrong username\\password");
			Menu.loginMenu();
			e.printStackTrace();
		}
	}

	public void joinCustomer() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, query4, num, num2, curCustomerID;

			// Reading from "customer" TABLE
			System.out.println("-=Please input *Username* for joining=-");
			num = sc.scanString();
			query = "SELECT * FROM customer WHERE user_name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			System.out.println("-=Information about your account=-");
			System.out.println();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + ": Status = " + rs.getString(8)
						+ " ] \n");
			}
			curCustomerID = rs.getString(6);
			
			System.out.println("-=Please input *Username* for joining=-");
			num2 = sc.scanString();
			query2 = "SELECT * FROM customer WHERE user_name = ?";
			ps = conn.prepareStatement(query2);
			ps.setString(1, num2);
			rs = ps.executeQuery();
			System.out.println("-=Information about your account=-");
			System.out.println();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + ": Status = " + rs.getString(8)
						+ " ] \n");
			}
			
			query3 = "UPDATE FROM customer WHERE user_name = ? AND customer_id =? and status = ?";
			ps = conn.prepareStatement(query3);
			ps.setString(1, num2);
			ps.setString(2, curCustomerID);
			ps.setString(3, "joined");
			
			rs = ps.executeQuery();
			
			query4 = "SELECT * FROM customer WHERE status ='joined'";
			ps = conn.prepareStatement(query4);			
			rs = ps.executeQuery();
			
			System.out.println("-=Acoounts were joined=-");
			System.out.println("*************************\n");
			// ------------------------------------

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
