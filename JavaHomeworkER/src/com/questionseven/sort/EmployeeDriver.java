package com.questionseven.sort;

import java.util.ArrayList;
import java.util.Collections;

import com.questionseven.sort.Employee.Sortbyage;
import com.questionseven.sort.Employee.Sortbydepartment;
import com.questionseven.sort.Employee.Sortbyname;

//Driver class 
public class EmployeeDriver {
	
    	public static void main (String[] args) { 

    	            ArrayList<Employee> arr = new ArrayList<Employee>(); 
    	            arr.add(new Employee(37, "Rana", "HR")); 
    	            arr.add(new Employee(25, "Alyssa", "Accounting")); 
    	          
    	      
    	            Collections.sort(arr, new Sortbyage()); 
    	      
    	            System.out.println("\nSorted by age"); 
    	            for (int i=0; i<arr.size(); i++) 
    	            	System.out.println(arr.get(i)); 
    	      
    	            Collections.sort(arr, new Sortbyname()); 
    	      
    	            System.out.println("\nSorted by name"); 
    	            for (int i=0; i<arr.size(); i++) 
    	                System.out.println(arr.get(i)); 
    	            
    	            Collections.sort(arr, new Sortbydepartment()); 
    	  	      
    	            System.out.println("\nSorted by department"); 
    	            for (int i=0; i<arr.size(); i++) 
    	                System.out.println(arr.get(i)); 
    	} 
    	        
    	
}
