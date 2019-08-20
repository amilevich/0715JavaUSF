package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PrintWriter
		PrintWriter printWriter = response.getWriter();
		String fColor = "RedMagentaLavender";
		printWriter.write("<h1>Go back and press the other button, yo</h1>");
		printWriter.write("<h2>Btw my favorite color is: " + fColor + "</h2>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//forward
		//request.getRequestDispatcher("Home.html").forward(request, response);
		
		//redirect
		response.sendRedirect("https://tenor.com/view/space-cat-flying-funny-speed-of-light-gif-4867939");
		
	}
	
	/*
	 * How can a servlet respond to a request?
	 * 1) Direct Response -> PrintWriter (we can send back HTML or JSON, any string)
	 * 2) Redirect -> SendRedirect
	 * 		Request is transferred to another resource to a different domain
	 * 		or server for further processing
	 * 		AKA -> we leave our application
	 * 		2 requests and 2 responses from the client perspective.
	 * 		URL changes
	 * 3) Forward -> requestDispatcher
	 * 		Request is transferred to another resource within the same server
	 * 		1 request and 1 response from the client perspective.
	 * 		URL does not change, user is blind to the server interaction
	 */

}
