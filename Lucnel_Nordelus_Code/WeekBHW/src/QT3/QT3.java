package QT3;

public class QT3 {
	/*
	 * Reverse a string without using a temporary variable. Do NOT use reverse() in
	 * the StringBuffer or the StringBuilder APIs.
	 */
	public static void main(String[] args) {
		// set string c  to "Cat"
		String c = "Cat";
		for (int i = 0; i < c.length(); i++) { // grabs the substring of cat and moves the charto the end
			c = c.substring(1, c.length() - i) 
					+ c.substring(0, 1) 
			+ c.substring(c.length() - i, c.length());

			System.out.println(c);

		}
	}
}
