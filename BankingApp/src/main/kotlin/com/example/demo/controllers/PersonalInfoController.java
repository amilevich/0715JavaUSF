package com.example.demo.controllers;

import com.example.demo.DAO.UserDAO;
import com.example.demo.data.UserData;

public class PersonalInfoController
{
    UserDAO userDAO = new UserDAO();

    public boolean checkType(String username)
    {
        boolean result = false;
        UserData userData = userDAO.selectByUsername(username);

        if (userData.getType().equals("admin"))
        {
            result = true;
        }
        return result;
    }
}
