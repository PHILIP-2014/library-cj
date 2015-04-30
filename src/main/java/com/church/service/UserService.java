package com.church.service;

import com.church.model.UserModel;
import com.church.utils.ServiceException;

public interface UserService {

	public UserModel doLogin(UserModel user) throws ServiceException;
}
