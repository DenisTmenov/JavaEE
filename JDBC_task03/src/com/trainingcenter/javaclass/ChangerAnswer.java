package com.trainingcenter.javaclass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ChangerAnswer {
	public static void saveAnswer(String answer, int question) throws NamingException {

		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate("INSERT INTO jdbc_task03_db.answers (answer, fk_question_id) VALUES ('" + answer
					+ "' , " + question + ")");
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}

	public static void saveTrueAnswer(String answer) throws NamingException {

		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate(
					"UPDATE jdbc_task03_db.answers SET trueOrFalse='true' WHERE answer='" + answer + "';");

		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}

	public static void changeAnswer(String answer, int question) throws NamingException {
		System.out.println("answer =  " + answer);
		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate("UPDATE jdbc_task03_db.answers SET trueOrFalse='false', answer='" + answer
					+ "' WHERE id_a='" + question + "';");

		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}

	public static void deleteAllAnswers(String numQuestion) throws NamingException {

		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate(
					"DELETE FROM `jdbc_task03_db`.`answers` WHERE `fk_question_id`='" + numQuestion + "';");

		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}

	public static void nullAllAnswers(String numQuestion) throws NamingException {

		Connection c = null;
		Statement statement = null;
		try {
			Context initContext = new InitialContext();
			Context rootContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

			c = dataSource.getConnection();
			statement = c.createStatement();
			statement.executeUpdate(
					"UPDATE `jdbc_task03_db`.`answers` SET `fk_question_id`=NULL WHERE `fk_question_id`='" + numQuestion
							+ "';");
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionManager.closeDbResources(c, statement);
		}
	}

}
