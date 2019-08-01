package q3.string.reversal;

public class Reverse {
	static String x = "I am Groot"; //String variable
	
	static void count(String n) //reverse String method
	{
		int length = n.length(); //counts length of string
		
		int i; //i variable declaration as an integer
		System.out.print("Reversed: "); //print statement
		for(i = length-1;  i >= 0; i--) //for loop so we can use any string, with any number of characters, with i = length minus 1 since loop count starts at 0 for first character, then loops for each character in total string length, since we are starting at last character, we decrement till we reach the 1st character index 
		{
		System.out.print(n.charAt(i)); //this prints out each character of the string at each index starting from the last index thus reversing the string
		}								//charAt method from interface CharSequeunce, not part of the StringBuilder or StringBuffer classes  	
	}
	public static void main(String[] args) {
		System.out.println("Not reversed: " + x); //print statement of String before reversal
		count(x); //reversal of String statement
	}
}