//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

package q8;

import java.util.ArrayList;
import java.util.ListIterator;

public class PallindromeHeck {

	//The first arraylist is declared
	public static void main(String[] args) {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("karan");
		alist.add("madam");
		alist.add("tom");
		alist.add("civic");
		alist.add("radar");
		alist.add("sexes");
		alist.add("jimmy");
		alist.add("kayak");
		alist.add("john");
		alist.add("refer");
		alist.add("billy");
		alist.add("did");
		
		//this prints out the original list
		System.out.println(alist);
		
		//this is the list to put only the pallindromes inside of
		ArrayList<String> pallinlist = new ArrayList<String>();
		//a list iterator is created that looks at the ArrayList and returns only the pallindromes, and in the order they were found in the original ArrayList
		ListIterator<String> striter = alist.listIterator();
		while (striter.hasNext()) {
			String b = striter.next();
			String c = new String();
			char t;
			
			
			//this determines what exactly is a pallindrome within the original ArrayList
			for(int i = b.length() -1; i >= 0; i--)
			{	
				t = b.charAt(i);
				c += t;
			}			
			//this adds the pallindromes to the pallindrome list
			if (b.equals(c)) {
				pallinlist.add(c);
				//System.out.println(pallinlist);
				
			}
			
			
			
		//this prints out the pallindromelist	
		}for (String d: pallinlist) {
			System.out.print(d + " ");
		}
		
			
		
		
//		
//		for( int i = 0; i<input.length(); i++) {
//			if(input.charAt(i) == input.charAt(input.length()-1)) {
//				System.out.println("The string is somethang awright...");
//			} else {
//					System.out.println("The string ain't no palindrome.");
//				}
//		
//		
//		
	}

	
}
