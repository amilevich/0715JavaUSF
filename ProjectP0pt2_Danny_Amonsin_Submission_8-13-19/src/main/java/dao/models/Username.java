package dao.models;

public class Username {
	
	protected String userName;
	protected String password;
	public Username() {
	}
	public Username(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UsernameDAOImpl [userName=" + userName + ", password=" + password + "]";
	}
	
	
}