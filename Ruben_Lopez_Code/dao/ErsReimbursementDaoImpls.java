package com.revature.dao;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ErsReimbursement;


public class ErsReimbursementDaoImpls implements ErsReimbursementDao {
	
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }
	
	private static String url = "jdbc:oracle:thin:@rubendb.crbseux6wvrb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "LopezR013";
	private static String password = "Wtwmbiwfil13";

	//CREATE
	
	public int insertErsReimbursement(ErsReimbursement p) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT ( REIMB_ID, REIMB_AMOUNT,REIMB_SUBMITTED , REIMB_RESOLVED , REIMB_DESCRIPTION , REIMB_RECEIPT , REIMB_AUTHOR , REIMB_RESOLVER, REIMB_STATUS_ID , REIMB_TYPE_ID )\r\n" + 
					"VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )");
			ps.setInt(1, 		p.getReimbID());
			ps.setInt(2, 		p.getReimbAmount());
			ps.setTimestamp(3, 	p.getReimbSubmitted());
			ps.setTimestamp(4, 	p.getReimbResolved());
			ps.setString(5, 	p.getReimbDescription());
			ps.setBlob(6, 		p.getReimbReceipt());
			ps.setInt(7, 		p.getReimbAuthor());
			ps.setInt(8, 		p.getReimbResolver());
			ps.setInt(9, 		p.getReimbStatusID());
			ps.setInt(10, 		p.getReimbTypeId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	
	
	//READ
	
	
	public ErsReimbursement selectErsReimbursementbyId(int reimbId) {
		ErsReimbursement tempUser = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID=?");
			
			ps.setInt(1, reimbId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tempUser = new ErsReimbursement( rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempUser;
		
		
		
		
	}
	
	public static List<ErsReimbursement> selectAllReimbursement(){
		
		List<ErsReimbursement> reimbursementList = new ArrayList<ErsReimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursementList.add(new ErsReimbursement( rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return reimbursementList;
		
		
	}
	
	public static List<ErsReimbursement> selectByUserID(int userid){

		List<ErsReimbursement> reimbursementList = new ArrayList<ErsReimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement where REIMB_AUTHOR = ?");
			
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursementList.add(new ErsReimbursement( rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return reimbursementList;
	}
	//UPDATE
		
	public int updateReimbursement(ErsReimbursement p) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_AMOUNT = ? ,REIMB_SUBMITTED = ?, REIMB_RESOLVED = ? , REIMB_DESCRIPTION = ? , REIMB_RECEIPT = ?, REIMB_AUTHOR = ? , REIMB_RESOLVER =?, REIMB_STATUS_ID = ?, REIMB_TYPE_ID =? where REIMB_ID=?");
			ps.setInt(10, p.getReimbID());
			ps.setInt(1, p.getReimbAmount());
			ps.setTimestamp(2, p.getReimbSubmitted());
			ps.setTimestamp(3, p.getReimbResolved());
			ps.setString(4, p.getReimbDescription());
			ps.setBlob(5, p.getReimbReceipt());
			ps.setInt(6, p.getReimbAuthor());
			ps.setInt(7, p.getReimbResolver());
			ps.setInt(8, p.getReimbStatusID());
			ps.setInt(9, p.getReimbTypeId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 1;
	}
	
	
	//DELETE
	public int deleteById(int p) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?");
			ps.setInt(1, p);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
}
