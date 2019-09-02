package com.revature.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.dao.ErsReimbursementDaoImpls;

import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUsers;

public class ApproveController {
	
public static String approve(HttpServletRequest request) {
	
		final  Logger loggyApprove = Logger.getLogger(ApproveController.class);
		
		ErsUsers user1 = (ErsUsers) request.getSession().getAttribute("User1");
	
		int Resolverid = user1.getErsUserId();
		
		ErsReimbursementDaoImpls ersReimbursementDaoImpls = new ErsReimbursementDaoImpls();
		
		
		ErsReimbursement updatedTicket = new ErsReimbursement();
		
		//The value from the select. It get the Id that i wish to manipulate
		Integer ticketID = Integer.parseInt(request.getParameter("selectBar2"));
		
		//The new ticket status that i wish to update to in the ticket
		Integer newStatus = Integer.parseInt(request.getParameter("selectBar1"));
		
		
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		
		updatedTicket = ersReimbursementDaoImpls.selectErsReimbursementbyId(ticketID);
		
		updatedTicket.setReimbStatusID(newStatus);
		updatedTicket.setReimbResolver(Resolverid);
		updatedTicket.setReimbResolved(timestamp);
		
		
		ersReimbursementDaoImpls.updateReimbursement(updatedTicket);
	
		//String username = request.getParameter("username");
		
		
		
		
	
		
		
		
		

		
	
		
		
		return "/html/AppDenied.html";
	}

}
