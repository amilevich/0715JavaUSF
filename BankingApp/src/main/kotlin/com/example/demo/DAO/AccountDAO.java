package com.example.demo.DAO;

import com.example.demo.database.Accounts;
import com.example.demo.model.Account;
import com.example.demo.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO implements Select<Account>, Delete<Account>, Update<Account>
{
	ConnectionManager connectionManager = ConnectionManager.getInstance();

	@Override
	public void delete(int id)
	{
		Connection connection = connectionManager.getConnection();
		try {
			CallableStatement callableStatement = connection.prepareCall("{call DELETE_ACCOUNT(?)}");
			callableStatement.setInt(1, id);

			callableStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account selectOne(int id)
	{
		Connection connection = connectionManager.getConnection();
		Account account = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ACCOUNTS where ACCOUNT_NUMBER = ?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				account = new Account(resultSet.getInt(1));
				account.setBalance(resultSet.getDouble(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}

	@Override
	public ArrayList<Account> selectAll()
	{
		Connection connection = connectionManager.getConnection();
		ArrayList<Account> accounts = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * from ACCOUNTS");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next())
			{
				Account account = new Account(resultSet.getInt(1));
				account.setBalance(resultSet.getDouble(2));

				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;
	}

	@Override
	public void update(Account obj) {
		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ACCOUNTS SET BALANCE = ? where ACCOUNT_NUMBER = ?");
			preparedStatement.setDouble(1, obj.getBalance());
			preparedStatement.setInt(2, obj.getAccountNumber());

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Integer> getAllAccountNumbers()
	{
		ArrayList<Integer> accountNumbers = new ArrayList<>();
		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ACCOUNTS");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				accountNumbers.add(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accountNumbers;
	}
}
