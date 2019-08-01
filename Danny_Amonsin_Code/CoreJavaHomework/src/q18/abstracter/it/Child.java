package q18.abstracter.it;

/*
 *  1. Check for uppercase chara in a string, and return ‘true’ or ‘false’ depending if any are found.
	2. Convert all of the lower case chara to uppercase in the input string, and return the result.
	3. Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.
 */

public class Child extends Parent //inherits methods from an abstract class so must implement the methods there because this is a concrete class 
{
	@Override
	public boolean isStringUpperCase(String chara) //concrete method for checking for an uppercase character 
	{

		int length = chara.length(); //length variable storing the length the String argument passed into this method

		for (int i = 0; i < length; i++) //loops through each character one by one through the entire length of the String argument passed in 
		{ 
			char character = chara.charAt(i); // we store each character in the "chara" variable
			
			if (Character.isUpperCase(character)) 			// checking for each character that its a Upper-case, if it is, returns true,  
			{												//if no uppercase characters, we return false
				return true;
			}
		}
		return false;
	}

	@Override
	String upperCaseConv(String upper)  //method for changing the String argument passed into to all uppercase, and returns the value after it has become uppercase
	{
		return upper.toUpperCase();
	}

	@Override
	void convertString(String x) //method converts a String that is a number spelled out as a word and converts that String into an integer data type and add 10 it   
	{							//before printing it to the console
		int y = Integer.parseInt(x);
		System.out.println(y + 10);
	}
}
