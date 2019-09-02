package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ErsUsersDaoImpls;
import com.revature.model.ErsUsers;

public class RegisterController {

	public static String Register(HttpServletRequest request) {
		
		
		String username = request.getParameter("username");
		String ersPassword = request.getParameter("userpassword");
		String userFirstName = request.getParameter("firstName");
		String userLastName = request.getParameter("userLastName");
		String userEmail = request.getParameter("userEmail");
		
		
		
		ErsUsers user = new ErsUsers();
		
		user.setErsUserId(0);
		user.setErsUserName(username);
		user.setErsPassword(ersPassword);
		user.setUserFirstName(userFirstName);
		user.setUserLastName(userLastName);
		user.setUserEmail(userEmail);
		user.setUserRoleId(2);
		
		

		
		ErsUsersDaoImpls ersUserDaoImpls = new ErsUsersDaoImpls();
		
		ersUserDaoImpls.insertErsUser(user);
		
		
		return "/html/Login.html";
	}

}
