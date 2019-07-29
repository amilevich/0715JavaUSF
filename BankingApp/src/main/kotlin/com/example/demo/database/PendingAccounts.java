package com.example.demo.database;

import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;
import com.example.demo.utility.IdGenerator;

import java.util.HashMap;

public class PendingAccounts
{
    private static PendingAccounts instance = null;

    private HashMap<AccountApplication, Customer> applicationMap;

    private IdGenerator generator;

    private PendingAccounts()
    {
        applicationMap = new HashMap<>();
        generator = new IdGenerator();
    }

    public static PendingAccounts getInstance()
    {
        if (instance == null)
        {
            instance = new PendingAccounts();
        }
        return instance;
    }

    public void addPendingAccount(Customer customer)
    {
        AccountApplication application = new AccountApplication(generator.generateId());
        applicationMap.put(application, customer);
    }

    public void deletePendingAccount(AccountApplication application)
    {
        applicationMap.remove(application);
    }

    public Customer getCustomerByApplication(AccountApplication application)
    {
        return applicationMap.get(application);
    }
}
