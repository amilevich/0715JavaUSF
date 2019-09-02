package com.ers.project.dao.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ers.project.daoimpl.UserRolesDAOImpl;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.UserRoles;
import com.ers.project.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnrollUserController {	
	final static Logger loggy = Logger.getLogger(EnrollUserController.class);
	public static String populateDrop(HttpServletRequest request, HttpServletResponse response) {
		//PropertyConfigurator.configure("Log4j.properties");
		List<UserRoles> userRolesList = new ArrayList<>();
		MainInterface<UserRoles> userRolesImpl = new UserRolesDAOImpl();
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		
		userRolesList = userRolesImpl.findAllRecord();
		if (userRolesList != null) {
			loggy.info(" Send JSON Data to user enroll");
//			String jsonString = JsonUtil.convertJavaToJson(userRolesList);			
			//System.out.println(jsonString);
			try {
//				response.getWriter().write(jsonString);
				response.getWriter().write(new ObjectMapper().writeValueAsString(userRolesList));
			} catch (IOException e) {
				System.out.println("Error to generate Json: " + e.getMessage());
			}
		}
		return null;
	}
}
