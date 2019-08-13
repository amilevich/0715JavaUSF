package com.project.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class accountDaoIMPL implements accountDAO {

	private static String url = "jdbc:oracle:thin:@db0715java.ce8jdxpwtsbf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "niroj85";
	private static String password = "niroj4401";

	@Override
	public void insertAccount(account a1) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO ACCOUNT_DETAILS(USER_NAME,BALANCE) VALUES(?,?)");
			ps.setString(1, a1.UName);
			ps.setDouble(2, a1.balance);
			ps.executeUpdate();
			//System.out.println("account inserted");
		} catch (SQLException e) {
			System.out.println("This User Name Already Existing.");
			// e.printStackTrace();
		}
	}

	@Override
	public account selectAccount(int acc_No) {
		account acc = null;
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ACCOUNT_DETAILS WHERE ACC_NO=?");
			ps.setInt(1, acc_No);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				acc = new account(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				double a = acc.getBalance();
				System.out.println(a);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public account selectAccountUserName(String userName) {
		account acc = null;
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ACCOUNT_DETAILS WHERE USER_NAME=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				acc = new account(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				// int AcNo =acc.getAcc_No();
				// System.out.println(AcNo);
				// System.out.println(userName);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return acc;

	}

	@Override
	public void insertJunctionTable(account acc1) {

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO JUNCTION_TABLE VALUES(?,?)");
			ps.setString(1, acc1.getUName());
			ps.setInt(2, acc1.getacc_No());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Couldn't Insert In To The Junction Table");
			// e.printStackTrace();
		}

	}

	@Override
	public void employeeSeeAccountDetails(int acc_No) {
		
		double Existingbalance;
		Scanner sc = new Scanner(System.in);
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACC_NO=?");
			ps.setInt(1, acc_No);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Existingbalance = rs.getDouble(1);
				System.out.println("This Account's Current Balance Is ==>" + Existingbalance);
				System.out.println("\n");
				MainClass mc=new MainClass();
				mc.employeeMenu();
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void cancelAccount(int acc_No) {
		try(Connection con = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps=con.prepareStatement("DELETE FROM ACCOUNT_DETAILS WHERE ACC_NO=?");
			ps.setInt(1, acc_No);
			ps.executeUpdate();
			
			try(Connection con1 = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps1=con.prepareStatement("DELETE FROM JUNCTION_TABLE WHERE ACC_NUMBER=?");
				ps1.setInt(1, acc_No);
				ps1.executeUpdate();
				System.out.println("Account Has Been Cancelled Successfully.");
				MainClass mc=new MainClass();
				System.out.println("\n");
				mc.adminMenu();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
