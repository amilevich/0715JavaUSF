package Main;

import java.util.Scanner;

import Model.BankManagement;

public class main {
    
    
    public static void main(String[] args) {
        
        displayMainHomeMenu();
    }
    
    private static void displayMainHomeMenu(){
        
       boolean isCorrect = false ;
			
       int usr_Choice ;
       Scanner input = new Scanner(System.in) ; 
        
       do {

                System.out.println("Choose Option:" + "\n\t 1- Press 1 for Customer Uses."
                                    +"\n\t 2- Press 2 for Employees Uses." 
                                            +"\n\t 3- Press 3 for Admin Uses."
                                            +"\n\t 4- Press 0 to exit the application\nEnter Your Choice");

                try{
                    usr_Choice = input.nextInt();
                }catch(Exception e){
                    usr_Choice = Integer.MAX_VALUE;
                }

                switch(usr_Choice){
                    
                case 1:
                        input.nextLine();
                        BankManagement customerbnk = new BankManagement();
                        customerbnk.introduction();
                        customerbnk.CustomerMenu();
                        //System.out.println("You have successfully Update the Customer information.");
                        break ;

                case 2:
                        input.nextLine();
                        BankManagement employeesbnk = new BankManagement();
                        employeesbnk.introduction();
                        employeesbnk.EmployeeMenu();
                        //System.out.println("You have successfully Update the Customer information.");
                        break ;

                case 3:				
                        input.nextLine();
                        BankManagement adminbnk = new BankManagement();
                        adminbnk.introduction();
                        adminbnk.AdminMenu();
                        //System.out.println("You have successfully Update the Customer information.");
                        break ;

                case 0:

                        isCorrect = true ;
                        System.out.println("Thank You for using. Good Bye!!!");

                        break;

                default :
                        input.nextLine();
                        System.out.println("Please Enter the valid option.");

                }

        }while(!isCorrect);
    }
}
