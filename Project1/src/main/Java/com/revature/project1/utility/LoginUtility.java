package com.revature.project1.utility;

import com.revature.project1.dao.UserDAO;
import com.revature.project1.model.User;

public class LoginUtility
{
    public boolean checkCredentials(String username, String password)
    {
        UserDAO userDAO = new UserDAO();
        boolean success = false;
        User user = userDAO.getUserByUsername(username);

        if (user != null)
        {
            if (user.getPassword().equals(password))
            {
                success = true;
            }
        }

        return success;
    }
}
