package com.church.dao;

import org.apache.ibatis.annotations.Param;

import com.church.model.UserModel;

public interface UserDao {

	public Long insert(UserModel userModel);
	
	public UserModel queryOne(Long id);
	
	public UserModel queryByName(String name);
	
	public Integer countExist(@Param("uid") Long uid, @Param("role") Integer role);
	
	public Integer update(UserModel userModel);
	
	public Integer updatePassword(Long id, String password);
	
}
