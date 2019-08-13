package bank;

import java.util.Scanner;
import bank.User;


public class Admin extends Employee
{
	private static final long serialVersionUID = 6123793905217370736L;

	public Admin() 
	{
		userName = "admin";
		password = "admin";
		approved = true;
		joint = false;
		employee = true;
		admin = true;
		users.put("username", this);
	}
	public Admin(String name, String pass) 
	{
		userName = name;
		password = pass;
		approved = true;
		joint = false;
		employee = true;
		admin = true;
		users.put(name, this);
	}
	protected void addEmployee(String username) {
		Employee e = new Employee(username,"password");
		users.put(username, e);
	}
	
	protected void editAcct(String username) {
		int select;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println(users.get(username));
			System.out.println("Please select field you would like to edit:");
			System.out.println("1) Account number");
			System.out.println("2) Username");
			System.out.println("3) Password");
			System.out.println("4) Balance");
			System.out.println("5) Cancel this account");
			System.out.println("6) Exit");
			select = input.nextInt();	
			input.nextLine();
			switch(select) {
			case(1):
				System.out.println("Please enter your intended account number: ");
				String temp = input.nextLine();		
				tracker.info(this.userName + "account number has been changed from "+ users.get(username).accountNumber +" to "+temp);
				users.get(username).accountNumber = temp;				
				break;
			case(2):
				System.out.println("Please the new intended username: ");
				String temp2 = input.nextLine();
				tracker.info(this.userName + " edited account name from "+ users.get(username).userName +" to "+temp2);
				users.get(username).userName = temp2;
				users.put(temp2, users.get(username));
				users.remove(username);
				break;
			case(3):
				System.out.println("Please enter the new intended password: ");
				String temp3 = input.nextLine();		
				tracker.info(this.userName + " edited "+ username+"'s account password from "+ users.get(username).password +" to "+temp3);
				users.get(username).password = temp3;
				break;
			case(4):
				System.out.print("Please enter the intended altered balance: ");
				double temp4 = input.nextDouble();	
				tracker.info(this.userName + " corrected "+ username+"'s balance from "+ users.get(username).balance +" to "+temp4);
				input.nextLine();
				users.get(username).setBalance(username,temp4);
				break;
			case(5):
				System.out.println("Will you cancel " + username +"'s account?");
			System.out.println("Enter y for yes or n for no.");
				String temp8 = input.nextLine();
				if(temp8.compareToIgnoreCase("y") == 0) {
					System.out.println("Account Canceled");
					if(users.get(username).joint)
						users.get(username).joint = false;
					tracker.info(this.userName + " canceled "+ username +"'s account");
					users.remove(username);
				}else if(temp8.compareToIgnoreCase("n") == 0)
					System.out.println(username + "'s account will remain.");
				else
					System.out.println("The result has not been changed.");
				break;
			case(6):
				System.out.println("Thank you for your business.");
				break;
			default:
				System.out.println("Apologies, this is not a valid entry. Please try again.");
				break;
			}							
		}while(select != 6);
		
	}

}
