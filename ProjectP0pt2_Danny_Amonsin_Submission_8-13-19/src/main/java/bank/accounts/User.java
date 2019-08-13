package bank.accounts;

import java.io.Serializable;

//administration methods
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3770610167666961024L;
	//
	protected int accountID;
	protected double balance;
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String password;
	protected String accountType;
	protected String accountStatus;
	protected String jointStatus;
	protected int jointAcctID;
	protected int personalAcctID;
	protected double overdraftFee;
	protected String firstNameJ; //for joint accounts, 2nd person who is part of the account
	protected String lastNameJ;
	protected String userNameJ;
	protected String passwordJ;
	
	//getters and setters
	
	public double getOverdraftFee() {
		return overdraftFee;
	}

	public String getJointStatus() {
		return jointStatus;
	}

	public void setJointStatus(String jointStatus) {
		this.jointStatus = jointStatus;
	}

	public String getFirstNameJ() {
		return firstNameJ;
	}

	public void setFirstNameJ(String firstNameJ) {
		this.firstNameJ = firstNameJ;
	}

	public String getLastNameJ() {
		return lastNameJ;
	}

	public void setLastNameJ(String lastNameJ) {
		this.lastNameJ = lastNameJ;
	}

	public String getUserNameJ() {
		return userNameJ;
	}

	public void setUserNameJ(String userNameJ) {
		this.userNameJ = userNameJ;
	}

	public String getPasswordJ() {
		return passwordJ;
	}

	public void setPasswordJ(String passwordJ) {
		this.passwordJ = passwordJ;
	}

	public int getPersonalAcctID() {
		return personalAcctID;
	}

	public void setPersonalAcctID(int personalAcctID) {
		this.personalAcctID = personalAcctID;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setOverdraftFee(double overdraftFee) {
		this.overdraftFee = overdraftFee;
	}
	
	public String getUserName() {
		return userName;
	}

	public int getJointAcctID() {
		return jointAcctID;
	}

	public void setJointAcctID(int nextID) {
		this.jointAcctID = nextID;
	}

	public String isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	
}
