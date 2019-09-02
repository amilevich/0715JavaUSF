package com.project1.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.project1.DAO.ReimbursementDAOImpl;
import com.project1.model.Reimbursement;
import com.project1.model.Users;

public class RequestApprovalController {
	
	
public static String approve(HttpServletRequest request) {
		
		Users user = (Users) request.getSession().getAttribute("User");
	
		int Resolverid = user.getUsersID();
		
		ReimbursementDAOImpl ersReimbursementDaoImpl = new ReimbursementDAOImpl();
		
		
		Reimbursement updatedTicket = new Reimbursement();
		
		//The value from the select. It get the Id that i wish to manipulate
		Integer ticketID = Integer.parseInt(request.getParameter("selectBar2"));
		
		//The new ticket status that i wish to update to in the ticket
		String newStatus = (request.getParameter("selectBar1"));
		
		
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		ReimbursementDAOImpl reimbursement = new ReimbursementDAOImpl();
		updatedTicket = reimbursement.selectReimbursementByReimbID(ticketID);
		
		updatedTicket.setReimb_Status(newStatus);
		updatedTicket.setReimb_Resolver(Resolverid);
		updatedTicket.setReimb_Resolved(timestamp);
		
		
		reimbursement.updateReimbursement(updatedTicket);
	
		//String username = request.getParameter("username");
		
		
		
		
	
		
		
		
		

		
	
		
		
		return "/html/RequestDenial.html";
	}

}
