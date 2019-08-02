package q8;

import java.util.ArrayList;

public class Palindrome {
	static String original;
	static String reverse = "";

	static void checkPalindrome() {

		ArrayList<String> emp = new ArrayList<>();
		emp.add("Karan");
		emp.add("madam");
		emp.add("tom");
		emp.add("civic");
		emp.add("radar");
		emp.add("sexes");
		emp.add("Jimmy");
		emp.add("Kayak");
		emp.add("John");
		emp.add("refer");
		emp.add("billy");
		emp.add("did");
		
		ArrayList<String> revEmp = new ArrayList<>();
		for (int i = 0; i < emp.size(); i++) {
			original = emp.get(i);
			
			
			for (int a = original.length() - 1; a >= 0; a--) {

				reverse = reverse + original.charAt(a);

			}
			
			if (original.equals(reverse)) {
				
				revEmp.add(reverse);
			} else {
				
			}
			reverse = "";

		}
		
		System.out.println("The words from original Array :");
		System.out.println(emp);
		System.out.println();
		System.out.println("The words of Palindrome array :");
		System.out.println(revEmp);
	}

	public static void main(String[] args) {
		checkPalindrome();

	}
}
