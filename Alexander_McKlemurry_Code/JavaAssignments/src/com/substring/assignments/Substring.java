package com.substring.assignments;

public class Substring {
	public static String substring(String str, int idx) { //string to denote the type of 
		//variable and idx so that we can have an index
		String temp="";					//temp name for string
		for(int itr=0; itr < idx; itr++) {		//for loop so that it can be incremented since we are
			//printed out only a certain number of chars
			temp = temp+str.charAt(itr); // we use At(itr) so that the system know where char is at(
			//ie the selection of letters out of the string)
		}
			return temp;		//no void so there must always be a return value
	}

	public static void main(String[] args) {	//main method
		System.out.println(substring("Why am I having such a hard time figuring this out", 5 ));
		//substring in the parenthesis links this line of code to line 4 so that the program
		//can executed properly
	}

}
