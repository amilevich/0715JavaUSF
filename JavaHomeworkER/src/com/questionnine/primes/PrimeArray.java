package com.questionnine.primes;

import java.util.ArrayList;

public class PrimeArray {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<Integer>();
        ArrayList<Integer> myPrimes = new ArrayList<Integer>();
        ArrayList<Integer> notPrime = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            myList.add(i);
        }

        for (int primes : myList) {

            //boolean to check if it is a prime number
            boolean boolPrime = isPrime(primes);

            //if it is a prime number
            if (boolPrime) {          
                myPrimes.add(primes);
            } else {
                notPrime.add(primes);
            }
        }

        //print out the list to the console
        System.out.println("Not Prime Numbers in the ArrayList: ");
        System.out.println(notPrime);

        System.out.println("Prime Numbers in the ArrayList: ");
        System.out.print(myPrimes);

    }


    public static boolean isPrime(int num) {

        if(num == 1 || num == 0) return false;
        if(num == 2) return true;


        //check if the number is a multiple of 2
        if (num % 2 == 0) return false;

        //if not, then check the odds
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;

    }
}

