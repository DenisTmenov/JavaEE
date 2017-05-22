package com.trainingcenter.javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_task03_db?useSSL=false";

	private static final String DB_USER = "root";

	private static final String DB_PASSWORD = "root";

	private ConnectionManager() {
		throw new InstantiationError("No need to create instances for static content!");
	}

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Some errors occurred during loading DB Driver!", e);
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		}
	}
	
	public static void closeDbResources(Connection connection, Statement statement) {
		closeDbResources(connection, statement, null);
	}

	public static void closeDbResources(Connection connection, Statement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	private static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error: Connection has not been closed!");
			}
		}
	}

	private static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("Error: Statement has not been closed!");
			}
		}
	}

	private static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("Error: ResultSet has not been closed!");
			}
		}
	}
}
