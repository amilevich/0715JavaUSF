package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.ProfileController;
import com.revature.controller.RegisterController;

public class RequestHelper {
	
public static String process(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException, ServletException, SQLException {
		
		switch(request.getRequestURI()) {
		//depending on the URI that comes with the request, this 
		//method chooses the corresponding controller and calls
		//the method within that controller
		
		case "/PROJECT1/html/Login.do":
			return LoginController.Login(request);
		
		case "/PROJECT1/html/Home.do":
			return HomeController.Home(request, response);
			
		case "/PROJECT1/html/haha.do":
			return RegisterController.Register(request);
			
		case "/PROJECT1/html/Update.do":
			return ProfileController.showalltickets(request, response);
		case "/PROJECT1/html/ViewPast.do":
			return ViewPastController.showalltickets(request, response);
			
		case "/PROJECT1/html/fart.do":
			return NewTicketController.newTicket(request);
		case "/PROJECT1/html/bark.do":
			return ApproveController.approve(request);
		default:
			return "/html/Login.html";
		}
	}
}
