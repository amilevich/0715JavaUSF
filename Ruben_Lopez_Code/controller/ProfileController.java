package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsReimbursementDaoImpls;
import com.revature.model.ErsReimbursement;

public class ProfileController {

	public static String showalltickets(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List<ErsReimbursement> alist = ErsReimbursementDaoImpls.selectAllReimbursement();
		
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
