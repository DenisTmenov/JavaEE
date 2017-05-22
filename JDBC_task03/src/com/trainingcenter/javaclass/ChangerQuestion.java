package com.trainingcenter.javaclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ChangerQuestion {
	public static void saveQuestion(String question) throws NamingException {

		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate("INSERT INTO jdbc_task03_db.questions (question) VALUES ('" + question + "')");
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}

	public static void changeQuestion(String question, int questionNum) throws NamingException {

		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate(
					"UPDATE jdbc_task03_db.questions SET question='"+ question +"' WHERE id_q='" + questionNum + "';");

		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}

	

	public static int numQuestionInDB(String question) throws NamingException {

		Connection c = null;
		Statement statement = null;
		ResultSet set = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			set = statement.executeQuery("SELECT id_q FROM jdbc_task03_db.questions WHERE question='" + question + "'");
			if (set.next()) {
				return set.getInt("id_q");
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement, set);
		}
	}
	
	public static void deleteQuestion(String numQuestion) throws NamingException {

		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate(
					"DELETE FROM `jdbc_task03_db`.`questions` WHERE `id_q`='" + numQuestion + "';");
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}
}
