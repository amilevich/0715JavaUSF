package com.example.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDriver {

	public static void main(String[] args) {

		// creates an ArrayList

		List<Employees> Employees = new ArrayList<Employees>();

		Employees.add(new Employees("James", "Bio", 19)); // add to the Araylist

		Employees.add(new Employees("Corey", "Soc", 21));// add to the Araylist

		// implemented the Sorters on the Arraylist

		Collections.sort(Employees, new NameSorter()

				.thenComparing(new DeptNameSorter())

				.thenComparing(new AgeSorter()));

		System.out.println(Employees);

	}
}
