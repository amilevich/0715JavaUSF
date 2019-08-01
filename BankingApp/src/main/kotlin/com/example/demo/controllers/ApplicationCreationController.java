package com.example.demo.controllers;

import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.database.PendingAccounts;
import com.example.demo.database.PendingJointAccounts;
import com.example.demo.model.Customer;

public class ApplicationCreationController
{
    public void createApplication(String type)
    {
        if (type.equals("Checking Account"))
        {
            PendingAccounts pendingAccounts = PendingAccounts.getInstance();
            Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();

            pendingAccounts.addPendingAccount(customer);
        }
        else if(type.equals("Joint Account"))
        {
            PendingJointAccounts pendingJointAccounts = PendingJointAccounts.getInstance();
            Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();


        }
    }
}
