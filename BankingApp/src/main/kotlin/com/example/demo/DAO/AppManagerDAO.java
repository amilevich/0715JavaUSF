package com.example.demo.DAO;

import com.example.demo.database.CheckingAccounts;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;

import java.util.ArrayList;

public class AppManagerDAO implements Insert<Customer>, Delete<Account>
{
    CheckingAccounts checkingAccounts = CheckingAccounts.getInstance();

    AccountDAO accountDAO = new AccountDAO();

    @Override
    public void delete(int id)
    {
        checkingAccounts.cancelAccount(accountDAO.selectOne(id));
    }

    @Override
    public void insert(Customer obj)
    {
        checkingAccounts.addCheckingAccount(obj);
    }

    public ArrayList<Account> getAllCustomerAccounts(Customer customer)
    {

        return checkingAccounts.getAccountsByCustomer(customer);
    }
}
