package main.java.com.trainingcenter.projectEE.maven.dao;

import main.java.com.trainingcenter.projectEE.maven.dao.exceptions.ExceptionDao;
import main.java.com.trainingcenter.projectEE.maven.entity.UserRoleEntity;

public interface UserRoleDao {

	void save(UserRoleEntity bean) throws ExceptionDao;

	void update(UserRoleEntity bean) throws ExceptionDao;

	void remove(Integer idRole) throws ExceptionDao;
	
	UserRoleEntity loadUserRoleByIdRole(Integer idRole) throws ExceptionDao;
}
