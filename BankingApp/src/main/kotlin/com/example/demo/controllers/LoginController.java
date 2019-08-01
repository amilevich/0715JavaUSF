package com.example.demo.controllers;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.data.UserData;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.Customer;
import com.example.demo.utility.Login;

public class LoginController
{
    Login loginUtil = new Login();

    private void populateUsers()
    {
        UserData user1 = new UserData(1, "Nick", "password", "admin");
        UserData user2 = new UserData(2, "Dan", "password", "customer");

        UserDAO dao = new UserDAO();
        dao.insert(user1);
        dao.insert(user2);
    }

    public boolean checkCredentials(String username, String password)
    {
        this.populateUsers();
        return loginUtil.login(username,password);
    }

    public void SetLoggedInCustomer(String username)
    {
        CustomerDAO customerDAO = new CustomerDAO();

    }
}
