package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil
{
    private static ConnectionUtil instance = null;

    private Connection connection;

    private ConnectionUtil()
    {
        String url = "jdbc:oracle:thin:@usf0715java.c8qdvhcksjqe.us-east-2.rds.amazonaws.com:1521:ORCL";
        String username = "admin";
        String password = "adminpass";
        try 
        {
            this.connection = DriverManager.getConnection(url, username, password);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static ConnectionUtil getInstance()
    {
        if (instance == null)
        {
            instance = new ConnectionUtil();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}