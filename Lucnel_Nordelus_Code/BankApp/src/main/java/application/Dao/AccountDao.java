package main.java.application.Dao;

import java.util.ArrayList;

import main.java.application.Domain.Account;
import main.java.application.Domain.User;

public interface AccountDao {
    public Account getBalance(int accountNumber);
    public boolean setBalance(int accountNumber);
    public boolean deposit(int accountNumber, double amount);
    public boolean withdraw(int accountNumber, double amount);
    public boolean transfer(int accountFrom, int accountTo, double amount);
    public Account getAccount(int accountNum);
    public boolean denyAccountApplication(int accountNum);
    public boolean denyJointApplication(String username, int accountNum);
    public boolean approveAccountApplication(int accountNum);
    public boolean approveJointApplication(String username, int accountNum);
    public boolean cancelAccount(int accountNum);
    public boolean createAccountApplication(User user);
    
    // Create Account Needs a User name
    public boolean createAccount(String usename, double balance);
    
    // join account needs 2 user names
    public boolean createJointAccountApplication(String user1, String user2);
    
    public boolean changeAccountStatus(int accountNumber, char operation);
    public ArrayList<Integer> getUserAccounts(String userName);
    
    // needs a return type
    public String getAccountStatus(int accountNumber);
    
    
    public ArrayList<Integer> getAllAccounts();
    public ArrayList<Account> getPendingJointApplications();
    public ArrayList<Account> getPendingApplications();
}
