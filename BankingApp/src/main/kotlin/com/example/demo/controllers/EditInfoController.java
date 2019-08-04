package com.example.demo.controllers;

import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.model.Customer;
import com.example.demo.viewmodel.FullCustomerViewModel;
import tornadofx.ViewModel;

public class EditInfoController
{
    CustomerDAO customerDAO = new CustomerDAO();

    AppManagerDAO appManagerDAO = new AppManagerDAO();

    public void sendUpdate(Customer customer)
    {
        customerDAO.update(customer);
        appManagerDAO.updateCustomer(customer);
    }

    public Customer getCustomer(FullCustomerViewModel model)
    {
        Customer customer = new Customer();
        customer.setFirstname(model.getFirstname().getValue());
        customer.setLastname(model.getLastname().getValue());
        customer.setAddress(model.getAddress().getValue());
        customer.setCustomerID(model.getCid().getValue());
        customer.setUsername(model.getUsername().getValue());
        customer.setPassword(model.getPassword().getValue());

        return customer;
    }
}
