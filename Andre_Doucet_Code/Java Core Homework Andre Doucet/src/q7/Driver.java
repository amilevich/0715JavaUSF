package q7;

import java.util.ArrayList;
import java.util.Collections;

//import q7.ComparatorTime.Employee;
//import q7.ComparatorTime.Employee.Sortbyage;
//import q7.ComparatorTime.Employee.Sortbyname;

public class Driver {

	public static void main(String[] args) {
		// This is where the array for each employee is instantiated
		ArrayList<Employee> ar = new ArrayList<Employee>();
		ar.add(new Employee("Mario", "Plumber", 21));
		ar.add(new Employee("Luigi", "Plumber", 19));
		ar.add(new Employee("Toad", "Accountant", 35));
		
		
		//this sorts the array by name
		Collections.sort(ar, new Sortbyname());
		
		//this prints out the sorted by name array
		System.out.println("Sorted by name");
		for (int i=0; i<ar.size(); i++)
			System.out.println(ar.get(i));
		
		//this sorts the array by dept
		Collections.sort(ar, new Sortbydept());
		//this prints out the array sorted by dept
		System.out.println("Sorted by dept");
		for (int i=0; i<ar.size(); i++)
			System.out.println(ar.get(i));
		
		//this sorts the array by age
		Collections.sort(ar, new Sortbyage());
		//this sorts the array by age
		System.out.println("Sorted by age");
		for (int i=0; i<ar.size(); i++)
			System.out.println(ar.get(i));
		
	}

}
