package com.example.demo.data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Amount
{
    private SimpleStringProperty amount;

    public Amount(String amount)
    {
        this.amount = new SimpleStringProperty(amount);
    }

    public SimpleStringProperty getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }
}
