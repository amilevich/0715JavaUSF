package com.ers.project.dao.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.project.model.Users;

public class EmployeePastDController {
	final static Logger loggy = Logger.getLogger(PastTicketEmplController.class);
	public static String FindTickets(HttpServletRequest request, HttpServletResponse response) {
		loggy.info("Past Employee Ticket");
		Users users = (Users) request.getSession().getAttribute("users");
//		System.out.println(users);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(users == null) return "/html/Login.html";
		
		request.getSession().setAttribute("users", users);		
		
		return "/html/EmpPastHistoryDenied.html";
	}
}
