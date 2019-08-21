package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class ProfileController {
	
	public static String Update(HttpServletRequest request) {
		//getting the session that was set upon login in LoginController
		Pet pet = (Pet)request.getSession().getAttribute("Pet");
		
		String type = request.getParameter("type");
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		pet.setType(type);
		petDaoImpl.updatePet(pet);
		
		return "/html/Home.html";
	}

}
