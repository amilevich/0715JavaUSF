package com.example.datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		
		//Sets
		
		//Data structures inside the collection API (maps too)
		//only allow for the storage of Objects
		//To actually utilize primitive data types in these
		//structures, we use Wrapper Classes
		/*
		 * int - Integer
		 * boolean - Boolean
		 * byte - Byte
		 * 
		 * 
		 * the process of converting a primitive data type
		 * into its wrapper class is called boxing(autoboxing)
		 * 
		 */
		Set<Integer> hSet = new HashSet<>();
		hSet.add(19);
		hSet.add(26);
		hSet.add(500);
		hSet.add(500);
		hSet.add(42);
		hSet.add(501);
		hSet.add(null);
		System.out.println(hSet);
		
		//no duplicates
		//sets and hashsets do not guarantee insertion order
		
		//TreeSet
		Set<Integer> tSet = new TreeSet<>();
	//	tSet.addAll(hSet);
		//System.out.println(tSet);
//		tSet.add(null);
//		System.out.println(tSet);
	}
}
