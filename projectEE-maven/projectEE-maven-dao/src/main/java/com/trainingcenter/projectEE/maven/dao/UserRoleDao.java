package com.trainingcenter.projectEE.maven.dao;

import com.trainingcenter.projectEE.maven.dao.entity.UserRoleEntity;
import com.trainingcenter.projectEE.maven.dao.exceptions.ExceptionDao;

public interface UserRoleDao {

	void save(UserRoleEntity bean) throws ExceptionDao;

	void update(UserRoleEntity bean) throws ExceptionDao;

	void remove(Integer idRole) throws ExceptionDao;
	
	UserRoleEntity loadUserRoleByIdRole(Integer idRole) throws ExceptionDao;
}
