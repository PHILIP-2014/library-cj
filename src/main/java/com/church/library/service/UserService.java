package com.church.library.service;

import java.util.List;

import com.church.library.condition.UserCond;
import com.church.library.model.UserModel;
import com.church.library.utils.ServiceException;

public interface UserService {

	public UserModel doLogin(UserModel user) throws ServiceException;

	public UserModel doCreate(UserModel userModel, Long uid) throws ServiceException;
	
	public List<UserModel> queryAll(UserCond cond) throws ServiceException;
}
