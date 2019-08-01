package question4;
import java.util.Scanner;
class Factorial{ 
	 public static void main(String args[])
	 {  
	  int fact=1;
	  Scanner s = new Scanner(System.in);
	  System.out.println("What's the factorial you want to see?");
	  int number = s.nextInt();
	  s.close();
	  for(int i=1;i<=number;i++){    
	      fact=fact*i;    
	  }    
	  System.out.println("Factorial of "+number+" is: "+fact);    
	 }  
	}  
