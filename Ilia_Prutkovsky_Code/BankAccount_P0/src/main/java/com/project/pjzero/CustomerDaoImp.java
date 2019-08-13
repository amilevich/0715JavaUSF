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
import com.project.members.*;

public class CustomerDaoImp implements CustomerDao {

	static ScanReader sc = new ScanReader(System.in);
	final static Logger logTracker = Logger.getLogger(EmployeeActions.class);

	private static String url = "jdbc:oracle:thin:@db0715usf.cb69xbtxd0so.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String u_name = "user0715";
	private static String p_word = "awe7some5q";

	// Create customer record in DB
	@Override
	public void insertPendingCustomer() throws SQLException, IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query;
			Customer cst = new Customer(null, null, null, null, null, 0, 0);
						
			query = "INSERT INTO pending_customer VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cst.getUsername());
			ps.setString(2, cst.getPassword());
			ps.setString(3, cst.getFirstName());
			ps.setString(4, cst.getLastName());
			ps.setString(5, cst.getPhoneNumber());
			ps.setInt(6, cst.getCustomerID());
			ps.setDouble(7, cst.getAccountBalance());
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
	}

	// Read customer from DB
	@Override
	public void copyToWorkDB() throws IOException, SQLException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, query4;

			// Reading from "pending_customer" TABLE
			query = "SELECT * FROM pending_customer";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
			}
			System.out.println();
			// ------------------------------------

			// Transfer customer from "pending_customer" TABLE to "approved_customer" TABLE
			query2 = "INSERT INTO approved_customer SELECT * FROM pending_customer WHERE user_name =?";
			ps = conn.prepareStatement(query2);
			System.out.println("-=Please input *username* for approving=-");
			String num = sc.scanString();
			ps.setString(1, num);
			ps.executeUpdate();
			// ------------------------------------

			// Delete from "pending_customer" TABLE
			query3 = "DELETE FROM pending_customer WHERE user_name =?";
			ps = conn.prepareStatement(query3);
			ps.setString(1, num);
			System.out.println("-=Customer was approved succefully=-");
			System.out.println();
			ps.executeUpdate();
			// ------------------------------------

			// Reading from "pending_customer" TABLE
			System.out.println("-=Customers that are not approved yet=-");
			query4 = "SELECT * FROM pending_customer";
			ps = conn.prepareStatement(query4);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
			}
			System.out.println("*************************\n");
			// ------------------------------------

			ps.close();
		} catch (SQLException e) {
			System.out.println("-=The system alredy has account with this username=-");
			System.out.println("-=Please try again=-");
			System.out.println("*************************\n");
			Menu.adminMenu();
			e.printStackTrace();
		}
	}

	public void readCustomerInfoFromWorkDB() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, num;

			// Reading from "pending_customer" TABLE
			System.out.println("-=Please input *Username*=-");
			num = sc.scanString();
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			System.out.println("-=Information about your account=-");
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
			}
			System.out.println("*************************\n");
			// ------------------------------------

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void readFullInfoFromWorkDB() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query;

			// Reading from "pending_customer" TABLE
			query = "SELECT * FROM approved_customer";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			System.out.println("-=List of approved customers=-");
			System.out.println();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
			}
			System.out.println("*************************\n");
			// ------------------------------------

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete pending customer from DB
	@Override
	public void deletePendingCustomer() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, num;

			// Reading from "pending_customer" TABLE
			query = "SELECT * FROM pending_customer";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
			}
			System.out.println();
			// ------------------------------------

			// Delete chosen customer from "pending_customer" TABLE
			System.out.println("-=Please input *Username* for cancelling=-");
			num = sc.scanString();
			query2 = "DELETE FROM pending_customer WHERE user_name =?";
			ps = conn.prepareStatement(query2);
			ps.setString(1, num);
			int ch = ps.executeUpdate();
			if (ch > 0) {
				System.out.println("-=Account with username " + "-=" + num + "=-" + " was cancelled=-\n");
			} else {
				System.out.println("-=Failed to cancel username " + "-=" + num + "=-");
			}
			// ------------------------------------

			// Reading from "pending_customer" TABLE
			System.out.println("-=Customers that are not approved yet=-");
			query3 = "SELECT * FROM pending_customer";
			ps = conn.prepareStatement(query3);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("-=[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ]=-\n");
			}
			System.out.println("*************************\n");
			// ------------------------------------

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFromWorkDB() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, num;
			// Reading from "approved_customer" TABLE
			query = "SELECT * FROM approved_customer";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
			}
			System.out.println();
			// Delete chosen customer from "approved_customer" TABLE
			System.out.println("-=Please input *Username* for cancelling=-");
			num = sc.scanString();
			query2 = "DELETE FROM approved_customer WHERE user_name =?";
			ps = conn.prepareStatement(query2);
			ps.setString(1, num);
			int ch = ps.executeUpdate();
			if (ch > 0) {
				System.out.println("-=Account with username " + "-=" + num + "=-" + " was cancelled=-\n");
			} else {
				System.out.println("-=Failed to cancel username " + "-=" + num + "=-");
			}
			// Reading from "approved_customer" TABLE
			System.out.println("-=Remaining customers=-");
			query3 = "SELECT * FROM approved_customer";
			ps = conn.prepareStatement(query3);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("-=[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ]=-\n");
			}
			System.out.println("*************************\n");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void customerDeposit() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, num;
			double amount, balance;

			// Read customer info from "approved_customer" TABLE & add input amount to
			// balance
			System.out.println("-=Please input *Username*=-");
			num = sc.scanString();
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getDouble(7) + " ] \n");
				balance = rs.getDouble(7);
				System.out.println("-=Please input amount of deposit=-");
				amount = sc.scanDouble();
				balance += amount;
				query2 = "UPDATE approved_customer SET account_balance =? WHERE user_name =?";
				ps = conn.prepareStatement(query2);
				ps.setDouble(1, balance);
				ps.setString(2, num);
				ps.executeUpdate();
			}
			// ------------------------------------

			// Read customer info from "approved_customer" TABLE
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
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
			String query, query2, num;
			double amount, balance;

			// Read customer info from "approved_customer" TABLE & add input amount to
			// balance
			System.out.println("-=Please input *Username*=-");
			num = sc.scanString();
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getDouble(7) + " ] \n");
				balance = rs.getDouble(7);
				System.out.println("-=Please input amount of deposit=-");
				amount = sc.scanDouble();
				if (balance >= amount) {
					balance -= amount;
					query2 = "UPDATE approved_customer SET account_balance =? WHERE user_name =?";
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
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
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
			String query, query2, query3, query4, num, num2;
			double amount, balance, balance2;

			// Read customer info from "approved_customer" TABLE & add input amount to
			// balance
			System.out.println("-=Please input *Username*=-");
			num = sc.scanString();
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getDouble(7) + " ] \n");
				balance = rs.getDouble(7);
				System.out.println("-=Please input amount of your transfer=-");
				amount = sc.scanDouble();
				if (balance >= amount) {
					balance -= amount;
					query2 = "UPDATE approved_customer SET account_balance =? WHERE user_name =?";
					ps = conn.prepareStatement(query2);
					ps.setDouble(1, balance);
					ps.setString(2, num);
					ps.executeUpdate();
					rs.close();
					System.out.println("-=Please input *Username* you want to transfer=-");
					num2 = sc.scanString();
					query3 = "SELECT * FROM approved_customer WHERE user_name =?";
					ps = conn.prepareStatement(query3);
					ps.setString(1, num2);
					rs = ps.executeQuery();

					while (rs.next()) {
						balance2 = rs.getDouble(7);
						query4 = "UPDATE approved_customer SET account_balance =? WHERE user_name =?";
						ps = conn.prepareStatement(query4);
						balance2 += amount;
						ps.setDouble(1, balance2);
						ps.setString(2, num2);
						ps.executeUpdate();
						// System.out.println(rs.getDouble(7));
					}

				} else {
					System.out.println("-=You don't have enough money on your account=-");
				}
			}
			// ------------------------------------

			// Read customer info from "approved_customer" TABLE
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getString(7) + " ] \n");
			}
			// ------------------------------------
			System.out.println("*************************\n");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void joinCustomer() throws IOException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String query, query2, query3, query4, num, num2;

			// Read customer info from "approved_customer" TABLE
			System.out.println("-=Please input *Username*=-");
			num = sc.scanString();
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
						+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
						+ rs.getString(6) + ": Account Balance = " + rs.getDouble(7) + " ] \n");
				// balance = rs.getDouble(7);

				System.out.println("-=Please input *Username*=-");
				num2 = sc.scanString();
				query2 = "SELECT * FROM approved_customer WHERE user_name =?";
				ps = conn.prepareStatement(query2);
				ps.setString(1, num2);
				while (rs.next()) {
					System.out.print("[ Username = " + rs.getString(1) + ": Firstname = " + rs.getString(3)
							+ ": Lastname = " + rs.getString(4) + ": Phone # = " + rs.getString(5) + ": CustomerID = "
							+ rs.getString(6) + ": Account Balance = " + rs.getDouble(7) + " ] \n");
					// balance2 = rs.getDouble(7);
					// totalBalance = balance + balance2;
					// query3 = "UPDATE approved_customer SET account_balance =? WHERE user_name
					// =?";
					// ps = conn.prepareStatement(query3);
					// ps.setDouble(1, totalBalance);
					// ps.setString(2, num);
					// ps.executeUpdate();

					query4 = "CREATE OR REPLACE VIEW join_approved_customer AS SELECT * FROM approved_customer WHERE account_balance (?, ?)";
					// (user_name, pass_word, first_name, last_name, phone_number, customer_id,
					// account_balance)
					ps = conn.prepareStatement(query4);
					ps.setString(1, num);
					ps.setString(2, num2);
					ps.executeUpdate(query4);
				}

			}
			// SELECT * FROM approved_customer ac1, approved_customer ac2 WHERE
			// ac1.account_balance = ac2.account_balance;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void customerLogin() throws IOException, SQLException {
		try (Connection conn = DriverManager.getConnection(url, u_name, p_word)) {
			String inputUser, inputPass, username, password, query, query2;

			// Read username from "approved_customer" TABLE
			System.out.println("-=Please input *Username*=-");
			inputUser = sc.scanString();
			query = "SELECT * FROM approved_customer WHERE user_name =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, inputUser);
			ResultSet rs = ps.executeQuery();
			rs.next();
			username = rs.getString(1);
			// ------------------------------------

			// Read password from "approved_customer" TABLE
			System.out.println("-=Please input *Password*=-");
			inputPass = sc.scanString();
			query2 = "SELECT * FROM approved_customer WHERE pass_word =?";
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

}