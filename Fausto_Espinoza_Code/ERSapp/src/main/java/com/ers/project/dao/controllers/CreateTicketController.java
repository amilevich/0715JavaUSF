package com.ers.project.dao.controllers;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.project.daoimpl.TicketDAOImpl;
import com.ers.project.model.ReimbursementTicket;
import com.ers.project.model.Users;

public class CreateTicketController {
	final static Logger loggy = Logger.getLogger(CreateTicketController.class);
	public static String CreateTicket(HttpServletRequest request, HttpServletResponse response){		
//		Date date = new Date();
//		long time = date.getTime();
//		Timestamp ts = new Timestamp(time);
		TicketDAOImpl ticketDaoImpl = new TicketDAOImpl();
		ReimbursementTicket ticket = new ReimbursementTicket();
		Users users = (Users) request.getSession().getAttribute("users");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(users == null) return "/html/Login.html";
		try {
			double amount = Double.parseDouble(request.getParameter("amount"));		
			String file = request.getParameter("file");		
			String observation = request.getParameter("name");		
			Long typeTicket = Long.parseLong(request.getParameter("type"));			
			
			Timestamp ts =  new Timestamp(new Date().getTime());
			
			ticket.setReimbAmount(amount);
			ticket.setReimbSubmitted(ts);
			ticket.setReimbDescription(observation);
			ticket.setBlob(null);
			ticket.setReimbAuthor(users.getUserId());
			ticket.setReimbtypeId(typeTicket);
			
			ticketDaoImpl.createRecord(ticket);
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		loggy.info(" User: " + users.getFirstName() + " " + users.getLastName());
		
		return "/html/CreateReimbursement.html";
	}

}
