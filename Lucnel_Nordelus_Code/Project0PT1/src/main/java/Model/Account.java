package Model;
import Utils.BankManagementContract;
import Utils.BankingFileIOOperations;
import Utils.MyLogger;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.InvalidBalanceException;
public abstract class Account {
	
	private int accountID ;
	private char [] accountHolder ;
	private Date date ;
	private char type ;
	private char [] accUserPassword ;
	private String accState ;
	protected Scanner input ;
	protected double currentBalance ;
	
	public Account() {
		
		accUserPassword = null ;
		
	}
	
	public Account(char[] accountHolder, Double balance,  char type) {
		
		this.accountHolder = accountHolder;
		this.type = type;
		this.currentBalance = balance ;
                this.accState = BankManagementContract.PENDING_ACCOUNT_STATE;
		input = new Scanner(System.in);
	}

    public String getAccState() {
        return accState;
    }

    public void setAccState(String accState) {
        this.accState = accState;
    }
    public abstract void Withdraw(Double twbalance);

    public char getCurrencyType(Scanner input){

            char cType ;
            boolean isCorrect = false ;

            do{

                    System.out.println("Enter customer currency type:( D/d for Dollars(US)");
                    input.nextLine();
                    cType = input.nextLine().charAt(0);

                    if (cType == 'D' || cType == 'd'){

                            isCorrect = true ;
                    }
                    else{
                            System.out.println("Please enter the valid currency type.");
                    }

            }while(!isCorrect);

            return cType ;
    }
	

    public void Deposit(){

        System.out.println("Enter the amount you want to deposit");
        double depositAmount = input.nextDouble();
        char currencyType = getCurrencyType(input);

        if (currencyType == 'D' || currencyType == 'd'){

                depositAmount = (depositAmount);
        }

        try{

                if (depositAmount <= 0){

                        throw new InvalidBalanceException("Exception occur that Deposit Amount Must be greater than zero.");
                }

                this.currentBalance += depositAmount ;
                String msg = ("Account Holder with name " 
                             + String.valueOf(this.getAccountHolder()) + " has performed transaction of Deposit.\n" 
                             + "You have successfully Deposit " + depositAmount 
                             + " Total Balance = " + this.currentBalance);
                MyLogger.log(msg);
                System.out.println("You have successfully deposit " + depositAmount + " to your basic account.");
        }

        catch(InvalidBalanceException e){

                Deposit();
        }
    }

    public int getAccountID() {
            return this.accountID;
    }
    public double getCurrentBalance() {
            return this.currentBalance;
    }
    public char[] getAccountHolder() {
            return this.accountHolder;
    }

    public Date getDate() {
            return this.date;
    }

    public char getType() {
            return this.type;
    }

    public void setAccountID(int accountID) {
            this.accountID = accountID;
    }

    public void setAccountHolder(char[] accountHolder) {
            this.accountHolder = accountHolder;
    }

    public void setDate(Date date) {
            this.date = date;
    }

    public void setType(char type) {
            this.type = type;
    }

    public void setCurrentBalance(double currentBalance) {
            this.currentBalance = currentBalance;
    }

    public char[] getAccUserPassword() {
            return this.accUserPassword;
    }

    public void setAccUserPassword(char[] accUserPassword) {
            this.accUserPassword = accUserPassword;
    }	

    public void Display(){

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            System.out.println("                    Account_Detail_List                                    \n" +
                               "\n*************************************************************************************************\n"
                      +"ID	Account_Holder_Name	Created_Date	Type	Current_Balance     State            \n"
                      +"*************************************************************************************************\n"
                      +this.getAccountID() + "\t" + String.valueOf(this.getAccountHolder())+ "\t" + formatter.format(this.getDate()) + "\t" 
                      +this.getType()+ "\t" + this.getCurrentBalance() + "\t" + this.accState);
    }
}
