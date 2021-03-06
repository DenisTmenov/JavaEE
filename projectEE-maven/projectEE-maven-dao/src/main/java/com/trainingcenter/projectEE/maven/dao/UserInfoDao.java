package com.trainingcenter.projectEE.maven.dao;

import com.trainingcenter.projectEE.maven.dao.entity.UserInfoEntity;
import com.trainingcenter.projectEE.maven.dao.exceptions.ExceptionDao;

public interface UserInfoDao {

	void save(UserInfoEntity bean) throws ExceptionDao;

	void update(UserInfoEntity bean) throws ExceptionDao;

	void remove(Integer idUserInfo) throws ExceptionDao;
	
	UserInfoEntity loadUserInfoById(Integer idInfo) throws ExceptionDao;
	
	UserInfoEntity loadUserInfoByEmail(String email) throws ExceptionDao;

	Boolean emailExists(String email) throws ExceptionDao;
}
