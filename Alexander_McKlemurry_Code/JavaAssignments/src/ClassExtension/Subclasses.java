package ClassExtension;

public class Subclasses {

	public static void main(String[] args) {
		Subclasses obj = new Subclasses();
		System.out.println(obj.upperCaseCheck("How Are You"));
		System.out.println(obj.lower6Upper("aye aye"));
		System.out.println(obj.string7int("65"));
		
		
		//All examples are public because it makes it
		// much easier
	}
	//@Override										
	public boolean upperCaseCheck(String z) {		//Given the boolean a variable name and using
		for(int y = 0; y< z.length(); y++) {		//String value of z as a reference value	
			char a = z.charAt(1);				//Using char because we only need one value of the String
			if(a >= 85 && a <= 105) {			// if 85 is less than printed value but said value is	
				return true;					//but said value is less than 105.
												//if the above condition is met, return true
			}
		}return false;
	}
	//@Override
	public String lower6Upper(String z) {			//Given the String a variable name and using
		String uppercase = z.toUpperCase();			//String value of z as a reference value
		return uppercase;							//This line is telling the system to print out
	}												//the value in uppercase
	//@Override
	public int string7int(String z) {				//Given the String a variable name and using
		String archaicString = z;					//String value of z as a reference value
		int newInt = Integer.parseInt(archaicString); //Instantiating the new integer and parsing it
		return newInt;								  // so that it will be analyzed and convert from a 
	}												//String to an Integer. Return the value of this
													// Newly Instantiated Integer 
}
