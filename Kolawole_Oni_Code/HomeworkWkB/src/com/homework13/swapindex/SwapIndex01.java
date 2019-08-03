package com.homework13.swapindex;

import java.util.Scanner;

public class SwapIndex01 {
	// To construct a  jagged two dimensional array that stores 0 and 1
	//
	
	public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows=s.nextInt();
        s.close();

//        Operations to print out the rows and values 
        for(int i=1; i<=rows; i++)
        {
              for(int j=1; j<=i; j++)
              {
                  if((i+j)%2==1)
                  {
                      System.out.print("0");
                  }
                      else{
                          System.out.print("1");
                      }
              
              }
              System.out.println();
        
        }}

}


