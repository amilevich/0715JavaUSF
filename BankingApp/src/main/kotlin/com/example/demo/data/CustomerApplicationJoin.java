package com.example.demo.data;

import com.example.demo.utility.IdGenerator;

public class CustomerApplicationJoin
{
    private int applicationId;

    private String firstname;

    private String lastname;

    private String address;

    public CustomerApplicationJoin()
    {
        this.applicationId = new IdGenerator().generateId();
        this.firstname = "";
        this.lastname = "";
        this.address = "";
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
