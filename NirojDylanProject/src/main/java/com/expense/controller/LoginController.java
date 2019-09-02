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

import org.apache.log4j.Logger;


import com.expense.beans.Employee;
import com.expense.beans.Ticket;
import com.expense.dao.EmployeeDaoImpl;
import com.expense.dao.TicketDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController {
	
	final static Logger loggy = Logger.getLogger(LoginController.class);

	static int employeeID;
	public static String Login(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String user=request.getParameter("user");
		System.out.println(user);
		
		if(user.equals("employee")) {
			System.out.println("you are employee");
			
			EmployeeDaoImpl empDaoImpl = new EmployeeDaoImpl();
			Employee emp = new Employee();
			emp = empDaoImpl.selectEmpByUsername(username, password);
			
			TicketDaoImpl ticketDao = new TicketDaoImpl();
			
			List<Ticket> allTickets=new ArrayList<>();
			allTickets=ticketDao.selectTicketsByEmpId(emp.getEmpId());
			
			try {
				if (username.equals(emp.getUsername()) && password.equals(emp.getPassword())) {
					request.getSession().setAttribute("Employee", emp);

					response.getWriter().write(new ObjectMapper().writeValueAsString(allTickets));
					employeeID=emp.getEmpId();
					System.out.println(employeeID+"employee");
					loggy.info(username + " Logged In");
					return "/html/Dashboard.html";
				}

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		
		}
		else {
			System.out.println("you are manager");
			loggy.info(username + " Logged In");
			
			return "/html/FinanceManager.html";
		}
		return "/html/index.html";

	}
		
		
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%changed by Niroj
	public static String getTicket( HttpServletResponse response) {//HttpServletRequest request,
		String eid="";
		//String eid=request.getParameter("eid");
		//System.out.println(eid+"vaffafagfa");
		//int eid1=Integer.parseInt(eid);
		//System.out.println(eid1);
		TicketDaoImpl ticketDao = new TicketDaoImpl();
		List<Ticket> allTickets=new ArrayList<>();
		allTickets=ticketDao.selectTicketsByEmpId(employeeID);
		//System.out.println("testing all tickets"+allTickets);
	
		try {
			 {
				response.getWriter().write(new ObjectMapper().writeValueAsString(allTickets));

				return "/html/Dashboard.html";
				
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "/html/index.html";
		return eid;

	}
	
	public static String getPendingtTicketById( HttpServletResponse response) {//HttpServletRequest request,
		String eid="";
		//String eid1=request.getParameter("eid");
		//int eid1=Integer.parseInt(eid);

		TicketDaoImpl ticketDao = new TicketDaoImpl();
		List<Ticket> allTickets=new ArrayList<>();
		allTickets=ticketDao.selectAllPendingTicketsById(employeeID);
		//System.out.println("testing "+allTickets);
	
		try {
			 {
				response.getWriter().write(new ObjectMapper().writeValueAsString(allTickets));

				return "/html/Dashboard.html";
				
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "/html/index.html";
		return eid;
}
	
	//************************************************************manager view pending tickets by employee ID.
	
	public static String getPendingtTicketByIdManager(HttpServletRequest request,HttpServletResponse response) {
		String eid="";
		
		//String EID=request.getParameter("teid");
		//int EmployeeID=Integer.parseInt(EID);
		//System.out.println(EmployeeID);
		TicketDaoImpl ticketDao = new TicketDaoImpl();
		List<Ticket> allTickets=new ArrayList<>();
		allTickets=ticketDao.selectTicketsByEmpId(9000);
		System.out.println("testing "+allTickets);
	
		try {
			 {
				response.getWriter().write(new ObjectMapper().writeValueAsString(allTickets));

				//return "/html/FinanceManager.html";
				
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "/html/index.html";
		return eid;
}
	//************************************************************
	
	
	public static String getPendingtTickets( HttpServletResponse response) {
		String eid="";
		TicketDaoImpl ticketDao = new TicketDaoImpl();
		List<Ticket> allTickets=new ArrayList<>();
		allTickets=ticketDao.selectAllPendingTickets();
		//System.out.println("Manager testing "+allTickets);
	
		try {
			 {
				response.getWriter().write(new ObjectMapper().writeValueAsString(allTickets));

				return "/html/FinanceManager.html";
				
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eid;
}
	
	public static String updateApprove(HttpServletRequest request, HttpServletResponse response) {
		int claimId = Integer.parseInt(request.getParameter("cid1"));
		System.out.println(claimId);
		TicketDaoImpl ticketDao = new TicketDaoImpl();
		ticketDao.updateTicketToApprove(claimId);
		loggy.info(" Claim #" + claimId + " Approved");
		return "/html/FinanceManager.html";

	}
	
	public static String updateDenied(HttpServletRequest request, HttpServletResponse response) {
		
		int claimId = Integer.parseInt(request.getParameter("cid"));
		System.out.println(claimId);
		TicketDaoImpl ticketDao = new TicketDaoImpl();
		ticketDao.updateTicketToReject(claimId);
		loggy.info(" Claim #" + claimId + " Denied");
		return "/html/FinanceManager.html";

	}
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
}