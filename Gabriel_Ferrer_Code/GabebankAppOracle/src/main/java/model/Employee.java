package model;

public class Employee extends Person {
	
	private String username;
	private Boolean isAdmin;
	
	public Employee(String username, Boolean isAdmin) {
		this.username = username;
		this.isAdmin = isAdmin;
	}
	
	public Employee (String firstName, String lastName, String username, Boolean isAdmin) {
		super(firstName, lastName);
		this.isAdmin = isAdmin;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", isAdmin=" + isAdmin + 
				", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
