package q8.array.list;

import java.util.ArrayList;

public class MainDriver {

	//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	
	static int n; //declared variable counter for for loop, static for calling directly in class
	
	public static void main(String[] args) 
	{
		ArrayList<String> list1 = new ArrayList<>(); //ArrayList 1 for storing initial Strings
		ArrayList<String> list2 = new ArrayList<>(); //ArrayList 2 for storing Strings that are palindromes only
		
		list1.add("karan"); //adding strings to ArrayList 1
		list1.add("madam");
		list1.add("tom");
		list1.add("civic");
		list1.add("radar");
		list1.add("sexes");
		list1.add("jimmy");
		list1.add("kayak");
		list1.add("john");
		list1.add("refer");
		list1.add("billy");
		list1.add("did");
		
		System.out.println(list1); //prints out all Strings contained in ArrayList 1 
		
		for(n=0; n <= list1.size()-1; n++ ) //loops through all of ArrayList 1 by index starting from index 0
		{
			String o = list1.get(n); //declaring variable "o" as a String container for each time we get a String value from ArrayList 
			
			String reverse = "";  //empty String variable "reverse" for storing new String that as been reversed
			for ( int i = o.length() - 1; i >= 0; i-- )   //loops thru entire String pulled from ArrayList
			 {
		         reverse = reverse + o.charAt(i); //stores reversed String in variable "reverse"
			 }
			
			if (o.equals(reverse))    	 //checks if initial String checked is the same as the reversed String, 
			  {							//if so, that means that the String is a palindrome, and adds that String to ArrayList 2
				list2.add(o);
			  }	
		}
		
		System.out.println(list2); //prints out ArrayList 2 of only palindrome Strings 
	}

}
