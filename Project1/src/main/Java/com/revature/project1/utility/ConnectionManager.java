package com.revature.project1.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
    private static ConnectionManager instance = null;

    private Connection connection;

    private ConnectionManager()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@revaturedb.cs48qmknn4om.us-east-2.rds.amazonaws.com:1521:ORCL",
                    "thedude", "theguesswho123");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
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

    public Connection getConnection()
    {
        return this.connection;
    }
}
