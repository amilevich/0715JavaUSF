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

    private HashMap<Account, ArrayList<Integer>> jointAccountMap;

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

    public HashMap<Account, ArrayList<Integer>> getJointAccountMap() {
        return jointAccountMap;
    }

    public void setJointAccountMap(HashMap<Account, ArrayList<Integer>> jointAccountMap) {
        this.jointAccountMap = jointAccountMap;
    }

    public void addJointAccount(ArrayList<Integer> customers)
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

    public ArrayList<Integer> getCustomersByAccount(Account account)
    {
        ArrayList<Integer> customers = null;

        for (Account acc : jointAccountMap.keySet())
        {
            if (acc.getAccountNumber() == account.getAccountNumber())
            {
                customers = jointAccountMap.get(acc);
            }
        }

        return customers;
    }

    public void updateAccountBalance(Account account)
    {
        for (Account acc : jointAccountMap.keySet())
        {
            if (account.getAccountNumber() == acc.getAccountNumber())
            {
                acc.setBalance(account.getBalance());
            }
        }
    }

    public ArrayList<Account> getAccountsByCustomerId(int id)
    {
        ArrayList<Account> accountList = new ArrayList<>();
        for (Account account : jointAccountMap.keySet())
        {
            if (jointAccountMap.get(account).contains(id))
            {
                accountList.add(account);
            }
        }
        return accountList;
    }

}
