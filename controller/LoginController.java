package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.DAO.UsersDAOImpl;
import com.project1.model.Users;

public class LoginController {

	public static String Login(HttpServletRequest request) {

		String username = request.getParameter("username");
		
		System.out.println(username);
		String password = request.getParameter("password");
		System.out.println(password);
		
		UsersDAOImpl usersdaoimpl = new UsersDAOImpl();
		Users user = new Users();
		

		user = usersdaoimpl.selectUsersByUsername(username);
		
		//System.out.println(user);
		if(user != null) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
		
				request.getSession().setAttribute("user", user);

				return "/html/Home.html";
			}
		}
		
		
		return "/html/Login.html";

	}
}