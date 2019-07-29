package com.example.demo.model;

import com.example.demo.utility.IdGenerator;

public class AccountApplication
{
    private boolean approved;

    private int applicationId;

    public AccountApplication(int id)
    {
        this.approved = false;
        this.applicationId = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
