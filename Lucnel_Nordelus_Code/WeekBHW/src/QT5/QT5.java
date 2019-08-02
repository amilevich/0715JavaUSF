package QT5;

public class QT5 {
	/*
	 * Write a substring method that accepts a string str and an integer idx and
	 * returns the substring contained between 0 and idx-1 inclusive. Do NOT use any
	 * of the existing substring methods in the String, StringBuilder, or
	 * StringBuffer APIs.
	 * 
	 */
	public static void main(String[] args) {

		System.out.println(substring("HelloWorld", 4));

	}
	// grabs the substring char between 0 and 3 
	private static String substring(String str, int idx) {
		String temp = "";
		for (int i = 0; i < idx; i++) {
			temp += str.charAt(i);
		}
					
		return temp;
	}

}
