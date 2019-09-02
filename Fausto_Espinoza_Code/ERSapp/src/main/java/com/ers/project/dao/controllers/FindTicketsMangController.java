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
import com.ers.project.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FindTicketsMangController {
	final static Logger loggy = Logger.getLogger(FindTicketsMangController.class);
	public static String FindTickets(HttpServletRequest request , HttpServletResponse response, long status) {
		TicketDAOImpl ticketDaoimpl = new TicketDAOImpl();
//		List<ReimbursementTicket> ticketsList = new ArrayList<>();
		List<Ticket> ticketsList = new ArrayList<>();
		
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		
//		ticketsList = ticketDaoimpl.findAllRecord(status);
		ticketsList = ticketDaoimpl.findAllTicket(status);
		
		if(ticketsList != null) {
			loggy.info(" Send JSON Data to tickets");
//			String jsonString = JsonUtil.convertJavaToJson(ticketsList);			
			try {
//				response.getWriter().write(jsonString);
//				System.out.println(new ObjectMapper().writeValueAsString(ticketsList));
				response.getWriter().write(new ObjectMapper().writeValueAsString(ticketsList));
			} catch (IOException e) {
				System.out.println("Error to generate Json: " + e.getMessage());
			}
		}
		return null;
	}


}
