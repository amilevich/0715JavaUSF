package com.example.demo.data;

import com.example.demo.utility.IdGenerator;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustomerApplicationJoin
{
    private SimpleIntegerProperty applicationId;

    private SimpleStringProperty firstname;

    private SimpleStringProperty lastname;

    private SimpleStringProperty address;

    public CustomerApplicationJoin()
    {
        this.applicationId = new SimpleIntegerProperty(new IdGenerator().generateId());
        this.firstname = new SimpleStringProperty("");
        this.lastname = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
    }

    public SimpleIntegerProperty getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId.set(applicationId);
    }

    public SimpleStringProperty getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public SimpleStringProperty getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public SimpleStringProperty getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
