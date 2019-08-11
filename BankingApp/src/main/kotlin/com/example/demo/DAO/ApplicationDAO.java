package com.example.demo.DAO;

import com.example.demo.database.Applications;
import com.example.demo.model.AccountApplication;
import com.example.demo.utility.ConnectionManager;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationDAO implements Delete<AccountApplication>, Insert<AccountApplication>, Select<AccountApplication>
{
    ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public void delete(int id) {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from APPLICATIONS where APP_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(AccountApplication obj) {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT into APPLICATIONS VALUES(APP_ID_SEQ.nextval,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccountApplication selectOne(int id) {
        AccountApplication accountApplication = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from APPLICATIONS where APP_ID = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                accountApplication = new AccountApplication(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountApplication;
    }

    @Override
    public ArrayList<AccountApplication> selectAll() {
        ArrayList<AccountApplication> applications = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from APPLICATIONS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                AccountApplication accountApplication = new AccountApplication(resultSet.getInt(1));

                applications.add(accountApplication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }
}
