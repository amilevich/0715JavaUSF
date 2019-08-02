package com.example.sorting;

import java.util.Comparator;

public class StudentQuirkComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
//		if(s1.getPersonalityQuirk().compareTo(s2.getPersonalityQuirk()) > 0) {
//			return 1;
//		} else if(s1.getPersonalityQuirk().compareTo(s2.getPersonalityQuirk()) < 0) {
//			return -1;
//		}else {
//			return 0;
//		}
		return (s1.getPersonalityQuirk().compareTo(s2.getPersonalityQuirk()));
	}

}
