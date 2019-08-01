package question1;

import java.util.Arrays;

public class BubbleSort { 
	//Create method
	    void bubbleSort(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 0; i < n-1; i++) 
	            for (int j = 0; j < n-i-1; j++) 
	                if (arr[j] > arr[j+1]) 
	                { 
	                    // swap arr[j+1] and arr[i] 
	                    int temp = arr[j]; 
	                    arr[j] = arr[j+1]; 
	                    arr[j+1] = temp; 
	                } 
	    } 
	  
	    // Prints the array 
	    void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	  
	    // Driver method to test above 
	    public static void main(String args[]) 
	    { 
	        BubbleSort ob = new BubbleSort(); 
	        int arr[] = {1,0,5,6,3,2,3,7,9,8,4}; 
	        System.out.println("The array consists of " + Arrays.toString(arr));
	        ob.bubbleSort(arr); 
	        System.out.println("The sorted array consists of "); 
	        ob.printArray(arr); 
	    } 
	} 

