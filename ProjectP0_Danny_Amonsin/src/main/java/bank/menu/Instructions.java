package bank.menu;

import java.util.Scanner;
import bank.running.AccountsM;
public class Instructions {
	
	Scanner scan = new Scanner(System.in);
	AccountsM accM = new AccountsM();
		
	int acctNum;
	
	public void empStr()
	{
		accM.createAccountE("employee", "s", "s", "1", "2");
		
	}
	
	/*
	 * 
	 * 
	 * Customer methods*************************
	 * 
	 * 
	 */
	
	//main menu method
	public void instrStart() {
		System.out.println("Welcome to Damon Bank, To continue, please enter the number for one of the options below");

		System.out.println("1) Are you a new customer?");

		System.out.println("2) Are you an existing customer?");

		System.out.println("3) Are you an employee?");

		System.out.println("4) Are you a bank administrator?");
		int n = scan.nextInt();
		initial(n);
	}
	
	//Main cases method
	public void initial(int num)
	{				
		scan = new Scanner(System.in);
	switch(num)
	{
		case 1:
			//"are u a new customer? call new account method, with option to do a single or joint acct
//			instruc.singleOrJoint();
			applyPers();
			instrStart();
			break;
			
		case 2:
			//"are u an existing customer? call customer login method
			logIn();
			break;
		case 3:
			//"are u an employee? call employee login method
			empLog();
			break;
		case 4:
			
			System.out.println("Welcome Administrator, what is your username?");
			String user = scan.nextLine();
			System.out.println("What is your password?");
			String pass = scan.nextLine();
			adminLog(user, pass);
			break;
			//"are u a bank admin? call admin login method
			
		default:
			System.out.println("Sorry, your entry is invalid, please enter a valid number to continue, 1, 2, 3, or 4");			
			instrStart();
	}
	}
	
	//application instruction method
	public void applyPers() {
		scan = new Scanner(System.in);
		
		System.out.println("New Personal Account Sign Up");
		
		System.out.println("Please enter your First Name");
		String firstName = scan.nextLine();				
		
		System.out.println("Please enter your Last Name");
		String lastName = scan.nextLine();
		
		System.out.println("For logging into your Account");
		System.out.println("Please enter a Username");
		String userName = scan.nextLine();
				
		System.out.println("Please enter Password for loging in");
		String password = scan.nextLine();
		
		String accountType = "personal";
	    
		accM.createAccount(accountType, firstName, lastName, userName, password);
//		System.out.println("getacctsize: "+ accM.getAcctSize());
		
	}

	//customer login method
	public void logIn()
	{
		scan = new Scanner(System.in);
//		System.out.println("acctsize login: " + accM.getAcctSize());
		System.out.println("To Log in to your Account");
		
		System.out.println("Enter your Account Number");
		this.acctNum = scan.nextInt();
		
		scan = new Scanner(System.in);
		if(accM.findAccID(this.acctNum))
		{
			System.out.println("Account number found");
		}
		else
		{
			System.out.println("Account number not found, returning to menu");
			instrStart();
		}
		
		System.out.println("Enter your Username");
		String userName = scan.nextLine();
//		System.out.println("account # at usercheck" + this.acctNum);
		
		if(accM.finduName(userName, this.acctNum))
		{
			System.out.println("Username found");
		}
		else
		{
			System.out.println("Username not found, returning to menu");
			instrStart();
		}		
				
		System.out.println("Enter your Password");
		String password = scan.nextLine();
		if(accM.findPassword(password, this.acctNum))
		{
			System.out.println("Password found");
		}
		else
		{
			System.out.println("Password not found, returning to menu");
			instrStart();
		}
		
		if(accM.perOrJoint(this.acctNum))
		{
			customerMenuJ();
		}
		else
		{	
			customerMenu();
		}
		
	}

	
	//customer menu method
	public void customerMenu() {
		System.out.println("Welcome to your Damon Bank Account, what would you like to do today?");

		System.out.println("1) View Account Information");
		
		System.out.println("2) Deposit");

		System.out.println("3) Withdraw");

		System.out.println("4) Transfer");

		System.out.println("5) Apply for joint account");
		
		System.out.println("6) Log out");
		
		int n = scan.nextInt();
		customerCases(n);
	}
	
	//customer cases method personal
	public void customerCases(int num)
	{				
	switch(num)
	{
		case 1:
			accM.viewAcct(this.acctNum);
			customerMenu();
			break;
			
		case 2:
			depositI();
			customerMenu();
			break;
		case 3: //withdrawing
			withdrawI();
			customerMenu();
			break;
		case 4:
			tranferI();
			customerMenu();
			break;
			
		case 5:
			System.out.println("You want to sign up for a joint account? Enter 1 for \"Yes\" and 2 for \"No\"");
			int number = scan.nextInt();
			if(number == 1)
			{
				applyJoint(this.acctNum);
			}
			else
			{
				System.out.println("Okay, returning to your Account menu");
				customerMenu();
			}
			break;
			
		case 6:
			instrStart();
			break;	
		
			
		default:
			System.out.println("Sorry, your entry is invalid, please enter a valid number to continue, 1, 2, 3, or 4");			
			customerMenu();
	}
	}
	
	
	public void customerMenuJ() {
		System.out.println("Welcome to your Damon Bank Account, what would you like to do today?");

		System.out.println("1) View Account Information");
		
		System.out.println("2) Deposit");

		System.out.println("3) Withdraw");

		System.out.println("4) Transfer");

		System.out.println("5) Log out");
		
		int n = scan.nextInt();
		customerCasesJ(n);
	}
	
	//customer cases method joint
		public void customerCasesJ(int num)
		{				
		switch(num)
		{
			case 1:
				accM.viewAcct(this.acctNum);
				customerMenuJ();
				break;
				
			case 2:
				depositI();
				customerMenuJ();
				break;
			case 3:
				withdrawI();
				customerMenuJ();
				break;
			case 4:
				tranferI();
				customerMenuJ();
				break;
				
			case 5:
				instrStart();
				break;	
			
			default:
				System.out.println("Sorry, your entry is invalid, please enter a valid number to continue, 1, 2, 3, or 4");			
				customerMenu();
		}
		}
		
		//withdrawingq instructions
		public void withdrawI()
		{
			scan = new Scanner(System.in);
			
			System.out.println("Withdrawing from your account: ");
			
			System.out.println("Please enter the amount you would like to withdraw");
			double amount = scan.nextDouble();		
			accM.withdraw(amount, this.acctNum);
		}
		
		//depositq instructions
		public void depositI()
		{
			scan = new Scanner(System.in);
					
			System.out.println("Depositing into your account: ");
					
			System.out.println("Please enter the amount you would like to deposit");
			double amount = scan.nextDouble();		
			accM.deposit(amount, this.acctNum);
		}

		//transferingq instructions
		public void tranferI()
		{
			scan = new Scanner(System.in);
			
			System.out.println("Transfering from your account: ");			
			System.out.println("Please enter the amount you would like to transfer");
			double amount = scan.nextDouble();
			
			System.out.println("Please enter the account number you would like to transfer to");
			int accountID2 = scan.nextInt();
			
			accM.transfer(amount, this.acctNum, accountID2);
		}
		
	//joint signup account menu 
	public void applyJoint(int personalAcctID) {
		scan = new Scanner(System.in);
		
		System.out.println("New Joint Account Sign Up");
		
		System.out.println("Please enter your First Name");
		String firstName = scan.nextLine();				
		
		System.out.println("Please enter your Last Name");
		String lastName = scan.nextLine();
		
		System.out.println("For logging into your Account");
		System.out.println("Please enter a Username");
		String userName = scan.nextLine();
				
		System.out.println("Password for log in?");
		String password = scan.nextLine();
		
		System.out.println("Please enter your Joint Partner's First Name");
		String firstNameJ = scan.nextLine();				
		
		System.out.println("Please enter your Joint Partner's Last Name");
		String lastNameJ = scan.nextLine();
		
		System.out.println("For logging into your Account");
		System.out.println("Please enter your Joint Partner's Username");
		String userNameJ = scan.nextLine();
				
		System.out.println("Please enter Joint Partner's Password for loging in");
		String passwordJ = scan.nextLine();
		
		String accountType = "joint";
	    
		accM.createAccountJ(accountType, firstName, firstNameJ, lastName, lastNameJ, userName, userNameJ, password, passwordJ, this.acctNum);
		instrStart();
	}
	
	/*
	 * 
	 * 
	 * Admin methods*************************
	 * 
	 * 
	 */
	
	
	//admin login method
	public void adminLog(String user, String pass)
	{
		if(user.equals("admin") && pass.equals("123"))
		{
			adminMenu();
			int num = scan.nextInt();
			adminCases(num);
		}
		else
		{
			System.out.println("Username or Password incorrect, returning to main menu");
			instrStart();
		}
			
	}
	
	//employee login method
	public void empLog()
	{			
//			scan = new Scanner(System.in);
			System.out.println("To Log in to your Employee Account");
			
			System.out.println("Enter your Account Number");
			acctNum = scan.nextInt();
			
			
			if(accM.findAccID(acctNum))
			{
				System.out.println("Account number found");
			}
			else
			{
				System.out.println("Account number not found, returning to menu");
				instrStart();
			}
			scan = new Scanner(System.in);
			System.out.println("Enter your Username");
			String userName = scan.nextLine();
			
			if(accM.finduName(userName, this.acctNum))
			{
				System.out.println("Username found");
			}
			else
			{
				System.out.println("Username not found, returning to menu");
				instrStart();
			}		
					
			System.out.println("Enter your Password");
			String password = scan.nextLine();
			if(accM.findPassword(password, this.acctNum))
			{
				System.out.println("Password found");
			}
			else
			{
				System.out.println("Password not found, returning to menu");
				instrStart();
			}
			empMenu();	
		}
	
	//admin main menu
	public void adminMenu() {
		scan = new Scanner(System.in);
		
		System.out.println("1) Approve or Deny Bank Accounts");
		
		System.out.println("2) Cancel Bank Accounts");
		
		System.out.println("3) View All Accounts");
		
		System.out.println("4) Withdraw from Account");
		
		System.out.println("5) Deposit into an Account");
		
		System.out.println("6) Transfer between Accounts");
		
		System.out.println("7) Log out of admin menu, and return to main bank menu");

		int n = scan.nextInt();
		adminCases(n);
	}
	
	//admin cases method
	public void adminCases(int num)
	{				
	switch(num)
	{
		case 1:
			//approve customer
			accM.adminApprove();
			adminMenu();
			break;
			
		case 2:
			//cancel accounts
			accM.adminCancel();
			adminMenu();
			break;
		case 3:
			accM.showAllAccounts();
			adminMenu();
			break;			
		case 4:
			withdrawIAdmin();
			adminMenu();
			break;
		case 5: 			
			depositIAdmin();
			adminMenu();
			break;
		case 6:
			tranferIAdmin();
			adminMenu();
			break;
		case 7:
			instrStart();
			break;
			
		default:
			System.out.println("Sorry, your entry is invalid, please enter a valid number to continue, 1, 2, 3, or 4");			
			adminMenu();
	}
	}
	
	//employee main menu
			public void empMenu() {
				scan = new Scanner(System.in);
				
				System.out.println("1) Approve or Deny Bank Accounts");
				
				System.out.println("2) View All Accounts");
				
				System.out.println("3) Log out of admin menu, and return to main bank menu");

				int n = scan.nextInt();
				empCases(n);
			}
			
			//employee cases method
			public void empCases(int num)
			{	
			switch(num)
			{
				case 1:
					//approve customer
					accM.adminApprove();
					empMenu();
					break;
					
				case 2:
					accM.showAllAccounts();
					empMenu();
					break;
					
				case 3:
					instrStart();
					break;
//			}
//			
//				System.out.println("not valid");
			
					
				default:
					System.out.println("Sorry, your entry is invalid, please enter a valid number to continue, 1, 2, 3, or 4");			
					empMenu();
			}
			}

			
	//withdrawingq instructions
	public void withdrawIAdmin()
	{
		scan = new Scanner(System.in);
		System.out.println("Please enter the account number to withdraw from");
		int numb = scan.nextInt();
		if(accM.findAccID(numb))
		{
			System.out.println("Account found");
		}
		else
		{
			System.out.println("Account not found, returning to admin menu");
			adminMenu();
		}
		System.out.println("Please enter the amount you would like to withdraw");
		double amount = scan.nextDouble();		
		accM.withdrawAd(amount, numb);
	}
	
	//depositqa instructions
	public void depositIAdmin()
	{
		scan = new Scanner(System.in);
		System.out.println("Please enter the account number to deposit to");
		int numb = scan.nextInt();
		if(accM.findAccID(numb))
		{
			System.out.println("Account found");
		}
		else
		{
			System.out.println("Account not found, returning to admin menu");
			adminMenu();
		}		
		System.out.println("Please enter the amount you would like to deposit");
		double amount = scan.nextDouble();		
		accM.depositAd(amount, numb);
	}

	//transferingq instructions
	public void tranferIAdmin()
	{
		scan = new Scanner(System.in);
					
		System.out.println("Please enter the account number you would like to transfer from");
		int accountID = scan.nextInt();
		if(accM.findAccID(accountID))
		{
			System.out.println("Account found");
		}
		else
		{
			System.out.println("Account not found, returning to admin menu");
			adminMenu();
		}
		
		
		System.out.println("Please enter the account number you would like to transfer to");
		int accountID2 = scan.nextInt();
		if(accM.findAccID(accountID2))
		{
			System.out.println("Account found");
		}
		else
		{
			System.out.println("Account not found, returning to admin menu");
		}
		System.out.println("Please enter the amount you would like to transfer");
		double amount = scan.nextDouble();
		
		accM.transfer(amount, accountID, accountID2);
	}

	
	
}
