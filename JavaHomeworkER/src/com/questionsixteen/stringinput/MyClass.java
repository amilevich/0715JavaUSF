package com.questionsixteen.stringinput;

public class MyClass {
	
	public static void main(String[] args) {    
        String string = "Tampa is nice";    
        int count = 0;    
            
        //Counts each character except space    
        for(int i = 0; i < string.length(); i++) {    
            if(string.charAt(i) != ' ')    
                count++;    
        }    
            
        //Outputs the total number of characters present in the above string    
        System.out.println("The number of characters in a string is: " + count);    
    }    
}
