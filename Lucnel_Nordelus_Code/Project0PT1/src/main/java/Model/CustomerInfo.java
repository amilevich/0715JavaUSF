package Model;
import Model.SavingAccount;
import Utils.BankingFileIOOperations;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date ;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.AccountNotFound;
import Exceptions.InvalidBalanceAmountException;
import Exceptions.InvalidBalanceException;

public class CustomerInfo {
	
	private char [] customerName ;
        private char [] customerPassword ;
        
	private int  customerID ;
	private ArrayList<Account> account_List ;
	
	// Default Constructor........
	public CustomerInfo(){
		
		customerID = 1000;
		account_List = new ArrayList<Account>() ;
        }
        
        
        public void CustomerINET_BankingMenu(Scanner input){
            
            int usr_Choice ;
            
            do{
			
                System.out.println("************************************************************************\n"+
                                                              "\t\t\tWorld Bank Customer Menu\n"
                                   +"************************************************************************\n");
                System.out.println("Would you like to:" + "\n\t1- Press 1 for Deposit." + "\n\t2- Press 2 for Withdraw."
                                   + "\n\t3- Press 3 for Display account information."
                                   + "\n\t4- Press 4 to view your Account Balance. " 
                                   + "\n\t5- Press 0 go to the previous menu." + "\nEnter your choice");

                try{
                    usr_Choice = input.nextInt();
                }catch(Exception e){
                    usr_Choice = Integer.MAX_VALUE;
                }
                
                int accNo = 0 ;

                if (usr_Choice == 4 || usr_Choice == 1 || usr_Choice == 2 || usr_Choice == 3){

                    boolean isAccNoValid = false ;
                    do{
                        try{
                            System.out.println("Enter account number:");
                            accNo = input.nextInt();
                            isAccNoValid = true ;
                        }catch(Exception e){
                            input.nextLine();
                        }
                    }while(!isAccNoValid);
                    
                    switch(usr_Choice){
                        
                        case 1:
                            DepositAmount(accNo);
                            break;
                        case 2:
                            WithDrawAmount(accNo);
                            break;
                        case 3:
                            DisplayAccount(accNo);
                            break;
                        case 4:
                            CheckBalance(accNo);
                            break;
                    }
                }else if (usr_Choice == 0){
                    input.nextLine();
                    System.out.println("You Logged out from World Bank Account Successfully");
                }
                else{
                    input.nextLine();
                    System.out.println("Please enter the valid option.");
                }
                
            }while(usr_Choice != 0);
        }
        
        public void DepositAmount(int accNo){
		
		Account temp_Account = FindAccountNumber(accNo);
		
		if (temp_Account != null){
			
                    temp_Account.Deposit();
                    BankingFileIOOperations.UpdateAccountFile();
		}
		
		else{
			
			ThrowAccountException();
			
		}
	}
	
	public void ThrowAccountException(){
		
            try{
                throw new AccountNotFound("Exception occur that given account number is invalid or customer account does not exist.");
            }

            catch(AccountNotFound e){

                    System.out.println("Exception is : " + e);
                    //e.printStackTrace();
            }
		
	}
        
        public void WithDrawAmount(int accNo){
		
		Account temp_Account = FindAccountNumber(accNo);
		
		if (temp_Account != null){
			
			Double beforeBalance = temp_Account.getCurrentBalance();
			
			Double totalWithdrawBalance = BankingFileIOOperations.GetWithdrawBalance(accNo);
			
			char type = temp_Account.getType() ;
			
			if (type == 'b' || type == 'B'  ){
					
				if (totalWithdrawBalance < 30000.0){
					
					temp_Account.Withdraw(totalWithdrawBalance);
				}
				else{
                                    Logger.getLogger(BankingFileIOOperations.class.getName()).log(Level.SEVERE, null, "Your Withdrawal Limit Exceeds now. Please Try Later.");
				}	
			}
			
			else if (type == 's' || type == 'S'){
				
				if (totalWithdrawBalance < 25000.0){
					
					temp_Account.Withdraw(totalWithdrawBalance);
				}
				
				else{
					System.out.println("Your Withdrawal Limit Exceeds now. Please Try Later.");
				}
			}
			
			else if (type == 'c' || type == 'C'){
				
				temp_Account.Withdraw(0.0);
			}
			
			if (temp_Account.getCurrentBalance() > 0){
				
				if (totalWithdrawBalance == 0){
				
					BankingFileIOOperations.MakeWithdrawLog(temp_Account , beforeBalance , ( beforeBalance - temp_Account.getCurrentBalance()));
				}
				else{
					
					BankingFileIOOperations.MakeWithdrawLog(temp_Account , beforeBalance , totalWithdrawBalance);
				}
			}
			BankingFileIOOperations.UpdateAccountFile();
		}
		
		else{
			
			ThrowAccountException();
		}
		
	}
        
        public void DisplayAccount(int accNo){
		
            Account temp_acc = FindAccountNumber(accNo);

            if (temp_acc != null){

                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

                    System.out.println("*************************************************************************************************\n"
                                    +"ID	Account_Holder_Name	Created_Date	Type	Current_Balance             \n"
                                    +"*************************************************************************************************\n"
                                    +temp_acc.getAccountID() + "\t" + String.valueOf(temp_acc.getAccountHolder())+ "\t" + formatter.format(temp_acc.getDate()) + "\t" 
                                    +temp_acc.getType()+ "\t" + temp_acc.getCurrentBalance());		
            }

            else{

                    ThrowAccountException();
            }
	}
        
        public void CheckBalance(int accNo){
		
            Account temp_acc = FindAccountNumber(accNo);

            if (temp_acc != null){

                temp_acc.Display();
            }

            else {
                ThrowAccountException();
            }
	}
        
        public Account FindAccountNumber(int accNo){
		
            for (int j = 0 ; (j < this.getAccount_List().size()); j++){

                if (this.getAccount_List().get(j).getAccountID() == accNo){

                        return this.getAccount_List().get(j);
                }	
            }
            return null ;	
	
	
	}
	
	public void CreateCustomer(Scanner input){
                
            boolean isCorrect = false ;
            do{
                input.nextLine();
                System.out.println("Enter customer name ");
                customerName = input.nextLine().toCharArray();
                if (customerName != null && customerName.length > 2){
                    isCorrect = true ;
                }

            }while(!isCorrect);
            isCorrect = false ;
            do{
                //input.nextLine();
                System.out.println("Enter customer password  ");
                customerPassword = input.nextLine().toCharArray();
                if (customerPassword != null && customerPassword.length > 0){
                    isCorrect = true ;
                }
            }while(!isCorrect);
            
	}
	
	public char getCurrencyType(Scanner input){
		
		char cType ;
		boolean isCorrect = false ;
		input.nextLine();
		
		do{
			
			System.out.println("Enter customer currency type:(D/d for Dollars(US)");
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
	
	public void CreateAccount(Scanner input , int id){
		
		boolean isCorrect = false ;
		char choice ;
		double balance = 0.0 ;
		
		do{
			System.out.println("Select the account type" 
	                   + "\n" + "\t1- Press B or b for Basic Account of initial Balance Must be equal or greater than 1000"
	                   + "\n" + "\t2- Press S or s for Saving Account of initial Balance Must be equal or greater than 5000"
	                   + "\n" + "\t3- Press C or c for Current Account of initial Balance Must be greater than zero"
	                   + "\n" + "Enter the account type");
	
			choice = input.nextLine().charAt(0);
			char currencyType ;
			
			if (choice == 'B' || choice == 'b'){
				
                                boolean isCorrectBal = false ;
                                do{
                                    try{
                                        System.out.println("Enter the initial balance");
                                        balance = input.nextDouble();
                                        isCorrectBal = true ;
                                    }catch(Exception e){
                                        isCorrectBal = false ;
                                        input.nextLine();
                                    }
                                }while(!isCorrectBal);
				
				try{
				
					if (balance <= 0){
						
						throw new InvalidBalanceException("Exception occur that initial Balance Must be greater than zero.");
					}
					
					else if (balance < 1000){
						
						throw new InvalidBalanceAmountException("Exception occur that initial Balance Must be equal or greater than 1000.");
						
					}
				}
				
				catch(InvalidBalanceAmountException e){
					
					//System.out.println(e);
					input.nextLine();
                                        CreateAccount(input , id);
					//e.printStackTrace();
					
				}
				
				catch(InvalidBalanceException e){
					
					//System.out.println(e);
					input.nextLine();
                                        CreateAccount(input , id);
					//e.printStackTrace();
					
				}
                                
                                currencyType = getCurrencyType(input);
				
				if (currencyType == 'D' || currencyType == 'd'){
					
					balance = (balance);
				}
				
				if (balance > 999){
					
					char [] aname = (String.valueOf(this.customerName)+ " ").toCharArray();
					
					Account basicAccount = new BasicAccount(aname , balance , choice);
					
					if (id != 0){
						
						basicAccount.setAccountID(++id);
					}
					
					else{
			
						basicAccount.setAccountID(10001);
					}
					
					basicAccount.setAccUserPassword(customerPassword);
					basicAccount.setDate(new Date());
					this.account_List.add(basicAccount);
					
				}
			}
			else if (choice == 'S' || choice == 's'){
				
				boolean isCorrectBal = false ;
                                do{
                                    try{
                                        System.out.println("Enter the initial balance");
                                        balance = input.nextDouble();
                                        isCorrectBal = true ;
                                    }catch(Exception e){
                                        input.nextLine();
                                        isCorrectBal = false ;
                                    }
                                }while(!isCorrectBal);
				
				try{
				
					if (balance <= 0){
						
						throw new InvalidBalanceException("Exception occur that initial Balance Must be greater than zero.");
					}
					
					else if (balance < 5000){
						
						throw new InvalidBalanceAmountException("Exception occur that initial Balance Must be equal or greater than 5000.");
						
					}
				}
				
				catch(InvalidBalanceAmountException e){
					
					//System.out.println(e);
					input.nextLine();
                                        CreateAccount(input , id);
					//e.printStackTrace();
					
				}
				
				catch(InvalidBalanceException e){
					
					//System.out.println(e);
					input.nextLine();
                                        CreateAccount(input , id);
					//e.printStackTrace();
					
				}
                                
                                currencyType = getCurrencyType(input);
                                if (currencyType == 'D' || currencyType == 'd'){
					
					balance = (balance);
				}
				
				if (balance >= 5000){
					
					char [] aname = (String.valueOf(this.customerName)+ " ").toCharArray();
				
					Account savingAccount = new SavingAccount(aname , balance , choice);
				
					if (id != 0){
					
						savingAccount.setAccountID(++id);
					}
					else{
						savingAccount.setAccountID(10001);
					}
					
					savingAccount.setDate(new Date());
                                        savingAccount.setAccUserPassword(customerPassword);
					this.account_List.add(savingAccount);
				}
			}
			
			else if (choice == 'C' || choice == 'c'){
				
				boolean isCorrectBal = false ;
                                do{
                                    try{
                                        System.out.println("Enter the initial balance");
                                        balance = input.nextDouble();
                                        isCorrectBal = true ;
                                    }catch(Exception e){
                                        input.nextLine();
                                        isCorrectBal = false ;
                                    }
                                }while(!isCorrectBal);
				
				try{
				
                                    if (balance <= 0){

                                            throw new InvalidBalanceException("Exception occur that initial Balance Must be greater than zero.");
                                    }
				}
				
				catch(InvalidBalanceException e){
					
					//System.out.println(e);
					input.nextLine();
                                        CreateAccount(input , id);
					//e.printStackTrace();
					
				}
                                
                                currencyType = getCurrencyType(input);
				
				if (currencyType == 'D' || currencyType == 'd'){
					
					balance = (balance);
				}
					
				char [] aname = (String.valueOf(this.customerName)+ " ").toCharArray();
				
				Account currentAccount = new CurrentAccount(aname , balance , choice);
				
				if (id != 0){
					
					currentAccount.setAccountID(++id);
				}
				else{
					currentAccount.setAccountID(10001);
				}
				
				currentAccount.setDate(new Date());
				currentAccount.setAccUserPassword(customerPassword);
                                this.account_List.add(currentAccount);	
			}
			
                        if (choice == 'B' || choice == 'b' || choice == 'S' || choice == 's' || choice == 'C' || choice == 'c'){
                            int i = 0;
                            for (;i< account_List.size();i++);

                            System.out.println(String.valueOf(account_List.get(i - 1).getAccountHolder())
                                       +"your new Account request has been created with Account numer: " 
                                       + account_List.get(i - 1).getAccountID());

                            System.out.println("Do you want to add more account? Y/N");
                            char usr_Choice = input.nextLine().charAt(0);

                            if (usr_Choice != 'Y'){

                                isCorrect = true ;
                            }
                        }else{
                            System.out.println("Please Select account from the provided options...");
                        }
				
		}while(!isCorrect);
	}
	
	public void Display(){
		
		System.out.println(this.customerID + "\t" + String.valueOf(this.customerName));
	}
	
	public void setAccount_List(ArrayList<Account> account_List) {
		this.account_List = account_List;
	}

	public String getString(boolean isAppend){
		
		if (isAppend){
			
			return "\r\n" + this.customerID+"," +String.valueOf(this.customerName)+","+String.valueOf(this.customerPassword) ;
		}
		else{
			return this.customerID+","+String.valueOf(this.customerName)+","+String.valueOf(this.customerPassword);
		}
	}
	
	public ArrayList<Account> getAccount_List() {
	
		return this.account_List;
	}
        
        public char[] getCustomerPassword() {
            return customerPassword;
        }

        public void setCustomerPassword(char[] customerPassword) {
            this.customerPassword = customerPassword;
        }

	public void setCustomerName(char[] customerName) {
		this.customerName = customerName;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public char[] getCustomerName() {
		
		return this.customerName;
	
	}
}
