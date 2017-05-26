package com.skillsimprover.magicnums.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {

	private static final String SQL = "select * from users";

	public static void main(String[] args) throws IOException, SQLException {
		//readWithUrl();
		//readWithLoginPassword();
		readWithProperties();

	}

	private static void readWithUrl() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db?user=root&password=password");
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery(SQL);

		while (set.next()) {
			Integer id = set.getInt("id");
			String userName = set.getString("user_name");
			String password = set.getString("password");
			
			System.out.println(id + " - " + userName + " - " + password);
		}
		
		set.close();
		statement.close();
		connection.close();
	} 

	private static void readWithLoginPassword() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db", "root", "password");
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery(SQL);

		while (set.next()) {
			Integer id = set.getInt("id");
			String userName = set.getString("user_name");
			String password = set.getString("password");
			
			System.out.println(id + " - " + userName + " - " + password);
		}
		
		set.close();
		statement.close();
		connection.close();
	} 

	private static void readWithProperties() throws SQLException {
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "password");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db", properties);
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery(SQL);

		while (set.next()) {
			Integer id = set.getInt("id");
			String userName = set.getString("user_name");
			String password = set.getString("password");
			
			System.out.println(id + " - " + userName + " - " + password);
		}
		
		set.close();
		statement.close();
		connection.close();
	} 

}
