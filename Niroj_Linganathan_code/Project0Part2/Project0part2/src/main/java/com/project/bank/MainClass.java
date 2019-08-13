package com.project.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class MainClass {

	static String userName;
	static String passWord;
	static String fName;
	static String lName;
	static String address;
	static String accType;
	static int uniqueNo;
	static String accStatus;

	private static String url = "jdbc:oracle:thin:@db0715java.ce8jdxpwtsbf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "niroj85";
	private static String password = "niroj4401";
	
	static void welcome() {
		// Welcome page to enter the selection to login into bank page.
		System.out.println("          WELCOME TO COMMERCIAL BANK          ");
		System.out.println("ENTER THE APPROPRIATE KEYWORDS TO ENTER THE BANK.");
		System.out.println("==> Enter 'C' to login into Customer page.");
		System.out.println("==> Enter 'E' to login into Bank Employee page.");
		System.out.println("==> Enter 'A' to login into Bank Admin page.");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		switch (input) { // check the user input to choose the desired page.
		case "C":
			System.out.println("==========Welcome to Customer page===========");
			checkCustomer();
			break;
		case "c":
			System.out.println("==========Welcome to Customer page===========");
			checkCustomer();
			break;
		case "E":
			System.out.println("==========Welcome to Employee page===========");
			employeeLogin();
			break;
		case "e":
			System.out.println("==========Welcome to Employee page===========");
			employeeLogin();

			break;
		case "A":
			System.out.println("==============Welcome to Admin page===========");
			adminMainPage();
			break;
		case "a":
			System.out.println("==============Welcome to Admin page===========");
			adminMainPage();
			break;
		default:
			System.out.println("***********Wrong Selection. Please Try again later**********");
			welcome();
		}

	}

	public static void checkCustomer() // This method check that the customer is already has account or new customer.
	{
		// String UserName = null;
		System.out.print("Account Holder : Enter====> 1         Become An Account Holder : Enter====> 2        Exit : Enter====>3");
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		switch (input) {
		case "1":
			existingCustomer();
			break;
		case "2":
			NewCustomerRegister();
			break;
		case "3":
			welcome();
		default:
			System.out.println("Wrong Selection ");
			checkCustomer();
		}
	}

	public static void existingCustomer() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter User Name:");
		String UName = sc.nextLine();
		System.out.println("Enter Your Password :");
		String UPassword = sc.nextLine();

		customerDaoIMPL cdimpl = new customerDaoIMPL();
		cdimpl.selectCustomer(UName, UPassword);
		// cdimpl.customerCheckJunctionTable(UName);
	}

	// 88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
	public static void NewCustomerRegister() {

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"-------------------Thanks For Choosing The Commercial Bank As Your Future Banking Partner--------------------");
		System.out.println("");
		System.out.println(
				"==>Please Enter A User Name To Apply For An Account.******User Name Must Be Between 6 and 30 Charactors.******");
			userName = sc.nextLine();

		if (userName.length() < 6 || userName.length() > 30) {
			System.out.println("Invalid User Name Selection. Please Try Again.");
			NewCustomerRegister();
		} else {
			System.out.println("==>Create A Password.******Password Must Be Between 8 and 30 Charactors******");
			passWord = sc.nextLine();
			if (passWord.length() < 8 || passWord.length() > 30) {
				System.out.println("Invalid Password. Please Try Again.");
				NewCustomerRegister();
			} else {
				System.out.println("==>Confirm Password :");
				String confirmPassword = sc.nextLine();
				// System.out.println(confirmPassword);
				if (passWord.equals(confirmPassword)) {

					System.out.println("<==========Application For Open A New Bank Account==========>");
					System.out.println("First Name :");
					fName = sc.nextLine();

					System.out.println("Last Name :");
					lName = sc.nextLine();

					System.out.println("Address:");
					address = sc.nextLine();

					System.out.println("Would You Like A Joined Account : NO ==> 1        YES ==> 2");
					accType = sc.nextLine();

					Random ran = new Random();
					uniqueNo = ran.nextInt(1000000);
					accStatus = "Pending";
					customerDaoIMPL cdimpl = new customerDaoIMPL();

					if (accType.equals("2")) {
						accType = "Joined";

						customer cus1 = new customer(userName, passWord, fName, lName, address, accType, uniqueNo,
								accStatus);
						cdimpl.insertCustomer(cus1);

						System.out.println("==>Please Enter Join Holder's Details");

						System.out.println("Enter User name :");
						userName = sc.nextLine();

						System.out.println("Enter Password :");
						passWord = sc.nextLine();

						System.out.println("First Name :");
						fName = sc.nextLine();

						System.out.println("Last Name :");
						lName = sc.nextLine();

						System.out.println("Address:");
						address = sc.nextLine();

						cus1 = new customer(userName, passWord, fName, lName, address, accType, uniqueNo, accStatus);
						cdimpl.insertCustomer(cus1);

						System.out.println(
								"Your Application For Open An Account has been Submited. You Will Have An Account Number Once You Got Approved !");
						System.out.println("\n");
						welcome();
					} else {
						accType = "Single";
						customer cus1 = new customer(userName, passWord, fName, lName, address, accType, uniqueNo,
								accStatus);
						cdimpl.insertCustomer(cus1);

					}

				} else {

					System.out.println("******Passwords Do Not Match! Try Again******");
					NewCustomerRegister();
				}
			}
		}
	}

	// 888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888

	public static void employeeLogin() {

		System.out.println("                 Commercial Bank");
		System.out.println("                  Employee login");
		System.out.println(" ");
		System.out.println("Enter Employee ID :-");
		Scanner sc = new Scanner(System.in);
		String adminId = sc.nextLine();
		System.out.println("Enter Password :-");
		String password = sc.nextLine();

		if (adminId.equals("employee") && password.equals("commbank")) {
			System.out.println("WelCome" + " " + adminId);
			employeeMenu();

		} else {
			System.out.println("Invalid Login Details. Try Again");
			welcome();
		}

	}

	public static void employeeMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("@VIEW CUSTOMER PERSONAL DETAILS==> PRESS 1" + "    " + "@VIEW ACCOUNT BALANCE==> PRESS 2"
				+ "    " + "@VIEW PENDING APPLICATIONS==>3" + "    " + "Back To Employee Menu==> 4" +"    "+"Exit ==> 5");
		String input = sc.nextLine();
		switch (input) {

		case "1":

			customerDaoIMPL cdim = new customerDaoIMPL();
			System.out.println("==> Please Enter The Account Number :");
			int accNo = sc.nextInt();
			cdim.employeeSeeCustomerDetails(accNo);
			System.out.println("Back To Employee Menu ==> 1             Back To Main Menu==> 2");
			input=sc.nextLine();
			switch(input) {
			case "1":
				System.out.println("Back To Employee Menu.......");
				System.out.println("\n");
				employeeMenu();
				break;
			case "2":
				System.out.println("Back To Main Menu.......");
				System.out.println("\n");
				welcome();
				break;
				default:
					System.out.println("Back To Employee Menu.......");
					System.out.println("\n");
					employeeMenu();
					break;
			}
			break;
		case "2":
			System.out.println("==> Please Enter The Account Number : ");
			accNo = sc.nextInt();
			accountDaoIMPL adaoimpl = new accountDaoIMPL();
			adaoimpl.employeeSeeAccountDetails(accNo);
			break;

		case "3":
			System.out.println("Pending Applications");
			customerDaoIMPL cdimpl = new customerDaoIMPL();
			System.out.println(cdimpl.pendingApplications());
			System.out.println("\n");
			//-------------------------------------------------------------------------------------------------------------------------------
			System.out.println("Do You Want To Approve This Account Application? YES ==> 1  NO==> 2  Back==> 3  Main Menu==> 4");
			String input1 = sc.nextLine();
			
			switch(input1) {
			case "1":
				accountDaoIMPL adao = new accountDaoIMPL();

				//int UNo = cdimpl.pendingApplications().getUniqueNo();
				// System.out.println(UNo);
				String UName="";
				try {
					 UName= cdimpl.pendingApplications().getUserName();
				}catch(Exception e) {
					System.out.println("No Pending Applications!");
				}
					
				
				// System.out.println(UName);

				double balance = 00.00;
				account acc1 = new account(UName, balance);
				adao.insertAccount(acc1);

				String AccStatus = "Accepted";
				customer c1 = new customer(UName, AccStatus);
				c1.setAccType(AccStatus);
				c1.setUserName(UName);
				cdimpl.updateCustomerAccStatus(c1);
				JunctionTable(UName);

				System.out.println("Approved");
				break;
				
			case"2":
				//int UNo = cdimpl.pendingApplications().getUniqueNo();
				String UName1 = cdimpl.pendingApplications().getUserName();
				String AccStatus1 = "Rejected";
				customer c2 = new customer(UName1, AccStatus1);
				c2.setAccType(AccStatus1);
				c2.setUserName(UName1);
				cdimpl.updateCustomerAccStatus(c2);
				System.out.println("Account Application Has Been Rejected");
				break;
				
			case"3":
				System.out.println("Going Back To Employee Menu......");
				employeeMenu();
				break;
				
			case"4":
				System.out.println("Going Back To Main Menu......");
				welcome();
				break;
				
			}
			//-------------------------------------------------------------------------------------------------------------------------------
			

		case "4":
			employeeMenu();
		default:
			System.out.println("Going To Main Menu.......");
			welcome();
		}

	}

	public static void JunctionTable(String UName) {

		accountDaoIMPL adao = new accountDaoIMPL();
		int aNo = adao.selectAccountUserName(UName).getacc_No();

		account acc1 = new account(aNo, UName);

		adao.insertJunctionTable(acc1);
	}

	// ---------------------------------------------------------------------------------------------------------------------------------ADMIN
	// PAGE
	public static void adminMainPage() {

		Scanner sc = new Scanner(System.in);
		System.out.println("                 Commercial Bank");
		System.out.println("                   Admin login");
		System.out.println(" ");
		System.out.println("Enter Admin ID :-");

		String adminId = sc.nextLine();
		System.out.println("Enter Password :-");
		String password = sc.nextLine();

		if (adminId.equals("admin") && password.equals("commbank")) {
			System.out.println("WelCome" + " " + adminId);
			adminMenu();
		} else {
			System.out.println("Invalid Login Details. Try Again");
			adminMainPage();

		}

	}

	public static void adminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("@ Manage Bank Transactions==> PRESS 1" + "    " + "@ Cancel An Account==> PRESS 2" + "    "
				+ "Main Menu==> PRESS 3");
		String input = sc.nextLine();
		switch (input) {

		case "1":
			System.out.println("==>Manage Customer's Bank Transactions");
			customerDaoIMPL cdaoimpl = new customerDaoIMPL();
			System.out.println("Please Enter The Account Number : ");
			int accNo = sc.nextInt();
			cdaoimpl.getCustomerAccount(accNo);
			break;

		case "2":
			System.out.println("Cancel An Account");
			customerDaoIMPL cdaoimpl1 = new customerDaoIMPL();
			System.out.println("Please Enter The Account Number To Cancel :");
			accNo = sc.nextInt();
			cdaoimpl1.employeeSeeCustomerDetails(accNo);
			customer c1=new customer();
			System.out.println("\n");
			System.out.println("WARNING ! Are You Sure Want To Cancel This Account?");
			System.out.println("Yes ==> 1     No==> 2    Exit==> 3");
			int input1 = sc.nextInt();
			switch (input1) {
			case 1:
				try(Connection con = DriverManager.getConnection(url, username, password)){
					PreparedStatement ps=con.prepareStatement("SELECT USER_NAME FROM JUNCTION_TABLE WHERE ACC_NUMBER=?");
					ps.setInt(1, accNo);
					ResultSet rs=ps.executeQuery();
					String UName="";
					while (rs.next()){
						UName=rs.getString(1);
						
					}
					//System.out.println(UName);
					String  accStatus="Cancelled";
						try (Connection con1 = DriverManager.getConnection(url, username, password)) {
							PreparedStatement ps1 = con.prepareStatement("UPDATE USER_DETAILS SET ACC_STATUS=? WHERE USER_NAME=?");
							ps1.setString(1, accStatus);
							ps1.setString(2, UName);
							ps1.executeUpdate();
						} catch (SQLException e) {

							e.printStackTrace();
						}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				System.out.println("Account Deleting.........");
				accountDaoIMPL adaoimpl = new accountDaoIMPL();
				adaoimpl.cancelAccount(accNo);
				break;
			case 2:
				System.out.println("Going Back To Admin Menu.......");
				adminMenu();
				break;
				default:
					System.out.println("Going To Main Menu......");
					welcome();
					break;
			}

			break;
		case "3":
			System.out.println("Back To Main Menu......");
			welcome();
		default:
			System.out.println("Invalid Selection !");
			welcome();
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------------ADMIN
	// PAGE
	public static void main(String[] args) {
		welcome();
		// System.out.println("welcome");

		// ======================================CUSTOMER INSERT

		// customer cus1=new
		// customer("niroj85","niroj4401","Niroj","Linganathan","Texas","Joined",452515,"Approved");
		customerDaoIMPL cdimpl = new customerDaoIMPL();
		// cdimpl.insertCustomer(cus1);

		// ==========================================CUSTOMER SELECT
		// System.out.println(cdimpl.selectCustomer("niroj85","niroj4401"));

		// =======================================ACCOUNT CREATE
		// account acc1=new account("5000");
		// accountDaoIMPL adao = new accountDaoIMPL();
		// adao.insertAccount(acc1);
		// ========================================SELECT ACCOUNT
		// $$$$System.out.println(adao.selectAccount(10005));

	}
}
