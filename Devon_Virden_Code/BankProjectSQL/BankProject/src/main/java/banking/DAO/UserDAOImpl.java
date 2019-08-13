package banking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import banking.application.Account;
import banking.application.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) {
		try {
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			PreparedStatement prep = con.prepareStatement("INSERT INTO bank_user VALUES(?,?,?,?)");
			prep.setString(1, user.getID());
			prep.setString(2, user.getName());
			prep.setString(3, user.getPassword());
			prep.setString(4, user.getType());
			prep.execute();
			prep.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<User> getTiedUsers(Account account) {
		try {
			ArrayList<User> users = new ArrayList<User>();
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			PreparedStatement prep = con.prepareStatement(
					"SELECT * FROM linker RIGHT OUTER JOIN bank_user ON linker.user_id=bank_user.user_id WHERE account_number = ?");
			prep.setInt(1, account.getNumber());
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				users.add(new User(res.getString("user_id"), res.getString("user_password"),
						res.getString("user_name"), res.getString("user_type")));
			}
			prep.cancel();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(String userid) {
		try {
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			User writer = new User();
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_user WHERE user_id = ?");
			prep.setString(1, userid);
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				writer = new User(res.getString("user_id"), res.getString("user_password"), res.getString("user_name"),
						res.getString("user_type"));
			}
			prep.cancel();
			return writer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		try {
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			PreparedStatement prep = con
					.prepareStatement("UPDATE bank_user SET user_name=?,user_password=? WHERE user_id = ?");
			prep.setString(1, user.getName());
			prep.setString(2, user.getPassword());
			prep.setString(3, user.getID());
			prep.execute();
			prep.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean findUser(String userid) {
		try {
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_user WHERE user_id = ?");
			prep.setString(1, userid);
			ResultSet res = prep.executeQuery();
			prep.cancel();
			if (res.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getType(String userid) {
		try {
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			String type = new String();
			PreparedStatement prep = con.prepareStatement("SELECT user_type FROM bank_user WHERE user_id = ?");
			prep.setString(1, userid);
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				type = res.getString("user_type");
			}
			prep.cancel();
			return type;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int size() {
		try {
		int size = 0;
		Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
		PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_user");
		ResultSet res = prep.executeQuery();
		while (res.next()) {
			size++;
		}
		prep.cancel();
		return size;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return 0;
	}
	
	@Override
	public int getCustomers() {
		try {
			int size = 0;
			Connection con = DriverManager.getConnection(Info.getUrl(), Info.getUser(), Info.getPass());
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_user WHERE user_type = 'CUSTOMER'");
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				size++;
			}
			prep.cancel();
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return 0;
	}

}
