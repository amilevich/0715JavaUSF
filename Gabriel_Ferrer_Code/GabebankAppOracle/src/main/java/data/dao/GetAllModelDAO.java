package data.dao;

import java.util.TreeMap;

public interface GetAllModelDAO <Id,Model>{
	TreeMap<Id,Model> getAll();
	String[][] getTable();
}
