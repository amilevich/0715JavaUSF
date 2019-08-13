package dao.models;

public class JunctionInfo 
{
	String username;
	int account_id;
	public JunctionInfo() {
	
	}
	protected JunctionInfo(String username, int account_id) {
		super();
		this.username = username;
		this.account_id = account_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	@Override
	public String toString() {
		return "JunctionInfo [username=" + username + ", account_id=" + account_id + "]" + "\n";
	}
	
}
