package com.modulus.assignment;

public class Modulus {

	public static void main(String[] args) { //main method nothing more to say
		evenInteger(24);
		evenInteger(25);
		evenInteger(0);
	
		
		
	}
	public static void evenInteger(int number) { //public meaning it is more easily
		//Accessible, static making it apart of the class, and void to signify it has
		// no return value
		int quotient = number/2; //declaring an integer. using the (/) operator to
		//inform the system that it will use division in the operation
		boolean flag = true; // found out (flag) is really handy so decided to stick
		//with it. in this case flag is considered cell-sized due to the boolean data type
		for(int c = 0; c < number; c++) {  //using the for loop again to create a layout 
			//for a loop
			 flag = !flag; //giving flag a new reference name
		}
		if(flag) //flag is like a shapeshifter in java. it can change as you need it to
			//during programming
			System.out.println(number +" is even"); //using the (if) loop to setup
		//if-else declaration
		else {
			
			System.out.println(number + " is odd");
		}		
	}
}
