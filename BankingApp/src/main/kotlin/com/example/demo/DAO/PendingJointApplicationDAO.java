package com.example.demo.DAO;

import com.example.demo.data.CustomerApplicationJoin;
import com.example.demo.database.PendingJointAccounts;
import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;
import com.example.demo.utility.ConnectionManager;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.ArrayList;

public class PendingJointApplicationDAO implements Select<CustomerApplicationJoin>
{
    ApplicationDAO applicationDAO = new ApplicationDAO();

    ConnectionManager connectionManager = ConnectionManager.getInstance();

    CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public CustomerApplicationJoin selectOne(int id)
    {
        AccountApplication application = applicationDAO.selectOne(id);
        ArrayList<Integer> customerIds = this.getCustomerByAppId(id);
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
            if (!this.getCustomerByAppId(app.getApplicationId()).isEmpty())
            {
                AccountApplication application = applicationDAO.selectOne(app.getApplicationId());
                ArrayList<Integer> customerIds = this.getCustomerByAppId(app.getApplicationId());
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
        Connection connection = connectionManager.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call APPROVE_JOINT_APP(?)}");
            callableStatement.setInt(1, id);

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void denyJoinAccount(int id)
    {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from JOINT_APPLICATION where " +
                    "APP_ID = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Integer> getCustomerByAppId(int id)
    {
        Customer primary = new Customer();
        Customer secondary = new Customer();
        ArrayList<Integer> customerIds = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement getIdStatement = null;
        try {
            getIdStatement = connection.prepareStatement("SELECT PRIMARY_CUSTOMER_ID,SECONDARY_CUSTOMER_ID " +
                    "from JOINT_APPLICATION where APP_ID = ?");
            getIdStatement.setInt(1, id);

            ResultSet resultSet = getIdStatement.executeQuery();
            while (resultSet.next())
            {
                primary.setCustomerID(resultSet.getInt(1));
                customerIds.add(primary.getCustomerID());
                secondary.setCustomerID(resultSet.getInt(2));
                customerIds.add(secondary.getCustomerID());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerIds;
    }
}