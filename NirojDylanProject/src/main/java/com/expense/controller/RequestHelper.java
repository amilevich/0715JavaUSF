package com.expense.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {

		switch(request.getRequestURI()) {
		
		case "/NirojDylanProject/html/Login.do":
			return LoginController.Login(request,response);
		
		case "/NirojDylanProject/html/Dashboard.do":
			return DashboardController.Dashboard(request,response);
			
		case "/NirojDylanProject/html/Dashboard1.do":
			return DashboardController.NewReimForm(request);
			
		case "/NirojDylanProject/html/getTicket.do":
			return LoginController.getTicket(response);
			
		case "/NirojDylanProject/html/PendingById.do":
			return LoginController.getPendingtTicketById(response);
			
		/*case "/NirojDylanProject/html/ManagerDashBoard.do":
			return LoginController.getPendingtTicketById(response);*/
					
		case "/NirojDylanProject/html/ManagerPendingTickets.do":
			return LoginController.getPendingtTickets(response);
			//System.out.println("test requesthelper");
			
		/*case "/NirojDylanProject/html/ManagerPastTickets.do":
			return LoginController.getPendingtTicketById(response);*/
		
		case "/NirojDylanProject/html/ManagerRequest.do":
			return LoginController.getPendingtTickets(response);
			//System.out.println("test requesthelper");
			
		case "/NirojDylanProject/html/approve.do":
			return LoginController.updateApprove(request,response);
			//System.out.println("test requesthelper");
			
		case "/NirojDylanProject/html/deny.do":
			return LoginController.updateDenied(request,response);
			//System.out.println("test requesthelper");
			
		case "/NirojDylanProject/html/ManagerPastTickets.do":
			return LoginController.getPendingtTicketByIdManager(request,response);
			//System.out.println("test requesthelper");
		
			
		default:
			return "/html/Login.html";
		}
	}

}
