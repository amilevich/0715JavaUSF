package com.revature.dao;

import com.revature.domains.Bear;

public interface BearDao {
	public void updateBear(Bear hp);
	
	public void insertBear(Bear hp);
	
	public void deleteBear(Bear hp);
	
	public Bear getBearById(int id);
}
