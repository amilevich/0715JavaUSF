package com.question18.concretesubclass;

//Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass.  
//Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 
//
//1) Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
//2) Convert all of the lower case characters to uppercase in the input string, and return the result. 
//3) Convert the input string to integer and add 10, output the result to the console.
//4) Create an appropriate class having a main method to test the above setup.




//creating subclass
class TooEasyWork extends EasyWorkParent {

	// Method to check each character and determine whether they are uppercase or
	// not.
	@Override
	public boolean upperCaseCheck(String x) {

		String str = x;

//implementing an enhanced for loop to convert string to character array
		for (char c : str.toCharArray()) {
			
			//Check if character is uppercase
			if (Character.isUpperCase(c))
				return true;
		}
		return false;
	}

	@Override
	//Method that changes all lowercase characters to uppercase
	public String conversion(String y) {
		return y.toUpperCase();
	}
	@Override
	//Method that converts a string input to an integer and adds 10 to it.
	public int toInteger(String w) {
		
		int w1 = w.length() + 10;
		return w1;
		
	}

}
