package utility.print;

import java.util.ArrayList;
import java.util.TreeMap;
import com.github.freva.asciitable.AsciiTable;
import utility.ds.SetOps;

public class Table {
	public static void displayArray(String title, String[] headers, String[][] table) {
		System.out.println("======================="+title+"=======================");
		System.out.println(AsciiTable.getTable(headers, table));
	}
	
	public static <K, V> void displayMap(String modelp, String[] headers, TreeMap<K, V> all) {
		String[][] table = new String[ all.size() ][ headers.length ]; 
		ArrayList<K> convertedSet = SetOps.setToAL( all.keySet() );
		for (Integer fl1 = 0; fl1 < convertedSet.size(); fl1++) {
			for (Integer fl2 = 0; fl2 < headers.length; fl2++) {
				table[fl1][fl2] = all.get( convertedSet.get(fl1) ).toString();
			}
		}
		
		System.out.println("------------------List of "+ modelp +"----------------------");
		System.out.println(AsciiTable.getTable(headers, table));
	}
}
