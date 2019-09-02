package com.ers.project.dao.controllers;

import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.project.daoimpl.TicketDAOImpl;
import com.ers.project.model.ReimbursementTicket;
import com.ers.project.model.Users;

public class ChangeStatusController {
	final static Logger loggy = Logger.getLogger(ChangeStatusController.class);
	public static String ChangeStatus(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("jsonText");		
		ReimbursementTicket ticket = new ReimbursementTicket();
		TicketDAOImpl ticketDaoImpl = new TicketDAOImpl();
		Timestamp ts =  new Timestamp(new Date().getTime());
		Users users = (Users) request.getSession().getAttribute("users");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(users == null) return "/html/Login.html";
		
//		System.out.println(code);
		if(!code.equals("")) {
			boolean flag = true;
			while(flag) {				
				int endIndex = code.indexOf(":");
				int tmpIndex = code.indexOf(",");
				
				if(tmpIndex > 0) {
					long idTicket = Long.parseLong(code.substring(endIndex + 1, tmpIndex));
					System.out.println(idTicket);
					code = "" + code.subSequence(tmpIndex + 2, code.length());	
//					System.out.println(code);
					endIndex = code.indexOf(":");
					tmpIndex = code.indexOf("}");
					long idStatus = Long.parseLong(code.substring(endIndex + 1, tmpIndex));	
//					System.out.println(idStatus);
					code = "" + code.subSequence(tmpIndex + 2, code.length());
//					System.out.println(code);
					if(idStatus != 1) {
						ticket.setReimbResolved(ts);
						ticket.setReimbResolver(users.getUserId());
						ticket.setReimbstatusId(idStatus);
						ticket.setReimbId(idTicket);
						if (ticketDaoImpl.updateRecord(ticket)) System.out.println("Succefull");
						else System.out.println("Error");
					}
				}else flag = false;
			}			
		}
		loggy.info(" User: " + users.getFirstName() + " " + users.getLastName());
		return "/html/PendingTickets.html";		
	}
}
