package com.church.service;

import com.church.model.UserModel;
import com.church.utils.ServiceException;
import com.church.utils.SessionUser;

public interface UserService {

	public UserModel doLogin(UserModel user) throws ServiceException;

	public SessionUser initSessionUser(UserModel user);

}
