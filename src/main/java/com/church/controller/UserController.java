package com.church.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.church.condition.UserCond;
import com.church.model.UserModel;
import com.church.service.UserService;
import com.church.utils.ServiceException;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 用户中心
	 * 
	 * @return
	 */
	@RequestMapping(value = "/center", method = RequestMethod.GET)
	public void userCenter(HttpServletRequest request) {
		
	}
	
	/**
	 * 创建user
	 * @param request
	 * @param response
	 * @param userModel
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public UserModel create(HttpServletRequest request, HttpServletResponse response,
			UserModel userModel) throws IOException {

		try {
			return userService.doCreate(userModel, getUid(request));
		} catch (ServiceException e) {
			sendError(request, response, e.getMessage());
		}
		return null;
	}
	
	/**
	 * 获取userList
	 * @param request
	 * @param response
	 * @param cond
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UserModel> list(HttpServletRequest request, HttpServletResponse response, 
			@RequestBody UserCond cond) throws IOException{
		try {
			return userService.queryAll(cond);
		} catch (ServiceException e) {
			sendError(request, response, e.getMessage());
		}
		return null;
	}

}
