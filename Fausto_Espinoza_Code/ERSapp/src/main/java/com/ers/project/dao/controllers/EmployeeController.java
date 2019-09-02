package com.ers.project.dao.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ers.project.model.Users;

public class EmployeeController {
	final static Logger loggy = Logger.getLogger(EmployeeController.class);
	public static String HomeEmpl(HttpServletRequest request, HttpServletResponse response) {
//		PropertyConfigurator.configure("Log4j.properties");
		loggy.info("Employee Home");
		Users users = (Users) request.getSession().getAttribute("users");
//		System.out.println(users);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(users == null) return "/html/Login.html";
		
		request.getSession().setAttribute("users", users);		
		
		return "/html/EmployeeHome.html";
	}

}
