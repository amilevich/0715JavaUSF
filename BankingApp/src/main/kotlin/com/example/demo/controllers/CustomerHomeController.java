package com.example.demo.controllers;

import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.JointAppManagerDAO;
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

    public ObservableList<CustomerAccountJoin> getCustomerJointAccounts()
    {
        JointAppManagerDAO jointAppManagerDAO = new JointAppManagerDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ObservableList<CustomerAccountJoin> accounts = FXCollections.observableArrayList();
        Customer customer = CurrentLoggedInCustomer.getInstance().getLoggedInCustomer();

        for (Account account : jointAppManagerDAO.getAllCustomerJointAccounts(customer.getCustomerID()))
        {
            Customer primaryCustomer = customerDAO.selectOne(jointAppManagerDAO.getCustomersByAccount(account).get(0));
            CustomerAccountJoin join = new CustomerAccountJoin(account.getAccountNumber(), account.getBalance(),
                    primaryCustomer.getFirstname().getValue() + " " + primaryCustomer.getLastname().getValue(),
                    "Joint");

            accounts.add(join);
        }

        return accounts;
    }

    public ObservableList<CustomerAccountJoin> getAllAccounts()
    {
        ObservableList<CustomerAccountJoin> accounts = FXCollections.observableArrayList();
        accounts.addAll(getCustomerAccounts());
        accounts.addAll(getCustomerJointAccounts());

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
