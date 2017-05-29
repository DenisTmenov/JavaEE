package com.trainingcenter.projectee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trainingcenter.projectee.beans.UserBean;
import com.trainingcenter.projectee.dao.db.ConnectionPool;

public class MySqlUserDAO {

	public List<UserBean> loadAlluser() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		List<UserBean> result = new ArrayList<UserBean>();

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement("SELECT * FROM user");
			set = statement.executeQuery();

			while (set.next()) {
				UserBean entity = createUserBean(set);
				result.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}

		return result;
	}

	public UserBean loadUserById(Integer idUser) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE id=?");
			statement.setInt(1, idUser);

			set = statement.executeQuery();

			if (set.next()) {
				UserBean entity = createUserBean(set);
				return entity;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}

		return null;
	}
	
	public Integer returnIdByLogin(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE login=?");
			statement.setString(1, login);

			set = statement.executeQuery();

			if (set.next()) {
				Integer id_user = Integer.valueOf(set.getString("id_user"));
				return id_user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}

		return null;
	}

	public UserBean storeUser(UserBean bean) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection
					.prepareStatement("INSERT INTO user (login, password, del_status, fk_role) VALUES (?, ?, ?, ?)");
			statement.setString(1, bean.getLogin());
			statement.setString(2, bean.getPassword());
			statement.setBoolean(3, bean.getDelStatus());
			statement.setInt(4, bean.getFkRole());

			statement.executeUpdate();
			set = statement.getGeneratedKeys();
			if (set.next()) {
				Integer storedId = set.getInt(1);
				UserBean storedUser = loadUserById(storedId);
				return storedUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}

		return null;
	}

	public void updateUser(UserBean bean) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement(
					"UPDATE user SET login = ?, password = ?, del_status = ?, fk_role = ? WHERE id = ?");
			statement.setString(1, bean.getLogin());
			statement.setString(2, bean.getPassword());
			statement.setBoolean(3, bean.getDelStatus());
			statement.setInt(4, bean.getFkRole());
			statement.setInt(5, bean.getIdUser());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}

	public void removeUser(Integer idUser) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("DELETE FROM user WHERE id = ?");
			statement.setInt(1, idUser);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}

	private UserBean createUserBean(ResultSet set) throws SQLException {
		Integer userId = set.getInt("id_user");
		String login = set.getString("login");
		String password = set.getString("pawwsord");
		Boolean delStatus = set.getBoolean("del_status");
		Integer fkRole = set.getInt("fk_role");

		UserBean bean = new UserBean();

		bean.setIdUser(userId);
		bean.setLogin(login);
		bean.setPassword(password);
		bean.setDelStatus(delStatus);
		bean.setFkRole(fkRole);

		return bean;
	}
}
