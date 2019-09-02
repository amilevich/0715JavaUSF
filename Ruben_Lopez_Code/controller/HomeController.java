package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ErsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {

	
	public static String Home(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the pet object in our session
		ErsUsers user1 = (ErsUsers) request.getSession().getAttribute("User1");

		try {
			//converting the object pet into JSON for JavaScript to receive
			response.getWriter().write(new ObjectMapper().writeValueAsString(user1));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Marshalling (similar to serialization) is the process of transforming memory
		 * representation of an object to a data format suitable for storage or
		 * transmission.
		 * 
		 * Object -> JSON Unmarshalling JSON -> Object
		 * 
		 * Our tool of choice: Jackson (JSON marshalling tool)
		 */
		return null;
	}
}
