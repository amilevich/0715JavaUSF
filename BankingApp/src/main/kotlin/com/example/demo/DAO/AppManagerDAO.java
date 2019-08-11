package com.example.demo.DAO;

import com.example.demo.database.CheckingAccounts;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.utility.ConnectionManager;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppManagerDAO implements Delete<Account>
{
    ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public void delete(int id)
    {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from CUSTOMER_ACCOUNTS where ACCOUNT_ID = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Account> getAllCustomerAccounts(Customer customer)
    {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Integer> accountIds = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement getIdsStatement = connection.prepareStatement("SELECT * from CUSTOMER_ACCOUNTS where CUSTOMER_ID = ?");
            getIdsStatement.setInt(1, customer.getCustomerID());

            ResultSet accountIdSet = getIdsStatement.executeQuery();
            while (accountIdSet.next())
            {
                accountIds.add(accountIdSet.getInt(1));
            }

            for (Integer id : accountIds)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ACCOUNTS " +
                        "where ACCOUNT_NUMBER = ?");
                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    Account account = new Account(resultSet.getInt(1));
                    account.setBalance(resultSet.getDouble(2));

                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public Customer getCustomerByAccount(Account account)
    {
        Customer customer = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement getIdStatement = connection.prepareStatement("SELECT CUSTOMER_ID from CUSTOMER_ACCOUNTS" +
                    " where ACCOUNT_ID = ?");
            getIdStatement.setInt(1, account.getAccountNumber());

            ResultSet idSet = getIdStatement.executeQuery();
            while (idSet.next())
            {
                customer = new Customer();
                customer.setCustomerID(idSet.getInt(1));
            }

            if (customer != null)
            {
                PreparedStatement getCustomerStatement = connection.prepareStatement("SELECT * from CUSTOMERS " +
                        "where CUSTOMER_ID = ?");
                getCustomerStatement.setInt(1, customer.getCustomerID());

                ResultSet resultSet = getCustomerStatement.executeQuery();
                while (resultSet.next())
                {
                    customer.setFirstname(resultSet.getString(2));
                    customer.setLastname(resultSet.getString(3));
                    customer.setAddress(resultSet.getString(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
}
