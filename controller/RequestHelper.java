package com.project1.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.project1.controller.LoginController;



public class RequestHelper {
	
	
public static String process(HttpServletRequest req, HttpServletResponse response) throws SerialException, IOException, ServletException, SQLException {
		
		switch(req.getRequestURI()) {
		
		// checks for the URI. for example "Login.do", "Home.do"
		case "/E.R.S_Project1/html/Login.do":
			
			return LoginController.Login(req);
			
		case "/E.R.S_Project1/html/Home.do":
			return HomeController.Home(req, response);
			
		case "/E.R.S_Project1/html/Update.do":
			return ProfileController.showalltickets(req, response);
		
		case "/E.R.S_Project1/html/Approval.do":
			return RequestApprovalController.approve(req);
			
		case "/E.R.S_Project1/html/money.do":
			return NewReimbRequestController.newRequest(req);
			
		case "/E.R.S_Project1/html/oldtickets.do":
			return ViewPastTicketsController.showalltickets(req, response);
			
		default:
			return "/html/Login.html";
		}
	}


}
