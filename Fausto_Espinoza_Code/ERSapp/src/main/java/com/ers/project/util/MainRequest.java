package com.ers.project.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.project.dao.controllers.ChangeStatusController;
import com.ers.project.dao.controllers.CreateTicketController;
import com.ers.project.dao.controllers.EmployeeController;
import com.ers.project.dao.controllers.EmployeePastAController;
import com.ers.project.dao.controllers.EmployeePastDController;
import com.ers.project.dao.controllers.EnrollUserController;
import com.ers.project.dao.controllers.ErsTypeController;
import com.ers.project.dao.controllers.FindTicketsEmplController;
import com.ers.project.dao.controllers.FindTicketsMangController;
import com.ers.project.dao.controllers.LoginController;
import com.ers.project.dao.controllers.LogoutController;
import com.ers.project.dao.controllers.MangController;
import com.ers.project.dao.controllers.MangTicketAprController;
import com.ers.project.dao.controllers.MangTicketDenController;
import com.ers.project.dao.controllers.MangTicketPenController;
import com.ers.project.dao.controllers.PastTicketEmplController;
import com.ers.project.dao.controllers.PendTicketsController;
import com.ers.project.dao.controllers.RegisterController;
import com.ers.project.dao.controllers.ReisbormentTicketontroller;

public class MainRequest {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
			case "/ERSapp/html/Login.do": 
				return LoginController.login(request, response);			
			case "/ERSapp/html/EnrollUser.do": 
				return EnrollUserController.populateDrop(request, response);
			case "/ERSapp/html/Enroll.do": 
				return RegisterController.Register(request, response);	
			case "/ERSapp/html/ErsType.do": 				
				return ErsTypeController.TypeTicket(request, response);
			case "/ERSapp/html/Reinbursement.do": 				
				return CreateTicketController.CreateTicket(request, response);
			case "/ERSapp/html/PendingTickets.do": 				
				return PendTicketsController.FindTStatus(request, response);
			case "/ERSapp/html/ChangeStatus.do": 				
				return ChangeStatusController.ChangeStatus(request, response);
			case "/ERSapp/html/FindTicketsMg.do": 				
				return FindTicketsMangController.FindTickets(request, response, 2);
			case "/ERSapp/html/FindTicketsMgDeny.do": 				
				return FindTicketsMangController.FindTickets(request, response, 3);
			case "/ERSapp/html/TickectMang.do": 				
				return MangTicketPenController.GetTicketsPend(request, response);
			case "/ERSapp/html/TickectMangDen.do": 
				return MangTicketDenController.GetTicketsDend(request, response);
			case "/ERSapp/html/TickectMangApr.do": 
				return MangTicketAprController.GetTicketsAprb(request, response);	
			case "/ERSapp/html/HomeMangApr.do": 
				return MangController.HomeMnag(request, response);	
			case "/ERSapp/html/TickectEmpl.do": 
				return FindTicketsEmplController.FindTickets(request, response, 1);
				
			case "/ERSapp/html/TickectEmpl2.do": 
				return FindTicketsEmplController.FindTickets(request, response, 2);
				
			case "/ERSapp/html/TickectEmpl3.do": 
				return FindTicketsEmplController.FindTickets(request, response, 3);
				
				
			case "/ERSapp/html/LogOut.do": 
				return LogoutController.getLogOut(request, response);
			case "/ERSapp/html/HomeEmplApr.do": 
				return EmployeeController.HomeEmpl(request, response);
			case "/ERSapp/html/PastTicketEmpl.do": 
				return PastTicketEmplController.FindTickets(request, response);
			case "/ERSapp/html/ReisbormentTicket.do": 
				return ReisbormentTicketontroller.TicketsEmpl(request, response);
			case "/ERSapp/html/EmployeePatsA.do": 
				return EmployeePastAController.FindTickets(request, response);
			case "/ERSapp/html/EmployeePatsD.do": 
				return EmployeePastDController.FindTickets(request, response);
			default : return "/html/Login.html";
		} 
	}	
} 
