package com.example.demo.controllers;

import com.example.demo.DAO.AppManagerDAO;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.data.CurrentLoggedInEmployee;
import com.example.demo.data.UserData;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.utility.IdGenerator;
import com.example.demo.utility.Login;

public class LoginController
{
    Login loginUtil = new Login();

    public void populateUsers()
    {
        AppManagerDAO appManagerDAO = new AppManagerDAO();

        UserData user1 = new UserData(1, "nick", "password", "admin");
        UserData user2 = new UserData(2, "dan", "password", "customer");
        UserData user3 = new UserData(3, "emp", "password", "employee");

        Customer customer2 = new Customer();
        customer2.setCustomerID(2);
        customer2.setFirstname("Dan");
        customer2.setLastname("Hecker");
        customer2.setAddress("Hartford, Connecticut");
        customer2.setUsername(user2.getUsername());

        UserDAO dao = new UserDAO();
        dao.insert(user1);
        dao.insert(user2);
        dao.insert(user3);

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.insert(customer2);
        appManagerDAO.insert(customer2);
    }

    public boolean checkCredentials(String username, String password)
    {
        return loginUtil.login(username,password);
    }

    public String getType(String username)
    {
        UserDAO userDAO = new UserDAO();

        return userDAO.selectByUsername(username).getType();
    }

    public void SetLoggedInCustomer(String username)
    {
        CustomerDAO customerDAO = new CustomerDAO();
        CurrentLoggedInCustomer currentCustomer = CurrentLoggedInCustomer.getInstance();
        Customer customer = customerDAO.getCustomerByUsername(username);
        currentCustomer.setLoggedInCustomer(customer);
    }

    public void setLoggedInEmployee(String username, String password)
    {
        IdGenerator generator = new IdGenerator();
        CurrentLoggedInEmployee currentEmployee = CurrentLoggedInEmployee.getInstance();
        Employee employee = new Employee(generator.generateId(), username, password);
        currentEmployee.setEmployee(employee);
    }
}
