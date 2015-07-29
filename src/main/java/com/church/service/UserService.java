package com.church.service;

import java.util.List;

import com.church.condition.UserCond;
import com.church.model.UserModel;
import com.church.utils.ServiceException;

public interface UserService {

	public UserModel doLogin(UserModel user) throws ServiceException;

	public UserModel doCreate(UserModel userModel, Long uid) throws ServiceException;
	
	public List<UserModel> queryAll(UserCond cond) throws ServiceException;
}
