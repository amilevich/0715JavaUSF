package com.example.demo.DAO;

import com.example.demo.data.CustomerApplicationJoin;
import com.example.demo.database.PendingJointAccounts;
import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;

import java.util.ArrayList;

public class PendingJointApplicationDAO implements Select<CustomerApplicationJoin>
{
    PendingJointAccounts pendingJointAccounts = PendingJointAccounts.getInstance();

    ApplicationDAO applicationDAO = new ApplicationDAO();

    CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public CustomerApplicationJoin selectOne(int id)
    {
        AccountApplication application = applicationDAO.selectOne(id);
        ArrayList<Integer> customerIds = pendingJointAccounts.getCustomersByAppId(id);
        Customer customer1 = customerDAO.selectOne(customerIds.get(0));
        Customer customer2 = customerDAO.selectOne(customerIds.get(1));
        CustomerApplicationJoin join = new CustomerApplicationJoin();
        join.setApplicationId(application.getApplicationId());
        join.setFirstname(customer1.getFirstname().getValue());
        join.setLastname(customer1.getLastname().getValue());
        join.setFirstname2(customer2.getFirstname().getValue());
        join.setLastname2(customer2.getLastname().getValue());

        return join;
    }

    @Override
    public ArrayList<CustomerApplicationJoin> selectAll()
    {
        ArrayList<AccountApplication> appList = applicationDAO.selectAll();
        ArrayList<CustomerApplicationJoin> joinList = new ArrayList<>();

        for(AccountApplication app : appList)
        {
            if (pendingJointAccounts.getCustomersByAppId(app.getApplicationId()) != null)
            {
                AccountApplication application = applicationDAO.selectOne(app.getApplicationId());
                ArrayList<Integer> customerIds = pendingJointAccounts.getCustomersByAppId(app.getApplicationId());
                Customer customer1 = customerDAO.selectOne(customerIds.get(0));
                Customer customer2 = customerDAO.selectOne(customerIds.get(1));
                CustomerApplicationJoin join = new CustomerApplicationJoin();
                join.setApplicationId(application.getApplicationId());
                join.setFirstname(customer1.getFirstname().getValue());
                join.setLastname(customer1.getLastname().getValue());
                join.setFirstname2(customer2.getFirstname().getValue());
                join.setLastname2(customer2.getLastname().getValue());

                joinList.add(join);
            }
        }

        return joinList;
    }

    public void approveJointAccount(int id)
    {
        pendingJointAccounts.approveCustomer(id);
    }

    public void denyJoinAccount(int id)
    {
        pendingJointAccounts.denyCustomer(id);
    }
}
