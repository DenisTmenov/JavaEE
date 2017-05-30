package com.trainingcenter.javaclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.trainingcenter.connectionpool.ConnectionPool;

public class ChangerAnswer {
	public static void saveAnswer(String answer, int question) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection
					.prepareStatement("INSERT INTO jdbc_task03_db.answers (answer, fk_question_id) VALUES (?, ?)");
			statement.setString(1, answer);
			statement.setInt(2, question);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	public static void saveTrueAnswer(String answer) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection
					.prepareStatement("UPDATE jdbc_task03_db.answers SET trueOrFalse='true' WHERE answer = ?");
			statement.setString(1, answer);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	public static void changeAnswer(String answer, int question) throws NamingException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement(
					"UPDATE jdbc_task03_db.answers SET trueOrFalse='false', answer = ? WHERE id_a = ?");
			statement.setString(1, answer);
			statement.setInt(2, question);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	public static void deleteAllAnswers(String numQuestion) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection
					.prepareStatement("DELETE FROM `jdbc_task03_db`.`answers` WHERE `fk_question_id`= ? ");
			statement.setString(1, numQuestion);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

	public static void nullAllAnswers(String numQuestion) throws NamingException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement(
					"UPDATE `jdbc_task03_db`.`answers` SET `fk_question_id`=NULL WHERE `fk_question_id` = ?");
			statement.setString(1, numQuestion);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement);
		}
	}

}
