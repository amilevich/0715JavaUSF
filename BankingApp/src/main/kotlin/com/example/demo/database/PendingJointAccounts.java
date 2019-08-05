package com.example.demo.database;

import com.example.demo.DAO.ApplicationDAO;
import com.example.demo.DAO.JointAppManagerDAO;
import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;
import com.example.demo.utility.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class PendingJointAccounts
{
    private static PendingJointAccounts instance = null;

    private HashMap<AccountApplication, ArrayList<Integer>> jointAppMap;

    private IdGenerator generator;

    private JointAppManagerDAO jointDAO = new JointAppManagerDAO();

    ApplicationDAO applicationDAO = new ApplicationDAO();

    private PendingJointAccounts()
    {
        this.jointAppMap = new HashMap<>();
        this.generator = new IdGenerator();
    }

    public static PendingJointAccounts getInstance()
    {
        if(instance == null)
        {
            instance = new PendingJointAccounts();
        }
        return instance;
    }

    public HashMap<AccountApplication, ArrayList<Integer>> getJointAppMap() {
        return jointAppMap;
    }

    public void setJointAppMap(HashMap<AccountApplication, ArrayList<Integer>> jointAppMap) {
        this.jointAppMap = jointAppMap;
    }

    public void addJointApplication(ArrayList<Integer> customers)
    {
        AccountApplication application = new AccountApplication(generator.generateId());
        jointAppMap.put(application, customers);
        applicationDAO.insert(application);
    }

    public void deleteJointApplication(AccountApplication app)
    {
        this.jointAppMap.remove(app);
    }

    public void approveCustomer(int id)
    {
        AccountApplication app = applicationDAO.selectOne(id);
        ArrayList<Integer> customers = getCustomersByAppId(id);

        this.jointAppMap.remove(app);
        applicationDAO.delete(id);
        this.jointDAO.insert(customers);
    }

    public void denyCustomer(int id)
    {
        for (AccountApplication app : jointAppMap.keySet())
        {
            if (app.getApplicationId() == id)
            {
                jointAppMap.remove(app);
                break;
            }
        }
        applicationDAO.delete(id);
    }

    public ArrayList<Integer> getCustomersByAppId(int id)
    {
        ArrayList<Integer> resultList = null;
        for (AccountApplication app : jointAppMap.keySet())
        {
            if (app.getApplicationId() == id)
            {
                resultList = jointAppMap.get(app);
            }
        }
        return resultList;
    }
}
