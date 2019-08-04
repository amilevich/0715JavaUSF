package com.example.demo.controllers;

import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.data.CustomerAccountJoin;
import com.example.demo.data.UserData;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerHomeController
{
    UserDAO userDAO = new UserDAO();

    public ObservableList<CustomerAccountJoin> getCustomerAccounts()
    {
        AppManagerDAO appManagerDAO = new AppManagerDAO();
        ObservableList<CustomerAccountJoin> accounts = FXCollections.observableArrayList();
        Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();
        for(Account acc : appManagerDAO.getAllCustomerAccounts(customer))
        {
            CustomerAccountJoin join = new CustomerAccountJoin(acc.getAccountNumber(), acc.getBalance(),
                    customer.getFirstname().getValue() + " " + customer.getLastname().getValue(), "Checking");
            accounts.add(join);
        }

        return accounts;
    }

    public boolean checkType(String username)
    {
        boolean result = true;

        UserData user = userDAO.selectByUsername(username);

        if (user.getType().equals("employee"))
        {
            result = false;
        }

        return result;
    }
}
