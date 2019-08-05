package com.example.demo.data;

public class CustomerAccountJoin
{
    private int accountNumber;

    private double balance;

    private String name;

    private String name2;

    private String type;

    public CustomerAccountJoin(int accountNumber, double balance, String name, String type)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
        this.type = type;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName2()
    {
        return name2;
    }

    public void setName2(String name2)
    {
        this.name2 = name2;
    }
}
