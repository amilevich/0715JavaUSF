package com.example.demo.controllers;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.model.Account;

public class TransactionController
{
    AccountDAO accountDAO = new AccountDAO();

    AppManagerDAO appManagerDAO = new AppManagerDAO();

    public void withdraw(int accountNumber, double amount)
    {
        Account account = accountDAO.selectOne(accountNumber);
        account.setBalance(account.getBalance() - amount);
        accountDAO.update(account);
        appManagerDAO.update(account);
    }

    public void deposit(int accountNumber, double amount)
    {
        Account account = accountDAO.selectOne(accountNumber);
        account.setBalance(account.getBalance() + amount);
        accountDAO.update(account);
        appManagerDAO.update(account);
    }
}
