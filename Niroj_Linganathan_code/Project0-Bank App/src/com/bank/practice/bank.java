package com.bank.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class bank {
	//private static final com.bank.practice.CustomerDetails new = null;
	static String UserName;
	static String password;
	static String confirmPassword;
	static String fName;
	static String lName;
	static String DOB;
	static String address;
	static String phone;
	static String SSN;
	static double oldAmount;
	static double newAmount;
	private static int a;

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
			Employee e = new Employee();
			e.employeeMainPage();
			break;
		case "e":
			System.out.println("==========Welcome to Employee page===========");
			Employee e1 = new Employee();
			e1.employeeMainPage();
			break;
		case "A":
			System.out.println("==============Welcome to Admin page===========");
			Admin a=new Admin();
			a.adminMainPage();
			break;
		case "a":
			System.out.println("==============Welcome to Admin page===========");
			Admin a1=new Admin();
			a1.adminMainPage();
			break;
		default:
			System.out.println("***********Wrong Selection. Please Try again later**********");

		}

	}

	public static void checkCustomer() // This method check that the customer is already has account or new customer.
	{
		String UserName = null;
		System.out.print("Account Holder : Enter====> 1         Become An Account Holder : Enter====> 2");
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch (input) {
		case 1:

			OldCustomerRead();

			break;
		case 2:
			System.out.println("New Customer ");
			NewCustomerRegister();
			break;
		default:
			System.out.println("Wrong Selection ");

		}
	}

	public static void NewCustomerRegister() {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"-------------------Thanks For Choosing The Commercial Bank As Your Future Banking Partner--------------------");
		System.out.println("");
		System.out.println(
				"==>Please Enter A User Name To Apply For An Account.******User Name Must Be Between 6 and 30 Charactors.******");
		UserName = sc.nextLine();

		if (UserName.length() < 6 || UserName.length() > 30) {
			System.out.println("Invalid User Name Selection. Please Try Again.");

		} else {
			// System.out.println("Good");
			System.out.println("==>Create A Password.******Password Must Be Between 8 and 30 Charactors******");
			password = sc.nextLine();
			if (password.length() < 8 || password.length() > 30) {
				System.out.println("Invalid Password. Please Try Again.");
			} else {
				// System.out.println(pwd);
				System.out.println("==>Confirm Password :");
				confirmPassword = sc.nextLine();
				// System.out.println(confirmPassword);
				if (password.equals(confirmPassword)) {

					System.out.println("<==========Application For Open A New Bank Account==========>");
					System.out.println("First Name :");
					fName = sc.nextLine();

					System.out.println("Last Name :");
					lName = sc.nextLine();

					System.out.println("Date of Birth :");
					DOB = sc.nextLine();

					System.out.println("Address :");
					address = sc.nextLine();

					System.out.println("Phone :");
					phone = sc.nextLine();

					System.out.println("SSN :");
					SSN = sc.nextLine();

					System.out.println("");

					Random ran = new Random();
					int acc = ran.nextInt(1000000);
					String accNumber = Integer.toString(acc);

					// Write in txt file############################################

					String cusTxtFile = "./" + UserName + ".txt";
					String customerFile = cusTxtFile;
					NewCustomer NCTXT = new NewCustomer(UserName, password, fName, lName, DOB, address, phone, SSN,
							accNumber);

					WriteCustomerTxt(customerFile, NCTXT);
					ReadCustomerTxt(customerFile);
					
					
					CustomerDetails CD=new CustomerDetails(password);
					String cusPassword = "./" + UserName+"password" + ".txt";
					WritePasswordTxt(cusPassword,CD);
					
					System.out.println(
							"Your Application For Open An Account has been Submited. You Will Have An Account Number Once You Got Approved !");
					Employee e = new Employee();
					e.approveAccount(accNumber);

					// Store details for display in Employee's approve account method.
					fName = NCTXT.getCFirstName();
					lName = NCTXT.getCLastName();
					DOB = NCTXT.getDOB();
					address = NCTXT.getAddress();
					SSN = NCTXT.getSSN();
					UserName = NCTXT.getUserName();

				} else {
					System.out.println("******Passwords Do Not Match!******");
				}
			}

		}

	}

	

	

	// Write in TXT file*************************************************
	public static void WriteCustomerTxt(String customerFile, Object obj) {
		try (ObjectOutputStream OOSTXT = new ObjectOutputStream(new FileOutputStream(customerFile))) {
			OOSTXT.writeObject(obj);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	// *********************************************************************
	// Read the text file- Immediately once customer applied ***************
	// Read the customer name and auto generated account number for creating files.
	public static void ReadCustomerTxt(String customerFile) {
		try (ObjectInputStream OISTXT = new ObjectInputStream(new FileInputStream(customerFile))) {
			Object obj = OISTXT.readObject();
			System.out.println(obj);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// *************************************************************************
	//===========================================Password class-Customer
	
	public static void WritePasswordTxt(String customerFile, Object obj) {
		try (ObjectOutputStream OOSTXT = new ObjectOutputStream(new FileOutputStream(customerFile))) {
			OOSTXT.writeObject(obj);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public static void ReadPasswordTxt(String customerFile) {
		try (ObjectInputStream OISTXT = new ObjectInputStream(new FileInputStream(customerFile))) {
			Object obj = OISTXT.readObject();
			System.out.println(obj);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//=======================================================================
	public static void OldCustomerRead() {
		AccountDetails AD;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name:");

		String UName = sc.nextLine();
		System.out.println("");
		String cusTxtFile = "./" + UName + ".txt";
		try (ObjectInputStream OISTXT = new ObjectInputStream(new FileInputStream(cusTxtFile))) {
			Object obj = OISTXT.readObject();
		

			String accNumber = (String) obj.toString();
			//==========================================================Password
			try {
				String cusTxtFile1 = "./" + UName+"password" + ".txt";
				ObjectInputStream OISTXT1 = new ObjectInputStream(new FileInputStream(cusTxtFile1));
					Object obj1 = OISTXT1.readObject();
					String pwd=obj.toString();
					System.out.println(obj.toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//=========================================================
			System.out.println("Account Number : "+accNumber);
			cusTxtFile = "./" + accNumber + "AccountDetails" + ".txt";
			Employee e = new Employee();
			e.ReadAccountTxt(cusTxtFile);
			System.out.println("Please Enter the correct number to do any banking transction. Thank you. ");
			System.out.println("=> Deposit : 1" + "       " + "=> Withdraw : 2" + "      " + "=> Transfer : 3");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				//Deposit
				System.out.println("=> Enter The Depositing Amount :");
				while (!sc.hasNextDouble()) {
					System.out.println("Invalid Amount. Please Try Again!");
					sc.next();
				}
				double depositAmount = sc.nextDouble();
				if (depositAmount<=0){
					System.out.println("Invalid Amount. Deposits Can't Be A Negative Value.");
				}else {
		
				System.out.println("Deposited Amount : "+ depositAmount+ " $");
				double oldAmount=e.bal();
				double newAmount=oldAmount+depositAmount;
				 AD = new AccountDetails(accNumber, newAmount);
				e.WriteAccountTxt(cusTxtFile, AD);
				System.out.println("Your Money Has Been Deposited Succesfully.");
				System.out.println("New Balance Of Account Number "+ accNumber+" Is " +newAmount+" $");
				}
				break;
			case "2":
				//Withdraw
				//System.out.println("withdraw");
				System.out.println("=> Enter The Withdraw Amount :");
				oldAmount=e.bal();
				while (!sc.hasNextDouble()) {
					System.out.println("Invalid Amount. Please Try Again!");
					sc.next();
				}
				
				double withdrawAmount = sc.nextDouble();
				if(withdrawAmount<=0) {
					System.out.println("Invalid Amount. Withdraw Can't Be A Negative Value.");
				}else if(oldAmount<withdrawAmount) {
					System.out.println("The Withdrawal Amount Can Not Be More Than Current Balance.");
				}else {
				System.out.println("Withdrawed Amount : "+withdrawAmount+" $");
				
				newAmount=oldAmount-withdrawAmount;
				AD = new AccountDetails(accNumber, newAmount);
				e.WriteAccountTxt(cusTxtFile, AD);
				System.out.println("Your Money Has Been withdraw Succesfully.");
				System.out.println("New Balance Of Account Number "+ accNumber+" Is " +newAmount+" $");
				}
				break;
			case "3":
				//========================================================================================================================Transfer Money
				//System.out.println("transfer");
				System.out.println("Enter The Account Number To Transfer Money :");
				String transferNumber=sc.nextLine();
				System.out.println("=> Enter The Transfer Amount :");
				while (!sc.hasNextDouble()) {
					System.out.println("Invalid Amount. Please Try Again!");
					sc.next();
				}
				
				double transferAmount = sc.nextDouble();
				oldAmount=e.bal();
				if(transferAmount<=0) {
					System.out.println("Invalid Amount. Withdraw Can't Be A Negative Value.");
				}else if(oldAmount<transferAmount){
					System.out.println("The Transfer Amount Can Not Be More Than Current Balance.");
				}else {
						System.out.println("Amount To Transfer : "+transferAmount+" $");
						System.out.println("Account Number To Transfer : "+transferNumber);
						
						newAmount=oldAmount-transferAmount;
						/*AD = new AccountDetails(accNumber, newAmount);
						e.WriteAccountTxt(cusTxtFile, AD);
						System.out.println("Your Money Has Been Transfered Succesfully.");
						System.out.println("New Balance is : "+newAmount);*/
						
						String transferFile="./" + transferNumber +"AccountDetails"+ ".txt";
						e.ReadTransferTxt(transferFile);
						double ExistingAmount=e.bal();
						double totalTransferAmount=ExistingAmount+transferAmount;
						
							 AccountDetails AD1 = new AccountDetails(transferFile,totalTransferAmount );
								e.WriteTransferAmount(transferFile, AD1);
						
						if(e.check()!=1) {
							//System.out.println("Money Updated");
							AD = new AccountDetails(accNumber, newAmount);
							e.WriteAccountTxt(cusTxtFile, AD);
							System.out.println("Your Money Has Been Transfered Succesfully.");
							System.out.println("New Balance Of Account Number "+ accNumber+" Is " +newAmount+" $");
						}
						else {
							System.out.println("Money Did Not Transfered!");
						}
						
				//==================================================================================================================================
				break;
				}
			default:
				System.out.println("Wrong Selection !.");

			}
			sc.close();

		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Invalid User Name. There is No Account Associated With This User.");
		}
	}

	private static int parseInt(String accNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void tempCustDetails() {
		System.out.println("Name : " + fName + " " + lName);
		System.out.println("DOB : " + DOB + "       || Address : " + address + "       || SSN : " + SSN
				+ "      ||User Name : " + UserName);

	}

	public static void main(String[] args) {

		welcome();

	}

}
