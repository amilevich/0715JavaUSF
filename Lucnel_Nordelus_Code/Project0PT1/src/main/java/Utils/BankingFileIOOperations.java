package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Account;
import Model.BankManagement;
import Model.BasicAccount;
import Model.CurrentAccount;
import Model.CustomerInfo;
import Model.SavingAccount;
import Utils.BankManagementContract;


public class BankingFileIOOperations {

    private static File inputFile ;
    private static FileWriter inputFileWriter ;
    private static boolean isFileOpen  ;
    private static Scanner input ;
    
    public BankingFileIOOperations(){
        
        inputFile = null ;
        inputFileWriter = null ;
        isFileOpen = false ;
    }
    
    public static char [] ReadingFile(){

            char [] data = null ;
            FileReader reader = null ;

            try {
                    if (inputFile.exists()){

                            if (((int) inputFile.length()) != 0){

                                    data = new char[(int)inputFile.length()] ;
                                    reader = new FileReader(inputFile);
                                    reader.read(data);
                                    reader.close();
                            }
                    }
            } 

            catch (FileNotFoundException e) {

                    System.out.println(e+" Exception occur that file not found.");
                    //e.printStackTrace();
            } catch (IOException e) {
                    System.out.println(e+" Exception occur in reading file data.");
                    //e.printStackTrace();
            }

            return data ;
    }
    
    public static void SaveToList(CustomerInfo customer , String [] Attributes , char type , int index){

            Date adate = StringToDate(Attributes[3] , "AccountDate");
            Double balance = Double.parseDouble(Attributes[4]);
            //System.out.println(balance);
            if (type == 'b' || type == 'B' ){

                    Account basic = new BasicAccount(Attributes[1].toCharArray() , Double.parseDouble(Attributes[4])  , type);
                    basic.setAccountID(Integer.parseInt(Attributes[0]));
                    basic.setAccUserPassword(Attributes[6].toCharArray());
                    basic.setCurrentBalance(balance);
                    basic.setDate(adate);
                    basic.setAccState(Attributes[5]);
                    customer.getAccount_List().add(basic);
            }
            else if (type == 'S' || type == 's'){

                    Account saving = new SavingAccount(Attributes[1].toCharArray(), Double.parseDouble(Attributes[4])  , type);
                    saving.setAccountID(Integer.parseInt(Attributes[0]));
                    saving.setCurrentBalance(balance);
                    saving.setDate( adate);
                    saving.setAccState(Attributes[5]);
                    customer.getAccount_List().add(saving);
            }
            else {

                    Account current = new CurrentAccount(Attributes[1].toCharArray() , Double.parseDouble(Attributes[4])  , type);
                    current.setAccountID(Integer.parseInt(Attributes[0]));
                    current.setCurrentBalance(balance);
                    current.setDate(adate);
                    current.setAccState(Attributes[5]);
                    customer.getAccount_List().add(current);
            }
    }

    public static List<CustomerInfo> LoadData(){

        List<CustomerInfo> customerList = new ArrayList<>();
        MakeCustomerFile();

        char [] data = ReadingFile();
        String [] custData = null ;
        String [] Attributes = null ;

        if (data != null){

                custData = String.valueOf(data).split("\n");

                for (int i = 0 ; i < custData.length ; i++ ){

                        CustomerInfo temp_New_Customer = new CustomerInfo();

                        Attributes = custData[i].split(",");

                        temp_New_Customer.setCustomerID(Integer.parseInt(Attributes[0]));
                        temp_New_Customer.setCustomerName(Attributes[1].toCharArray());
                        temp_New_Customer.setCustomerPassword(Attributes[2].toCharArray());
                        // Adding already existing customer to the customer list......
                        customerList.add(temp_New_Customer);  
                }
        }

        else {

                System.out.println("Currently no cutomer record found.");
        }

        if (!(customerList.isEmpty()) && customerList.size() > 2){

                MakeAccountFile();

                data = ReadingFile();

                if (data != null){

                    custData = String.valueOf(data).split("\n");

                    boolean customerFound = false ;

                    for (int i = 0 ; i < custData.length ; i++){

                        Attributes = custData[i].split(",");

                        customerFound = false ;

                        char type = Attributes[2].charAt(0);

                        for (int j = 0 ; ( (j < customerList.size()) && (!customerFound) ) ; j++ ){
                            
                            if ((customerList.get(j).getCustomerID()) == (Integer.parseInt(Attributes[7].trim())) ){

                                SaveToList(customerList.get(j) , Attributes , type , j);
                                customerFound = true ;
                            }
                        }	   
                    }			
                }

                else{
                    System.out.println("No customer account record found.");
                }
        }
        
        return customerList ;
    }
    
    public static void SaveCustomerInfo(CustomerInfo customer){

        try {	

            MakeCustomerFile();    // Making the object for customer database......

            int id = getIDFromFile("Customer");

            if (inputFile.length() != 0){

                    customer.setCustomerID(++id);
                    OpenDataBaseFile();
                try {
                    inputFileWriter.write(customer.getString(true).toCharArray());
                } catch (IOException ex) {
                    Logger.getLogger(BankingFileIOOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println("New customer record has been saved successfully with id = " + id );
            }

            else{

                    OpenDataBaseFile();      // Opening database file in writing mode.....
                try {
                    inputFileWriter.write(customer.getString(false).toCharArray());
                } catch (IOException ex) {
                    Logger.getLogger(BankingFileIOOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println("New customer record has been saved successfully with id = " + customer.getCustomerID());
            }
            
            CloseDataBaseFile(inputFileWriter);
            
            MakeAccountFile();
            OpenDataBaseFile();
            ArrayList<Account> temp_List = customer.getAccount_List();
            
            for(int i = 0 ; i < temp_List.size(); i++){
                
                try {
                    if (i == 0){
                        inputFileWriter.write(getAccountAttributes(temp_List.get(i) , "New" , false) + "," + String.valueOf(temp_List.get(i).getAccUserPassword()) + "," + customer.getCustomerID());
                    }else{
                        inputFileWriter.write(getAccountAttributes(temp_List.get(i) , "New" , true) + "," + String.valueOf(temp_List.get(i).getAccUserPassword()) + "," + customer.getCustomerID());
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(BankingFileIOOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        }finally{
            CloseDataBaseFile(inputFileWriter);
            isFileOpen = false;
        }
    }
    
    public static void UpdateAccountFile(){
		
        if (isFileOpen){
            
            CloseDataBaseFile(inputFileWriter);
            isFileOpen = false ;
        }

        MakeAccountFile();

        int size = 0 ;
        int cust_id = 0 ;

        try {

            inputFileWriter = new FileWriter(inputFile);
            //isFileOpen = true ;
            String identifier = "Old";
            List<CustomerInfo> customerList = BankManagement.getCustomerInfoList();

            for (int i = 0 ; i < customerList.size(); i++){

                // Total Customer Accounts...
                size = customerList.get(i).getAccount_List().size() ;

                if (size > 0){

                    cust_id = customerList.get(i).getCustomerID();

                    for (int j = 0 ; j < size; j++){

                        if (i == 0){

                                inputFileWriter.write(getAccountAttributes(customerList.get(i).getAccount_List().get(j) 
                                                              , identifier , false) + "," 
                                                     + String.valueOf(customerList.get(i).getAccount_List().get(j).getAccUserPassword())  
                                                     + "," + cust_id);
                        }

                        else if (i != 0){

                                inputFileWriter.write(getAccountAttributes(customerList.get(i).getAccount_List().get(j) 
                                      , identifier , true) + "," 
                             + String.valueOf(customerList.get(i).getAccount_List().get(j).getAccUserPassword())  
                             + "," + cust_id);
                        }
                        identifier = "repeat";
                    }
                }
            }
        } 
        catch (IOException e) {
                System.out.println(e+" Exception occur in saving customer updating account data.");
                //e.printStackTrace();
        }

        finally{

                try {
                        inputFileWriter.close();
                } catch (IOException e) {

                        System.out.println(e+" Exception occur in closing accounts database file.");
                        //e.printStackTrace();
                }
        }		
    }
    
    public static String getAccountAttributes(Account account , String isNew , boolean isAppend){
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        int id = account.getAccountID();

        if (isNew.equals("Old") || !isAppend){

                return id + "," + String.valueOf(account.getAccountHolder()) + "," 
                              + account.getType() + "," + formatter.format(account.getDate()) + "," 
                              + account.getCurrentBalance()+","+account.getAccState();
        }

        if (isNew.equals("repeat")){

                return "\r\n" + id + "," + String.valueOf(account.getAccountHolder()) + "," 
                              + account.getType() + "," + formatter.format(account.getDate()) + "," 
                              + account.getCurrentBalance()+","+account.getAccState();

        }
        return "\r\n" + id + "," + String.valueOf(account.getAccountHolder()) + "," 
                      + account.getType() + ","   + formatter.format(account.getDate())  + ","  
                      + account.getCurrentBalance()+","+account.getAccState();
    }
    
    public static void MakeWithdrawLog(Account acc , Double balance , Double WithdrawalAmount){

            if (isFileOpen){

                    CloseDataBaseFile(inputFileWriter);
                    isFileOpen = false ;
            }

            inputFile = new File(BankManagementContract.WL_FILE_PATH);

            try {

                    inputFileWriter = new FileWriter(inputFile , true);

                    Date currentDate = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

                    char [] logData = (acc.getAccountID() + "," + balance  + "," + formatter.format(currentDate) 
                                       + "," +  acc.getCurrentBalance() + "," + WithdrawalAmount).toCharArray();

                    if (inputFile.length() != 0){

                            String s = "\r\n" + String.valueOf(logData);
                            logData = s.toCharArray();
                            inputFileWriter.write(logData);
                    }
                    else {
                            inputFileWriter.write(logData);
                    }


            } 
            catch (IOException e) {
                    System.out.println(e+" Exception occur that: Error during writing into withdraw Log file.");
                    //e.printStackTrace();
            }

            finally{

                    if (inputFileWriter != null){

                            try {
                                    inputFileWriter.close();
                            } catch (IOException e) {
                                    System.out.println(e+" Exception occur that: Error in closing withdraw Log file.");
                                    //e.printStackTrace();
                            }
                    }
            }	
    }

    public static Double GetWithdrawBalance(int accNo){

        Double totalWithdraw = 0.0 ;

        if (isFileOpen){

                CloseDataBaseFile(inputFileWriter);
                isFileOpen = false ;
        }

        inputFile = new File(BankManagementContract.WL_FILE_PATH);

        if(inputFile.exists()){

                try {

                        input = new Scanner(inputFile);
                        String data = " ";
                        String [] Values = null;

                        while(input.hasNext()){

                                data = input.nextLine();

                                 Values = data.split(",");

                                 if (Integer.parseInt(Values[0]) == accNo){

                                         Long numDays = Converter(StringToDate(Values[2].trim() , "AccountDate") , "days");

                                         if (numDays <= 1){

                                                 totalWithdraw += Double.parseDouble(Values[4]);
                                         }  
                                 }
                        }
                }
                catch(FileNotFoundException e){

                        System.out.println(e+" Excep occur that: " + e);
                        //e.printStackTrace();
                }
        }
        return totalWithdraw ;
    }
    
    public static Long Converter(Date adate , String convert){

            Long retNumber = 0L ;

            //System.out.println("Adate: " + adate);

            Date currentDate = new Date();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            try{

                    String newDate = formatter.format(currentDate);
                    currentDate = formatter.parse(newDate);
                    //System.out.println("Current Date = " + currentDate);

            }
            catch(ParseException e){

                    System.out.println(e + "Exception occur that Error: in parsing system date.");
                    //e.printStackTrace();

            }

            Long dateDiffMillis = currentDate.getTime() - adate.getTime();

            if (convert.equals("days")){

                    retNumber = (dateDiffMillis / (24 * 60 * 60 * 1000));  // Get number of days...........
            }

            else if (convert.equals("Hours")){

                    retNumber = ((dateDiffMillis / (60 * 60 * 1000)) );  // Get number of hours...............
            }

            else if (convert.equals("Minutes")){

                    retNumber = ((dateDiffMillis / (60 * 1000)) % 60);    // Get number of minutes...................
            }

            return retNumber ;

    }
    
    public static Date StringToDate(String date , String whichDate){

            Date retDate = null ;

            SimpleDateFormat formatter = null ;
            if (whichDate.equals("AccountDate")){

                    try{

                            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            retDate = formatter.parse(date);
                    }
                    catch(ParseException e){

                            System.out.println(e+" Exception occur that error in parsing string into date data type." + date);
                            //e.printStackTrace();

                    }
            }
            return retDate ;
    }
    
    public static int getIDFromFile(String fileName){
		
        int id = 0 ;

        try{
            
            if (fileName.equals("Customer")){
                MakeCustomerFile();
                OpenDataBaseFile();
            }else{
                MakeAccountFile();
                OpenDataBaseFile();
            }

            if (inputFile.exists()){

                input = new Scanner(inputFile);

                String lastLine = " ";

                if (input.hasNext()){

                        while(input.hasNextLine()){

                                lastLine = input.nextLine();
                        }

                        StringTokenizer tokenize = new StringTokenizer(lastLine , ",");

                        // Parsing into integer we cannot do casting........
                        id = Integer.parseInt(tokenize.nextElement().toString());
                }
            }
        }
        catch(FileNotFoundException e){

                System.out.println(e +" Exception occur in scanning the file");
                //e.printStackTrace();
        }finally{
            
        }

        return id ;
		
    }
    
    public static void MakeCustomerFile(){

            // Object for customer database file.......
            inputFile = new File(BankManagementContract.CUSTOMER_FILE_PATH);

    }

    public static void MakeAccountFile(){

            // Object for customer database file.......
            inputFile = new File(BankManagementContract.ACCOUNT_FILE_PATH);

    }
	
    public static void OpenDataBaseFile(){

            try{

                    inputFileWriter = new FileWriter(inputFile , true);
                    isFileOpen = true ;

            }
            catch(IOException ex){

                    System.out.println(ex + " Exception occur in opening database file.");
                    //ex.printStackTrace();

            }

    }

    public static void CloseDataBaseFile(FileWriter fw){

            try{

                if (fw != null){
                    fw.close();
                    isFileOpen = false ;
                }
                    
            }
            catch(IOException ex){

                    System.out.println(ex + " Exception occer in closing database file.");
                    //ex.printStackTrace();

            }
    }
}
