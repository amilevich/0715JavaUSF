package homework.question.q05;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "jfdytykgfrdfjgh";
		String substr = subString(str,5); // calling own implementation
		System.out.println(substr); 
		System.out.println( str.substring(0, 5)); // calling String substring api
	}
	
	static String subString(String str, Integer size) {
		char[] chars = str.toCharArray(); // converts string to char array
		String result = "";
		
		
		for (int j = 0; j < size; j++) {
			result += chars[j]; // loops from zero to size minus one
		}
		return result; // return the substring of string
	}
}
