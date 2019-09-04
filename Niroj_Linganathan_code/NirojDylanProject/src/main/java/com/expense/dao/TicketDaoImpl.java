package com.expense.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.expense.beans.Employee;
import com.expense.beans.Ticket;
//***********************************************
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

//***********************************************

public class TicketDaoImpl implements TicketDao {
	private static String url = "jdbc:oracle:thin:@db0715java.ce8jdxpwtsbf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "niroj85";
	private static String password = "niroj4401";
	
	static int EID; //For SMS method.
	static String status;
	static double amount;
    static{
           try {
               Class.forName("oracle.jdbc.driver.OracleDriver");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
       }
    
    @Override
    public void insertTicket(Ticket ticket) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO reim_form VALUES(null,?,null,?,null,?,null,'pending',?,?,?,?,?,?)");
            //ps.setInt(null, form.getClaimId());  //Need to figure out how to sync this with claim_types table
            ps.setInt(1, ticket.getEmpId());
            //ps.setInt(null, form.getAdminId());  //Inserted in UPDATE Method
            ps.setString(2, ticket.getDateOfRequest());
            //ps.setString(null, form.getDateOfResolution()); Inserted in UPDATE method
            ps.setString(3, ticket.getDateOfExpense());
            //ps.setBlob(null, image()); Apparently NOT using BLOB for this project
            //ps.setString(4, form.getClaimStatus()); auto fill as pending
            ps.setDouble(4, ticket.getTravelAmount());
            ps.setDouble(5, ticket.getLodgeingAmount());
            ps.setDouble(6, ticket.getFoodAmount());
            ps.setDouble(7, ticket.getOtherAmount());
            ps.setString(8, ticket.getComments());
            ps.setDouble(9, ticket.getClaimTotal());
            ps.executeUpdate();
            
            sms(ticket.getEmpId(),ticket.getDateOfRequest(),ticket.getClaimTotal());
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
   
    
    @Override
    public Ticket selectTicketsById(int claimid) {
        Ticket ticket = null;
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form WHERE claim_id =?");
            ps.setInt(1, claimid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ticket = new Ticket(rs.getInt("claim_id"), rs.getInt("emp_id"), rs.getInt("admin_id"), rs.getString("date_of_request"),
                        rs.getString("date_of_resolution"), rs.getString("date_of_expenses"), rs.getObject("expense_image"),
                        rs.getString("claim_status"), rs.getDouble("travel_amount"),rs.getDouble("lodgeing_amount"),
                        rs.getDouble("food_amount"),rs.getDouble("other_amount"), rs.getString("expense_comments"),rs.getDouble("claim_Total"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }
    
    @Override
    public List<Ticket> selectTicketsByEmpId(int empid) {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form WHERE emp_id = ?");
            ps.setInt(1, empid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ticketList.add(new Ticket(rs.getInt("claim_id"), rs.getInt("emp_id"), rs.getInt("admin_id"), rs.getString("date_of_request"),
                        rs.getString("date_of_resolution"), rs.getString("date_of_expenses"), rs.getObject("expense_image"),
                        rs.getString("claim_status"), rs.getDouble("travel_amount"),rs.getDouble("lodgeing_amount"),
                        rs.getDouble("food_amount"),rs.getDouble("other_amount"), rs.getString("expense_comments"),rs.getDouble("claim_Total")));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return ticketList;
    }
    
    
    @Override
    public List<Ticket> selectAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                tickets.add(new Ticket(rs.getInt("claim_id"), rs.getInt("emp_id"), rs.getInt("admin_id"), rs.getString("date_of_request"),
                        rs.getString("date_of_resolution"), rs.getString("date_of_expenses"), rs.getObject("expense_image"),
                        rs.getString("claim_status"), rs.getDouble("travel_amount"),rs.getDouble("lodgeing_amount"),
                        rs.getDouble("food_amount"),rs.getDouble("other_amount"), rs.getString("expense_comments"),rs.getDouble("claim_total")));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println(tickets);
        return tickets;
    }
    
    
    
    @Override
    public List<Ticket> selectAllPendingTickets() {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form WHERE claim_status = 'pending'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ticketList.add(new Ticket(rs.getInt("claim_id"), rs.getInt("emp_id"), rs.getInt("admin_id"), rs.getString("date_of_request"),
                        rs.getString("date_of_resolution"), rs.getString("date_of_expenses"), rs.getObject("expense_image"),
                        rs.getString("claim_status"), rs.getDouble("travel_amount"),rs.getDouble("lodgeing_amount"),
                        rs.getDouble("food_amount"),rs.getDouble("other_amount"), rs.getString("expense_comments"),rs.getDouble("claim_Total")));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("ticketdaoimpl"+ticketList);
        return ticketList;
    }
    
  
    @Override
    public List<Ticket> selectAllPendingTicketsById(int empid) {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form WHERE emp_id = ? AND claim_status = 'pending'");
            ps.setInt(1,empid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ticketList.add(new Ticket(rs.getInt("claim_id"), rs.getInt("emp_id"), rs.getInt("admin_id"), rs.getString("date_of_request"),
                        rs.getString("date_of_resolution"), rs.getString("date_of_expenses"), rs.getObject("expense_image"),
                        rs.getString("claim_status"), rs.getDouble("travel_amount"),rs.getDouble("lodgeing_amount"),
                        rs.getDouble("food_amount"),rs.getDouble("other_amount"), rs.getString("expense_comments"),rs.getDouble("claim_Total")));
          
           // System.out.println("Pending by ID " +ticketList);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(ticketList);
        return ticketList;
    }  
    
    
    @Override
    public List<Ticket> selectAllResolvedTickets() {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form WHERE claim_status = 'resolved'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ticketList.add(new Ticket(rs.getInt("claim_id"), rs.getInt("emp_id"), rs.getInt("admin_id"), rs.getString("date_of_request"),
                        rs.getString("date_of_resolution"), rs.getString("date_of_expenses"), rs.getObject("expense_image"),
                        rs.getString("claim_status"), rs.getDouble("travel_amount"),rs.getDouble("lodgeing_amount"),
                        rs.getDouble("food_amount"),rs.getDouble("other_amount"), rs.getString("expense_comments"),rs.getDouble("claim_Total")));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return ticketList;
    }
    
    
    
    
    
    @Override
    public void updateClaimToResolved(Ticket ticket) {
        try {
            Connection conn = DriverManager.getConnection(url,username, password);
            PreparedStatement ps = conn.prepareStatement("UPDATE reim_form SET claim_status = 'resolved', admin_id =? , date_of_resolution=? WHERE claim_id=?;"); 
            
            ps.setInt(1, ticket.getAdminId()); 
            ps.setString(2, ticket.getDateOfResolution());
            ps.setInt(3, ticket.getClaimId());
            ps.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void updateTicketToDenied(Ticket ticket) {
        try {
            Connection conn = DriverManager.getConnection(url,username, password);
            PreparedStatement ps = conn.prepareStatement("UPDATE reim_form SET claim_status = 'denied', admin_id =? , date_of_resolution=? WHERE claim_id=?;"); 
            
            ps.setInt(1, ticket.getAdminId()); 
            ps.setString(2, ticket.getDateOfResolution());
            ps.setInt(3, ticket.getClaimId());
            ps.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$update approve
    
    @Override
    public void updateTicketToApprove(int cliamId) {
    	
        try {
            Connection conn = DriverManager.getConnection(url,username, password);
            PreparedStatement ps = conn.prepareStatement("UPDATE reim_form SET CLAIM_STATUS = 'Approved' WHERE CLAIM_ID=?"); 
            ps.setInt(1,cliamId );
            ps.executeUpdate(); 
            String msg="Approved.";
            smsApproveAndDenied(cliamId, msg);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$update denied
    
    @Override
    public void updateTicketToReject(int cliamId) {
    	
        try {
            Connection conn = DriverManager.getConnection(url,username, password);
            PreparedStatement ps = conn.prepareStatement("UPDATE reim_form SET CLAIM_STATUS = 'Rejected' WHERE CLAIM_ID=?"); 
            ps.setInt(1,cliamId ); 
            ps.executeUpdate();    
            String msg="Rejected.";
            smsApproveAndDenied(cliamId, msg);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    //######################################################################################################
    
    public List<Ticket> selectPendingTicketsByEmpId(int empid) {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form WHERE emp_id = ? AND claim_status ='pending'");
            ps.setInt(1, empid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ticketList.add(new Ticket(rs.getInt("claim_id"), rs.getInt("emp_id"), rs.getInt("admin_id"), rs.getString("date_of_request"),
                        rs.getString("date_of_resolution"), rs.getString("date_of_expenses"), rs.getObject("expense_image"),
                        rs.getString("claim_status"), rs.getDouble("travel_amount"),rs.getDouble("lodgeing_amount"),
                        rs.getDouble("food_amount"),rs.getDouble("other_amount"), rs.getString("expense_comments"),rs.getDouble("claim_Total")));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return ticketList;
    }
    
    
    public int deleteClaim(Ticket ticket) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void updateClaim(Ticket ticket) {
        // TODO Auto-generated method stub
        
    }
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    public static void sms(int eid,String date,double amount) {
    	
    	try(Connection conn = DriverManager.getConnection(url, username, password)){
    		
    		String Ename="";
    		String number="";
    		int EmpId=eid;
        	String requestDate=date;
        	double total=amount;
        	//String number="+18175839325";
        	
        	PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE EMP_ID=?");
        	ps.setInt(1,EmpId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				Ename =rs.getString("first_name")+" "+rs.getString("last_name");
				number=rs.getString("EMAIL");
			}
          // Find your Account Sid and Token at twilio.com/user/account
           String ACCOUNT_SID = "ACe6ef59fb8554435ffa573ba209a4da13";
          String AUTH_TOKEN = "aaccaa03aa84683a9449ddbe2276d4ca";

          
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(new PhoneNumber(number),
                new PhoneNumber("+12147176263"), 
                
                "Dear "+Ename +" your Expense Reimburstment Request for Amount of "+total+" Has Been Received On "+requestDate).create();

            System.out.println(message.getSid());
				
    	} catch (SQLException e) {
			
			//e.printStackTrace();
		}
    		
    }
 
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
public static void smsApproveAndDenied(int cid,String msg) {
    	
    	try(Connection conn = DriverManager.getConnection(url, username, password)){
    		
    		String Ename="";
    		String number="";
    		int CID=cid;
    		status=msg;
        	
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM reim_form WHERE CLAIM_ID=?");
        	ps.setInt(1,CID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				EID=rs.getInt("EMP_ID");
				amount=rs.getDouble("CLAIM_TOTAL");
				System.out.println(EID+"testing");
			}
			try(Connection conn1 = DriverManager.getConnection(url, username, password)){
				
				PreparedStatement ps1 = conn1.prepareStatement("SELECT * FROM employees WHERE EMP_ID=?");
	        	ps1.setInt(1,EID);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {

					Ename =rs1.getString("FIRST_NAME")+" "+rs1.getString("LAST_NAME");
					number=rs1.getString("EMAIL");
					
					
					 // Find your Account Sid and Token at twilio.com/user/account
			           String ACCOUNT_SID = "ACe6ef59fb8554435ffa573ba209a4da13";
			          String AUTH_TOKEN = "aaccaa03aa84683a9449ddbe2276d4ca";

			          
			            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

			            Message message = Message.creator(new PhoneNumber(number),
			                new PhoneNumber("+12147176263"), 
			                
			                "Dear "+Ename +" your Expense Reimburstment Request for Amount of "+amount+" Has Been "+status+" Thank You.").create();

			            System.out.println(message.getSid());
				}
			}catch (SQLException e) {
				
				//e.printStackTrace();
			}
				
    	} catch (SQLException e) {
			
			//e.printStackTrace();
		}
    		
    }
    }
