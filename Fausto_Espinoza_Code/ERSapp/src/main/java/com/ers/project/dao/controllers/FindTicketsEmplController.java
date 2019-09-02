package com.ers.project.dao.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.project.daoimpl.TicketDAOImpl;
import com.ers.project.model.ReimbursementTicket;
import com.ers.project.model.Users;
import com.ers.project.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FindTicketsEmplController {
	final static Logger loggy = Logger.getLogger(FindTicketsEmplController.class);
	public static String FindTickets(HttpServletRequest request , HttpServletResponse response, long status) {
		TicketDAOImpl ticketDaoimpl = new TicketDAOImpl();
		Users users = (Users) request.getSession().getAttribute("users");
//		System.out.println(users);
		String test = new String();
		List<ReimbursementTicket> ticketsList = new ArrayList<>();	
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(users == null) return "/html/Login.html";		
//		test = request.getParameter("jsonText");
//		System.out.println("Jackson " + test);
		try {
			ticketsList = ticketDaoimpl.findAllRecord(status, users.getUserId());
			
			if(ticketsList != null) {
				loggy.info(" Send JSON Data to tickets Empl");
	//			String jsonString = JsonUtil.convertJavaToJson(ticketsList);			
				try {
	//				response.getWriter().write(jsonString);
					response.getWriter().write(new ObjectMapper().writeValueAsString(ticketsList));
				} catch (IOException e) {
					System.out.println("Error to generate Json: " + e.getMessage());
				}
			}
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage() );
		}
		return null;
	}
}
