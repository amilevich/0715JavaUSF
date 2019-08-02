package homework.question.q03;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original = "united";
		String reversed = reverse(original);
		
		System.out.println(reversed);
	}
	
	public static String reverse(String original) {
		int strLength = original.length() ;
		String shorterString = original.substring(0, strLength - 1); //take the string without the last character
		String oneChar = original.substring(strLength - 1); // take out the last character
		if (strLength > 1) {  // if string has more than one characters
			return oneChar + reverse(shorterString); //add the last character and call again the reverse method
		} else {
			return oneChar; // this line stops the call to reverse, adds the last character to the string
		}
		
	}

}
