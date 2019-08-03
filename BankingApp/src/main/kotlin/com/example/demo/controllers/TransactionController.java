package com.example.demo.controllers;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.model.Account;

import java.util.ArrayList;

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

    public void transfer(int senderID, int receiverID,double amount)
    {
        Account sender = accountDAO.selectOne(senderID);
        Account receiver = accountDAO.selectOne(receiverID);
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountDAO.update(sender);
        accountDAO.update(receiver);

        appManagerDAO.update(sender);
        appManagerDAO.update(receiver);
    }

    public ArrayList<Integer> getAllAccountNumbers()
    {
        return new ArrayList<Integer>(accountDAO.getAllAccountNumbers());
    }

    public boolean checkAccountNumber(int accountNumber)
    {
        return this.getAllAccountNumbers().contains(accountNumber);
    }

}
