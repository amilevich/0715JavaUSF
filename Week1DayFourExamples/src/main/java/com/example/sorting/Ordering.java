package com.example.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordering {
	
	/*
	 * Comparable Interface (natural ordering)
	 * ordering provided by the JVM
	 * interface allows to sort based on one element
	 * numbers - ascending
	 * characters - unicode values
	 * 
	 * Comparator Interface (unnatural ordering)
	 * All values can be compared to all other values
	 * Custom ordering 
	 * 
	 * You have to specifically tell a sorting method. 
	 * If you don't specify, then the sorting algorithm will use
	 * the natural ordering instead.
	 * 
	 */

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(25, "Roger", 1.2, "afraid of the aggresive color blue", "marine biology", 3));
		students.add(new Student(3124, "Peter Parker", 5.0, "the Spooderman", "radiology", 8));
		students.add(new Student(1337, "Das Gamerh", 0.0, "what is school", "fortnite", 0));
		students.add(new Student(666, "Lucifer", 4.4, "father issues", "business", 2));
		
		printListPretty(students);
		//Collections.sort(students);
		// utility class filed with static methods to be used on the data structures
		//from the Collection API
		//printListPretty(students);
		
		System.out.println("Students sorted by their personality quirks: ");
		Collections.sort(students, new StudentQuirkComparator());
		printListPretty(students);
		

	}
	
	static void printListPretty(List<Student> sList) {
		System.out.println("Students: ");
		for(Student i : sList) {
			//i.toString(); DevonTM
			System.out.println(i);
		}
	}

}
