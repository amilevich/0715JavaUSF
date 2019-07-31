package com.homework;

import java.util.*;


public class Problem07 {
	
	public static void main(String[] args) {
		
		ArrayList<Students> student = new ArrayList<Students>();
		
		student.add(new Students("Ruben", "Computer" , 26));
		student.add(new Students("Tony", "Art" , 14));
		student.add(new Students("Jill", "Math" , 13));
		
		ArrayList<Students> student2 = (ArrayList<Students>) student.clone();
		
		//old way
		System.out.println(student);
		Comparator<Students>c1 = new Comparator<Students>() {
			
			@Override
			public int compare(Students arg0, Students arg1) {
				// TODO Auto-generated method stub
				return arg0.name.compareTo(arg1.name);
			}
		};
		
		//Flexing old method to sort by student
		Collections.sort( student , c1);
		System.out.println(student);
		
		//Flexing method 2 to sort by department
		Comparator<Students> c2 = (Students s1, Students s2) -> (s1.department).compareTo(s2.department);
		
		Collections.sort(student2, c2);
		System.out.println(student2);
		
		//Flexing comparing age by a pointer method
		Comparator<Students> c3 = (Students s1, Students s2) -> (s1.age - s2.age);
		
		Collections.sort(student2, c3);
		System.out.println(student2);
	}
}
