package utility.ds;

import java.util.TreeSet;

public class ArrayOps {
	
	public static TreeSet<Integer> arrStringToIntegerSet (String[][] tbl, Integer index, String condition) {
		TreeSet<Integer> intSet = new TreeSet<Integer>();
		for (int i = 0; i < tbl.length; i++) {
			if ( tbl[i][index].equals(condition) ) {
				intSet.add(  Integer.valueOf(  tbl[i][0] ) );
			}
		}
		return intSet;
	}
	
	public static TreeSet<Integer> arrStringToIntegerSet (String[][] tbl) {
		TreeSet<Integer> intSet = new TreeSet<Integer>();
		for (int i =0; i < tbl.length; i++) {
			intSet.add(  Integer.valueOf(  tbl[i][0] ) );
		}
		return intSet;
	}
	
	public static TreeSet<String> arrStringToStringSet (String[][] tbl) {
		TreeSet<String> stringSet = new TreeSet<String>();
		for (int i =0; i < tbl.length; i++) {
			stringSet.add(  tbl[i][0] );
		}
		return stringSet;
	}
}
