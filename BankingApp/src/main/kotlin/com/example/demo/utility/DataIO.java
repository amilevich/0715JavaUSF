package com.example.demo.utility;

import com.example.demo.data.UserData;
import com.example.demo.database.*;
import com.example.demo.model.Account;
import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataIO
{
    private String baseFilePath = "/Users/Nick/JavaTraning/0715JavaUSF/BankingApp/Data/";

    public void saveAllData()
    {
        Accounts accounts = Accounts.getInstance();
        this.writeObject(baseFilePath + "accounts.txt", accounts.getAccountMap());

        Applications applications = Applications.getInstance();
        this.writeObject(baseFilePath + "applications.txt", applications.getAppMap());

        CheckingAccounts checkingAccounts = CheckingAccounts.getInstance();
        this.writeObject(baseFilePath + "checkingAccounts.txt", checkingAccounts.getAccountMap());

        JoinAccounts joinAccounts = JoinAccounts.getInstance();
        this.writeObject(baseFilePath + "jointAccounts.txt", joinAccounts.getJointAccountMap());

        Customers customers = Customers.getInstance();
        this.writeObject(baseFilePath + "customers.txt", customers.getCustomerMap());

        PendingAccounts pendingAccounts = PendingAccounts.getInstance();
        this.writeObject(baseFilePath + "pendingAccounts.txt", pendingAccounts.getApplicationMap());

        PendingJointAccounts pendingJointAccounts = PendingJointAccounts.getInstance();
        this.writeObject(baseFilePath + "pendingJointAccounts.txt", pendingJointAccounts.getJointAppMap());

        UserTable userTable = UserTable.getInstance();
        this.writeObject(baseFilePath + "users.txt", userTable.getUserMap());
    }

    public void readAllData()
    {
        Accounts accounts = Accounts.getInstance();
        accounts.setAccountMap((HashMap<Integer, Account>) this.readObject(baseFilePath + "accounts.txt"));

        Applications applications = Applications.getInstance();
        applications.setAppMap((HashMap<Integer, AccountApplication>) this.readObject(baseFilePath + "applications.txt"));

        CheckingAccounts checkingAccounts = CheckingAccounts.getInstance();
        checkingAccounts.setAccountMap((HashMap<Account, Customer>) this.readObject(baseFilePath + "checkingAccounts.txt"));

        JoinAccounts joinAccounts = JoinAccounts.getInstance();
        joinAccounts.setJointAccountMap((HashMap<Account, ArrayList<Integer>>) this.readObject(baseFilePath + "jointAccounts.txt"));

        Customers customers = Customers.getInstance();
        customers.setCustomerMap((HashMap<Integer, Customer>) this.readObject(baseFilePath + "customers.txt"));

        PendingAccounts pendingAccounts = PendingAccounts.getInstance();
        pendingAccounts.setApplicationMap((HashMap<AccountApplication, Customer>) this.readObject(baseFilePath + "pendingAccounts.txt"));

        PendingJointAccounts pendingJointAccounts = PendingJointAccounts.getInstance();
        pendingJointAccounts.setJointAppMap((HashMap<AccountApplication, ArrayList<Integer>>) this.readObject(baseFilePath + "pendingJointAccounts.txt"));

        UserTable userTable = UserTable.getInstance();
        userTable.setUserMap((HashMap<Integer, UserData>) this.readObject(baseFilePath + "users.txt"));
    }

    public void writeObject(String filename, Object obj) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(obj);
        }catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    public Object readObject(String filename) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            Object obj = ois.readObject();
            ois.close();
            return obj;
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
