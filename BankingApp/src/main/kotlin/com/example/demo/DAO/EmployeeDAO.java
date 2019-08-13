package com.example.demo.DAO;

import com.example.demo.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO
{
    ConnectionManager connectionManager = ConnectionManager.getInstance();

    public int getEmployeeIdByUsername(String username)
    {
        int id = 0;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT EMPLOYEE_ID from EMPLOYEES where USERNAME = ?");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
