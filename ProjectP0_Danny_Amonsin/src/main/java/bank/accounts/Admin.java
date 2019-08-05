package bank.accounts;

public class Admin extends User
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5045096345712964343L;
	
	public Admin()
	{
		this.firstName = "John";
		this.lastName = "Doe";
		this.accountType = "employee";
		this.userName = "emp";
		this.password = "123";
		this.accountStatus = "App";
	}
	
	public Admin(int accountID, String firstName, String lastName, String userName, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0.00;
		this.overdraftFee = 12.00;		
		this.accountType = "personal";
		this.userName = userName;
		this.password = password;
		this.accountStatus = "App";
		this.jointAcctID = 0;
		this.jointStatus = "false";
	}
}
