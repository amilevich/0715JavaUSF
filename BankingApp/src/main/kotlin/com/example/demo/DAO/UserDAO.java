package com.example.demo.DAO;

import com.example.demo.DAO.Delete;
import com.example.demo.DAO.Insert;
import com.example.demo.DAO.Select;
import com.example.demo.data.UserData;
import com.example.demo.database.UserTable;
import com.example.demo.utility.ConnectionManager;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO implements Select<UserData>
{
	ConnectionManager connectionManager = ConnectionManager.getInstance();

	public UserData selectByUsername(String username)
	{
		Connection connection = connectionManager.getConnection();
		UserData userData = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USERS where USERNAME = ?");
			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				userData = new UserData(this.getId(username), resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userData;
	}

	private int getId(String username)
	{
		Connection connection = connectionManager.getConnection();
		int id  = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER_JUNCTION where USERNAME = ?");
			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				id = resultSet.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public UserData selectOne(int id) {
		String username = "";
		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER_JUNCTION where CUSTOMER_ID = ? ");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				username += resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.selectByUsername(username);
	}

	@Override
	public ArrayList<UserData> selectAll() {
		ArrayList<UserData> users = new ArrayList<>();
		Connection connection = connectionManager.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USERS");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				UserData userData = new UserData(this.getId(resultSet.getString(1)),
						resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3));

				users.add(userData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
}
