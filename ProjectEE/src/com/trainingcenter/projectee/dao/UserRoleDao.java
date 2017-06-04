package com.trainingcenter.projectee.dao;

import com.trainingcenter.projectee.beans.UserRoleBean;
import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;

public interface UserRoleDao {

	void save(UserRoleBean bean) throws ExceptionDao;

	void update(UserRoleBean bean) throws ExceptionDao;

	void remove(Integer idRole) throws ExceptionDao;

}
