package com.example.demo.database;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.utility.IdGenerator;

import java.util.HashMap;

public class CheckingAccounts
{
    private static CheckingAccounts instance = null;

    private HashMap<Account, Customer> accountMap;

    private IdGenerator generator;

    private AccountDAO dao = new AccountDAO();

    private CheckingAccounts()
    {
        this.accountMap = new HashMap<>();
        generator = new IdGenerator();
    }

    public static CheckingAccounts getInstance()
    {
        if (instance == null)
        {
            instance = new CheckingAccounts();
        }
        return instance;
    }

    public void addCheckingAccount(Customer customer)
    {
        Account newAccount = new Account(generator.generateId());
        accountMap.put(newAccount,customer);
        dao.insert(newAccount);
    }

    public void cancelAccount(Account account)
    {
        accountMap.remove(account);
        dao.delete(account.getAccountNumber());
    }

    public Customer getCustomerByAccount(Account account)
    {
        return accountMap.get(account);
    }
}
