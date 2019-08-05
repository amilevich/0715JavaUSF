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

    private HashMap<AccountApplication, ArrayList<Customer>> jointAppMap;

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

    public HashMap<AccountApplication, ArrayList<Customer>> getJointAppMap() {
        return jointAppMap;
    }

    public void setJointAppMap(HashMap<AccountApplication, ArrayList<Customer>> jointAppMap) {
        this.jointAppMap = jointAppMap;
    }

    public void addJointApplication(ArrayList<Customer> customers)
    {
        AccountApplication application = new AccountApplication(generator.generateId());
        this.jointAppMap.put(application, customers);
    }

    public void deleteJointApplication(AccountApplication app)
    {
        this.jointAppMap.remove(app);
    }

    public ArrayList<Customer> getCustomersByApplication(AccountApplication application)
    {
        return this.jointAppMap.get(application);
    }

    public void approveCustomer(int id)
    {
        AccountApplication app = applicationDAO.selectOne(id);
        ArrayList<Customer> customers = jointAppMap.get(app);

        this.jointAppMap.remove(app);
        this.jointDAO.insert(customers);
    }
}
