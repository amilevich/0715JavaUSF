package com.p2.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.p2.user.User;
import com.p2.user.UserDAOImpl;

public class LoginController {
	
	private final static Logger loggy = Logger.getLogger(LoginController.class);

	public static String Login(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = new User();		
		user = userDAOImpl.selectUserByUsernameAndPassword(username, password);
		
		//runs if user is empty
		if (user == null) {
			return "/index.html";
		}
		
		//determines if user is employee or financial_manager
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			request.getSession().setAttribute("User", user);
			if (user.getRole().equals("EMPLOYEE")) {
				loggy.info(user.getUsername() + " who is a " + user.getRole() + " logged in to the system.");
				return "/start_page.html";
			} else if (user.getRole().equals("F_N")) {
				loggy.info(user.getUsername() + " who is a " + user.getRole() + " logged in to the system.");
				return "/start_page_fm.html";
			}
		}
		
		return "/index.html";		
		
	}
}