package com.HW1.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question7 {

	public static void main(String[] args) {
		
		ArrayList<Employee>arrList= new ArrayList<Employee>(); //Initial creation of employee objects
		arrList.add(new Employee("Gary", "HR", 32)); 
        arrList.add(new Employee("Sarah", "Perfume", 24)); 
        arrList.add(new Employee("Bob", "Electronics", 26)); 
  
        System.out.println("Unsorted"); 
        for (int i=0; i<arrList.size(); i++) 
            System.out.println(arrList.get(i)); 
  
        Collections.sort(arrList, new SortByName()); 		//sorting by sort from collections and 
        												// comparator class of selected data 
        System.out.println("\nSorted by Name"); 		
        for (int i=0; i<arrList.size(); i++) 				//Outputting arrayList to show the sorting
            System.out.println(arrList.get(i)); 				// by the different data selected
  
        Collections.sort(arrList, new SortByDepartment()); 
  
        System.out.println("\nSorted by Department"); 
        for (int i=0; i<arrList.size(); i++) 
            System.out.println(arrList.get(i)); 
        
        Collections.sort(arrList, new SortByAge()); 
        
        System.out.println("\nSorted by Age"); 
        for (int i=0; i<arrList.size(); i++) 
            System.out.println(arrList.get(i)); 
	}
}

class Employee{				//Class that defines objects to be compared
	String name;
	String department;
	int age;
	
	public Employee(String n, String d, int a) {
		this.name = n;
		this.department = d;
		this.age = a;
	}
	
	public String toString() {					//sets format to display object
		return this.name+ " " + this.department + 
                " " + this.age; 
	}	
}

class SortByName implements Comparator<Employee>{	//Comparator classes named by the data that they sort
	public int compare(Employee a, Employee b) {	// and implement compare with desired data
		return a.name.compareTo(b.name);
	}
}

class SortByDepartment implements Comparator<Employee>{	
	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}

class SortByAge implements Comparator<Employee>{	
	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}
