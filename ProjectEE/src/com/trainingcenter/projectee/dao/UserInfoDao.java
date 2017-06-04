package com.trainingcenter.projectee.dao;

import com.trainingcenter.projectee.beans.UserInfoBean;
import com.trainingcenter.projectee.dao.exceptions.ExceptionDao;

public interface UserInfoDao {

	void save(UserInfoBean bean) throws ExceptionDao;

	void update(UserInfoBean bean) throws ExceptionDao;

	void remove(Integer idUserInfo) throws ExceptionDao;
	
	UserInfoBean loadUserInfoById(Integer idInfo) throws ExceptionDao;
	
	UserInfoBean loadUserInfoByEmail(String email) throws ExceptionDao;

	Boolean emailExists(String email) throws ExceptionDao;
}
