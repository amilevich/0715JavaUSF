package com.example.demo.controllers;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.database.PendingAccounts;
import com.example.demo.database.PendingJointAccounts;
import com.example.demo.model.Customer;

import java.util.ArrayList;

public class ApplicationCreationController
{
    public void createApplication()
    {
        PendingAccounts pendingAccounts = PendingAccounts.getInstance();
        Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();

        pendingAccounts.addPendingAccount(customer);
    }

    public void createJointApplication(int customerId)
    {
        PendingJointAccounts pendingJointAccounts = PendingJointAccounts.getInstance();
        Integer loggedInCustomerId = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer().getCustomerID();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(customerId);
        ids.add(loggedInCustomerId);
        pendingJointAccounts.addJointApplication(ids);
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
