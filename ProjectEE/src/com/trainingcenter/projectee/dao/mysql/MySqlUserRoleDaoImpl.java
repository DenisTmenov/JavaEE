package com.trainingcenter.projectee.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainingcenter.projectee.beans.UserRoleBean;
import com.trainingcenter.projectee.dao.UserRoleDao;
import com.trainingcenter.projectee.dao.db.ConnectionPool;
import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;

public class MySqlUserRoleDaoImpl implements UserRoleDao {
	@Override
	public void save(UserRoleBean bean) {
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
	public void update(UserRoleBean bean) {
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
	public UserRoleBean loadUserRoleByIdRole(Integer idRole) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_role WHERE id_role = ?");
			statement.setInt(1, idRole);

			set = statement.executeQuery();

			if (set.next()) {
				UserRoleBean userRoleBean = createUserRoleBean(set);
				return userRoleBean;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserRoleDaoImpl in loadUserRoleByIdRole.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}

	private UserRoleBean createUserRoleBean(ResultSet set) throws SQLException {
		Integer idRole = set.getInt("id_role");
		String nameRole = set.getString("name_role");
		Boolean add = set.getBoolean("add");
		Boolean delete = set.getBoolean("delete");
		Boolean modify = set.getBoolean("modify");
		Boolean read = set.getBoolean("read");

		UserRoleBean bean = new UserRoleBean();

		bean.setIdRole(idRole);
		bean.setNameRole(nameRole);
		bean.setAdd(add);
		bean.setDelete(delete);
		bean.setModify(modify);
		bean.setRead(read);

		return bean;
	}
}
