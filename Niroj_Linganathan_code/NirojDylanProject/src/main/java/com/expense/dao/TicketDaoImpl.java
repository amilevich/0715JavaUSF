package com.expense.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.expense.beans.Ticket;

public class TicketDaoImpl implements TicketDao {
	private static String url = "jdbc:oracle:thin:@db0715java.ce8jdxpwtsbf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "niroj85";
	private static String password = "niroj4401";
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
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /*public void insertForm(Form form) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO reim_form VALUES(null,?,null,?,null,?,null,'pending',?,?,?,?,?,?)");
            //ps.setInt(null, form.getClaimId());  //Need to figure out how to sync this with claim_types table
            ps.setInt(1, 5);
            //ps.setInt(null, form.getAdminId());  //Inserted in UPDATE Method
            ps.setString(2, "01/JAN/2000");
            //ps.setString(null, form.getDateOfResolution()); Inserted in UPDATE method
            ps.setString(3, "01/JAN/2000");
            //ps.setBlob(null, image()); Apparently NOT using BLOB for this project
            //ps.setString(4, form.getClaimStatus()); auto fill as pending
            ps.setDouble(4, 55);
            ps.setDouble(5, 55);
            ps.setDouble(6, 55);
            ps.setDouble(7, 55);
            ps.setString(8, "comments");
            ps.setDouble(9, 55);
    
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    */
    
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
        System.out.println(ticketList);
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
    
}
