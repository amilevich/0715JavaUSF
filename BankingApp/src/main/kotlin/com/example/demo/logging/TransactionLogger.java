package com.example.demo.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TransactionLogger
{
    final static Logger transactionLogger = LogManager.getLogger(TransactionLogger.class);

    public void logWithdrawl(int accountId, double amount)
    {
        transactionLogger.info("$" + amount + " was withdrawn from account#: " + accountId);
    }

    public void logDeposit(int accountId, double amount)
    {
        transactionLogger.info("$" + amount + " was withdrawn from account#: " + accountId);
    }

    public void logTransfer(int sender, int reciever, double amount)
    {
        transactionLogger.info("$" + amount + " was transferred from " + sender + " to " + reciever);
    }
}
