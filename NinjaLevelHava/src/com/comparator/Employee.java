package com.comparator;

import java.util.*;

public class Employee {
	//Sort two employees based on their name, department,
		//and age using the Comparator interface
	//For demonstration purposes I actually used 4 Employee object instead of 2.
		String name;
		String department;
		int age;
		//I generated a constructor here using all fields so I can create my objects easily.
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}
		public String toString() {
			//here I am overriding the toString method from Object
			//this is going to return a textual representation of my objects
			return this.name + " "+ this.department +" "+ this.age;
		}
		

		
	
	 public static void main(String[] argzzz) {
		 //I need to create an ArrayList of type Employee
		 //populate the ArrayList with Employee objects
		 
		 ArrayList<Employee> empList = new ArrayList<Employee>();
		 
		 
		 empList.add(new Employee("Bruce Banner", "Rediology", 48));
		 empList.add(new Employee("Tony Stark", "Engineering", 50));
		 empList.add(new Employee("Thor...","Ruler of Asgard", 1500));
		 empList.add(new Employee("Giovanni Maldonado", "Engineering", 39));
		 
		 System.out.println("Lets sort by name...");
		 Collections.sort(empList, new SortByName());
		 
		 for(int i = 0; i < empList.size(); i++) {
			 System.out.println(empList.get(i));
		 }System.out.println("");
		 
		 System.out.println("Lets sort by department...");
		 Collections.sort(empList, new SortByDept());
		 
		 for(int i = 0; i < empList.size(); i++) {
			 System.out.println(empList.get(i));
		 }System.out.println("");
		 
		 System.out.println("Lets sort by age...");
		 Collections.sort(empList, new SortByAge());
		 
		 for(int i = 0; i < empList.size(); i++) {
			 System.out.println(empList.get(i));
		 }System.out.println("");
	 }
}

	

//now I am going to make classes that implement the Comparator Interface using objects from the Employee class
//Then I will be able to implement the abstract method (compare()) from comparator in the way that I see fit.

     class SortByName implements Comparator<Employee>{
	
    	 public int compare(Employee a, Employee b) {
    		 return a.name.compareTo(b.name);
    	 }
}
     class SortByDept implements Comparator<Employee>{
    		
    	 public int compare(Employee a, Employee b) {
    		 return a.department.compareTo(b.department);
    	 }
}
     class SortByAge implements Comparator<Employee>{
    		
    	 public int compare(Employee a, Employee b) {
    		 return a.age - b.age;
    	 }
}


     