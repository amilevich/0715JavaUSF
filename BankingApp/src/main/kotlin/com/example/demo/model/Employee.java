package com.example.demo.model;

import com.example.demo.DAO.ApplicationDAO;
import com.example.demo.database.PendingAccounts;
import com.example.demo.database.PendingJointAccounts;

public class Employee extends User
{
    private ApplicationDAO dao = new ApplicationDAO();

    public Employee(String username, String password)
    {
        super(username, password);
    }

    public void approveApplication(int id)
    {
        PendingAccounts pendingAccounts = PendingAccounts.getInstance();
        pendingAccounts.approveCustomer(id);
    }

    public void removeApplication(int id)
    {
        PendingAccounts pendingAccounts = PendingAccounts.getInstance();
        pendingAccounts.deletePendingAccount(dao.selectOne(id));
    }

    public void approveJointApplication(int id)
    {
        PendingJointAccounts pendingJointAccounts = PendingJointAccounts.getInstance();
        pendingJointAccounts.approveCustomer(id);
    }

    public void removeJointApplication(int id)
    {
        PendingJointAccounts pendingJointAccounts = PendingJointAccounts.getInstance();
        pendingJointAccounts.deleteJointApplication(dao.selectOne(id));
    }
}
