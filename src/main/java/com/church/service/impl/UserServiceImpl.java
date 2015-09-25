package com.church.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.condition.UserCond;
import com.church.dao.UserDao;
import com.church.model.UserModel;
import com.church.service.UserService;
import com.church.utils.PwdEncoder;
import com.church.utils.ServiceException;
import com.church.utils.StrUtils;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PwdEncoder pwdEncoder;
	@Autowired
	private UserDao userDao;

	public UserModel doLogin(UserModel user) throws ServiceException {

		UserModel userModel = queryByName(user.getName());
		if(userModel == null) {
			throw new ServiceException("error.account.not.exist");
		}
		if(userModel.getIsDisable()) {
			throw new ServiceException("error.account.status.not.normal");
		}
		/*if(!pwdEncoder.isPasswordValid(userModel.getPassword(), user.getPassword())) {
			throw new ServiceException("error.account.password.invalid");
		}*/
		if(userModel.getPassword() == null || !userModel.getPassword().equals(user.getPassword())){
			throw new ServiceException("error.account.password.invalid");
		}
		return userModel;
	}
	
	public UserModel doCreate(UserModel userModel, Long uid) throws ServiceException {
		if(lackParams(userModel)){
			throw new ServiceException("error.user.require.param");
		}
		if(!hasPermission(uid, UserModel.ROLE_ADMIN)){
			throw new ServiceException("error.user.forbid");
		}
		userDao.insert(initModel(userModel));
		return userModel;
	}
	
	public List<UserModel> queryAll(UserCond cond) throws ServiceException {
		if(!hasPermission(cond.getUid(), UserModel.ROLE_ADMIN)){
			throw new ServiceException("error.user.forbid");
		}
		return userDao.queryAll(cond);
	}

	/**
	 * 初始化user
	 * @param userModel
	 * @return
	 */
	private UserModel initModel(UserModel userModel){
		userModel.setIsVerify(true);
		userModel.setIsDisable(false);
		return userModel;
	}
	
	/**
	 * 通过用户名查询用户
	 * @param name
	 * @return
	 */
	private UserModel queryByName(String name){
		return userDao.queryByName(name);
	}
	
	/**
	 * 判断权限
	 * @param uid
	 * @param role
	 * @return
	 */
	private Boolean hasPermission(Long uid, Integer role){
		if(userDao.countExist(uid, role) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断参数完整性
	 * @param userModel
	 * @return
	 */
	private Boolean lackParams(UserModel userModel){
		if(StrUtils.isEmpty(userModel.getName()) || StrUtils.isEmpty(userModel.getPassword())
				|| StrUtils.isEmpty(userModel.getPhone())){
			return true;
		}
		return false;
	}

}
