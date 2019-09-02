package com.ers.project.interfaces;

import java.util.List;

public interface MainInterface<T> {
	
	public boolean createRecord(T t);
	public T findRecordById(T t);
	public List<T> findAllRecord();
	public boolean updateRecord(T t);
	public boolean deleteRecord(T t);	

}
