package com.example.demo.DAO;

import java.util.ArrayList;

public interface Select<T>
{
	T selectOne(int id);
	
	ArrayList<T> selectAll();
}
