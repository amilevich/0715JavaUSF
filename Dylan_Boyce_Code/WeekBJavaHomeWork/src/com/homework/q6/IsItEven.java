package com.homework.q6;

public class IsItEven {
	
	public static void main(String[] args) {
		
		isEven(24);
		isEven(15);
		
	}
		//line 18, method takes a double data type parameter
		//on line 19, cast the double parameter to int to check for equality 
		//by dividing both by 2. 
		//If the double has a decimal value after being divided,
		//then we prove that it has a remainder and it cannot be 
		//equal to its whole number equivalent
	
	static void isEven(double number) {
		if(number /2 == (int)number/2) {  
			System.out.println(number + " is Even!");
		}else {
			
		System.out.println(number + " is not Even \n"
				+ "because " + number + " divided by 2 "
						+ "gives a number that has a decimal value of "
				+ (number/2));
		}
	}

}
