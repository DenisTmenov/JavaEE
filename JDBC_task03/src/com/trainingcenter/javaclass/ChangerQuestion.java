package com.trainingcenter.javaclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.trainingcenter.connectionpool.ConnectionPool;

public class ChangerQuestion {
	public static void saveQuestion(String question) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("INSERT INTO jdbc_task03_db.questions (question) VALUES (?)");
			statement.setString(1, question);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	public static void changeQuestion(String question, int questionNum) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("UPDATE jdbc_task03_db.questions SET question = ? WHERE id_q = ?");
			statement.setString(1, question);
			statement.setInt(2, questionNum);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	public static int numQuestionInDB(String question) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("SELECT id_q FROM jdbc_task03_db.questions WHERE question = ?");
			statement.setString(1, question);

			set = statement.executeQuery();

			if (set.next()) {
				return set.getInt("id_q");
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}

	public static void deleteQuestion(String numQuestion) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection
					.prepareStatement("DELETE FROM `jdbc_task03_db`.`questions` WHERE `id_q`= ?");
			statement.setString(1, numQuestion);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}
}
