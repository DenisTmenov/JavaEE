package com.trainingcenter.projectee.dao;

import com.trainingcenter.projectee.beans.UserBean;
import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;

public interface UserDao {

	void save(UserBean bean) throws ExceptionDao;

	void update(UserBean bean) throws ExceptionDao;

	void remove(Integer idUser) throws ExceptionDao;

	Integer returnIdByLogin(String login) throws ExceptionDao;

	UserBean loadUserByIdUser(Integer idUser) throws ExceptionDao;

	Boolean loginExists(String login) throws ExceptionDao;

	Boolean passwordEquals(String login, String password) throws ExceptionDao;

}
