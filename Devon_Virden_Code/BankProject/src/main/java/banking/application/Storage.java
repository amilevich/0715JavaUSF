package banking.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Storage<K, V> implements Serializable{

	private static final long serialVersionUID = -7977926067047423227L;
	TreeMap<K, V> storage = new TreeMap<K, V>();
	int size=0;

	public void put(K key, V value) {
		storage.put(key, value);
		size++;
	}

	public void remove(K key) {
		storage.remove(key);
	}
	
	public void removePending(K key) {
		storage.remove(key);
		size--;
	}
	
	public V get(K key){
		return storage.get(key);
	}
	
	public boolean containsKey(K key) {
		return storage.containsKey(key);
	}

	public int size() {
		return size;
	}
	
	public ArrayList<K> allKeys(){
		ArrayList<K> keys = new ArrayList<K>();
		keys.addAll(storage.keySet());
		return keys;
	}
}
