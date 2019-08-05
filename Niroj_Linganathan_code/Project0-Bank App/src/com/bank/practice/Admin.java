package com.bank.practice;

import java.io.File;
import java.util.Scanner;

public class Admin {
	static String accNumber;
	static double balance;
	static String adminId;
	static String password;
	static double bal2;
	public static void  adminMainPage() {
		AccountDetails AD;
		Employee e = new Employee();
		bank b1=new bank();
		Scanner sc = new Scanner(System.in);
		System.out.println("                 Commercial Bank");
		System.out.println("                   Admin login");
		System.out.println(" ");
		System.out.println("Enter Admin ID :-");

		adminId = sc.nextLine();
		System.out.println("Enter Password :-");
		password = sc.nextLine();
		
		if (adminId.equals("admin") && password.equals("commbank")) {
			System.out.println("WelCome" + " " + adminId);

			System.out.println("@ Manage Bank Transactions==> PRESS 1" + "    " + "@ Cancel An Account==> PRESS 2");
			String input = sc.nextLine();
			switch (input) {
			
			case "1":
				System.out.println("Manage Customer's Bank Transactions");
				System.out.println("=> Deposit : 1" + "       " + "=> Withdraw : 2" + "      " + "=> Transfer : 3");
				String input1=sc.nextLine();
				switch(input1) {
				case "1":
					
					//=============================================================>Deposit from Admin page
					System.out.println("Enter The Account Number :");
					accNumber=sc.nextLine();
					System.out.println("=> Enter The Depositing Amount :");
					String cusTxtFile = "./" + accNumber + "AccountDetails" + ".txt";
					
					e.ReadAccountTxt(cusTxtFile);
					while (!sc.hasNextDouble()) {
						System.out.println("Invalid Amount. Please Try Again!");
						sc.next();
					}
					double depositAmount = sc.nextDouble();
					if (depositAmount<=0){
						System.out.println("Invalid Amount. Deposits Can't Be A Negative Value.");
					}else {
			
					System.out.println("Deposited Amount : "+depositAmount+" $");
					double oldAmount=e.bal();
					double newAmount=oldAmount+depositAmount;
					 AD = new AccountDetails(accNumber, newAmount);
					e.WriteAccountTxt(cusTxtFile, AD);
					System.out.println("Money Has Been Deposited Succesfully.");
					System.out.println("New Balance Of Account Number "+ accNumber+" Is " +newAmount+" $");
					}
					//======================================================================>
					break;
				case "2":
					//======================================================================>Withdraw from admin page
					//System.out.println("withdraw");
					System.out.println("Enter The Account Number :");
					accNumber=sc.nextLine();
					System.out.println("=> Enter The Withdraw Amount :");
					cusTxtFile = "./" + accNumber + "AccountDetails" + ".txt";
					//Employee e = new Employee();
					e.ReadAccountTxt(cusTxtFile);
					double oldAmount=e.bal();
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
						
					System.out.println("Withdrawed Amount : "+withdrawAmount+ " $");
					double newAmount=oldAmount-withdrawAmount;
					AD = new AccountDetails(accNumber, newAmount);
					e.WriteAccountTxt(cusTxtFile, AD);
					System.out.println("Money Has Been withdrawed Succesfully.");
					System.out.println("New Balance Of Account Number "+ accNumber+" Is " +newAmount+" $");
					}
					//========================================================================================>
					
					break;
				case "3":
					//===========================================================================>Tranfer from admin page
					System.out.println("Transfer");
					
					System.out.println("Enter The Account Number :");
					accNumber=sc.nextLine();
					//System.out.println("=> Enter The Withdraw Amount :");
					cusTxtFile = "./" + accNumber + "AccountDetails" + ".txt";
					e.ReadAccountTxt(cusTxtFile);
					 oldAmount=e.bal();
					
					System.out.println("Enter The Account Number To Transfer Money :");
					String transferNumber=sc.nextLine();
					System.out.println("=> Enter The Transfer Amount :");
					while (!sc.hasNextDouble()) {
						System.out.println("Invalid Amount. Please Try Again!");
						sc.next();
					}
					
					double transferAmount = sc.nextDouble();
					if(transferAmount<=0) {
						System.out.println("Invalid Amount. Withdraw Can't Be A Negative Value.");
					}else if(oldAmount<transferAmount){
						System.out.println("The Transfer Amount Can Not Be More Than Current Balance.");
					}else {
							System.out.println("Amount To Transfer : "+transferAmount+" $");
							System.out.println("Account Number To Transfer : "+ transferNumber);
							
							double newAmount=oldAmount-transferAmount;
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
					}
			default:
				System.out.println("Invalid Selection !");
			b1.welcome();
			}
			case "2":
				System.out.println("Cancel An Account");
				cancelAccount();
				
				break;
			default:
				System.out.println("Invalid Selection !");
			b1.welcome();
			}

		} else {
			System.out.println("Invalid Login Details.");
			b1.welcome();
		}
		sc.close();
	}
	public static void cancelAccount() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Account Number You Want To Cancel :");
		accNumber=sc.nextLine();
	
		String cusTxtFile = "./" + accNumber + "AccountDetails" + ".txt";
		Employee e=new Employee();
		e.ReadAccountTxt(cusTxtFile);
		System.out.println("************WARNING****************");
		System.out.println("ARE YOU SURE WANT TO CANCEL THIS ACCOUNT? y/n");
		if(sc.nextLine().equals("y")) {
			
			File file = new File("C:\\Users\\IBM\\Documents\\workspace-sts-3.9.4.RELEASE\\Bank_Practice\\"+cusTxtFile); 
	        
	        if(file.delete()) 
	        { 
	            System.out.println("Account Canceled successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to Cancel the Account"); 
	        } 
		}else {
			System.out.println("Processed Canceled And You Are Directed To Main Page");
			bank b1=new bank();
			b1.welcome();
		}
		
	}
	}
	

