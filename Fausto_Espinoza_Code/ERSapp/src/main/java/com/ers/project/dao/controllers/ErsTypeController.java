package com.ers.project.dao.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.project.daoimpl.TypesDAOImpl;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.ReimbursementTypes;
import com.ers.project.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErsTypeController {
	final static Logger loggy = Logger.getLogger(ErsTypeController.class);
	public static String TypeTicket(HttpServletRequest request, HttpServletResponse response) {
		List<ReimbursementTypes> typeList = new ArrayList<>();
		TypesDAOImpl typeImpl = new TypesDAOImpl();
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		
		typeList = typeImpl.findAllRecord();
		if (typeList != null) {
			loggy.info(" Send JSON Data to type");
//			String jsonString = JsonUtil.convertJavaToJson(typeList);			
//			System.out.println(jsonString);
			try {
//				response.getWriter().write(jsonString);
				response.getWriter().write(new ObjectMapper().writeValueAsString(typeList));
			} catch (IOException e) {
				System.out.println("Error to generate Json: " + e.getMessage());
			}
		}
		return null;
	}
}
