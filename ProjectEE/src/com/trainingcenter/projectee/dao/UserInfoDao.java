package com.trainingcenter.projectee.dao;

import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;
import com.trainingcenter.projectee.entity.UserInfoEntity;

public interface UserInfoDao {

	void save(UserInfoEntity bean) throws ExceptionDao;

	void update(UserInfoEntity bean) throws ExceptionDao;

	void remove(Integer idUserInfo) throws ExceptionDao;
	
	UserInfoEntity loadUserInfoById(Integer idInfo) throws ExceptionDao;
	
	UserInfoEntity loadUserInfoByEmail(String email) throws ExceptionDao;

	Boolean emailExists(String email) throws ExceptionDao;
}
