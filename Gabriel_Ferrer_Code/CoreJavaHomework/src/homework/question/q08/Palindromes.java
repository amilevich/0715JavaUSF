package homework.question.q08;

import java.util.ArrayList;
import java.util.Arrays;

import homework.question.q03.*; // importing reverse function from question 3

public class Palindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] string = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<String> palindromes = new ArrayList<>();
		
		strings.addAll(Arrays.asList(string)); // adds all array items to ArrayList
		
		palindromes = palindromizer(strings);
		System.out.println("All Strings: " + strings);
		System.out.println("Palindromes: " + palindromes);
	}
	
	public static ArrayList<String> palindromizer(ArrayList<String> strings) {
		ArrayList<String> palindromes = new ArrayList<>();
		
		for (String string : strings) { 
			if ( string.compareTo( ReverseString.reverse(string) ) == 0) { // uses the reverse method from q03 to compare 
																		   // original and reversed string if both are equal
				                                                           // they are palindromes
				palindromes.add( string );
			}
		}
		
		return palindromes;
	}
	
}
