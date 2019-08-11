package com.example.demo.DAO;

import com.example.demo.data.CustomerApplicationJoin;
import com.example.demo.database.PendingAccounts;
import com.example.demo.model.AccountApplication;
import com.example.demo.model.Customer;
import com.example.demo.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class PendingApplicationDAO implements Select<CustomerApplicationJoin>
{
    PendingAccounts pendingAccounts = PendingAccounts.getInstance();

    ApplicationDAO applicationDAO = new ApplicationDAO();

    ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public CustomerApplicationJoin selectOne(int id)
    {
        AccountApplication application = applicationDAO.selectOne(id);
        Customer customer = this.getCustomerByAppId(id);
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
            if (pendingAccounts.getCustomerByApplication(app) != null)
            {
                Customer customer = this.getCustomerByAppId(app.getApplicationId());
                CustomerApplicationJoin join = new CustomerApplicationJoin();
                join.setApplicationId(app.getApplicationId());
                join.setFirstname(customer.getFirstname().getValue());
                join.setLastname(customer.getLastname().getValue());
                join.setAddress(customer.getAddress().getValue());

                joinList.add(join);
            }
        }

        return joinList;
    }

    public void approveApplication(int id)
    {
        Connection connection = connectionManager.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call APPROVE_CHECKING_APP(?)}");
            callableStatement.setInt(1, id);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void denyApplication(int id)
    {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from CHECKING_APPLICATIONS where APP_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer getCustomerByAppId(int id)
    {
        Customer customer = new Customer();
        Connection connection = connectionManager.getConnection();
        PreparedStatement getIdStatement = null;
        try {
            getIdStatement = connection.prepareStatement("SELECT CUSTOMER_ID from CHECKING_APPLICATIONS " +
                    "where APP_ID = ?");
            getIdStatement.setInt(1, id);

            ResultSet resultSet = getIdStatement.executeQuery();
            while (resultSet.next())
            {
                customer.setCustomerID(resultSet.getInt(1));
            }
            PreparedStatement getCustomerStatement = connection.prepareStatement("SELECT * from CUSTOMERS where CUSTOMER_ID = ?");
            getCustomerStatement.setInt(1, customer.getCustomerID());

            resultSet = getCustomerStatement.executeQuery();
            while (resultSet.next())
            {
                customer.setFirstname(resultSet.getString(2));
                customer.setLastname(resultSet.getString(3));
                customer.setAddress(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
}
