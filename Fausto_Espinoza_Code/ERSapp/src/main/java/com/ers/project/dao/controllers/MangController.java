package com.ers.project.dao.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.project.model.Users;

public class MangController {
	final static Logger loggy = Logger.getLogger(MangTicketAprController.class);
	public static String HomeMnag(HttpServletRequest request, HttpServletResponse response) {
		loggy.info("Manager Home");
		Users users = (Users) request.getSession().getAttribute("users");
//		System.out.println(users);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(users == null) return "/html/Login.html";
		
		request.getSession().setAttribute("users", users);		
		
		return "/html/ManagerHome.html";
	}
}
