package com.trainingcenter.projectee.dao;

import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;
import com.trainingcenter.projectee.entity.UserRoleEntity;

public interface UserRoleDao {

	void save(UserRoleEntity bean) throws ExceptionDao;

	void update(UserRoleEntity bean) throws ExceptionDao;

	void remove(Integer idRole) throws ExceptionDao;
	
	UserRoleEntity loadUserRoleByIdRole(Integer idRole) throws ExceptionDao;
}
