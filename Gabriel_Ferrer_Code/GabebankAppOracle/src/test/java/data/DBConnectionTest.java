package data;

import java.sql.SQLException;

import org.junit.Test;

import static data.db.DBConnector.conn;
import static org.junit.Assert.assertEquals;

public class DBConnectionTest {
	@Test
	public void connectionTest () {
        try {
			System.out.println(  conn.getSchema()  );
			assertEquals("CGABFERR", conn.getSchema());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}
