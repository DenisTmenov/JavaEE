package com.trainingcenter.projectee.dao;

import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;
import com.trainingcenter.projectee.entity.UserEntity;

public interface UserDao {

	void save(UserEntity bean) throws ExceptionDao;

	void update(UserEntity bean) throws ExceptionDao;

	void remove(Integer idUser) throws ExceptionDao;

	Integer returnIdByLogin(String login) throws ExceptionDao;

	UserEntity loadUserByIdUser(Integer idUser) throws ExceptionDao;
	
	UserEntity loadUserByLogin(String login) throws ExceptionDao;

	Boolean loginExists(String login) throws ExceptionDao;

	Boolean passwordEquals(String login, String password) throws ExceptionDao;

}
