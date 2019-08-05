package data;

import java.io.*;
import java.util.*;

//import main.com.bank.utility.*;

public interface DAO<T, U> {
	public TreeMap<Integer, T> getAll(U data);
	void add(T single, U data);
	public T get(int id, U data);
	void remove(int id, U data);
	void edit(int id, T single, U data);
}
