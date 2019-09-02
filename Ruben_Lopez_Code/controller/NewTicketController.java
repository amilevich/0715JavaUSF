package com.revature.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.revature.dao.ErsReimbursementDaoImpls;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUsers;

public class NewTicketController {
		
public static String newTicket(HttpServletRequest request) throws IOException, ServletException, SerialException, SQLException {
		
		ErsUsers user1 = (ErsUsers) request.getSession().getAttribute("User1");
		
		int newTicketid = 0;
		Integer newAmount = Integer.parseInt(request.getParameter("Amount"));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp resolved = null;
		String newdescription = request.getParameter("description");
		//Blob filePart = (Blob)(request.getPart("avatar"));
		int AuthorID = user1.getErsUserId();
		int status = 1;
		Integer type = Integer.parseInt( request.getParameter("TypeID"));
		
		System.out.println(type);
	
		
		//String pic = request.getParameter("inputGroupFile01");
		
		
		
		
		
		
		
		
		ErsReimbursement newticket = new ErsReimbursement();
		
		newticket.setReimbID(newTicketid);
		newticket.setReimbAmount(newAmount);
		newticket.setReimbSubmitted(timestamp);
		newticket.setReimbResolved(resolved);
		newticket.setReimbDescription(newdescription);
		newticket.setReimbReceipt(null);
		newticket.setReimbAuthor(AuthorID);
		newticket.setReimbResolver(0);
		newticket.setReimbStatusID(status);
		newticket.setReimbTypeID(type);
		
		ErsReimbursementDaoImpls ersReimbursementDaoImpls = new ErsReimbursementDaoImpls();
		
		ersReimbursementDaoImpls.insertErsReimbursement(newticket);
		
		
		//id--
		//amount--
		//submitted--
		//resolved--
		//description--
		//receipt--
		//Author--
		//Resolver
		//status
		//typed
		
		
		
		return "/html/AddTicket.html";
	}
}
