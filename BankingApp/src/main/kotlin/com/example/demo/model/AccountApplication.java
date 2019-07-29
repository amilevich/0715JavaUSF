package com.example.demo.model;

import com.example.demo.utility.IdGenerator;

public class AccountApplication
{
    private boolean approved;

    private int applicationId;

    private IdGenerator generator;

    public AccountApplication()
    {
        this.approved = false;
        this.generator = new IdGenerator();
        this.applicationId = generator.generateId();
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
