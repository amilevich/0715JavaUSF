package Model;

import Model.CustomerInfo;
import Utils.BankManagementContract;
import Utils.BankingFileIOOperations;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.AccountNotFound;
import Exceptions.CustomerNotFoundException;

public class BankManagement {
    
    private Scanner input ; 
    
    private static List<CustomerInfo> customerList ;
    
    // Default Constructor....
    public BankManagement(){
        
        input = new Scanner(System.in);
        customerList = new ArrayList<CustomerInfo>();
    }
    
    public void introduction(){
		
        System.out.println("************************************************************************\n"
                            + "\t\t\t Welcome to Bank Management System\n" + 
                                      "\t\t\t Bank Name: International World Bank\n"  +
                            "\n************************************************************************" );
        customerList = BankingFileIOOperations.LoadData();
        
    }
    
    public void CustomerMenu(){
        boolean isCorrect = false ;
        int usr_Choice ;
        
       do {
                System.out.println("Choose Option:" + "\n\t 1- Press 1 for LogIn ."
                                    +"\n\t 2- Press 2 for account opening and registration." 
                                    +"\n\t 3- Press 0 to go back to main menu\nEnter Your Choice");

                try{
                    usr_Choice = input.nextInt();
                }catch(Exception e){
                    usr_Choice = Integer.MAX_VALUE;
                }

                switch(usr_Choice){
                    
                case 1:
                        input.nextLine();
                        
                        try{
                            
                            CustomerInfo authenticCustomer = logInUser();
                        
                            if (authenticCustomer != null){
                            
                                if (authenticCustomer.getAccount_List() != null && authenticCustomer.getAccount_List().size() > 0){
                                    
                                    String accState = authenticCustomer.getAccount_List().get(0).getAccState();

                                    if (accState.equals(BankManagementContract.APPROVED_ACCOUNT_STATE)){

                                        // Display Customer functions here....
                                        authenticCustomer.CustomerINET_BankingMenu(input);

                                    }else if (accState.equals(BankManagementContract.REJECTED_ACCOUNT_STATE)){
                                        System.out.println("Sorry, Your Bank Account Request has been Rejected.\n"
                                                         + "Please try again or visit World bank for more details.\nThank You for your patience");
                                    }else{
                                        System.out.println("Your Bank Account Request is still in under review.\n"
                                                         + "Please wait untill Bank staff take action against your request.");
                                    }
                                }

                            }else{
                                
                                throw new CustomerNotFoundException("Error due to the following reasons:" + "\n Given Customer credentials is invalid " + 
				                                    "\n World Bank database does not recognize the record corressponding to the given id."
				                                    +"\nTry again to with a valid customer credentials.");
                            }
                            
                        }catch(CustomerNotFoundException e){
                            //System.out.println(e.getMessage());
                        }
                        break ;

                case 2:
                        //input.nextLine();
                        createNewCustomer();
                        System.out.println("You have successfully Apply for opening new account\n.Please wait untill Bank Staff Approve your request.");
                        break ;
                        
                case 0:

                        isCorrect = true ;
                        System.out.println("Thank You for visit this menu.");

                        break;

                default :
                        input.nextLine();
                        System.out.println("Please Enter the valid option.");

                }

        }while(!isCorrect);
    }
    
    public void EmployeeMenu(){
        
        boolean isCorrect = false ;
        int usr_Choice ;
        
        do {
                System.out.println("Choose Option:" + "\n\t 1- Press 1 for LogIn ." 
                                    +"\n\t 2- Press 0 to go back to main menu\nEnter Your Choice");

                try{
                    usr_Choice = input.nextInt();
                }catch(Exception e){
                    usr_Choice = Integer.MAX_VALUE;
                }

                switch(usr_Choice){
                    
                case 1:
                        input.nextLine();
                        
                        try{
                            
                            CustomerInfo authenticCustomer = logInUser();
                        
                            if (authenticCustomer != null){
                            
                                int custID = authenticCustomer.getCustomerID();
                                
                                if (custID == 1002){
                                    
                                    // Display Employee functions here....
                                    Employee_BankingMenu();
                                
                                }else{
                                    System.out.println("Unable to access this account.");
                                }
                            }else{
                                
                                throw new CustomerNotFoundException("Error due to the following reasons:" + "\n Given Customer credentials is invalid " + 
				                                    "\n World Bank database does not recognize the record corressponding to the given id."
				                                    +"\nTry again to with a valid customer credentials.");
                            }
                            
                        }catch(CustomerNotFoundException e){
                            //System.out.println(e.getMessage());
                        }
                        break ;
                        
                case 0:

                        isCorrect = true ;
                        System.out.println("Thank You for visit this menu.");

                        break;

                default :
                        input.nextLine();
                        System.out.println("Please Enter the valid option.");

                }

        }while(!isCorrect);
    }
    
    public void AdminMenu(){
        
        boolean isCorrect = false ;
        int usr_Choice ;
        
        do {
            System.out.println("Choose Option:" + "\n\t 1- Press 1 for LogIn ." 
                                +"\n\t 2- Press 0 to go back to main menu\nEnter Your Choice");

            try{
                usr_Choice = input.nextInt();
            }catch(Exception e){
                usr_Choice = Integer.MAX_VALUE;
            }

            switch(usr_Choice){

            case 1:
                    input.nextLine();

                    try{

                        CustomerInfo authenticCustomer = logInUser();

                        if (authenticCustomer != null){

                            int custID = authenticCustomer.getCustomerID();

                            if (custID == 1001){

                                // Display Customer functions here....
                                //authenticCustomer.CustomerINET_BankingMenu(input);
                                Admin_BankingMenu();

                            }else{
                                System.out.println("Unable to access this account.\n"
                                                 + "Please try with your credentials");
                            }
                        }else{

                            throw new CustomerNotFoundException("Error due to the following reasons:" + "\n Given Customer credentials is invalid ");
                        }

                    }catch(CustomerNotFoundException e){
                        //System.out.println(e.getMessage());
                    }
                    break ;

            case 0:

                    isCorrect = true ;
                    System.out.println("Thank You for visit this menu.");

                    break;

            default :
                    input.nextLine();
                    System.out.println("Please Enter the valid option.");

            }

        }while(!isCorrect);
    }
    
    /*
        Administrative Functions Implementation....
    */
    public void Admin_BankingMenu(){

        int usr_Choice ;

        do{

            System.out.println("************************************************************************\n"+
                                                          "\t\t\tWorld Bank Admin Menu\n"
                               +"************************************************************************\n");
            System.out.println("Would you like to:" + "\n\t1- Press 1 for approve/deny open applications for accounts." 
                              + "\n\t2- Press 2 for view all of customers information."
                              + "\n\t1- Press 3 for Deposit." + "\n\t2- Press 4 for Withdraw."
                              + "\n\t3- Press 5 for Display account information."
                              + "\n\t3- Press 0 go to the previous menu." + "\nEnter your choice");

            try{
                usr_Choice = input.nextInt();
            }catch(Exception e){
                usr_Choice = Integer.MAX_VALUE;
            }
            int accNo = 0 ;
            switch(usr_Choice){

                case 1:
                    List<Account> pendingAccounts = getPendingAccounts();
                    boolean isAccNoValid = false ;
                    do{
                        try{
                            pendingAccounts.forEach((account) -> {
                                account.Display();
                            });
                            System.out.println();
                            System.out.println("Enter account number:");
                            accNo = input.nextInt();
                            isAccNoValid = true ;
                        }catch(Exception e){
                            input.nextLine();
                        }
                    }while(!isAccNoValid);
                    
                    boolean isValid = false ;
                    do{
                        try{
                            
                            System.out.println("Do you want to Approve/Deny selected account request with number is: " + accNo + "? Y/N");
                            char usr_action = input.nextLine().charAt(0);

                            if (usr_action == 'N' || usr_action == 'n'){

                                isValid = true ;
                                UpdateAccountRequest(accNo, BankManagementContract.REJECTED_ACCOUNT_STATE);
                            }else if (usr_action == 'Y' || usr_action == 'y'){
                                isValid = true ;
                                UpdateAccountRequest(accNo, BankManagementContract.APPROVED_ACCOUNT_STATE);
                            }
                            
                        }catch(Exception e){
                            input.nextLine();
                        }
                        
                    }while(!isValid);
                    
                    break;
                case 2:
                    DisplayAll();
                    break;
                case 3:
                case 4:
                case 5:
                    isAccNoValid = false ;
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
                        
                        case 3:
                            DepositAmount(accNo);
                            break;
                        case 4:
                            WithDrawAmount(accNo);
                            break;
                        case 5:
                            DisplayAccount(accNo);
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Thanks for using!!!");
                    break;
                default:
                    input.nextLine();
                    System.out.println("Please enter the valid option.");
            }
        }while(usr_Choice != 0);
    }
    
    /*
        Administrative Functions Implementation....
    
    */
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

    public Account FindAccountNumber(int accNo){

        for (int i = 0 ; i < customerList.size(); i++){

            for (int j = 0 ; (j < customerList.get(i).getAccount_List().size()); j++){

                if (customerList.get(i).getAccount_List().get(j).getAccountID() == accNo){

                        return customerList.get(i).getAccount_List().get(j);

                }	
            }	
        }
        return null ;
    }
    
    /*
        Employee Functions Implementation.....
    
    */
    public void Employee_BankingMenu(){

        int usr_Choice ;

        do{

            System.out.println("************************************************************************\n"+
                                                          "\t\t\tWorld Bank Employee Menu\n"
                               +"************************************************************************\n");
            System.out.println("Would you like to:" + "\n\t1- Press 1 for approve/deny open applications for accounts." 
                              + "\n\t2- Press 2 for view all of customers information." 
                               + "\n\t3- Press 0 go to the previous menu." + "\nEnter your choice");

            try{
                usr_Choice = input.nextInt();
            }catch(Exception e){
                usr_Choice = Integer.MAX_VALUE;
            }
            int accNo = 0 ;
            switch(usr_Choice){

                case 1:
                    List<Account> pendingAccounts = getPendingAccounts();
                    if(pendingAccounts != null && !pendingAccounts.isEmpty()){
                        boolean isAccNoValid = false ;
                        do{
                            try{
                                pendingAccounts.forEach((account) -> {
                                    account.Display();
                                });
                                System.out.println();
                                System.out.println("Enter account number:");
                                accNo = input.nextInt();
                                isAccNoValid = true ;
                            }catch(Exception e){
                                input.nextLine();
                            }
                        }while(!isAccNoValid);

                        boolean isValid = false ;
                        do{
                            try{

                                System.out.println("Do you want to Approve/Deny selected account request with number is: " + accNo + "? Y/N");
                                char usr_action = input.nextLine().charAt(0);

                                if (usr_action == 'N' || usr_action == 'n'){

                                    isValid = true ;
                                    UpdateAccountRequest(accNo, BankManagementContract.REJECTED_ACCOUNT_STATE);
                                }else if (usr_action == 'Y' || usr_action == 'y'){
                                    isValid = true ;
                                    UpdateAccountRequest(accNo, BankManagementContract.APPROVED_ACCOUNT_STATE);
                                }

                            }catch(Exception e){
                                input.nextLine();
                            }

                        }while(!isValid);
                    }else{
                        System.out.println("There is no Pending Accounts available...");
                    }
                    
                    break;
                case 2:
                    DisplayAll();
                    break;
                case 0:
                    System.out.println("Thanks for using!!!");
                    break;
                default:
                    input.nextLine();
                    System.out.println("Please enter the valid option.");
            }
        }while(usr_Choice != 0);
    }
    
    private void UpdateAccountRequest(int accNo, String status){
        
        boolean isFound = false ;
        for (int i = 0 ; i < customerList.size() && (!isFound); i++){
			
            for (int j = 0 ; ((j < (customerList.get(i).getAccount_List().size())) && (!isFound)); j++){

                if (customerList.get(i).getAccount_List().get(j).getAccountID() == accNo){

                    customerList.get(i).getAccount_List().get(j).setAccState(status);
                    BankingFileIOOperations.UpdateAccountFile();
                    isFound = true ;
                    break ;
                }	
            }	
        }
    }
    
    private List<Account> getPendingAccounts(){
        
        List<Account> pendingAccounts = new ArrayList<>();
        customerList.forEach((cust) -> {
            cust.getAccount_List().stream().filter((account) -> (account.getAccState().equals(BankManagementContract.PENDING_ACCOUNT_STATE))).forEachOrdered((account) -> {
                pendingAccounts.add(account);
            });
        });
        return pendingAccounts;
    }
    
    private void DisplayAll(){

        for (int i = 0 ; i < customerList.size() ; i++ ){

            System.out.println("           Customer_Detail_List                 \n" + 
                       "\n***************************************************************************\n"
              +"ID	Customer_Name        \n"
              +"***************************************************************************\n");

            customerList.get(i).Display();

            if (customerList.get(i).getAccount_List() != null){

                for (int j = 0 ; j < customerList.get(i).getAccount_List().size();j++){

                        customerList.get(i).getAccount_List().get(j).Display();

                }
            }
        }
    }
    
    private CustomerInfo logInUser(){
        
        boolean isValid = false ;
        String userName = "";
        String userPWD = "" ;
        CustomerInfo authenticCustomer = null;
        do{
            System.out.println("Enter Username: ");
            userName = input.nextLine();
            if (userName != null && userName.length() > 0){
                isValid = true ;
            }

        }while(!isValid);

        isValid = false ;

        do{
            System.out.println("Enter Password: ");
            userPWD = input.nextLine();
            if (userPWD != null && userPWD.length() > 0){
                isValid = true ;
            }

        }while(!isValid);
        
        authenticCustomer = FindCustomer(userName, userPWD);
        return authenticCustomer ;
    }
    
    public void createNewCustomer() {

        CustomerInfo cust = new CustomerInfo();
        cust.CreateCustomer(input);
        cust.CreateAccount(input , BankingFileIOOperations.getIDFromFile("Account"));     // passing scanner as argument.......
        BankingFileIOOperations.SaveCustomerInfo(cust);
        customerList.add(cust);   // Adding new customer to the customer list.........
        //input = new Scanner(System.in);
    }
    
    public static List<CustomerInfo> getCustomerInfoList(){
        return customerList;
    }
    
    public CustomerInfo FindCustomer(String userName , String password){

        //System.out.println(userName + "," + password);
        for (int i = 0 ; i < customerList.size(); i++){
            
            char [] custName = customerList.get(i).getCustomerName();
            char [] custPwd = customerList.get(i).getCustomerPassword();
            //System.out.println(String.valueOf(custName) + " " + String.valueOf(custPwd));
            if ((String.valueOf(custName)).trim().equalsIgnoreCase(userName) && (String.valueOf(custPwd)).trim().equals(password)){
                    return customerList.get(i);
            }
        }
        return null ;
    }
}
