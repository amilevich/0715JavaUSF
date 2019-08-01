package com.example.demo.controllers;

import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerHomeController
{
    public ObservableList<Account> getCustomerAccounts()
    {
        AppManagerDAO appManagerDAO = new AppManagerDAO();
        ObservableList<Account> accounts = FXCollections.observableArrayList();
        Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();
        accounts.addAll(appManagerDAO.getAllCustomerAccounts(customer));

        return accounts;
    }
}
