package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.DAO.CustomerDAO;

public class RegistrationController
{
    public void registerCustomer(Customer customer)
    {
        CustomerDAO dao = new CustomerDAO();

        dao.insert(customer);
    }
}
