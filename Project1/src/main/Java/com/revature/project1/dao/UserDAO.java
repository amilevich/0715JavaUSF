package com.revature.project1.dao;

import com.revature.project1.model.User;
import com.revature.project1.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO
{
    ConnectionManager connectionManager = ConnectionManager.getInstance();

    public User getUserByUsername(String username)
    {
        User user = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USERS where USERNAME = ?");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                user = new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
