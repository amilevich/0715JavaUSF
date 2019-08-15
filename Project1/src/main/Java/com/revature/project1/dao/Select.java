package com.revature.project1.dao;

import java.util.ArrayList;

public interface Select<T>
{
    T selectOne(int id);

    ArrayList<T> selectAll();
}
