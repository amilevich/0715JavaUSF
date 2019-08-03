package com.example.demo.data;

import javafx.beans.property.SimpleStringProperty;

public class TransferAmount
{
    private SimpleStringProperty amount;

    private SimpleStringProperty accountNumber;

    public TransferAmount()
    {
        amount = new SimpleStringProperty();
        accountNumber = new SimpleStringProperty();
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getAccountNumber() {
        return accountNumber.get();
    }

    public SimpleStringProperty accountNumberProperty() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }
}
