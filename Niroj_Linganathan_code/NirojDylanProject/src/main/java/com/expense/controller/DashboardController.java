package com.expense.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expense.beans.Employee;
import com.expense.beans.Ticket;
import com.expense.dao.TicketDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DashboardController {

	public static String Dashboard(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the employee object in our session
		Employee emp = (Employee) request.getSession().getAttribute("Employee");

		try {
			//converting the object employee into JSON for JavaScript to receive
			response.getWriter().write(new ObjectMapper().writeValueAsString(emp));
			//System.out.println(emp+"gusqus");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 
		return null;
		
		
	}
	
	
	
	public static String NewReimForm(HttpServletRequest request) {
		//The request is the submitted form from HTML -> JS(ajax) ->java(this method)
		//System.out.println(request.toString());
		
		//assigns all json feild names to a variable
		//int claim_id = Integer.parseInt(request.getParameter("claim_id"));
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String dateOfRequest = request.getParameter("date_of_request");
		String dateOfExpense = request.getParameter("date_of_expense");
		//String claimStatus = request.getParameter("claim_status");
		
		double travel_amount = Double.parseDouble(request.getParameter("travel_amount"));
		double lodgeing_amount = Double.parseDouble(request.getParameter("lodgeing_amount"));
		double food_amount = Double.parseDouble(request.getParameter("food_amount"));
		double other_amount = Double.parseDouble(request.getParameter("other_amount"));
		String comments = request.getParameter("expense_comments");
		double claimTotal = Double.parseDouble(request.getParameter("claim_total"));
	
				
				//creates a Form object, sets all values into Object
		Ticket ticket = new Ticket();
		//form.setClaimId(claim_id);
		ticket.setEmpId(emp_id);
		ticket.setDateOfRequest(dateOfRequest);
		ticket.setDateOfExpense(dateOfExpense);
		//form.setClaimStatus(claimStatus);
		ticket.setTravelAmount(travel_amount);
		ticket.setLodgeingAmount(lodgeing_amount);
		ticket.setFoodAmount(food_amount);
		ticket.setOtherAmount(other_amount);
		ticket.setComments(comments);
		ticket.setClaimTotal(claimTotal);
		
		//Submits object into Database via DAO
		TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();
		ticketDaoImpl.insertTicket(ticket);
		
		return "/html/Dashboard.html";
		
	}
	
}
