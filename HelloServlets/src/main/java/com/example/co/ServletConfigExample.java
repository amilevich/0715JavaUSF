package com.example.co;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletConfigExample extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Config Example");
		String pupper = getInitParameter("favoritePupper");
		System.out.println("Favorite pupper is " + pupper);

		String cake = getInitParameter("bestDessert");
		System.out.println("Best dessert is " + cake);

		String db = getServletContext().getInitParameter("databaseUrl");
		System.out.println("Database URL is " + db);
	}
}
