/**
 * 
 */
package com.expense.dao;
import com.expense.beans.manager;

/**
 * @author IBM
 *
 */
public interface managerDao {
	
	public manager selectManager(String username,String password);

}
