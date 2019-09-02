package com.ers.project.dao.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ers.project.daoimpl.UserDAOImpl;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.Users;
import com.ers.project.util.EnDeCrypt;

public class LoginController {
	private static Logger loggy = Logger.getLogger(LoginController.class);
	public static String login(HttpServletRequest request, HttpServletResponse response) {
//		PropertyConfigurator.configure("Log4j.properties");
//		loggy = Logger.getRootLogger();
//		BasicConfigurator.configure();
//		PropertyConfigurator.configure("Log4j.properties");
		MainInterface<Users> userDaoImpl = new UserDAOImpl();
		String user = request.getParameter("Username");
		String pwd = request.getParameter("Password");
		String pwdDeCr = new String();
		Users users = new Users();
		users.setUserName(user);
		users = userDaoImpl.findRecordById(users);
		
		if(users != null ) {
			pwdDeCr = EnDeCrypt.enCrypt(pwd);
			request.getSession().setAttribute("users", users);			
			if(pwdDeCr.equals(users.getPassword())) {
				if(users.getRoleId() == 1) {
					return "/html/EmployeeHome.html";
				}else if(users.getRoleId() == 2) {
					//return "/html/PendingTickets.html";
					return "/html/ManagerHome.html";
				}else if(users.getRoleId() == 3) {
					
				}
				loggy.info(" User: " + users.getFirstName() + " " + users.getLastName());
			}			
		}	
		
		return "/html/Login.html";			
	}

}
