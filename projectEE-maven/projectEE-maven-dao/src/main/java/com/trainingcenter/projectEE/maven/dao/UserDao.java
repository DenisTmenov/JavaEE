package main.java.com.trainingcenter.projectEE.maven.dao;

import main.java.com.trainingcenter.projectEE.maven.dao.exceptions.ExceptionDao;
import main.java.com.trainingcenter.projectEE.maven.entity.UserEntity;

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
