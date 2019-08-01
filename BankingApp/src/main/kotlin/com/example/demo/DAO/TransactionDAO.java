package com.example.demo.DAO;

import com.example.demo.model.Account;

public class TransactionDAO
{
    AccountDAO accountDAO = new AccountDAO();

    public void withdraw(int id, double amount)
    {
        double currentBalance = accountDAO.selectOne(id).getBalance();
        accountDAO.selectOne(id).setBalance(currentBalance - amount);
    }

    public void deposit(int id, double amount)
    {
        double currentBalance = accountDAO.selectOne(id).getBalance();
        accountDAO.selectOne(id).setBalance(currentBalance + amount);
    }

    public void transfer(int id1, int id2, double amount)
    {
        double account1Balance = accountDAO.selectOne(id1).getBalance();
        double account2Balance = accountDAO.selectOne(id2).getBalance();

        accountDAO.selectOne(id1).setBalance(account1Balance - amount);
        accountDAO.selectOne(id2).setBalance(account2Balance + amount);
    }
}
