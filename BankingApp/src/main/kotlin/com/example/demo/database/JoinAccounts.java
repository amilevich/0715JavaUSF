package com.example.demo.database;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.utility.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class JoinAccounts
{
    private static JoinAccounts instance = null;

    private HashMap<Account, ArrayList<Customer>> jointAccountMap;

    private IdGenerator generator;

    private AccountDAO dao;

    private JoinAccounts()
    {
        jointAccountMap = new HashMap<>();
        generator = new IdGenerator();
        dao = new AccountDAO();
    }

    public static JoinAccounts getInstance()
    {
        if (instance == null)
        {
            instance = new JoinAccounts();
        }
        return instance;
    }

    public void addJointAccount(ArrayList<Customer> customers)
    {
        Account account = new Account(generator.generateId());
        jointAccountMap.put(account, customers);
        dao.insert(account);
    }

    public void cancelJointAccount(Account account)
    {
        jointAccountMap.remove(account);
        dao.delete(account.getAccountNumber());
    }

    public ArrayList<Customer> getCustomersByAccount(Account account)
    {
        return jointAccountMap.get(account);
    }

}
