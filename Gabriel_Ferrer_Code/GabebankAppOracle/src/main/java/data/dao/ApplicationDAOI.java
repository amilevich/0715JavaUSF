package data.dao;

import static data.db.DBConnector.conn;

import org.apache.log4j.Logger;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.TreeMap;

import main.All;
import model.AccountDetail;
import model.Applicant;
import model.Application;
import utility.print.Table;
import value.AccountSharing;
import value.ApplicationStatus;
import value.Currency;

public class ApplicationDAOI implements 
	CommonDAO<Integer, Application>, GetAllModelDAO <Integer, Application> {

	final static Logger logger = Logger.getLogger(ApplicationDAOI.class);
	private static TreeMap<Integer, Application> applications = new TreeMap<Integer, Application>();
	
	@Override
	public Application getOne(Integer id) {
		Application application = null;
		AccountDetail accountDetail = null;
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		
		try {
			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM APPLICATIONS WHERE APP_ID = ?");
			ps1.setInt(1, id);
			
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM APPLICANTS WHERE APP_ID = ?");
			ps2.setInt(1, id);
			
			PreparedStatement ps3 = conn.prepareStatement("SELECT * FROM ACCOUNTDETAILS WHERE APP_ID = ?");
			ps3.setInt(1, id);
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();

			while(rs2.next()) {
				applicants.add(new Applicant(rs2.getString("FIRSTNAME"), 
						rs2.getString("LASTNAME"), rs2.getString("USERNAME")));
			}
			
			while(rs3.next()) {
				accountDetail = new AccountDetail(rs3.getDouble("AMOUNT")
						, Currency.valueOf( rs3.getString("CURRENCY") ), 
						AccountSharing.valueOf( rs3.getString("SHARINGTYPE")));
			}
			
			while(rs1.next()) {
				application = new Application(rs1.getInt("APP_ID"), 
						ApplicationStatus.valueOf( rs1.getString("STATUS") ),
						applicants, accountDetail);
			}

		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
		}
		
		return application;
	}

	@Override
	public Integer insertOne(Application member) {
		Integer returnedNumber = 0;
		String shareType = "";
		try {
			// WE HAVE TO GET THE PRIMARY KEY
			CallableStatement cs1 = conn.prepareCall("{CALL RETURN_APP_PK_ON_INSERT(?)}");
			cs1.registerOutParameter(1, Types.INTEGER);
			cs1.execute();
			returnedNumber = cs1.getInt(1);
			
			PreparedStatement ps2 = conn.prepareStatement
					("INSERT INTO APPLICANTS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, APP_ID) VALUES (?,?,?,?,?)");
			for (int i = 0; i < member.getApplicants().size(); i++) {
				ps2.setString(1, member.getApplicants().get(i).getFirstName());
				ps2.setString(2, member.getApplicants().get(i).getLastName());
				ps2.setString(3, member.getApplicants().get(i).getUsername());
				ps2.setString(4, member.getApplicants().get(i).getPassword());
				ps2.setInt(5, returnedNumber);
				ps2.addBatch();
			}
			
			ps2.executeBatch();
			
			PreparedStatement ps3 = conn.prepareStatement
					("INSERT INTO ACCOUNTDETAILS (CURRENCY, SHARINGTYPE, AMOUNT, APP_ID) VALUES (?,?,?,?)");
			ps3.setString(1, member.getAccountDetail().getCurrency().name());
			ps3.setString(2, member.getAccountDetail().getAccountSharing().name());
			ps3.setDouble(3, member.getAccountDetail().getAmount());
			ps3.setInt(4, returnedNumber);
			
			ps3.executeUpdate();
			shareType = member.getAccountDetail().getAccountSharing().name();

		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
			return 0;
		}
		logger.info(String.format("Application number %1$s was created for %2$s account", returnedNumber, shareType));
		return returnedNumber;
	}

	@Override
	public boolean updateOne(Application member) {
		try {
			PreparedStatement ps1 = 
					conn.prepareStatement("UPDATE APPLICATIONS SET STATUS = ? WHERE APP_ID = ?");
			ps1.setString(1, member.getAppStatus().name() );
			ps1.setInt(2, member.getNumber() );
			ps1.executeUpdate();
			//// copying from applications to customers, bank account and user account
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		logger.info(String.format("Application number %1$s has a/an %2$s status", member.getNumber(), member.getAppStatus().name()));
		return true;
	}

	@Override
	public Integer deleteOne(Integer id) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public TreeMap<Integer, Application> getAll() {
		Application application = new Application();
		AccountDetail accountDetail = new AccountDetail();
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		Integer app_id = 0;
		
		try {
			PreparedStatement ps = 
					conn.prepareStatement("SELECT * FROM ALL_APPLICATIONS WHERE STATUS = ?");
			ps.setString(1, ApplicationStatus.PENDING.name());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if (app_id == 0 || app_id != rs.getInt("APP_ID")) {
					application.setApplicants(applicants); // assigns applicants to the application
					application.setAccountDetail(accountDetail); // assigns one account detail to the application
					applications.put(app_id, application); // adds one application to a map collection of applications
					app_id = rs.getInt("APP_ID"); // assigns new value to app_id 
					application = new Application(); // dereference the existing application object
				}
				accountDetail = new AccountDetail(rs.getDouble("AMOUNT"), 
						Currency.valueOf( rs.getString("CURRENCY")), 
						AccountSharing.valueOf( rs.getString("SHARINGTYPE")));  // keep on 
				applicants.add(new Applicant(rs.getString("firstName"), 
						rs.getString("lastName"), rs.getString("username"))); // keep on adding applicants to app
			}
			
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
		}
		
		return applications;
	}

	
	public String[][] getTable() {
		Integer rowCount = 0;
		Integer colCount = 0;
		String[][] table = null;
		try {
			PreparedStatement ps = 
					conn.prepareStatement("SELECT * FROM ALL_APPLICATIONS2 WHERE STATUS = ?", 
							ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_READ_ONLY);
			
			ps.setString(1, ApplicationStatus.PENDING.name());
			ResultSet rs = ps.executeQuery();
			rs.last();
			rowCount = rs.getRow();
			rs.beforeFirst();
			
			colCount = rs.getMetaData().getColumnCount();
			table = new String[rowCount][colCount - 1];
			int i = 0 ,j = 0;
			while(rs.next()) {
				table[ i ][ j++ ] = rs.getString("APP_ID");
				table[ i ][ j++ ] = rs.getString("APPLICANTS");
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
