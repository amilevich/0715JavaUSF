package model;

public class Customer extends Person {
	
	private Integer bankAccountNumber;
	private String username;
	
	public Customer(String firstName, String lastName, String username, Integer number) {
		super(firstName, lastName);
		this.username = username;
		this.bankAccountNumber = number;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getFullname() {
		return getFirstName() + " " + getLastName();
	}
	
	public String getFirstName() {
		return super.firstname;
	}
	
	public String getLastName() {
		return super.lastname;
	}
	
	public Integer getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Integer number) {
		this.bankAccountNumber = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Customer [bankAccountNumbers=" + bankAccountNumber + ", username=" + username + ", firstname="
				+ firstname + ", lastname=" + lastname + "]";
	}
}