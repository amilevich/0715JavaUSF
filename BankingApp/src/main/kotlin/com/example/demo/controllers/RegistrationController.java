package com.example.demo.controllers;

import com.example.demo.data.UserData;
import com.example.demo.model.Customer;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.utility.IdGenerator;

public class RegistrationController
{
    private IdGenerator idGenerator = new IdGenerator();

    public void registerCustomer(Customer customer)
    {
        int id = idGenerator.generateId();
        customer.setCustomerID(id);

        CustomerDAO dao = new CustomerDAO();
        UserDAO userDAO = new UserDAO();

        UserData user = new UserData(customer.getCustomerID(), customer.getUsername().getValue(),
                customer.getPassword().getValue(), "customer");
        userDAO.insert(user);

        dao.insert(customer);
    }
}
