package com.ers.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.project.daoimpl.StatusDAOImpl;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.ReimbursementStatus;
import com.ers.project.util.JsonUtil;

@WebServlet("/addStatus")
public class StatusServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse  response ) throws ServletException ,IOException {
		String name = new String();
		String jsonStatus = new String();
		List<ReimbursementStatus> statusList = new ArrayList<>();
		MainInterface<ReimbursementStatus> statussDAO = new StatusDAOImpl();
		ReimbursementStatus status = new ReimbursementStatus();
		try(PrintWriter out = response.getWriter()){
			name = request.getParameter("nameStatus");
			System.out.println(name);
			if(!name.equals("")) {
				status.setStatusName(name);
				statussDAO.createRecord(status);				
			}
			
			statusList = statussDAO.findAllRecord();
			if (statusList != null) {
//				jsonStatus = JsonUtil.convertJavaToJson(statusList);
				out.print(jsonStatus);
			}
			
			response.sendRedirect("rsbmstatus.html");	
		}catch(Exception e) {
			System.out.println("Exception while taking PrintWriter");
		}
	}

}
