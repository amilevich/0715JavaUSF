package utility.ds;

import java.util.Arrays;
import java.util.Map;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapOps {
	public static TreeMap<String, Integer[]> keys = new TreeMap<>();
	public static final Integer[] admin = {12,13};
	public static final Integer[] reg = {10,11};
	public static final Integer[] amount = {17, 23, 34, 36, 39, 45, 47, 50}; // deals with the amount transacted
	public static final Integer[] application = {66, 67, 68, 69}; // deals with the application number
	public static final Integer[] bankAccountCustomer = {34,36,38,39}; // deals with the bank account number
	public static final Integer[] bankAccountAdmin = {44, 45, 46, 47, 48, 49, 50, 64};
	public static final Integer[] currency = {18,24};
	public static final Integer[] customers = {8,9};
	public static final Integer[] joint = {65};
	public static final Integer[] name = {19,20,25,26,71,72}; // firstnames, lastname
	public static final Integer[] oldUsername = {8,9,10,11,12,13,70}; // logging in existing username
	public static final Integer[] newUsername = {21,22,27,28}; // new username
	public static final Integer[] password = {9,11,13,22,28};
	public static final Integer[] customerEdit = {70,71,72};
	
	static {
		keys.put("adm",admin); keys.put("reg",reg);
		keys.put("amount",amount); keys.put("app",application);
		keys.put("bac",bankAccountCustomer); keys.put("baa",bankAccountAdmin);
		keys.put("currency",currency); keys.put("cust",customers);
		keys.put("name",name); keys.put("oun",oldUsername);
		keys.put("nun",newUsername); keys.put("pw",password);
		keys.put("jn", joint); keys.put("custe", customerEdit);
	}
	
	public static String concatStr(TreeMap<String, String> toConcat, String forConcat) {
		/// <"firstname","'gabriel'">
		/// <"lastname", "'ferrer'">
		//String forConcat = "update customer set ";
		StringBuilder sb = new StringBuilder(forConcat);
		for(String key: toConcat.keySet()) {
			sb.append(key + " = '" + toConcat.get(key) + "',");
		}
		sb.replace(sb.length() - 1, sb.length(), " ");
		return sb.toString();
	}
	
	public static boolean match(String key, Integer answerkey) {
		Integer index = Arrays.binarySearch(keys.get(key)  , answerkey  );
		return index > -1 ? true : false;
	}
	
	
	public static Integer find(TreeMap<Integer, Integer> map, Integer value) {
	    for (Entry<Integer, Integer> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return new Integer(-1);
	}
	
	public static Integer find(Map<Integer, String> map, String value) {
	    for (Entry<Integer, String> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return new Integer(-1);
	}
	
	//map must be a bijection in order for this to work properly
	public static <K,V> TreeMap<V,K> reverse(TreeMap<K,V> map) {
		TreeMap<V,K> rev = new TreeMap<V, K>();
	    for(Map.Entry<K,V> entry : map.entrySet())
	        rev.put(entry.getValue(), entry.getKey());
	    return rev;
	}
	
	public static <K, V> Set<K> mapToSet(TreeMap<K, V> map) {
		return map.keySet();
	}
	
	
}
