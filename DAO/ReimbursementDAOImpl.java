package com.project1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.Reimbursement;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "gaelgino";
	private static String password = "Un2trois4";

	@Override
	public int insertReimbursement(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO Reimbursement Values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, r.getReimb_ID());

			ps.setInt(2, r.getReimb_Amount());

			ps.setTimestamp(3, r.getReimb_Submitted());

			ps.setTimestamp(4, r.getReimb_Resolved());

			ps.setString(5, r.getReimb_Description());

			ps.setBlob(6, r.getReimb_Receipt());

			ps.setInt(7, r.getReimb_Author());

			ps.setInt(8, r.getReimb_Resolver());

			ps.setInt(9, r.getReimb_Status_ID());
			
			ps.setString(10, r.getReimb_Status());

			ps.setInt(11, r.getReimb_Type_ID());
			
			ps.setString(12, r.getReimb_Type());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public Reimbursement selectReimbursementByReimbID(int reimb_ID) {
		Reimbursement reimbursement = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement WHERE reimb_ID=?"); 
																																					
																											
			ps.setInt(1, reimb_ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursement = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getInt(11), rs.getString(12));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursement;

	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement");
			// sql query goes into our prepared statement
			// we have no question marks, so no indices at this point
			ResultSet rs = ps.executeQuery();
			// result set of the query
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getInt(11), rs.getString(12)));
			} // iterating through the result set, while we still have the next value
				// we populate the new Pet objects and add them to the ArrayList
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;

	}
	
	
	@Override
	public List<Reimbursement> selectReimbursementByStatus(String reimb_Status) {

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement WHERE reimb_Status=?");
			// sql query goes into our prepared statement
			// we have no question marks, so no indices at this point
			ResultSet rs = ps.executeQuery();
			// result set of the query
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), 
						rs.getInt(11), rs.getString(12)));
			} // iterating through the result set, while we still have the next value
				// we populate the new Pet objects and add them to the ArrayList
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;

	}
	

	@Override
	public int updateReimbursement(Reimbursement r) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("UPDATE Reimbursement SET reimb_Status_ID=? WHERE reimb_ID=?");
			
			ps.setInt(1, r.getReimb_Status_ID());
			
			ps.setInt(2, r.getReimb_ID());
			
			ps.executeUpdate();
			
			// can make void

		} catch (

		SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int deleteReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public List<Reimbursement> selectByUsersID(int userid){
        List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement where reimb_Author = ?");
            
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                reimbursementList.add(new Reimbursement( rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
                        rs.getString(5), rs.getBlob(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getInt(11),
                        rs.getString(12)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reimbursementList;
    }

}
