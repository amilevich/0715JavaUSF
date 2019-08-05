package com.lopez.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapS {
	public static void main(String[] args) {
		Map m1 = new HashMap();
		m1.put("map", "HashMap");
		m1.put("schildt", "java2");
		m1.put("mathew", "Hyden");
		m1.put("schildt", "java2s");
		System.out.println(m1.keySet() + "Keys"); 
		System.out.println(m1.values() + "Values"); 

		SortedMap sm = new TreeMap();
		sm.put("map", "TreeMap");
		sm.put("schildt", "java2");
		sm.put("mathew", "Hyden");
		sm.put("schildt", "java2s");
		System.out.println(sm.keySet() + "Keys"); 
		System.out.println(sm.values() + "Values");
		
		
		MoonA moonA = new MoonA(1);
		MoonA moonB = new MoonA(2);
		MoonA moonC = new MoonA(3);
		MoonA moonD = new MoonA(4);

		LinkedHashMap lm = new LinkedHashMap();
		lm.put( 001 , moonA);
		lm.put( 002, moonB );
		lm.put( 003, moonC);
		lm.put( 002, moonD);
		System.out.println(lm.keySet() + "Keys"); 
		System.out.println(moonA.getA() + "values");
		System.out.println(moonB.getA() + "values");
		System.out.println(moonC.getA() + "values");
		System.out.println(moonD.getA() + "values");
	}
	
	
}
