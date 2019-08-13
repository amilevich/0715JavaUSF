package bank.accounts;

public class Personal extends User 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2581994621639051609L;

	public Personal()
	{
		this.firstName = "John";
		this.lastName = "Doe";
		this.accountID = 0;
		this.balance = 0.00;
		this.overdraftFee = 12.00;	
		this.accountType = "personal";
		this.userName = "Customer";
		this.password = "1234";
		this.accountStatus = "NotApp";
		this.jointStatus = "false";
		this.jointAcctID = 0;
	}
	
	public Personal(int accountID, String firstName, String lastName, String userName, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0.00;
		this.overdraftFee = 12.00;		
		this.accountType = "personal";
		this.userName = userName;
		this.password = password;
		this.accountStatus = "NotApp";
		this.jointAcctID = 0;
		this.jointStatus = "false";
	}

	@Override
	public String toString() {
		return "Personal [overdraftFee=" + overdraftFee + ", accountID=" + accountID + ", balance=" + balance
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", accountType=" + accountType + ", accountStatus=" + accountStatus + ", jointStatus="
				+ jointStatus + ", jointAcctID=" + jointAcctID + "]";
	}
}
