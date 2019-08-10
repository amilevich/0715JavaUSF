package com.example.demo.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
    private static ConnectionManager instance = null;

    private Connection connection;

    private ConnectionManager()
    {
        String url = "jdbc:oracle:thin:@revaturedb.cs48qmknn4om.us-east-2.rds.amazonaws.com:1521:ORCL";
        String username = "thedude";
        String password = "theguesswho123";
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionManager getInstance()
    {
        if (instance == null)
        {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
