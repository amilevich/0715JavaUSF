package q1;

	public class ABloodyClass
		{ 
		    void bubbleSort(int arr[]) 
		    { 
		        int a = arr.length; 
		        for (int i = 0; i < a-1; i++) 
		            for (int b = 0; b < a-i-1; b++) 
		                if (arr[b] > arr[b+1]) 
		                { 
		                    // swap arr[b+1] and arr[i] 
		                    int temp = arr[b]; 
		                    arr[b] = arr[b+1]; 
		                    arr[b+1] = temp; 
		                } 
		    } 
		  
		    /* Prints the array */
		    void printArray(int arr[]) 
		    { 
		        int a = arr.length; 
		        for (int i=0; i<a; ++i) 
		            System.out.print(arr[i] + " "); 
		        System.out.println(); 
		    } 
		  
		    // Driver method to test above 
		    public static void main(String args[]) 
		    { 
		        ABloodyClass bubba = new ABloodyClass(); 
		        int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 }; 
		        bubba.bubbleSort(arr); 
		        System.out.println("BubbleSorted array: \n"); 
		        bubba.printArray(arr); 
		    } 
		
	}


