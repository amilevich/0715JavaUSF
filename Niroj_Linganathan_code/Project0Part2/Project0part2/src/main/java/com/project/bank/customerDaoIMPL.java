package com.project.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class customerDaoIMPL implements customerDAO {

	private static String url = "jdbc:oracle:thin:@db0715java.ce8jdxpwtsbf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "niroj85";
	private static String password = "niroj4401";

	@Override
	public void insertCustomer(customer c1) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO USER_DETAILS VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, c1.getUserName());
			ps.setString(2, c1.getPassWord());
			ps.setString(3, c1.getfName());
			ps.setString(4, c1.getlName());
			ps.setString(5, c1.getAddress());
			ps.setString(6, c1.getAccType());
			ps.setInt(7, c1.getUniqueNo());
			ps.setString(8, c1.getAccStatus());
			ps.executeUpdate();

			String accType = c1.getAccType();
			if (accType.equals("Joined")) {

			} else {
				System.out.println(
						"Your Application For Open An Account has been Submited. You Will Have An Account Number Once You Got Approved !");
				MainClass mc = new MainClass();
				System.out.println("\n");
				mc.welcome();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public customer selectCustomer(String userName,String passWord) {
		customer cus = null;
		try (Connection con = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM USER_DETAILS WHERE USER_NAME=? AND UPASSWORD=?");
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cus = new customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (cus == null) {

			System.out.println("Invalid Login Details");
			MainClass mc = new MainClass();
			mc.existingCustomer();

		} else {
			customerCheckJunctionTable(userName);

		}
		return cus;
	}

	@Override
	public customer pendingApplications() {
		customer cus = null;
		try (Connection con = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM USER_DETAILS WHERE ACC_STATUS=?");
			ps.setString(1, "Pending");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cus = new customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));
				int UNum = cus.getUniqueNo();
			}

		} catch (SQLException e) {
			System.out.println("No Pending Applications1");
			//e.printStackTrace();

		}
		return cus;
	}

	@Override
	public void updateCustomerAccStatus(customer c1) {
		
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("UPDATE USER_DETAILS SET ACC_STATUS=? WHERE USER_NAME=?");
			ps.setString(1, c1.getAccStatus());
			ps.setString(2, c1.getUserName());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("No Pending Applications2");
			//e.printStackTrace();
		}

	}

	@Override
	public void customerCheckJunctionTable(String userName) {

		try (Connection con = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = con.prepareStatement("SELECT ACC_NUMBER FROM JUNCTION_TABLE WHERE USER_NAME=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// cus=new customer(rs.getString(1));
				int accNo = rs.getInt(1);
				System.out.println("Account Number ==>" + accNo);
				getCustomerAccount(accNo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void getCustomerAccount(int accNo) {
		double Existingbalance;
		Scanner sc = new Scanner(System.in);
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACC_NO=?");
			ps.setInt(1, accNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Existingbalance = rs.getDouble(1);
				System.out.println("Your Current Balance Is ==>" + Existingbalance);
				// --------------------------------------------------------------------------------------------------------------------------------------------
				bankingTransactions(accNo,Existingbalance);
				
				System.out.println("\n");
				System.out.println("Do You Want To Do Anything Else?  Yes ==> 1      No and Exit==> 2 ");
				String input=sc.nextLine();
				
				switch(input) {
				case "1":
					getCustomerAccount(accNo);
					break;
					
				default:
					MainClass mc=new MainClass();
					mc.welcome();
				}
				// -----------------------------------------------------------------------------------------------------------------------------------------
				}
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	public static void updateBalance(double amount, int accNo) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("UPDATE ACCOUNT_DETAILS SET BALANCE=? WHERE ACC_NO=?");
			ps.setDouble(1, amount);
			ps.setInt(2, accNo);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public static void bankingTransactions(int accNo, double Existingbalance) {
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Please Enter the correct number to do any banking transction. Thank you. ");
		System.out.println("=> Deposit : 1" + "       " + "=> Withdraw : 2" + "      " + "=> Transfer : 3"+"      "+"=> Exit : 4");
		String input = sc.nextLine();
		
		switch (input) {
		case "1":
			// Deposit
			System.out.println("=> Enter The Depositing Amount :");
			while (!sc.hasNextDouble()) {
				System.out.println("Invalid Amount. Please Try Again!");
				sc.next();
			}
			double depositAmount = sc.nextDouble();
			if (depositAmount <= 0) {
				System.out.println("Invalid Amount. Deposits Can't Be A Negative Value.");
			} else {

				System.out.println("Deposited Amount : " + depositAmount + " $");
				double oldAmount = Existingbalance;
				double newAmount = oldAmount + depositAmount;
				updateBalance(newAmount, accNo);
				System.out.println("Your Money Has Been Deposited Succesfully.");
				System.out.println("New Balance Of Account Number " + accNo + " ==>" + newAmount + " $");
			}
			break;
			
		case"2":
			//**************************************************************************************************************
			System.out.println("=> Enter The Withdraw Amount :");
			double oldAmount=Existingbalance;
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
			
			double newAmount=oldAmount-withdrawAmount;
			updateBalance(newAmount, accNo);
			System.out.println("Your Money Has Been withdraw Succesfully.");
			System.out.println("New Balance Of Account Number "+ accNo+" Is " +newAmount+" $");
			}
			//**************************************************************************************************************
			break;
		case "3":
			//**************************************************************************************************************
			System.out.println("Enter The Account Number To Transfer Money :");
			int transferNumber=sc.nextInt();
			System.out.println("=> Enter The Transfer Amount :");
			while (!sc.hasNextDouble()) {
				System.out.println("Invalid Amount. Please Try Again!");
				sc.next();
			}
			
			double transferAmount = sc.nextDouble();
			oldAmount=Existingbalance;
			if(transferAmount<=0) {
				System.out.println("Invalid Amount. Withdraw Can't Be A Negative Value.");
			}else if(oldAmount<transferAmount){
				System.out.println("The Transfer Amount Can Not Be More Than Current Balance.");
			}else {
					System.out.println("Amount To Transfer : "+transferAmount+" $");
					System.out.println("Account Number To Transfer : "+transferNumber);
					
					double newAmount=oldAmount-transferAmount;
					updateBalance(newAmount, accNo);
			
					//This is the target accounts existing balance.
					double ExistingAmountOfTarget;
					
					
					try (Connection con = DriverManager.getConnection(url, username, password)) {
						PreparedStatement ps = con.prepareStatement("SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACC_NO=?");
						ps.setInt(1, transferNumber);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							ExistingAmountOfTarget = rs.getDouble(1);
							double totalTransferAmount=ExistingAmountOfTarget+transferAmount;
							//System.out.println("Current Balance Of Target Account Is ==>" + totalTransferAmount);
							updateBalance(totalTransferAmount, transferNumber);
							
						}
		
						System.out.println("Your Money Has Been Transfered Succesfully.");
						System.out.println("New Balance Of Account Number "+ accNo+" Is " +newAmount+" $");
						
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
		
			}	
			
			//**************************************************************************************************************
			break;
		case "4":
			System.out.println("Back To Main Menu......");
			System.out.println("\n");
			MainClass mc=new MainClass();
			mc.welcome();
		default:
			System.out.println("Wrong Selection And Forwarded To Back....");
			bankingTransactions(accNo,Existingbalance);
			break;
}
	}

	@Override
	public void employeeSeeCustomerDetails(int accNo) {
		
		
		try (Connection con = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = con.prepareStatement("SELECT USER_NAME FROM JUNCTION_TABLE WHERE ACC_NUMBER=?");
			ps.setInt(1,accNo);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				
				String  UserName =rs.getString(1);
				//System.out.println("User Name ==>" +UserName );
				try(PreparedStatement ps1 = con.prepareStatement("SELECT * FROM USER_DETAILS WHERE USER_NAME=?")){
					ps1.setString(1, UserName);
					ResultSet rs1=ps1.executeQuery();
					
						
						while(rs1.next()) {
							System.out.println("First Name ==> "+rs1.getString(3)+"    Last Name ==> "+rs1.getString(4)+"    Address ==> "+rs1.getString(5));
							System.out.println("Account Number ==> "+accNo +"    Account Type ==> "+rs1.getString(6)+"    Account Status ==> "+rs1.getString(8));
						}			
							
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				//getCustomerAccount(accNo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		

	}

	public static void throwUserName(String UserName) {
		String userName=UserName;
	}
		
	}
	
