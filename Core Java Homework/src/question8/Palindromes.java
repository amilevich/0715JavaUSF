package question8;

import java.util.ArrayList;
import java.util.Arrays;

//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"



public class Palindromes 
{
	public static void main(String[] args)
	{
		String[] names = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> strings = new ArrayList<>();
		strings.addAll(Arrays.asList(names));
		System.out.println("The original list is: ");
		strings.forEach(word ->{System.out.println(word);});
		int len = strings.size();
		ArrayList<String> palindromes = new ArrayList<>();
		for (int i = 0; i<len; i++)
		{
			String reverse = "";
			String word = strings.get(i);   
			int length = word.length();
		      for ( int j = length - 1; j >= 0; j-- ) 
		      {
		         reverse = reverse + word.charAt(j); 
		      }
		      if (word.equals(reverse))  
		      {
		         palindromes.add(word);  
		      }
		}
		System.out.println("");
		System.out.println("The palindrome list is: ");
		palindromes.forEach(word ->{System.out.println(word);});
		
	}
}
