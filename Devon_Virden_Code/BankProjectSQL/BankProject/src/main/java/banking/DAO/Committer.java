package banking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Committer {

	private Committer() {
		super();
	}

	public static void commit() {
		try {
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			PreparedStatement prep = con.prepareStatement("COMMIT");
			prep.execute();
			prep.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
