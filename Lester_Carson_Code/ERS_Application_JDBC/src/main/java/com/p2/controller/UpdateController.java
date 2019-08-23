package com.p2.controller;

import javax.servlet.http.HttpServletRequest;
import com.p2.reimbursment.Reimbursement;
import com.p2.reimbursment.ReimbursementDAOImpl;

public class UpdateController {

	public static String Update(HttpServletRequest request) {
		//getting the session that was set upon login in LoginController
		ReimbursementDAOImpl reimDAOImpl = new ReimbursementDAOImpl();
		String id = request.getParameter("id");
		Reimbursement reim = reimDAOImpl.selectReimbursmentById(Integer.parseInt(id));
		
		String status = request.getParameter("status");
		reim.setStatus(status);
		reimDAOImpl.updateReimbursmentByStatus(reim);
		
		return "/start_page.html";
	}
	
}