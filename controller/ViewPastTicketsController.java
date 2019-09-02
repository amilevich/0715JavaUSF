package com.project1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.DAO.ReimbursementDAOImpl;
import com.project1.model.Reimbursement;
import com.project1.model.Users;

public class ViewPastTicketsController {
	
	
	public static String showalltickets(HttpServletRequest request, HttpServletResponse response) {
	
		Users user = (Users) request.getSession().getAttribute("User");
		
		ReimbursementDAOImpl reimbursementDAOImpl= new ReimbursementDAOImpl();
		
		List<Reimbursement> alist = reimbursementDAOImpl.selectByUsersID(user.getUsersID());
		
		try {
			//converting the object pet into JSON for JavaScript to receive
			response.getWriter().write(new ObjectMapper().writeValueAsString(alist));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return null;
	}

}
