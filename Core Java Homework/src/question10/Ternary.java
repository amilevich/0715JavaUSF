package question10;
import java.util.Scanner;

public class Ternary {
	public static void main(String args[])  
	{  
	    // variable declaration 
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a positive integer.");
	    int n1 = s.nextInt();
	    System.out.println("Please enter another positive integer.");
	    int n2 = s.nextInt();
	    System.out.println("Please enter a third positive integer.");
	    int n3 = s.nextInt();
	    int max;  
	    s.close();
// two numbers
//	    // Largest among n1 and n2  
//	    max = (n1 > n2) ? n1 : n2;  
//	      
//	      
//	    System.out.println("Largest number between " + n1 +  
//	                  " and " + n2 + " is " + max + ". " );  
	    max = (n1 > n2) ?  
	            (n1 > n3 ? n1 : n3) :  
	            (n2 > n3 ? n2 : n3); 
	          
	      System.out.println("Largest number among " + n1 +  
	                               ", " + n2 + " and " + n3 +  
	                                   " is " + max + ". " );  
	  }  
} 

