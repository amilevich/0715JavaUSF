package com.example.demo.DAO;

import com.example.demo.model.Account;
import com.example.demo.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JointAppManagerDAO implements Delete<Account>
{
    ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public void delete(int id)
    {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from JOINT_ACCOUNTS where ACCOUNT_ID = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Account> getAllCustomerJointAccounts(int id)
    {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Integer> accountIds = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement getIdsStatement = connection.prepareStatement("SELECT ACCOUNT_ID from JOINT_ACCOUNTS " +
                    "where PRIMARY_CUSTOMER_ID = ? or SECONDARY_CUSTOMER_ID = ?");
            getIdsStatement.setInt(1, id);
            getIdsStatement.setInt(2, id);

            ResultSet idSet = getIdsStatement.executeQuery();
            while (idSet.next())
            {
                accountIds.add(idSet.getInt(1));
            }

            for (Integer i : accountIds)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ACCOUNTS " +
                        "where ACCOUNT_NUMBER = ?");
                preparedStatement.setInt(1, i);

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

    public ArrayList<Integer> getCustomersByAccount(Account account)
    {
        ArrayList<Integer> customerIds = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * from JOINT_ACCOUNTS " +
                    "where ACCOUNT_ID = ?");
            preparedStatement.setInt(1, account.getAccountNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                customerIds.add(resultSet.getInt(2));
                customerIds.add(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerIds;
    }

}
