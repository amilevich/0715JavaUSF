package q6;
import java.util.Scanner;
public class EvenInteger {
static int Newresult;
	static void divide() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Number");
	
		int n1=sc.nextInt();
	    Newresult=n1/2; //First divide the user given number by 2.
		
		if(Newresult*2==n1 ) {
			System.out.println("Even Number");//Multiply the result by 2.Check the user input number.if not equal odd number.
		}else 
		{
			System.out.println("Odd Number");
		}
	sc.close();
	}
	public static void main(String[] args) {
		divide();
		
	}
}
