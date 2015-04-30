package com.church.dao;

import com.church.model.UserModel;

public interface UserDao {

	public Long insert(UserModel userModel);
	
	public UserModel queryOne(Long id);
	
	public UserModel queryByPhone(String phone);
	
	public Integer update(UserModel userModel);
	
	public Integer updatePassword(Long id, String password);
	
}
