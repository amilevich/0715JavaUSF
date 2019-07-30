package com.homeworkcoreJava.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Answer to Question 7:
//Q7. Sort two employees based on their name, department, and age using the Comparator interface.
//Barton Carson
public class Question7 {
	
	static class Employee {
		
		String name, department;
		int age;
		
		//Constructor
		public Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		//Prints the Employee Information, overrides .toString for objects
		@Override
		public String toString() {
			return this.name + " " + this.department + " " + Integer.toString(this.age);
		}
		
	}
	
	//Class to sort by age
	static class Sortbyage implements Comparator<Employee> {
		
	    // Used for sorting in ascending order of age 
	    public int compare(Employee a, Employee b) { 
	        return a.age - b.age; 
	    } 
	} 
	
	//Class to sort by name
	static class Sortbyname implements Comparator<Employee> {
		
	    //Used for sorting in ascending order of name 
	    public int compare(Employee a, Employee b) { 
	        return a.name.compareTo(b.name); 
	    } 
	}
	
	//Class to sort by department
	static class Sortbydepartment implements Comparator<Employee> {
		
		//Use for sorting in ascending order of department
		public int compare(Employee a, Employee b) {
			return a.department.compareTo(b.department);
		}
	}

	//Main method that prints out employee information properly sorted
	public static void main(String[] args) {
		
		ArrayList<Employee> ar = new ArrayList<Employee>(); 
        ar.add(new Employee("Bob", "Physics", 45)); 
        ar.add(new Employee("Luke", "Math", 68)); 
  
        System.out.println("Unsorted"); 
        for (int i=0; i<ar.size(); i++) {
            System.out.println(ar.get(i)); 
        }
  
        Collections.sort(ar, new Sortbyage()); 
        System.out.println("\nSorted by Age"); 
        for (int i=0; i<ar.size(); i++) {
            System.out.println(ar.get(i)); 
        }
  
        Collections.sort(ar, new Sortbyname()); 
        System.out.println("\nSorted by Name"); 
        for (int i=0; i<ar.size(); i++) {
            System.out.println(ar.get(i));
        }
        
        Collections.sort(ar, new Sortbydepartment()); 
        System.out.println("\nSorted by Department"); 
        for (int i=0; i<ar.size(); i++) {
            System.out.println(ar.get(i));
        }    
	}
}