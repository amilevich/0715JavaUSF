package bank;


public class Employee extends User 
{
	private static final long serialVersionUID = 6529339495085000296L;
	
	public Employee() 
	{
		userName = "username";
		password = "password";
		approved = true;
		joint = false;
		employee = true;
		admin = false;
		users.put("username", this);
	}
	public Employee(String name, String pass) 
	{
		userName = name;
		password = pass;
		approved = true;
		joint = false;
		employee = true;
		admin = false;
		users.put(name, this);
	}
		
	public void approveAcct(String username) 
	{
		users.get(username).approved = true;
	}

}
