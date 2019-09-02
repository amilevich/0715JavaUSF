package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsReimbursementDaoImpls;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUsers;


public class ViewPastController {
		
	
	public static String showalltickets(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ErsUsers user1 = (ErsUsers) request.getSession().getAttribute("User1");
		List<ErsReimbursement> alist = ErsReimbursementDaoImpls.selectByUserID(user1.getErsUserId());
		
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
