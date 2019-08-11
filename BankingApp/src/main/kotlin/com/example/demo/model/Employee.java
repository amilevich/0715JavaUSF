package com.example.demo.model;

import com.example.demo.DAO.ApplicationDAO;

public class Employee extends User
{
    private ApplicationDAO dao;

    private int id;

    public Employee(int id, String username, String password)
    {
        super(username, password);
        this.dao = new ApplicationDAO();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
