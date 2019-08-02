package com.questionten.ternary;

public class MinTwo {
	public static void main(String[] args) {

        int x = 8;
        int y = 21;
        System.out.print("The minimum number of "+x+" and "+y+" is: ");
        int minNum = (x < y) ? x : y;
        System.out.println(minNum);
    }

}
