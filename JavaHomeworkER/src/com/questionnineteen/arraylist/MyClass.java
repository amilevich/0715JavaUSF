package com.questionnineteen.arraylist;

import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {

        ArrayList<Integer> myArr = new ArrayList<Integer>();
        int evenSum = 0;
        int oddSum = 0;


        for (int i = 1; i <= 10; i++) { //creates the array list of 1 through 10
            myArr.add(i);
        }

        System.out.println("Array List 1 through 10: " + myArr); //Prints out the array

        boolean even = true;
        boolean odd = true;

        for (int i = 0; i < myArr.size(); i++) {
            //checks if elements in the array list are even
            int check = isEvenOdd(myArr.get(i));
            if (check == 1) {
                while(even){
                    System.out.print("Even numbers: ");
                    even =false;
                }
                System.out.print(myArr.get(i)+ " ");
                evenSum += myArr.get(i);
            }

        }
        System.out.println(" Even Sum: " + evenSum);

        for (int i = 0; i < myArr.size(); i++) {
            //checks if elements in the array list are odd
            int check = isEvenOdd(myArr.get(i));
            if (check == 0) {
                while(odd){
                    System.out.print("Odd numbers: ");
                    odd =false;
                }
                System.out.print(myArr.get(i)+ " ");
                oddSum += myArr.get(i);
            }
        }
        System.out.println("Odd sum: " + oddSum);

        for (int i = 0; i < myArr.size(); i++) {
            boolean boolPrime = isPrime(myArr.get(i));
            if (!boolPrime) {
            	myArr.remove(i);
            }

        }
        System.out.println("Without prime numbers: " + myArr);

        }

    public static int isEvenOdd(int num) {
        if(num % 2 == 0)
        {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static boolean isPrime(int num) {

    	//This will check for prime numbers
        if(num == 1 || num == 0) return false;

        if(num == 2) return true;


        //check if n is a multiple of 2
        if (num % 2 == 0) return false;

        //if not, then just check the odds
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;

    }


}
