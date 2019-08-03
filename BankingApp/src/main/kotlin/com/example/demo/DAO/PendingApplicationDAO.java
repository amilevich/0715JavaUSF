package com.example.demo.DAO;

import com.example.demo.data.CustomerApplicationJoin;
import com.example.demo.database.PendingAccounts;
import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;

import java.util.ArrayList;

public class PendingApplicationDAO implements Select<CustomerApplicationJoin>
{
    PendingAccounts pendingAccounts = PendingAccounts.getInstance();

    ApplicationDAO applicationDAO = new ApplicationDAO();

    @Override
    public CustomerApplicationJoin selectOne(int id)
    {
        AccountApplication application = applicationDAO.selectOne(id);
        Customer customer = pendingAccounts.getCustomerByApplication(application);
        CustomerApplicationJoin join = new CustomerApplicationJoin();
        join.setApplicationId(application.getApplicationId());
        join.setFirstname(customer.getFirstname().getValue());
        join.setLastname(customer.getLastname().getValue());
        join.setAddress(customer.getAddress().getValue());

        return join;
    }

    @Override
    public ArrayList<CustomerApplicationJoin> selectAll()
    {
        ArrayList<AccountApplication> appList = applicationDAO.selectAll();
        ArrayList<CustomerApplicationJoin> joinList = new ArrayList<>();

        for(AccountApplication app : appList)
        {
            Customer customer = pendingAccounts.getCustomerByApplication(app);
            CustomerApplicationJoin join = new CustomerApplicationJoin();
            join.setApplicationId(app.getApplicationId());
            join.setFirstname(customer.getFirstname().getValue());
            join.setLastname(customer.getLastname().getValue());
            join.setAddress(customer.getAddress().getValue());

            joinList.add(join);
        }

        return joinList;
    }

    public void approveApplication(int id)
    {
        pendingAccounts.approveCustomer(id);
    }

    public void denyApplication(int id)
    {
        pendingAccounts.denyCustomer(id);
    }
}
