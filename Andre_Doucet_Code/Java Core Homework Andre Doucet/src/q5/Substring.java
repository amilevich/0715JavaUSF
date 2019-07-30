package q5;


public class Substring {
	public static void main(String args[]) {

		// Initializing String 
		String str = new String("Welcome to heck");
		
		//this prints  out only 5 characters from the above string
		System.out.println(Something(str, 5));

	}
	//this is the method that counts through the array and returns only what number is specified in the above sysout
	static String Something(String str, int idx) {
		String str2 = new String("");
		for (int i = 0; i < idx; i++) {
			str2 += (str.charAt(i));
			
		}
		return str2;

	}
}
