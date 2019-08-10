package com.example.demo.controllers;

import com.example.demo.data.UserData;
import com.example.demo.model.Customer;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.utility.DataIO;
import com.example.demo.utility.IdGenerator;

public class RegistrationController
{
    private IdGenerator idGenerator = new IdGenerator();

    public void registerCustomer(Customer customer)
    {
        CustomerDAO dao = new CustomerDAO();

        dao.insert(customer);
    }

    public void saveData()
    {
        DataIO dataIO = new DataIO();
        dataIO.saveAllData();
    }
}
