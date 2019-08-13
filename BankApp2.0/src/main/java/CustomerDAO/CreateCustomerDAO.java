package CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybank.app.Individual;

public class CreateCustomerDAO {
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "gaelgino";
    private static String password = "Un2trois4";
    
    public int createIndividual(Individual individual) {
    	 try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            
	            PreparedStatement ps = conn.prepareStatement("INSERT INTO Individuals Values(?,?,?,?,?)");
	            ps.setString(1,individual.getUsername());
	            ps.setString(2,individual.getPassword());
	            ps.setInt(3,individual.getType());
	            ps.setString(4,individual.getFirst_name());
	            ps.setString(5,individual.getLast_name());
	            return ps.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }
}
