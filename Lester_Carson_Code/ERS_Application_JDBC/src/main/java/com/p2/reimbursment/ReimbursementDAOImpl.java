package com.p2.reimbursment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:oracle:thin:@lestercarson.cij8ici48e2h.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "lbcarson4";
	private static String password = "Lbc49681ataws";

	@Override
	public void insertReimbursment(Reimbursement r) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, r.getId());
			ps.setInt(2, r.getAmount());
			ps.setTimestamp(3, r.getSubmitted());
			ps.setTimestamp(4, r.getResolved());
			ps.setString(5, r.getDescription());
			ps.setBlob(6, r.getReceipt());
			ps.setString(7, r.getAuthor());
			ps.setString(8, r.getResolver());
			ps.setString(9, r.getStatus());
			ps.setString(10, r.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Reimbursement selectAllReimbursments() {

		Reimbursement r = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT ORDER BY REIR_ID");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimbursement selectReimbursmentById(int id) {

		Reimbursement r = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIR_ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimbursement selectReimbursmentByAuthor(String author) {

		Reimbursement r = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIR_AUTHOR = ?");
			ps.setString(1, author);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimbursement selectReimbursmentByType(String type) {

		Reimbursement r = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIR_TYPE = ? ORDER BY REIR_TYPE");
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimbursement selectReimbursmentByStatus(String status) {

		Reimbursement r = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIR_STATUS = ?");
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void updateReimbursmentByStatus(Reimbursement r) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn
					.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIR_STATUS = ? WHERE REIR_ID = ?");
			ps.setString(1, r.getStatus());
			ps.setInt(2, r.getId());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}