package com.homework14.impswtch;


	
	 
	
	
	

	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
	import java.util.ListIterator;
	import java.util.Scanner;

	public class Swtch {
		
		static void printString(ArrayList<String> arr) {
			
			ListIterator<String> iterato = arr.listIterator();
			while(iterato.hasNext()) {
				System.out.print(iterato.next() + " ");
			}
			System.out.println("");
			
		}

		public static void main(String[] args) {
			//To create program with three cases
			Scanner scn = new Scanner(System.in);	
			System.out.println("1 -> Find the square root of a number using the Math class method.");
			System.out.println("2 -> Display today’s date.");
			System.out.println("3 -> Split the following string and store it in a string array. 	");
			System.out.println("Enter the option:");
			int option = scn.nextInt();
			
			switch(option) {
				case 1: System.out.println("Enter the number: ");
						int number = scn.nextInt();
						if(number >= 0) {
							System.out.println(Math.sqrt(number));//one, to find the square root of number
						}else {
							System.out.println("Number can't be negative");
						}
					    break;
				case 2: //DateFormat format = new SimpleDateFormat("mm/dd/yyyy");
						LocalDate date = LocalDate.now();//two, To display todays date
						System.out.println("Today is: " + DateTimeFormatter.ofPattern("yyy/MM/dd").format(date));
					    break;
				case 3: String stg = "I am learning Core Java” Find the square root of a number using the Math class method.";
						int n = (stg.length() - 1) / 2;
						ArrayList<String> arr1 = new ArrayList<>();
						ArrayList<String> arr2 = new ArrayList<>();
						//Split first ArraList
						for(int i = 0; i <= n; i++) {
							String s = new String();
							s += stg.charAt(i);
							arr1.add(s);
							s = "";
						}
						
						//Split Second ArrayList
						for(int i = n+1; i < stg.length(); i++) {
							String s = new String();
							s += stg.charAt(i);
							arr2.add(s);
							s = "";
						}//three, to split the "I am learning coreJava" and store in string array
						System.out.println("Firsst split");
						printString(arr1);
						System.out.println("Second split");
						printString(arr2);
						
					    break;
				default: System.out.println("There is not this option");
					    break;	
			}
			
			scn.close();

		}

	}
