package com.example.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListExample {

	public static void main(String[] args) {
		
		//ArrayList
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(500);
		arrList.add(47);
		arrList.add(99);
		arrList.add(500);
		arrList.add(240);
		//System.out.println(arrList);
		//guarantees insertion order
		//allows for duplicates
		
		//print out a specific index, 2nd element
		//System.out.println(arrList.get(1));
		//System.out.println(arrList.get(10));
		
		/*
		 * Iterators
		 * 
		 * A universal iterator that we can apply to any
		 * Collection object.
		 * By using Iterator, we can perform both read and
		 * remove operations
		 */
		ArrayList<String> aList = new ArrayList<>();
		aList.add("Carrot");
		aList.add("Potato");
		aList.add("Kewl");
		aList.add("Coffee");
		aList.add("Pineapple pen");
		
		//ListIterator to traverse the list
		ListIterator<String> iterator = aList.listIterator();
		
		//Traversing the list in forward direction
		System.out.println("Displaying list "
				+ "elements in forward direction: ");
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
		
		//Traversing the list in backward direction
		System.out.println("Displaying list "
				+ "elements in backward direction: ");
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous() + " ");
		}
	}
}
