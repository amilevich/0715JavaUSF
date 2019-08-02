package com.questioneighteen.abstractmethods;
import java.util.Scanner;

public class StringCheck extends MyClass {

	public StringCheck() {
		
}

	@Override
	boolean isUpperCase() {
		String lowerString = input.toLowerCase();
        //this checks if when input characters are lowercase
        boolean lower = lowerString.equals(input);
        
        //if they are equal then myString doesn't have uppercase letters
        if(lower){
            return false;
        }else{
            //if they are not equal then myString did have upper case letters
            return true;
	}
}

	@Override
	String convertToUpperCase() {
		//this converts myString to all uppercase letters
        return input.toUpperCase();
	}

	@Override
		public int convertToInt() {
	        int num = 10;
	        //a string is scanned to add an integer to the string
	        for(int i = 0; i<input.length();i++){
	            num = num + (int)input.charAt(i);
	        }
	        return num;
	}
	
	//Main Driver
	public static void main(String[] args) {
		
		//gets string input from user
		Scanner in = new Scanner(System.in);  
	    System.out.print("Please enter a string: ");  
	    String input = in.nextLine();               
	    in.close();             
	    }  

//	    boolean isUpperCase (String input) {
//	    
//	    {
//	    if(input.contains(null) ){
//	        System.out.println("Does have uppercase letters");
//	    }else{
//	        System.out.println("Does not have uppercase letters");
//	    }
	
	char[] charArray = input.toCharArray();
    
    for(int i=0; i < charArray.length; i++){
        
        //if any character is not in upper case, return false
        if(!Character.isUpperCase(charArray[i] ))
            return false;
    }
    
    return true;
}

	    String toUpper = input.convertToUpperCase();
	    System.out.println("Converted to UpperCase: " + toUpper);

	    int addTen = input.convertToInt();
	    System.out.println(input + " + 10 = " + addTen);


	}

	}
}
