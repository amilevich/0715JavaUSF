package com.project1.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;

import com.project1.DAO.ReimbursementDAOImpl;
import com.project1.model.Reimbursement;
import com.project1.model.Users;

public class NewReimbRequestController {
	
	
public static String newRequest(HttpServletRequest request) throws IOException, ServletException, SerialException, SQLException {
		
		Users user = (Users) request.getSession().getAttribute("Users");
		
		int newTicketid = 0;
		Integer newAmount = Integer.parseInt(request.getParameter("Amount"));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp resolved = null;
		String newdescription = request.getParameter("description");
		int AuthorID = user.getUsersID();
		String status = "pending";
		int status_ID = 1;
		int typeid = 0;
		String type =(request.getParameter("Type"));
		
		if(type.equals("Lodging")) {
			
			typeid = 1;
			
		} else if (type.equals("Travel")){
			
			typeid = 2;
			
		} else if (type.equals("Food")) {
			
			typeid = 3;
			
		} else if (type.equals("Other")) {
			
			typeid = 4;
		}
		
		
		System.out.println(type);
	
		
		
		
		
		
		Reimbursement newticket = new Reimbursement();
		
		newticket.setReimb_ID(newTicketid);
		newticket.setReimb_Amount(newAmount);
		newticket.setReimb_Submitted(timestamp);
		newticket.setReimb_Resolved(resolved);
		newticket.setReimb_Description(newdescription);
		newticket.setReimb_Receipt(null);
		newticket.setReimb_Author(AuthorID);
		newticket.setReimb_Resolver(0);
		newticket.setReimb_Status_ID(status_ID);
		newticket.setReimb_Status(status);
		newticket.setReimb_Type_ID(typeid);
		newticket.setReimb_Type(type);
		
		ReimbursementDAOImpl reimbursementDAOImpl = new ReimbursementDAOImpl();
		
		reimbursementDAOImpl.insertReimbursement(newticket);
		
		
		
		
		
		return "/html/NewReimbRequest.html";
	}

}
