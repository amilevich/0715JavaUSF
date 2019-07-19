package com.example.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] computerLady) {
		
		//HashMap
		
		Map<Integer, String> hMap = new HashMap<>();
		hMap.put(14, "Fourteen");
		hMap.put(16, "Sweet Sixteen");
		hMap.put(19, "Rana's B-Day");
		hMap.put(47, "Agent");
		hMap.put(8, "Ate");
		hMap.put(null, "nothing bad ever happens to Rico, he is gr8");
		hMap.put(14, "!Fourteen");
		//insertion order is not preserved
		//null can be a key
		//must keys be unique? yes
		//if two keys are the same, the value that comes last will
		//remain the value for the key
		//keys are objects
		System.out.println(hMap);
		System.out.println(hMap.get(null));
		System.out.println(hMap.get(19));
		System.out.println(hMap.get(500));
		
		//for each/enhanced for loop
		/*
		 * the enhanced for statement simplifies traversing over
		 * collections of data.
		 * It has no explicit counter
		 * The statement goes through an array or a collection
		 * one by one and the current value is copied to a variable
		 * defined in the construct
		 */
		
		for(Entry<Integer, String> en : hMap.entrySet()) {
			System.out.println(en.getKey() + "\t" + en.getValue());
		}
	}
}
