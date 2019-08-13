package data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	public static final String URL = "jdbc:oracle:thin:@gabebank.cbvpgyiaxyiq.us-east-2.rds.amazonaws.com:1521/ORCL";
    public static final String USER = "cgabferr";
    public static final String PASS = "zHyDk98dF";
    public static final String driver = "oracle.jdbc.driver.OracleDriver";
    public static DBConnector connectionFactory = new DBConnector();
    public static Connection conn;
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static void connect() {
    	conn =  connectionFactory.getConnection();
    }
    
    public static Connection getConnection()
    {
      try {
    	  Class.forName(driver);
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	  }
	  return null;
    }
    
    public static void main(String[] args) {
		connect();
		try {
			System.out.println( conn.getSchema() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
