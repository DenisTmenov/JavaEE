package com.trainingcenter.projectEE.maven.dao;

import com.trainingcenter.projectEE.maven.dao.entity.UserEntity;
import com.trainingcenter.projectEE.maven.dao.exceptions.ExceptionDao;

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
