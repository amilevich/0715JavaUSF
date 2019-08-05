package data;

import java.util.TreeMap;

public class GenericDAO<T,U> implements DAO<T, U> {

	@Override
	public TreeMap<Integer, T> getAll(U data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T single, U data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int id, U data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int id, U data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(int id, T single, U data) {
		// TODO Auto-generated method stub
		
	}
	
}
