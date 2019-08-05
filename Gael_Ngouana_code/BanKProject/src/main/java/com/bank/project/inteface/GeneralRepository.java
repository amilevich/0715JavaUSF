package com.bank.project.inteface;

import java.util.List;

public interface GeneralRepository<T> {
	
	
	public boolean createRegister(T t);
	public List<T> finAllRegister();
	public T findById(T t);
	public boolean updateRegister(T t);
	public boolean deleteRegister(T t);
	

}
