package com.ers.project.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.project.daoimpl.UserRolesDAOImpl;
import com.ers.project.model.UserRoles;
import com.ers.project.util.JsonUtil;

@WebServlet("/html/addRoles")
public class UserRolesServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException ,IOException {
		UserRoles userRoles = new UserRoles();
		List<UserRoles> userRolesList = new ArrayList<>();
		UserRolesDAOImpl userImpl = new UserRolesDAOImpl();
		String name = request.getParameter("nameRoles");		
		
//		if(!name.equals("")) {
//			userRoles.setRoleName(name);
//			userImpl.createRecord(userRoles);
//		}	
		
		userRolesList = userImpl.findAllRecord();
		
		if(userRolesList != null) {
//			String JsonStatus = JsonUtil.convertJavaToJson(userRolesList);
//			System.out.println(JsonStatus);
//			response.getWriter().write(JsonStatus);
		}		
		
		
		
//		response.sendRedirect("/ERSapp/html/UserRoles.html");
	}
}
