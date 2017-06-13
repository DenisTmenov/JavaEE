package main.java.com.trainingcenter.projectEE.maven.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.trainingcenter.projectEE.maven.entity.UserEntity;
import main.java.com.trainingcenter.projectEE.maven.entity.UserInfoEntity;
import main.java.com.trainingcenter.projectEE.maven.entity.UserRoleEntity;

public class CreaterEntity {
	
	public static main.java.com.trainingcenter.projectEE.maven.entity.UserEntity createUserEntity(ResultSet set) throws SQLException {
		Integer idUser = set.getInt("id_user");
		String login = set.getString("login");
		String password = set.getString("password");
		Boolean delStatus = set.getBoolean("del_status");
		Integer fkRole = set.getInt("fk_role");

		UserEntity entity = new UserEntity();

		entity.setIdUser(idUser);
		entity.setLogin(login);
		entity.setPassword(password);
		entity.setDelStatus(delStatus);
		entity.setFkRole(fkRole);

		return entity;
	}
	
	public static UserInfoEntity createUserInfoEntity(ResultSet set) throws SQLException {
		Integer idInfo = set.getInt("id_info");
		String firstName = set.getString("first_name");
		String lastName = set.getString("last_name");
		String email = set.getString("email");
		Integer fkIdUser = set.getInt("fk_id_user");

		UserInfoEntity entity = new UserInfoEntity();

		entity.setIdInfo(idInfo);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setEmail(email);
		entity.setFkIdUser(fkIdUser);

		return entity;
	}

	public static UserRoleEntity createUserRoleEntity(ResultSet set) throws SQLException {
		Integer idRole = set.getInt("id_role");
		String nameRole = set.getString("name_role");
		Boolean add = set.getBoolean("add");
		Boolean delete = set.getBoolean("delete");
		Boolean modify = set.getBoolean("modify");
		Boolean read = set.getBoolean("read");

		UserRoleEntity entity = new UserRoleEntity();

		entity.setIdRole(idRole);
		entity.setNameRole(nameRole);
		entity.setAdd(add);
		entity.setDelete(delete);
		entity.setModify(modify);
		entity.setRead(read);

		return entity;
	}
	
	
}
