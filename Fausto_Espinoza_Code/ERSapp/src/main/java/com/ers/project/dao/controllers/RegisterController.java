package com.ers.project.dao.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ers.project.daoimpl.EmailDAOImpl;
import com.ers.project.daoimpl.UserDAOImpl;
import com.ers.project.model.Email;
import com.ers.project.model.Users;
import com.ers.project.util.EnDeCrypt;
import com.ers.project.util.SendMail;

public class RegisterController {
	final static Logger loggy = Logger.getLogger(RegisterController.class);
	public static String Register(HttpServletRequest request, HttpServletResponse response) {
//		PropertyConfigurator.configure("Log4j.properties");
		UserDAOImpl userDaoImpl = new UserDAOImpl();
		Users users = new Users();
		Users usersRegister = new Users();
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		pwd = EnDeCrypt.enCrypt(pwd);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		EmailDAOImpl emailDaoImpl = new EmailDAOImpl();
		Email sendEmail = new Email();		
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		
		Long roleId = Long.parseLong(request.getParameter("userRole"));
		
		usersRegister.setUserName(user);
		usersRegister.setPassword(pwd);
		usersRegister.setFirstName(firstName);
		usersRegister.setLastName(lastName);
		usersRegister.setEmail(email);
		usersRegister.setRoleId(roleId);
		
		
		users = userDaoImpl.findRecordById(usersRegister);
		if(users == null) {
			users = userDaoImpl.findByEmail(usersRegister);
			if(users == null) {				
				userDaoImpl.createRecord(usersRegister);
				sendEmail.seteMailId(1);
				SendMail.sendMail(emailDaoImpl.findRecordById(sendEmail), usersRegister);
				loggy.info(" User created: " + usersRegister.getFirstName() + " " + usersRegister.getLastName());
				return "/html/Login.html";
			}			
		}			
		return "/html/EnrollUser.html";
	}

}
