package com.trainingcenter.projectee.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainingcenter.projectee.dao.UserInfoDao;
import com.trainingcenter.projectee.dao.db.ConnectionPool;
import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;
import com.trainingcenter.projectee.entity.UserInfoEntity;

public class MySqlUserInfoDaoImpl implements UserInfoDao {
	@Override
	public UserInfoEntity loadUserInfoById(Integer idInfo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_info WHERE id_info = ?");
			statement.setInt(1, idInfo);

			set = statement.executeQuery();

			if (set.next()) {
				UserInfoEntity beanUserInfo = CreaterEntity.createUserInfoEntity(set);
				return beanUserInfo;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserInfoDaoImpl in loadUserInfoById.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}
	
	public UserInfoEntity returnUserInfoByLogin(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user, user_info WHERE login = ? AND user.id_user = user_info.fk_id_user");
			statement.setString(1, login);

			set = statement.executeQuery();

			if (set.next()) {
				UserInfoEntity userInfoEntity = CreaterEntity.createUserInfoEntity(set);
				return userInfoEntity;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in returnRoleByLogin.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}
		return null;
	}
	
	public Integer returnIdInfoByFkIdUser(Integer fkIdUser) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_info WHERE fk_id_user = ?");
			statement.setInt(1, fkIdUser);

			set = statement.executeQuery();

			if (set.next()) {
				Integer idInfo = set.getInt("id_info");
				return idInfo;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserInfoDaoImpl in returnIdInfoByFkIdUser.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}

	@Override
	public UserInfoEntity loadUserInfoByEmail(String email) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_info WHERE email = ?");
			statement.setString(1, email);

			set = statement.executeQuery();

			if (set.next()) {
				UserInfoEntity userInfoEntity = CreaterEntity.createUserInfoEntity(set);
				return userInfoEntity;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserInfoDaoImpl in loadUserInfoByEmail.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}

	@Override
	public void save(UserInfoEntity bean) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO user_info (first_name, last_name, email, fk_id_user) VALUES (?, ?, ?, ?)");
			statement.setString(1, bean.getFirstName());
			statement.setString(2, bean.getLastName());
			statement.setString(3, bean.getEmail());
			statement.setInt(4, bean.getFkIdUser());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserInfoDaoImpl in save.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	@Override
	public void update(UserInfoEntity bean) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement("UPDATE user_info SET "
					+ "first_name = ?, last_name = ?, email = ?, fk_id_user = ? WHERE id_info = ?");
			statement.setString(1, bean.getFirstName());
			statement.setString(2, bean.getLastName());
			statement.setString(3, bean.getEmail());
			statement.setInt(4, bean.getFkIdUser());
			statement.setInt(5, bean.getIdInfo());
			

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserInfoDaoImpl in update.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	@Override
	public void remove(Integer idInfo) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("DELETE FROM user_info WHERE id_info = ?");
			statement.setInt(1, idInfo);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserInfoDaoImpl in remove.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	@Override
	public Boolean emailExists(String email) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_info WHERE email=?");
			statement.setString(1, email);

			set = statement.executeQuery();

			if (set.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserInfoDaoImpl in emailExists.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}
		return false;
	}

	

}
