package com.project1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.project1.model.Users;

public class HomeController {
	
	//the purpose of this is to getting the session attributes and converting it to JSON
	
	
		public static String Home(HttpServletRequest request, HttpServletResponse response) {
			
			//retrieving the user object in our session
					Users user = (Users)request.getSession().getAttribute("user");

					try {
						//converting the object user into JSON for JavaScript to receive
						response.getWriter().write(new ObjectMapper().writeValueAsString(user));
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					return null;
				}
			

}
