/*package com.expense.controller;

import javax.servlet.http.HttpServletRequest;

import com.expense.beans.Employee;
import com.expense.dao.EmployeeDaoImpl;

public class LoginController {

	
	public static String Login(HttpServletRequest request) {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			EmployeeDaoImpl empDaoImpl = new EmployeeDaoImpl();
			Employee emp = new Employee();
			
			emp = empDaoImpl.selectEmpByUsername(username,password);
			System.out.println(emp);
			
			
				try {
					if(username.equals(emp.getUsername()) && password.equals(emp.getPassword())) {
						request.getSession().setAttribute("Employee", emp);
						
						//System.out.println(emp.getFirstName());
					}
						return "/html/Dashboard.html";
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "/html/index.html";		
		}
	
	
}
*/
package com.expense.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expense.beans.Employee;
import com.expense.beans.Ticket;
import com.expense.dao.EmployeeDaoImpl;
import com.expense.dao.TicketDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController {

	public static String Login(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EmployeeDaoImpl empDaoImpl = new EmployeeDaoImpl();
		Employee emp = new Employee();
		emp = empDaoImpl.selectEmpByUsername(username, password);
		//System.out.println(emp);

		TicketDaoImpl ticketDao = new TicketDaoImpl();
		List<Ticket> ticketList = new ArrayList<>();
		ticketList = ticketDao.selectPendingTicketsByEmpId(emp.getEmpId());
		System.out.println(ticketList);
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@changed by Niroj
		List<Ticket> allTickets=new ArrayList<>();
		allTickets=ticketDao.selectTicketsByEmpId(emp.getEmpId());
		//System.out.println(allTickets);
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@changed by Niroj
		try {
			if (username.equals(emp.getUsername()) && password.equals(emp.getPassword())) {
				request.getSession().setAttribute("Employee", emp);

				response.getWriter().write(new ObjectMapper().writeValueAsString(ticketList));

				return "/html/Dashboard.html";
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/html/index.html";

	}
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%changed by Niroj
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
}