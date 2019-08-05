package items;

//BankAccount class will parent UserAccount


public class BankAccount {
	private int ID;
	private double balance;
	
	
	public BankAccount(int ID, double balance) {
		super();
		this.ID = ID;
		this.balance = balance;
	}


	public BankAccount() {
		super();
	}


	@Override
	public String toString() {
		return "Account [ID=" + ID + ", balence=  $" + String.format("%.2f",balance) + "]";
	}


	public int getID() {
		return ID;
	}


	public void setID(int ID) {
		this.ID = ID;
	}


	public double getBalance() {
		return balance;
	}


	public  void setBalance(double balence) {
		this.balance = balence;
	}
	

}
	
	
	


