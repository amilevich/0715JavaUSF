package com.ers.project.dao.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.project.daoimpl.TicketDAOImpl;
import com.ers.project.model.ReimbursementTicket;
import com.ers.project.model.Ticket;
import com.ers.project.model.Users;
import com.ers.project.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PendTicketsController {
	final static Logger loggy = Logger.getLogger(PendTicketsController.class);
	public static String FindTStatus(HttpServletRequest request , HttpServletResponse response) {
		TicketDAOImpl ticketDaoimpl = new TicketDAOImpl();
//		List<ReimbursementTicket> ticketsList = new ArrayList<>();
		List<Ticket> ticketsList = new ArrayList<>();
		Users users = (Users) request.getSession().getAttribute("users");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
//		System.out.println(users);
		if(users == null) return "/html/Login.html";
		
//		ticketsList = ticketDaoimpl.findAllRecord(1);
		ticketsList = ticketDaoimpl.findAllTicket(1);
		
		if(ticketsList != null) {
			loggy.info(" Send JSON Data to tickets");			
//			String jsonString = JsonUtil.convertJavaToJson(ticketsList);			
//			System.out.println(jsonString);
			try {
//				System.out.println(new ObjectMapper().writeValueAsString(ticketsList));
				response.getWriter().write(new ObjectMapper().writeValueAsString(ticketsList));
				//response.getWriter().write(jsonString);
			} catch (IOException e) {
				System.out.println("Error to generate Json: " + e.getMessage());
			}
		}
		return null;
	}

}
