package com.questionseventeen.interest;

import java.util.ArrayList;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {

        ArrayList<String> person = scanForData();

        double rate = Double.parseDouble(person.get(0));
        double principal = Double.parseDouble(person.get(1));
        double time = Integer.parseInt(person.get(2));

        double interest = principal * rate * time;

        System.out.println("Total Interest: $" + interest);

    }

    @SuppressWarnings("resource")
	public static ArrayList<String> scanForData() {
        double interest;
        double principal;
        int numberYears;

        ArrayList<String> person = new ArrayList<>();

        //Input for interest by user and checks for user errors
        Scanner one = new Scanner(System.in);
        System.out.println("Enter your Rate of Interest:" );
        while (true) {
            try {
                interest = Double.parseDouble(one.next());
                break; //Will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input, please enter numeric value");
            }
        }
        String interestString = Double.toString(interest);
        person.add(interestString);// Allows a person to enter rate of interest


        //Input for principal by user and checks for user errors
        Scanner two = new Scanner(System.in);
        System.out.println("Enter your principal:" );
        while (true) {
            try {
                principal = Double.parseDouble(two.next());
                break; //Will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input, please enter numeric value");
            }
        }
        //Convert account number integer to string to convert to store in person string array
        String principalString = Double.toString(principal);
        person.add(principalString);



        //Input for number of years by user and checks for user errors
        Scanner three = new Scanner(System.in);
        System.out.println("Enter the number of years:" );
        while (true) {
        	try {
                numberYears = Integer.parseInt(three.next());
                break; //Will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input, please numeric value");
            }
        }

        String yearString = Integer.toString(numberYears);

        person.add(yearString);

                return person;
    }

}

