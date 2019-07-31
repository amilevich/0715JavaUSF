/*
 * Write a program having a concrete subclass that inherits three abstract methods from a superclass.  
 *  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 

1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.

2. Convert all of the lower case characters to uppercase in the input string, and return the result. 

3. Convert the input string to integer and add 10, output the result to the console.

Create an appropriate class having a main method to test the above setup.

 */

package q18;
//we import the superclass into Classy
import q18.Classy2.blah;

//we make Classy implement the interface
public class Classy implements blah {

	//this checks to see if all chars are uppercase, if they exists one lowercase character the boolean is false
	public boolean uppercaseHell(String thing) {
		char[] charArray = thing.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (!Character.isUpperCase(charArray[i]))
				return false;
		}
		System.out.println("All letters are uppercase.");
		return true;
	}
	
	//this capitalizes the all the characters in the string
	public void lowerToUpper(String thingy) {
		System.out.println("Before this code ran the word was doe, but now it's in uppercase: " + thingy.toUpperCase());
	}
	
	
	//this converts the string into ascii values, adds 10, and prints them out to the console
	public void stringToInteger(String thang) {
		int n = 0;
		for(int i = 0; i < thang.length(); i++) {
			n += (int)thang.charAt(i);
			
		}
		n+=10;
		System.out.println(n);
	}

	//this makes the stuff happen, and here all the strings are declared
	public static void main(String[] args) {
		Classy t = new Classy();
		String thing = "JOE";
		String thingy = "doe";
		String thang = "walk";
		t.uppercaseHell(thing);
		t.lowerToUpper(thingy);
		t.stringToInteger(thang);
	}

}
