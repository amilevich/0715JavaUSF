package com.example.demo.controllers;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.JointAppManagerDAO;
import com.example.demo.Scopes.CustomerScope;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;

import java.util.ArrayList;

public class TransactionController
{
    AccountDAO accountDAO = new AccountDAO();

    AppManagerDAO appManagerDAO = new AppManagerDAO();

    JointAppManagerDAO jointAppManagerDAO = new JointAppManagerDAO();

    public void withdraw(int accountNumber, double amount)
    {
        Account account = accountDAO.selectOne(accountNumber);
        account.setBalance(account.getBalance() - amount);
        accountDAO.update(account);
    }

    public void deposit(int accountNumber, double amount)
    {
        Account account = accountDAO.selectOne(accountNumber);
        account.setBalance(account.getBalance() + amount);
        accountDAO.update(account);
    }

    public void transfer(int senderID, int receiverID,double amount)
    {
        Account sender = accountDAO.selectOne(senderID);
        Account receiver = accountDAO.selectOne(receiverID);
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountDAO.update(sender);
        accountDAO.update(receiver);
    }

    public void delete(int id)
    {
        appManagerDAO.delete(id);
        accountDAO.delete(id);
    }

    public void deleteJointAccount(int id)
    {
        jointAppManagerDAO.delete(id);
        accountDAO.delete(id);
    }

    public ArrayList<Integer> getAllAccountNumbers()
    {
        return new ArrayList<Integer>(accountDAO.getAllAccountNumbers());
    }

    public boolean checkAccountNumber(int accountNumber)
    {
        return this.getAllAccountNumbers().contains(accountNumber);
    }

    public CustomerScope getCustomerScope(int accountNumber)
    {
        Account account = accountDAO.selectOne(accountNumber);
        Customer customer = appManagerDAO.getCustomerByAccount(account);
        CustomerScope customerScope = new CustomerScope();
        customerScope.getModel().setItem(customer);

        return customerScope;
    }

    public CustomerScope getJointCustomerScope(int accountNumber)
    {
        CustomerDAO customerDAO = new CustomerDAO();
        Account account = accountDAO.selectOne(accountNumber);
        ArrayList<Integer> customers = jointAppManagerDAO.getCustomersByAccount(account);
        Customer customer = customerDAO.selectOne(customers.get(0));
        CustomerScope customerScope = new CustomerScope();
        customerScope.getModel().setItem(customer);

        return customerScope;
    }

}
