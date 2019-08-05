package bank.accounts;

public class Joint extends User 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1390353527574846920L;

	public Joint()
	{
		this.firstName = "John";
		this.lastName = "Doe";
		this.balance = 0.00;
		this.overdraftFee = 12.00;	
		this.accountType = "joint";
		this.userName = "Customer";
		this.password = "1234";
		this.accountID = 0;
		this.accountStatus = "NotApp";
		this.personalAcctID = 0;
		this.firstNameJ = "Ashley";
		this.lastNameJ = "Doe";
		this.userNameJ = "Customer2";
		this.passwordJ = "1234";
	}
	
	public Joint(int accountID, String firstName, String firstNameJ, String lastName, String lastNameJ, String userName, String userNameJ, String password, String passwordJ, int personalAcctID)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = 0.00;
		this.overdraftFee = 12.00;		
		this.accountType = "joint";
		this.userName = userName;
		this.password = password;
		this.accountID = accountID;
		this.accountStatus = "NotApp";
		this.personalAcctID = personalAcctID;
		this.firstNameJ = firstNameJ;
		this.lastNameJ = lastNameJ;
		this.userNameJ = userNameJ;
		this.passwordJ = passwordJ;
	}
	
	@Override
	public String toString() {
		return "Joint [overdraftFee=" + overdraftFee + ", accountID=" + accountID + ", balance=" + balance
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", accountType=" + accountType + ", accountStatus=" + accountStatus + ", jointStatus="
				+ jointStatus + ", jointAcctID=" + jointAcctID + "]";
	}
	
	
}
