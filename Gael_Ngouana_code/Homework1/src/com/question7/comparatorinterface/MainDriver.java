package com.question7.comparatorinterface;

import java.util.ArrayList;
import java.util.Collections;

public class MainDriver {
	public static void main(String[] args) {

		//creates an arraylist
		ArrayList<Employee1> ar = new ArrayList<Employee1>();
		
		//adds new object to the arraylist
		ar.add(new Employee1("Mike", "Information", 25));
		//add object to the arraylist
		ar.add(new Employee1("Zachary", "Accounting", 29));

		System.out.println("Unsorted");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		// method that sorts by name
		Collections.sort(ar, new Sortbyname());

		System.out.println("\nSorted by name");
		for (int i = 0; i < ar.size(); i++)
			//prints out arraylist
			System.out.println(ar.get(i));

		//method that sorts by department
		Collections.sort(ar, new Sortbydepartment());

		System.out.println("\nSorted by department");
		for (int i = 0; i < ar.size(); i++)
			//prints out arraylist
			System.out.println(ar.get(i));

		//method that sort by age
		Collections.sort(ar, new Sortbyage());

		System.out.println("\nSorted by age");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
	}

}
