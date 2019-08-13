package dao.models;

public class Customer 
{
	protected int accountID;
	protected double balance;
	protected String firstName;
	protected String lastName;
	protected String accountType;
	protected String accountStatus;

	public Customer() {
	}
	
	public Customer(int accountID, int balance, String accountStat, String firstName, String lastName, String accountType) {
		this.accountID = accountID;
		this.balance = balance;
		this.accountStatus = accountStat;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountType = accountType;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Customer [accountID=" + accountID + ", balance=" + balance + ", firstName=" + firstName + ", lastName="
				+ lastName + ", accountType=" + accountType + ", accountStatus=" + accountStatus + "]";
	}


	}
