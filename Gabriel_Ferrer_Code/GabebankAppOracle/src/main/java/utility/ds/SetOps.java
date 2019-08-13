package utility.ds;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class SetOps {
	public static Set<String> reduceDim(Set<String[]> set, Integer index) {
		Set<String> items = new TreeSet<String>();
		for(String[] str: set) {
			items.add(  str[index] );
		}
		return items;
	}
	
	public static <T> ArrayList<T> setToAL(Set<T> set) {
		ArrayList<T> al = new ArrayList<T>();
		for(T t: set) {
			al.add(t);
		}
		return al;
	}
}
