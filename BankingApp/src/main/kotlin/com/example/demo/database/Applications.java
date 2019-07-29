package com.example.demo.database;

import com.example.demo.model.AccountApplication;

import java.util.ArrayList;
import java.util.HashMap;

public class Applications
{
    private static Applications instance = null;

    private HashMap<Integer, AccountApplication> appMap;

    private Applications()
    {
        appMap = new HashMap<>();
    }

    public static Applications getInstance()
    {
        if(instance == null)
        {
            instance = new Applications();
        }
        return instance;
    }

    public void addApplication(AccountApplication app)
    {
        this.appMap.put(app.getApplicationId(), app);
    }

    public AccountApplication getApplicationById(int id)
    {
        return this.appMap.get(id);
    }

    public ArrayList<AccountApplication> getAllApps()
    {
        ArrayList<AccountApplication> list = new ArrayList<>();
        for (Integer i : this.appMap.keySet())
        {
            list.add(this.appMap.get(i));
        }
        return list;
    }

    public void removeApplication(int id)
    {
        this.appMap.remove(id);
    }
}
