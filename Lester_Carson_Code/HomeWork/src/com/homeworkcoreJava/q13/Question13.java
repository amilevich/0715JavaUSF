package com.homeworkcoreJava.q13;

//Answer to Question 13:
//Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
//0
//1 0
//1 0 1
//0 1 0 1
//Barton Carson
public class Question13 {

	public static void main(String[] args) {
		
		printBinary();

	}
	
	public static void printBinary() {
		
		int n = 4;
		Boolean check = true, check1 = true;
		//print out 0 to start
		StringBuilder line = new StringBuilder("0");
		System.out.println("0");
		
		//Place 1 in front, then at the end, then 0 in front, then 0 at the end, and repeat
        for (int i = 1; i < n; i++) { 
            if(!check && !check1) {
            	line.insert(0, "0");
            	check = !check;
            } else if (check && !check) {
           		line.insert(line.length(), "0");
           		check1 = !check1;
           	} else if (check && check1) {
           		line.insert(0, "1");
           		check = !check;
           	} else if (!check && check1) {
           		line.insert(line.length(),  "1");
           		check1 = !check1;
           	}
            System.out.println(line);
		}	
	}
}