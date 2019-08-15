package com.revature.project1.servlets;

import com.revature.project1.model.User;
import com.revature.project1.utility.LoginUtility;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LoginUtility loginUtility = new LoginUtility();
        JsonReader reader = Json.createReader(request.getReader());
        JsonObject userJson = reader.readObject();
        Boolean result = loginUtility.checkCredentials(userJson.getString("username"), userJson.getString("password"));

        PrintWriter printWriter = response.getWriter();
        printWriter.print(result);
        printWriter.close();
    }
}
