package com.trainingcenter.projectEE.maven.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	// реализация Singlton On Demand Holder idiom   https://habrahabr.ru/post/129494/
	// + Ленивая инициализация
	// + Высокая производительность
	// - Невозможно использовать для не статических полей класса

	public static class SingletonHolder {
		public static final ConnectionPool HOLDER_INSTANCE = new ConnectionPool();
	}
	/*
	private static ConnectionPool instance = null; // 3 признак. PRIVATE STATIC
													// переменная самого себя

	
	 public static ConnectionPool getInstance() { 
	 // 2 признак. Instance создаем только один раз и возвращаем его 
	 if(instance == null){ 
	 instance = new ConnectionPool(); 
	 } 
	 return instance; }
	 */

	public static ConnectionPool getInstance() {

		return SingletonHolder.HOLDER_INSTANCE;
	}

	private DataSource dataSource;

	private ConnectionPool() {
		// 1 признак. Конструктор всегда PRIVATE
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			dataSource = (DataSource) rootContext.lookup("jdbc/project_ee_db_context");
		} catch (NamingException e) {
			throw new RuntimeException("Some errors occurred during DataSource lookup!", e);
		}
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Can not receive connection!", e);
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void closeDbResources(Connection connection, Statement statement) {
		closeDbResources(connection, statement, null);
	}

	public void closeDbResources(Connection connection, Statement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error: Connection has not been closed!");
			}
		}
	}

	private void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("Error: Statement has not been closed!");
			}
		}
	}

	private void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("Error: ResultSet has not been closed!");
			}
		}
	}
}
