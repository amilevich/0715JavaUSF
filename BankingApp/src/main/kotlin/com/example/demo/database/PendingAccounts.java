package com.example.demo.database;

import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.DAO.ApplicationDAO;
import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;
import com.example.demo.utility.IdGenerator;

import java.util.HashMap;

public class PendingAccounts
{
    private static PendingAccounts instance = null;

    private HashMap<AccountApplication, Customer> applicationMap;

    private IdGenerator generator;

    ApplicationDAO appDAO = new ApplicationDAO();

    AppManagerDAO managerDAO = new AppManagerDAO();

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

    public HashMap<AccountApplication, Customer> getApplicationMap() {
        return applicationMap;
    }

    public void setApplicationMap(HashMap<AccountApplication, Customer> applicationMap) {
        this.applicationMap = applicationMap;
    }

    public void addPendingAccount(Customer customer)
    {
        ApplicationDAO applicationDAO = new ApplicationDAO();
        AccountApplication application = new AccountApplication(generator.generateId());
        applicationMap.put(application, customer);
        applicationDAO.insert(application);
    }

    public void deletePendingAccount(AccountApplication application)
    {
        applicationMap.remove(application);
    }

    public Customer getCustomerByApplication(AccountApplication application)
    {
        Customer customer = null;
        for (AccountApplication app : applicationMap.keySet())
        {
            if (app.getApplicationId() == application.getApplicationId())
            {
                customer = applicationMap.get(app);
            }
        }

        return customer;
    }

    public void approveCustomer(int id)
    {
        AccountApplication app = appDAO.selectOne(id);
        Customer customer = getCustomerByApplication(app);

        this.applicationMap.remove(app);
        appDAO.delete(id);
        //this.managerDAO.insert(customer);
    }

    public void denyCustomer(int id)
    {
        for (AccountApplication app : applicationMap.keySet())
        {
            if (app.getApplicationId() == id)
            {
                applicationMap.remove(app);
                break;
            }
        }
        appDAO.delete(id);
    }
}
