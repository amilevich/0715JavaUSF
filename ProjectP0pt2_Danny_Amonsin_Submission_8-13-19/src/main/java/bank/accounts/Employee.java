package bank.accounts;

public class Employee extends User
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7770169556020041948L;

	public Employee()
	{
		this.firstName = "John";
		this.lastName = "Doe";
		this.accountType = "employee";
		this.userName = "emp";
		this.password = "123";
		this.accountStatus = "App";
	}
	
	public Employee(int accountID, String firstName, String lastName, String userName, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0.00;
		this.overdraftFee = 12.00;		
		this.accountType = "employee";
		this.userName = userName;
		this.password = password;
		this.accountStatus = "App";
		this.jointAcctID = 0;
		this.jointStatus = "false";
	}

	@Override
	public String toString() {
		return "Employee [accountID=" + accountID + ", balance=" + balance + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userName=" + userName + ", password=" + password + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", jointStatus=" + jointStatus + ", jointAcctID=" + jointAcctID
				+ ", personalAcctID=" + personalAcctID + ", overdraftFee=" + overdraftFee + ", firstNameJ=" + firstNameJ
				+ ", lastNameJ=" + lastNameJ + ", userNameJ=" + userNameJ + ", passwordJ=" + passwordJ + "]";
	}
	
	
}
