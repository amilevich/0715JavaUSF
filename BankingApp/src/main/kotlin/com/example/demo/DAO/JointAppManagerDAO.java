package com.example.demo.DAO;

import com.example.demo.database.JoinAccounts;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;

import java.util.ArrayList;

public class JointAppManagerDAO implements Insert<ArrayList<Integer>>, Delete<Account>, Update<Account>
{
    JoinAccounts joinAccounts = JoinAccounts.getInstance();

    AccountDAO accountDAO = new AccountDAO();

    @Override
    public void delete(int id)
    {
        joinAccounts.cancelJointAccount(accountDAO.selectOne(id));
    }

    @Override
    public void insert(ArrayList<Integer> obj)
    {
        joinAccounts.addJointAccount(obj);
    }

    @Override
    public void update(Account obj)
    {
        joinAccounts.updateAccountBalance(obj);
    }

    public ArrayList<Account> getAllCustomerJointAccounts(int id)
    {
        return joinAccounts.getAccountsByCustomerId(id);
    }

    public ArrayList<Integer> getCustomersByAccount(Account account)
    {
        return joinAccounts.getCustomersByAccount(account);
    }

}
