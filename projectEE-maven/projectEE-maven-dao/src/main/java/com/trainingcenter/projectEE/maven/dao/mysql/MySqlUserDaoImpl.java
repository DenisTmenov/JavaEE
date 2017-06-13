package main.java.com.trainingcenter.projectEE.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.trainingcenter.projectEE.maven.dao.UserDao;
import main.java.com.trainingcenter.projectEE.maven.dao.db.ConnectionPool;
import main.java.com.trainingcenter.projectEE.maven.dao.exceptions.ExceptionDao;
import main.java.com.trainingcenter.projectEE.maven.entity.UserEntity;
import main.java.com.trainingcenter.projectEE.maven.entity.UserInfoEntity;

public class MySqlUserDaoImpl implements UserDao {
	@Override
	public Integer returnIdByLogin(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE login=?");
			statement.setString(1, login);

			set = statement.executeQuery();

			if (set.next()) {
				Integer id_user = Integer.valueOf(set.getString("id_user"));
				return id_user;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in returnIdByLogin.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}

	@Override
	public UserEntity loadUserByIdUser(Integer idUser) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE id_user=?");
			statement.setInt(1, idUser);

			set = statement.executeQuery();

			if (set.next()) {
				UserEntity userBean = CreaterEntity.createUserEntity(set);
				return userBean;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in loadUserByIdUser.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}
	
	@Override
	public UserEntity loadUserByLogin(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE login=?");
			statement.setString(1, login);

			set = statement.executeQuery();

			if (set.next()) {
				UserEntity userBean = CreaterEntity.createUserEntity(set);
				return userBean;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in loadUserByLogin.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return null;
	}

	@Override
	public Boolean loginExists(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE login=?");
			statement.setString(1, login);

			set = statement.executeQuery();

			if (set.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in loginExists.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return false;
	}

	@Override
	public Boolean passwordEquals(String login, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE login = ? AND password = ?");
			statement.setString(1, login);
			statement.setString(2, password);

			set = statement.executeQuery();

			if (set.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in passwordEquals.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement, set);
		}

		return false;
	}

	@Override
	public void save(UserEntity bean) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection
					.prepareStatement("INSERT INTO user (login, password, del_status, fk_role) VALUES (?, ?, ?, ?)");
			statement.setString(1, bean.getLogin());
			statement.setString(2, bean.getPassword());
			statement.setBoolean(3, bean.getDelStatus());
			statement.setInt(4, bean.getFkRole());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in save.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}

	}

	@Override
	public void update(UserEntity bean) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement(
					"UPDATE user SET login = ?, password = ?, del_status = ?, fk_role = ? WHERE id_user = ?");
			statement.setString(1, bean.getLogin());
			statement.setString(2, bean.getPassword());
			statement.setBoolean(3, bean.getDelStatus());
			statement.setInt(4, bean.getFkRole());
			statement.setInt(5, bean.getIdUser());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in update.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	@Override
	public void remove(Integer idUser) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("DELETE FROM user WHERE id_user = ?");
			statement.setInt(1, idUser);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in remove.", e);
		} finally {
			ConnectionPool.getInstance().closeDbResources(connection, statement);
		}
	}

	public Boolean returnDelStatusByLogin(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user WHERE login = ?");
			statement.setString(1, login);

			set = statement.executeQuery();

			if (set.next()) {
				Boolean delStatus = set.getBoolean("del_status");
				return delStatus;
			}
		} catch (SQLException e) {
			throw new ExceptionDao("Exception from MySqlUserDaoImpl in returnDelStatusByLogin.", e);
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
