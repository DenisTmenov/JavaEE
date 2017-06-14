package com.trainingcenter.projectEE.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainingcenter.projectEE.maven.dao.UserRoleDao;
import com.trainingcenter.projectEE.maven.dao.db.ConnectionPool;
import com.trainingcenter.projectEE.maven.dao.entity.UserRoleEntity;
import com.trainingcenter.projectEE.maven.dao.exceptions.ExceptionDao;

public class MySqlUserRoleDaoImpl implements UserRoleDao {
	@Override
	public void save(UserRoleEntity bean) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO user_role (name_role, add, delete, modify, read) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, bean.getNameRole());
			statement.setBoolean(2, bean.getAdd());
			statement.setBoolean(3, bean.getDelete());
			statement.setBoolean(4, bean.getModify());
			statement.setBoolean(5, bean.getRead());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	@Override
	public void update(UserRoleEntity bean) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement(
					"UPDATE user_info SET name_role = ?, add = ?, delete = ?, modify = ?, read = ? WHERE id_role = ?");
			statement.setString(1, bean.getNameRole());
			statement.setBoolean(2, bean.getAdd());
			statement.setBoolean(3, bean.getDelete());
			statement.setBoolean(4, bean.getModify());
			statement.setBoolean(5, bean.getRead());
			statement.setInt(6, bean.getIdRole());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	@Override
	public void remove(Integer idRole) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("DELETE FROM user_role WHERE id_role = ?");
			statement.setInt(1, idRole);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	@Override
	public UserRoleEntity loadUserRoleByIdRole(Integer idRole) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_role WHERE id_role = ?");
			statement.setInt(1, idRole);

			set = statement.executeQuery();

			if (set.next()) {
				UserRoleEntity userRoleBean = CreaterEntity.createUserRoleEntity(set);
				return userRoleBean;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserRoleDaoImpl in loadUserRoleByIdRole.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}
	
	public Integer returnIdRoleByNameRole(String roleName) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_role WHERE name_role = ?");
			statement.setString(1, roleName);

			set = statement.executeQuery();

			if (set.next()) {
				Integer numRole = set.getInt("id_role");
				return numRole;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserRoleDaoImpl in loadUserRoleByIdRole.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}

	public String returnRoleByLogin(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user, user_role WHERE login = ? AND user.fk_role = user_role.id_role");
			statement.setString(1, login);

			set = statement.executeQuery();

			if (set.next()) {
				String role = set.getString("name_role");
				return role;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in returnRoleByLogin.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}
		return "";
	}
	
	
}
