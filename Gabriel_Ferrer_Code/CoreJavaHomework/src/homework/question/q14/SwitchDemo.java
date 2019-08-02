package homework.question.q14;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SwitchDemo {
	static double number = 25;
	static Date today = new Date();
	static String str = "I am learning Core Java";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runSwitch(2);
	}

	static void runSwitch(int i) {
		switch (i) {
		case 1:
			System.out.println("The square root of "+ number + " is "+Math.sqrt(number));
			break;
		case 2:
			DateFormat sdf = new SimpleDateFormat("MMMM dd YYYY"); //displays date in Month name day and year
			System.out.println("Today's date is " + sdf.format(today));
			break;
		case 3:
			String[] strArray = str.split(" ");
			System.out.print("[ ");
			for (String string : strArray) {
				System.out.println(string);
			}
			
			System.out.println("]");
			break;
		}
	}

}
