package com.example.demo.controllers;

import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.database.PendingAccounts;
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
    }
}
