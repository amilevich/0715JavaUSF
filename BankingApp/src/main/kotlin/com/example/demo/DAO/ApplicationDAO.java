package com.example.demo.DAO;

import com.example.demo.database.Applications;
import com.example.demo.model.AccountApplication;

import java.util.ArrayList;

public class ApplicationDAO implements Delete<AccountApplication>, Insert<AccountApplication>, Select<AccountApplication>
{
    Applications appTable = Applications.getInstance();

    @Override
    public void delete(int id) {
        appTable.removeApplication(id);
    }

    @Override
    public void insert(AccountApplication obj) {
        appTable.addApplication(obj);
    }

    @Override
    public AccountApplication selectOne(int id) {
        return appTable.getApplicationById(id);
    }

    @Override
    public ArrayList<AccountApplication> selectAll() {
        return appTable.getAllApps();
    }
}
