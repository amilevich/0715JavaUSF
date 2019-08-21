package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		//depending on the URI that comes with the request, this 
		//method chooses the corresponding controller and calls
		//the method within that controller
		
		case "/PetsFrontController/html/Login.do":
			return LoginController.Login(request);
		
		case "/PetsFrontController/html/Home.do":
			return HomeController.Home(request, response);
			
		case "/PetsFrontController/html/Register.do":
			return RegisterController.Register(request);
			
		case "/PetsFrontController/html/Update.do":
			return ProfileController.Update(request);
			
		default:
			return "/html/Login.html";
		}
	}
}
