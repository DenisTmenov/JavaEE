package com.trainingcenter.projectee.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainingcenter.projectee.entity.UserEntity;
import com.trainingcenter.projectee.entity.UserInfoEntity;
import com.trainingcenter.projectee.entity.UserRoleEntity;

public class CreaterEntity {
	
	public static UserEntity createUserEntity(ResultSet set) throws SQLException {
		Integer idUser = set.getInt("id_user");
		String login = set.getString("login");
		String password = set.getString("password");
		Boolean delStatus = set.getBoolean("del_status");
		Integer fkRole = set.getInt("fk_role");

		UserEntity bean = new UserEntity();

		bean.setIdUser(idUser);
		bean.setLogin(login);
		bean.setPassword(password);
		bean.setDelStatus(delStatus);
		bean.setFkRole(fkRole);

		return bean;
	}
	
	public static UserInfoEntity createUserInfoEntity(ResultSet set) throws SQLException {
		Integer idInfo = set.getInt("id_info");
		String firstName = set.getString("first_name");
		String lastName = set.getString("last_name");
		String email = set.getString("email");
		Integer fkIdUser = set.getInt("fk_id_user");

		UserInfoEntity bean = new UserInfoEntity();

		bean.setIdInfo(idInfo);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setFkIdUser(fkIdUser);

		return bean;
	}

	public static UserRoleEntity createUserRoleEntity(ResultSet set) throws SQLException {
		Integer idRole = set.getInt("id_role");
		String nameRole = set.getString("name_role");
		Boolean add = set.getBoolean("add");
		Boolean delete = set.getBoolean("delete");
		Boolean modify = set.getBoolean("modify");
		Boolean read = set.getBoolean("read");

		UserRoleEntity bean = new UserRoleEntity();

		bean.setIdRole(idRole);
		bean.setNameRole(nameRole);
		bean.setAdd(add);
		bean.setDelete(delete);
		bean.setModify(modify);
		bean.setRead(read);

		return bean;
	}
	
	
}
