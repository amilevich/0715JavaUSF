package q3;
import java.lang.*; 
import java.io.*; 
import java.util.*; 


class StringReversal 
{ 
	public static void main(String[] args) 
	{ 
		//first input is asked from the user
		Scanner s = new Scanner(System.in);
		System.out.println("Enter something to see what it is spelled backwards!");
		//the data input by the user is assigned to a string
		String input = s.nextLine(); 
		//an Array is created to store the string
		char[] hell = input.toCharArray();
		
		//the Array is initialized
		List<Character> derp = new ArrayList<>(); 

		//we add the string to the array
		for (char c: hell) 
			derp.add(c); 
		
		//we reverse the characters
		Collections.reverse(derp); 
		ListIterator li = derp.listIterator(); 
		while (li.hasNext()) 
			//the reverse string is output to the user
			System.out.print(li.next()); 
	} 
} 
