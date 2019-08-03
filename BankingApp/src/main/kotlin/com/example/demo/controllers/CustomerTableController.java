package com.example.demo.controllers;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerTableController
{
    CustomerDAO customerDAO = new CustomerDAO();

    public ObservableList<Customer> getAllCustomers()
    {
        return FXCollections.observableArrayList(customerDAO.selectAll());
    }
}
