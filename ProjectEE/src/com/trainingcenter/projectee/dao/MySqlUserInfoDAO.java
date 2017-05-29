package com.trainingcenter.projectee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trainingcenter.projectee.beans.UserInfoBean;
import com.trainingcenter.projectee.dao.db.ConnectionPool;

public class MySqlUserInfoDAO {

	public UserInfoBean loadUserInfoById(Integer id_info) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_info WHERE id_info=?");
			statement.setInt(1, id_info);

			set = statement.executeQuery();

			if (set.next()) {
				UserInfoBean entity = createUserInfoBean(set);
				return entity;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}

		return null;
	}

	public UserInfoBean storeUserInfo(UserInfoBean bean) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("INSERT INTO user_info ("
					+ "first_name, last_name, email, fk_id_user) VALUES (?, ?, ?, ?)");
			statement.setString(1, bean.getFirstName());
			statement.setString(2, bean.getLastName());
			statement.setString(3, bean.getEmail());
			statement.setInt(4, bean.getFkIdUser());
			    

			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}

		return null;
	}

	public void updateUserInfo(UserInfoBean bean) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = connection.prepareStatement("UPDATE user_info SET "
					+ "first_name = ?, last_name = ?, email = ?, fk_id_user = ? WHERE id_info = ?");
			statement.setString(1, bean.getFirstName());
			statement.setString(2, bean.getLastName());
			statement.setString(3, bean.getEmail());
			statement.setInt(4, bean.getFkIdUser());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}

	public void removeUserInfo(Integer idInfo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getPool().getConnection();

			statement = connection.prepareStatement("DELETE FROM user_info WHERE id_info = ?");
			statement.setInt(1, idInfo);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, set);
		}
	}

	private UserInfoBean createUserInfoBean(ResultSet set) throws SQLException {
		Integer idInfo = set.getInt("id_info");
		String firstName = set.getString("first_name");
		String lastName = set.getString("last_name");
		String email = set.getString("email");
		Integer fkIdUser = set.getInt("fk_id_user");

		UserInfoBean bean = new UserInfoBean();

		bean.setIdInfo(idInfo);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setFkIdUser(fkIdUser);

		return bean;
	}
}
