package com.expense.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expense.beans.Employee;
import com.expense.beans.Form;
import com.expense.dao.FormDaoImple;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DashboardController {

	public static String Dashboard(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the employee object in our session
		Employee emp = (Employee) request.getSession().getAttribute("Employee");

		try {
			//converting the object employee into JSON for JavaScript to receive
			response.getWriter().write(new ObjectMapper().writeValueAsString(emp));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 
		return null;
	}
	
	
	
	public static String NewReimForm(HttpServletRequest request) {
		//The request is the submitted form from HTML -> JS(ajax) ->java(this method)
		
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
		Form form = new Form();
		//form.setClaimId(claim_id);
		form.setEmpId(emp_id);
		form.setDateOfRequest(dateOfRequest);
		form.setDateOfExpense(dateOfExpense);
		//form.setClaimStatus(claimStatus);
		form.setTravelAmount(travel_amount);
		form.setLodgeingAmount(lodgeing_amount);
		form.setFoodAmount(food_amount);
		form.setOtherAmount(other_amount);
		form.setComments(comments);
		form.setClaimTotal(claimTotal);
		
		//Submits object into Database via DAO
		FormDaoImple formDaoImpl = new FormDaoImple();
		formDaoImpl.insertForm(form);
		
		return "/html/Dashboard.html";
		
	}
	
}
