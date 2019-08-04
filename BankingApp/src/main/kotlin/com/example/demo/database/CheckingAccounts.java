package com.example.demo.database;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.utility.IdGenerator;

import java.util.ArrayList;
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

    public ArrayList<Account> getAccountsByCustomer(Customer customer)
    {
        ArrayList<Account> accounts = new ArrayList<>();
        for(Account acc : accountMap.keySet())
        {
            if(accountMap.get(acc).equals(customer))
            {
                accounts.add(acc);
            }
        }
        return accounts;
    }

    public void updateAccountBalance(Account account)
    {
        for (Account acc : accountMap.keySet())
        {
            if (account.getAccountNumber() == acc.getAccountNumber())
            {
                acc.setBalance(account.getBalance());
            }
        }
    }

    public void updateCustomer(Customer customer)
    {
        for (Account acc : accountMap.keySet())
        {
            if (accountMap.get(acc).getUsername().getValue().equals(customer.getUsername().getValue()))
            {
                accountMap.put(acc,customer);
//                accountMap.get(acc).setFirstname(customer.getFirstname().getValue());
//                accountMap.get(acc).setAddress(customer.getAddress().getValue());
            }
        }
    }
}
