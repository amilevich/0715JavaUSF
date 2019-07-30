package com.homework.question7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CompInterface {
	
	public static void main(String[] args) {
		
		//Create and Populate the ArrayList
		ArrayList<Employee> arr = new ArrayList<>();
		arr.add(new Employee("John","121-d",30));
		arr.add(new Employee("Andrew","121-b",27));
		arr.add(new Employee("Gael","120-d",30));
		arr.add(new Employee("Fausto","119-c",40));
		arr.add(new Employee("Rana","421-d",25));
		
		//List unSort
		System.out.println("List Unsort");
		for(Employee e : arr) {
			System.out.println(e);
		}
		
		//Sort by name
		Collections.sort(arr, new SortByName());
		System.out.println("List sort by name");
		for(Employee e : arr) {
			System.out.println(e);
		}
		
		//Sort by deparment
		Collections.sort(arr, new SortByDeparment());
		System.out.println("List sort by deparment");
		for(Employee e : arr) {
			System.out.println(e);
		}
		
		//Sort by Age
		Collections.sort(arr, new SortByAge());
		System.out.println("List sort by Age");
		for(Employee e : arr) {
			System.out.println(e);
		}
		
	}

}
