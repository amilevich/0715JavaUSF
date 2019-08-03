package com.example.demo.data;

import com.example.demo.model.Employee;

public class CurrentLoggedInEmployee
{
    private static CurrentLoggedInEmployee ourInstance = new CurrentLoggedInEmployee();

    private Employee employee;

    public static CurrentLoggedInEmployee getInstance()
    {
        return ourInstance;
    }

    private CurrentLoggedInEmployee() { }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
