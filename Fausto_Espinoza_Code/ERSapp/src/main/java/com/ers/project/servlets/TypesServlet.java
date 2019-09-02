package com.ers.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.project.daoimpl.TypesDAOImpl;
import com.ers.project.model.ReimbursementTypes;

@WebServlet("/addTypes")
public class TypesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		TypesDAOImpl typeDaoImpl = new TypesDAOImpl();
		ReimbursementTypes type = new ReimbursementTypes();
		String name = new String();
		
		name = request.getParameter("nameTypes");
		
		if(!name.equals("")) {
			type.setTypeName(name);
			typeDaoImpl.createRecord(type);
		}	
		response.sendRedirect("rsbmtypes.html");
	}
}
