package com.example.demo.controllers;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.data.CurrentLoggedInCustomer;
import com.example.demo.data.CurrentLoggedInEmployee;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.utility.IdGenerator;
import com.example.demo.utility.Login;

public class LoginController
{
    Login loginUtil = new Login();

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
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CurrentLoggedInEmployee currentEmployee = CurrentLoggedInEmployee.getInstance();
        Employee employee = new Employee(employeeDAO.getEmployeeIdByUsername(username), username, password);
        currentEmployee.setEmployee(employee);
    }
}
