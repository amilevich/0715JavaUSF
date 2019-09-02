package com.revature.dao;

import com.revature.domains.Cave;

public interface CaveDao {
	public void updateCave(Cave hp);

	public void insertCave(Cave hp);

	public void deleteCave(Cave hp);

	public Cave getCaveById(int id);
}
