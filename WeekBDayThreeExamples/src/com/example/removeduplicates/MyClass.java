package com.example.removeduplicates;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MyClass {
	
	//Task: to remove duplicates (duplicate elements) from an ArrayList

	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(1,1,2,3,4,4,4,2,3,4,8,11,2));
		
//		HashSet<Integer> hSet = new HashSet<>(aList);
//		System.out.println(hSet);
		
//		TreeSet<Integer> tSet = new TreeSet<>(aList);
//		System.out.println(tSet);
		
		//Java 8 has Stream API, this API has a distinct() method which returns
		//a stream consisting of the distinct element comparing by object's 
		//equals() method.
		
		List<Integer> lList = aList.stream().distinct().collect(Collectors.toList());
		System.out.println(lList);
		
	}
	
}
