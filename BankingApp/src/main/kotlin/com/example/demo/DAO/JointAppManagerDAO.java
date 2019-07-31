package com.example.demo.DAO;

import com.example.demo.database.JoinAccounts;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;

import java.util.ArrayList;

public class JointAppManagerDAO implements Insert<ArrayList<Customer>>, Delete<Account>
{
    JoinAccounts joinAccounts = JoinAccounts.getInstance();

    AccountDAO accountDAO = new AccountDAO();

    @Override
    public void delete(int id)
    {
        joinAccounts.cancelJointAccount(accountDAO.selectOne(id));
    }

    @Override
    public void insert(ArrayList<Customer> obj)
    {
        joinAccounts.addJointAccount(obj);
    }
}
