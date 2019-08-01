package q5.substringer;

public class Subs 
{
	/* Write a substring method that accepts a string str and an integer idx and returns 
	 * the substring contained between 0 and idx-1 inclusive. e.g 0 <= 5-1, so print should be from 0 to 4 
	 */
	static int idx; //integer idx declared, static so we can directly call this variable
	static String newString = ""; //empty String container for substring return
	
	static String subStringIt(String str, int idx) //method for returning substring of a String it takes in and takes in a integer idx
	{
	int i; //i declared for use as counter in for loop and charAt printing each character
		int x = idx-1; //idx value minus 1
		
//		for(i=0; i<=x;i++)  //for seeing the indexes that have been printed 
//		{
//		System.out.print("index " + i);		
//		}
		for(i=0; i<=x;i++) //for loop starts at the 0 character index and will print until idx value minus 1, inclusive
		{						
			newString += str.charAt(i); //using newString container to store char values until substring idx value minus 1
		}
		
		System.out.println(newString); //for visual purpose of seeing what is being returned
		return newString; //substring is now returned
		
		
		
	}
	
	public static void main(String[] args) 
	{
		int o = 5; //idx start value
		String n = "I am Groot"; //String argument for method
		subStringIt(n, o); //method call for substring return
		
	}
	
}
