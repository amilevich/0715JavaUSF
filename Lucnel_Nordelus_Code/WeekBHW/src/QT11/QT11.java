package QT11;


/*
 * Write a program that would access two float-variables from a 
 * class that exists in another package. Note, you will need to 
 * create two packages to demonstrate the solution.
 * package. Note, you will need to create two packages to 
 * demonstrate the solution. 
 * 
 */

// import 
import Float1.Float1;
import Float2.Float2;

public class QT11 {

	public static void main(String[] args) {
		

		//set finnum equal to the sum of fnum5 and fnum2; 
		float finnum = Float2.fnum5 + Float1.fnum2;
		
		System.out.println(Float2.fnum5);
		System.out.println(Float1.fnum2);
		
		System.out.println("New Float Number : " + finnum);
		

	}

}
