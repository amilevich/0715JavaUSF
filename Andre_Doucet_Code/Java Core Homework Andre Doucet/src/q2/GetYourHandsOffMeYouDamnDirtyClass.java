package q2;
import java.util.Scanner;

public class GetYourHandsOffMeYouDamnDirtyClass  {
		public static void main(String[] args) {
				//this asks the user how many numbers into the Fibonacci they desire to see
			   Scanner input = new Scanner(System.in);
			  //this is the solicitation for input text
			   System.out.println("Enter a how many numbers you wish to see in the Fibonacci sequence: ");
			   
			   int num = input.nextInt();
			   //this keeps the code running until the number equals 1
			   for(int i = 1; i <= num; i++){
				   //this outputs the numbers
			      System.out.print(printFibonacci(i) + " ");
			   }
			   input.close();
			 }
			 
			 
			 // recursion function
			 private static int printFibonacci(int CurrentNumber){
			  //this code is a condition statement that ends the recursion once the value is at 1 or 2.
			  if(CurrentNumber == 1 || CurrentNumber == 2){
			   return 1;
			  }
			  //this makes the code keep printing numbers until it hits the values of 1 or 2.
			  return printFibonacci(CurrentNumber - 1) + printFibonacci(CurrentNumber - 2);
			 }

	}


