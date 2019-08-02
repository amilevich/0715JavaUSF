package com.questionseven.sort;

import java.util.Comparator;


public class Employee {
	
	int age; 
    String name, department;
	 
 // Constructor 
    public Employee(int age, String name, String department) {	
    	this.age = age; 
        this.name = name; 
        this.department = department;    
    }  
		
    
		    
 
	class Sortbyage implements Comparator<Employee> 
		{ 
		    // Used for sorting in ascending order by age number 
		    public int compare(Employee a, Employee b) 
		    { 
		        return a.age - b.age; 
		    } 
		} 
		  
		class Sortbyname implements Comparator<Employee> 
		{ 
		    // Used for sorting in ascending order by name
		    public int compare(Employee a, Employee b) 
		    { 
		        return a.name.compareTo(b.name); 
		    } 
		} 
		
		class Sortbydepartment implements Comparator<Employee> 
		{ 
		    // Used for sorting in ascending order by department
		    public int compare(Employee a, Employee b) 
		    { 
		        return a.department.compareTo(b.department); 
		    }
		}
	}	
		    
