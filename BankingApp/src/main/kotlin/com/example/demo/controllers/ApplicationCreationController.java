package com.example.demo.controllers;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.model.Customer;
import com.example.demo.utility.ConnectionManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationCreationController
{
    ConnectionManager connectionManager = ConnectionManager.getInstance();

    public void createApplication()
    {
        Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();
        Connection connection = connectionManager.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call ADD_CHECKING_APP(?)}");
            callableStatement.setInt(1, customer.getCustomerID());
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createJointApplication(int customerId)
    {
        Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();
        Connection connection = connectionManager.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call ADD_JOINT_APP(?,?)}");
            callableStatement.setInt(1, customer.getCustomerID());
            callableStatement.setInt(2, customerId);

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkCustomerId(int customerId)
    {
        boolean result = false;

        CustomerDAO customerDAO = new CustomerDAO();
        if (customerDAO.selectOne(customerId) != null)
        {
            result = true;
        }

        return result;
    }
}
